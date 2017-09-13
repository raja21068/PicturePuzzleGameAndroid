package com.aliasad.picturepuzzle.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.aliasad.picturepuzzle.R;

public class ImageAdapter extends BaseAdapter{

	private Context context;
	public Integer images[] = { R.drawable.pic1,
			R.drawable.pic2, R.drawable.pic3,
			R.drawable.pic1, R.drawable.pic1,
			R.drawable.pic1, R.drawable.pic1,
			R.drawable.pic1, R.drawable.pic1,
			R.drawable.pic1, R.drawable.pic1 };
	
	public ImageAdapter(Context context){
		this.context = context;
	}
	
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		ImageView iv = new ImageView(context);
		iv.setImageResource(images[position]);
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		iv.setPadding(0, 0, 0, 0);
		iv.setLayoutParams(new GridView.LayoutParams(200,180));
		return iv;
	}
	
	@Override
	public int getCount() {
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		return images[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	

}
