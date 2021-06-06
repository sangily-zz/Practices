package com.example.receiver;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity
					implements AutoPermissionsListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AutoPermissions.Companion.loadAllPermissions(this, 101);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
	}

	@Override
	public void onDenied(int i, String[] strings) {
		Toast.makeText(this, "permissions denied : " + strings.length, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onGranted(int i, String[] strings) {
		Toast.makeText(this, "permissions granted : " + strings.length, Toast.LENGTH_LONG).show();
	}
}