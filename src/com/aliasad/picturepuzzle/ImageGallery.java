package com.aliasad.picturepuzzle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.aliasad.picturepuzzle.util.ImageAdapter;

public class ImageGallery extends Activity implements OnItemClickListener{

	private GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setting Full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.image_gallery);
		
		gridView = (GridView)findViewById(R.id.gridView);
		gridView.setAdapter(new ImageAdapter(ImageGallery.this));
		gridView.setOnItemClickListener(this);
	}

	
	@Override
	public void onItemClick(AdapterView<?> av, View v, int position, long id) {
		
		ImageView imgView = (ImageView)v;
		Bitmap bmp = ((BitmapDrawable)imgView.getDrawable()).getBitmap();
		
		Intent i = new Intent(ImageGallery.this, GameBoard.class);
		i.putExtra("img", bmp);
		startActivity(i);
	}
}
