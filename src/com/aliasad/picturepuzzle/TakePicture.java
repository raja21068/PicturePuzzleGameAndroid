package com.aliasad.picturepuzzle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TakePicture extends Activity implements OnClickListener{

	private Bitmap bmp= null;
	private ImageView capturedImageView;
	private Button captureButton, doneButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setting Full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.take_picture_page);
		
		capturedImageView = (ImageView) findViewById(R.id.captured_image_view);
		captureButton = (Button) findViewById(R.id.capture_button);
		doneButton = (Button) findViewById(R.id.done_button);
		captureButton.setOnClickListener(this);
		doneButton.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.capture_button:
			Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, 0);
			break;
			
		case R.id.done_button:
			if(bmp != null){
				Intent i2 = new Intent(TakePicture.this, GameBoard.class);
				i2.putExtra("img", bmp);
				startActivity(i2);
			}
			else
				Toast.makeText(TakePicture.this, "Capture picture first", 0).show();
			break;
		}
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK){
			bmp = (Bitmap)data.getExtras().get("data");
			if(bmp!=null)
				capturedImageView.setImageBitmap(bmp);
		}
		
	}
	
}
