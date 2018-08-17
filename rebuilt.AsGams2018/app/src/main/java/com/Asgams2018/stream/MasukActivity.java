package com.Asgams2018.stream;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.media.MediaPlayer;
import android.view.View;

public class MasukActivity extends AppCompatActivity {
	
	
	private double click = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private Button halamanutama;
	private Button suka;
	private Button contactsdeveloper;
	private Button web;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	
	private Intent incoke = new Intent();
	private ObjectAnimator ani = new ObjectAnimator();
	private MediaPlayer med;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.masuk);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		halamanutama = (Button) findViewById(R.id.halamanutama);
		suka = (Button) findViewById(R.id.suka);
		contactsdeveloper = (Button) findViewById(R.id.contactsdeveloper);
		web = (Button) findViewById(R.id.web);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		
		halamanutama.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				incoke.setClass(getApplicationContext(), MainActivity.class);
				incoke.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				med.pause();
				startActivity(incoke);
			}
		});
		
		suka.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				incoke.setClass(getApplicationContext(), HalamanActivity.class);
				startActivity(incoke);
			}
		});
		
		contactsdeveloper.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				incoke.setClass(getApplicationContext(), ContactsdeveloperActivity.class);
				startActivity(incoke);
			}
		});
		
		web.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				incoke.setClass(getApplicationContext(), StreamasiangamesActivity.class);
				med.pause();
				startActivity(incoke);
			}
		});
	}
	private void initializeLogic() {
		click = 0;
		med = MediaPlayer.create(getApplicationContext(), R.raw.indoraya);
		med.start();
		med.setLooping(med.isLooping());
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
