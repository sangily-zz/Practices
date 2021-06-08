package com.example.recyclerviewpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
						implements OnPersonItemClickListener {
	ArrayList<Person> items = new ArrayList<Person>();
	OnPersonItemClickListener listener;

	@NonNull
	@org.jetbrains.annotations.NotNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.person_item, parent, false);

		return new ViewHolder(itemView, this);
	}

	@Override
	public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PersonAdapter.ViewHolder holder, int position) {
		Person item = items.get(position);
		holder.setItem(item);
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	static class ViewHolder extends RecyclerView.ViewHolder {
		TextView textView;
		TextView textView2;

		public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
			super(itemView);

			textView = itemView.findViewById(R.id.textView);
			textView2 = itemView.findViewById(R.id.textView2);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int position = getAdapterPosition();
					if (listener != null)
						listener.onItemClick(ViewHolder.this, v, position);
				}
			});
		}

		public void setItem(Person item) {
			textView.setText(item.getName());
			textView2.setText(item.getMobile());
		}
	}

	public void setOnClickListener(OnPersonItemClickListener listener) {
		this.listener = listener;
	}

	@Override
	public void onItemClick(ViewHolder holder, View view, int position) {
		if (listener != null)
			listener.onItemClick(holder, view, position);
	}

	public void addItem(Person item) {
		items.add(item);
	}

	public void setItems(ArrayList<Person> items) {
		this.items = items;
	}

	public Person getItem(int position) {
		return items.get(position);
	}

	public void setItem(int position, Person item) {
		items.set(position, item);
	}
}
