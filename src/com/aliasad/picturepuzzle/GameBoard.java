package com.aliasad.picturepuzzle;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameBoard extends Activity implements OnClickListener {

	private Bitmap bmp;
	private ImageView smallImageView;
	private ImageButton b[] = new ImageButton[12];
	private TextView timmerText;
	private Bitmap bmps[] = new Bitmap[11];
	private Button startButton;
	private boolean start;
	private TimmerTask tt;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Setting Full screen mode
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.game_board);
		
		smallImageView = (ImageView) findViewById(R.id.smallImageView);
		b[0] = (ImageButton) findViewById(R.id.b1);
		b[1] = (ImageButton) findViewById(R.id.b2);
		b[2] = (ImageButton) findViewById(R.id.b3);
		b[3] = (ImageButton) findViewById(R.id.b4);
		b[4] = (ImageButton) findViewById(R.id.b5);
		b[5] = (ImageButton) findViewById(R.id.b6);
		b[6] = (ImageButton) findViewById(R.id.b7);
		b[7] = (ImageButton) findViewById(R.id.b8);
		b[8] = (ImageButton) findViewById(R.id.b9);
		b[9] = (ImageButton) findViewById(R.id.b10);
		b[10] = (ImageButton) findViewById(R.id.b11);
		b[11] = (ImageButton) findViewById(R.id.b12);
		timmerText = (TextView)findViewById(R.id.timerText);
		
		startButton = (Button) findViewById(R.id.start);
		start = false;
		
		for(int k=0 ; k<b.length ; k++)
			b[k].setOnClickListener(this);
		startButton.setOnClickListener(this);
		
		bmp = getIntent().getParcelableExtra("img");
		smallImageView.setImageBitmap(bmp);
		
		tt = new TimmerTask(this);
	}
	
	
	@Override
	public void onClick(View v) {
		if(!start){
			if(v.getId() == R.id.start){
				initPuzzle();
				tt.execute("");
				start = true;
				startButton.setText("Reset");
			}
		}
		
		else{
			if(v.getId() == R.id.start){
				tt.stopTimmer();
				tt = new TimmerTask(this);
				tt.execute("");
				setImagesOnButtons();
			}
			else{
				boolean b = changeImage(v);
				if(b)
					check();
			}
		}
	}
	
	
	private void check() {
		
		for(int k=0 ; k<b.length-1 ; k++){
			if(b[k].getDrawable()!=null){
				if(((BitmapDrawable)b[k].getDrawable()).getBitmap() != bmps[k])
					return;
			}
			else
				return;
		}
		
		Toast.makeText(this, "Congratulations You won!", 0).show();
		
	}


	private boolean changeImage(View v) {
		
		ImageButton ib = (ImageButton)v;
		Bitmap img = null;
		if(ib.getDrawable()!=null)
			img = ((BitmapDrawable)ib.getDrawable()).getBitmap();
		
		if(img!=null){
			
			if(ib==b[0]){
				if(b[1].getDrawable() == null){
					b[1].setImageBitmap(img);
					b[0].setImageDrawable(null);
					return true;
				}
				if(b[3].getDrawable() == null){
					b[3].setImageBitmap(img);
					b[0].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib==b[1]){
				if(b[0].getDrawable() == null){
					b[0].setImageBitmap(img);
					b[1].setImageDrawable(null);
					return true;
				}
				if(b[2].getDrawable() == null){
					b[2].setImageBitmap(img);
					b[1].setImageDrawable(null);
					return true;
				}
				if(b[4].getDrawable() == null){
					b[4].setImageBitmap(img);
					b[1].setImageDrawable(null);
					return true;
				}
			}
			
			else if(ib==b[2]){
				if(b[1].getDrawable() == null){
					b[1].setImageBitmap(img);
					b[2].setImageDrawable(null);
					return true;
				}
				if(b[5].getDrawable() == null){
					b[5].setImageBitmap(img);
					b[2].setImageDrawable(null);
					return true;
				}
			}
			
			else if(ib==b[3]){
				if(b[0].getDrawable() == null){
					b[0].setImageBitmap(img);
					b[3].setImageDrawable(null);
					return true;
				}
				if(b[4].getDrawable() == null){
					b[4].setImageBitmap(img);
					b[3].setImageDrawable(null);
					return true;
				}
				if(b[6].getDrawable() == null){
					b[6].setImageBitmap(img);
					b[3].setImageDrawable(null);
					return true;
				}
			}
			
			else if(ib==b[4]){
				if(b[1].getDrawable() == null){
					b[1].setImageBitmap(img);
					b[4].setImageDrawable(null);
					return true;
				}
				if(b[3].getDrawable() == null){
					b[3].setImageBitmap(img);
					b[4].setImageDrawable(null);
					return true;
				}
				if(b[5].getDrawable() == null){
					b[5].setImageBitmap(img);
					b[4].setImageDrawable(null);
					return true;
				}
				if(b[7].getDrawable() == null){
					b[7].setImageBitmap(img);
					b[4].setImageDrawable(null);
					return true;
				}
			}
			
			else if(ib == b[5]){
				if(b[2].getDrawable() == null){
					b[2].setImageBitmap(img);
					b[5].setImageDrawable(null);
					return true;
				}
				if(b[4].getDrawable() == null){
					b[4].setImageBitmap(img);
					b[5].setImageDrawable(null);
					return true;
				}
				if(b[8].getDrawable() == null){
					b[8].setImageBitmap(img);
					b[5].setImageDrawable(null);
					return true;
				}
			}
			
			else if(ib == b[6]){
				if(b[3].getDrawable() == null){
					b[3].setImageBitmap(img);
					b[6].setImageDrawable(null);
					return true;
				}
				if(b[7].getDrawable()== null){
					b[7].setImageBitmap(img);
					b[6].setImageDrawable(null);
					return true;
				}
				if(b[9].getDrawable() == null){
					b[9].setImageBitmap(img);
					b[6].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib == b[7]){
				if(b[4].getDrawable() == null){
					b[4].setImageBitmap(img);
					b[7].setImageDrawable(null);
					return true;
				}
				if(b[6].getDrawable() == null){
					b[6].setImageBitmap(img);
					b[7].setImageDrawable(null);
					return true;
				}
				if(b[8].getDrawable() == null){
					b[8].setImageBitmap(img);
					b[7].setImageDrawable(null);
					return true;
				}
				if(b[10].getDrawable() == null){
					b[10].setImageBitmap(img);
					b[7].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib == b[8]){
				if(b[5].getDrawable() == null){
					b[5].setImageBitmap(img);
					b[8].setImageDrawable(null);
					return true;
				}
				if(b[7].getDrawable() == null){
					b[7].setImageBitmap(img);
					b[8].setImageDrawable(null);
					return true;
				}
				if(b[11].getDrawable() == null){
					b[11].setImageBitmap(img);
					b[8].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib == b[9]){
				if(b[6].getDrawable() == null){
					b[6].setImageBitmap(img);
					b[9].setImageDrawable(null);
					return true;
				}
				if(b[10].getDrawable() == null){
					b[10].setImageBitmap(img);
					b[9].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib == b[10]){
				if(b[7].getDrawable() == null){
					b[7].setImageBitmap(img);
					b[10].setImageDrawable(null);
					return true;
				}
				if(b[9].getDrawable() == null){
					b[9].setImageBitmap(img);
					b[10].setImageDrawable(null);
					return true;
				}
				if(b[11].getDrawable() == null){
					b[11].setImageBitmap(img);
					b[10].setImageDrawable(null);
					return true;
				}
			}
			
			
			else if(ib == b[11]){
				if(b[8].getDrawable() == null){
					b[8].setImageBitmap(img);
					b[11].setImageDrawable(null);
					return true;
				}
				if(b[10].getDrawable() == null){
					b[10].setImageBitmap(img);
					b[11].setImageDrawable(null);
					return true;
				}
			}
		}
		
		return false;
	}


	private void initPuzzle() {
		int width = b[0].getWidth();
		int height = b[0].getHeight();
		
		initImages(width, height);
		setImagesOnButtons();
	}


	private void initImages(int width, int height){
		
		Bitmap newBmp = Bitmap.createScaledBitmap(bmp, width*3+3, height*4+4, false);
		
		bmps[0] = Bitmap.createBitmap(newBmp, 0, 0, width, height);
		bmps[1] = Bitmap.createBitmap(newBmp, width+1, 0, width, height);
		bmps[2] = Bitmap.createBitmap(newBmp, width+1+width+1, 0, width, height);
		
		bmps[3] = Bitmap.createBitmap(newBmp, 0, height+1, width, height);
		bmps[4] = Bitmap.createBitmap(newBmp, width+1, height+1, width, height);
		bmps[5] = Bitmap.createBitmap(newBmp, width+1+width+1, height+1, width, height);
		
		bmps[6] = Bitmap.createBitmap(newBmp, 0, height+1+height+1, width, height);
		bmps[7] = Bitmap.createBitmap(newBmp, width+1, height+1+height+1, width, height);
		bmps[8] = Bitmap.createBitmap(newBmp, width+1+width+1, height+1+height+1, width, height);
		
		bmps[9] = Bitmap.createBitmap(newBmp, 0, height+1+height+1+height+1, width, height);
		bmps[10] = Bitmap.createBitmap(newBmp, width+1, height+1+height+1+height+1, width, height);
		
	}
	
	
	private void setImagesOnButtons() {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int k=0 ; k<b.length-1 ; k++){
			int r;
			do{
				r = rand.nextInt(bmps.length);
			}while(arr.contains(r));
			
			arr.add(r);
			b[k].setImageBitmap(bmps[r]);
		}
		b[b.length-1].setImageDrawable(null);
		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		tt.stopTimmer();
	}
	
	
	class TimmerTask extends AsyncTask<String, Integer, String>{

		private Activity a;
		private boolean running;
		private int counter;
		
		public TimmerTask(Activity a){
			this.a = a;
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			counter = 0;
			running = true;
		}
		
		@Override
		protected String doInBackground(String... arg0) {
			
					long startTime, diffTime, sleep;
					startTime = System.currentTimeMillis();
					while(running){
						
						setTime();
						counter++;
						
						diffTime = System.currentTimeMillis() - startTime;
						sleep = 1000 - diffTime;
						if(sleep<0)
							sleep = 1;
						try{
							Thread.sleep(sleep);
						}catch(Exception ex){}
						startTime = System.currentTimeMillis();
						
					}
				
				return null;
		}
		
		private void setTime() {
			if(counter > 0){
				
				int sec = counter;
				
				final int hours = sec / 3600;
				sec = sec % 3600;
				final int minutes = sec / 60;
				sec = sec % 60;
				final int s = sec;
				
				System.out.println(String.format("%02d:%02d:%02d", hours, minutes, sec));
				a.runOnUiThread(new Runnable(){
					public void run(){
						timmerText.setText(String.format("%02d:%02d:%02d", hours, minutes, s));
					}
				});
			}
		}
		
		public void stopTimmer(){
			running = false;
			counter = 0;
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}
		
	}
	
}
