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
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.media.MediaPlayer;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	
	
	private LinearLayout linear2;
	private TextView textview5;
	private TextView textview3;
	private EditText edittext3;
	private TextView textview4;
	private EditText edittext4;
	private Button daftar;
	private Button masuk;
	private Button lupapw;
	
	private Intent intentcoks = new Intent();
	private SharedPreferences file;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private MediaPlayer med;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview3 = (TextView) findViewById(R.id.textview3);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		textview4 = (TextView) findViewById(R.id.textview4);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		daftar = (Button) findViewById(R.id.daftar);
		masuk = (Button) findViewById(R.id.masuk);
		lupapw = (Button) findViewById(R.id.lupapw);
		file = getSharedPreferences("userinformation", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		
		daftar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				intentcoks.setClass(getApplicationContext(), DaftarActivity.class);
				med.pause();
				startActivity(intentcoks);
				finish();
			}
		});
		
		masuk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext3.getText().toString().equals("") || edittext4.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Data kosong");
				}
				else {
					auth.signInWithEmailAndPassword(edittext3.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(MainActivity.this, _auth_sign_in_listener);
					intentcoks.setClass(getApplicationContext(), MasukActivity.class);
					SketchwareUtil.showMessage(getApplicationContext(), "Selamat datang 😊");
					med.pause();
					startActivity(intentcoks);
					finish();
				}
			}
		});
		
		lupapw.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				intentcoks.setClass(getApplicationContext(), ResetpassActivity.class);
				med.pause();
				startActivity(intentcoks);
				finish();
			}
		});
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	private void initializeLogic() {
		med = MediaPlayer.create(getApplicationContext(), R.raw.hutri);
		med.start();
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
