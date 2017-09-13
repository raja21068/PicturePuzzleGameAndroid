package com.aliasad.picturepuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SelectPictureType extends Activity implements OnClickListener {

	private Button anyPicButton, takePicButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setting Full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.picture_type_page);
		
		anyPicButton = (Button) findViewById(R.id.any_pic_button);
		takePicButton = (Button) findViewById(R.id.take_pic_button);
		anyPicButton.setOnClickListener(this);
		takePicButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.any_pic_button:
			try{
				Class c = Class.forName("com.aliasad.picturepuzzle.ImageGallery");
				Intent i = new Intent(SelectPictureType.this, c);
				startActivity(i);
			}catch(Exception ex){}
			break;
			
		case R.id.take_pic_button:
			try{
				Class c = Class.forName("com.aliasad.picturepuzzle.TakePicture");
				Intent i = new Intent(SelectPictureType.this, c);
				startActivity(i);
			}catch(Exception ex){}
			break;
		}
	}
}
