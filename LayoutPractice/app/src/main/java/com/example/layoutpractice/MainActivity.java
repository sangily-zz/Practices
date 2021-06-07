package com.example.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Layout1 layout1 = findViewById(R.id.layout1);

		layout1.setImage(R.drawable.ic_launcher_foreground);
		layout1.setName("이혜진");
		layout1.setMobile("010-5207-0968");

		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				layout1.setImage(R.drawable.hyejin1);
			}
		});

		Button button2 = findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				layout1.setImage(R.drawable.hyejin2);
			}
		});
	}
}