package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	RecyclerView recyclerView;
	PersonAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerView = findViewById(R.id.recyclerView);

		GridLayoutManager layoutManager =
							new GridLayoutManager(this, 2);
		recyclerView.setLayoutManager(layoutManager);
		PersonAdapter adapter = new PersonAdapter();

		adapter.addItem(new Person("Mbti", "010-1000-1000"));
		adapter.addItem(new Person("컴온컴온", "010-2000-2000"));
		adapter.addItem(new Person("세계관", "010-3000-3000"));
		adapter.addItem(new Person("최강자", "010-4000-3000"));
		adapter.addItem(new Person("잇프피", "010-5000-3000"));
		adapter.addItem(new Person("배고파", "010-6000-3000"));
		adapter.addItem(new Person("졸려", "010-7000-3000"));
		adapter.addItem(new Person("울먹", "010-8000-3000"));
		adapter.addItem(new Person("풉피치", "010-9000-3000"));
		adapter.addItem(new Person("위협적", "010-3000-4000"));
		adapter.addItem(new Person("인자세", "010-3000-5000"));
		adapter.addItem(new Person("남자들", "010-3000-6000"));
		adapter.addItem(new Person("은밀한", "010-3000-7000"));
		adapter.addItem(new Person("놀이터", "010-3000-7000"));
		adapter.addItem(new Person("indoor", "010-3000-7000"));
		adapter.addItem(new Person("화나고", "010-3000-7000"));
		adapter.addItem(new Person("쌉같네", "010-3000-7000"));
		adapter.addItem(new Person("쌉될래", "010-3000-7000"));
		adapter.addItem(new Person("ㅎㅂㅎ", "010-3000-7000"));

		recyclerView.setAdapter(adapter);

		adapter.setOnClickListener(new OnPersonItemClickListener() {
			@Override
			public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {

				Person item = adapter.getItem(position);
				Toast.makeText(getApplicationContext(), "아이템 선택됨: " + item.getName(), Toast.LENGTH_LONG).show();
			}
		});
	}
}