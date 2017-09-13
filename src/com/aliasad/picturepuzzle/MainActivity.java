package com.aliasad.picturepuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button playButton, aboutButton, exitButton;
	private Intent nextScreen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setting Full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		playButton = (Button) findViewById(R.id.play_button);
		aboutButton = (Button) findViewById(R.id.about_button);
		exitButton = (Button) findViewById(R.id.exit_button);
		playButton.setOnClickListener(this);
		aboutButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
	
		try{
			Class c = Class.forName("com.aliasad.picturepuzzle.SelectPictureType");
			nextScreen = new Intent(MainActivity.this, c);
		}catch(ClassNotFoundException ex){}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.play_button:
			startActivity(nextScreen);
			break;
			
		case R.id.about_button:
			
			break;
			
		case R.id.exit_button:
			finish();
			break;
		}
	}
	
}
