package com.example.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onPause 호출됨");
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onResume 호출됨");
        restoreState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.nameInput);
        Toast.makeText(this, "OnCreate 호출됨", Toast.LENGTH_LONG).show();
        Log.d("Main", "onCreate 호출됨");
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("name")) ){
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", nameInput.getText().toString() );
        editor.commit();
    }

    protected void clearState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}