package com.example.starswars;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterActors extends RecyclerView.Adapter<MyHolderActors> {

    ArrayList<People> people;
    SharedPreferences mPrefs;

    public MyAdapterActors(SharedPreferences mPrefs , ArrayList<People> people){
        this.people = people;
        this.mPrefs = mPrefs;
    }

    @NonNull
    @Override
    public MyHolderActors onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        return new MyHolderActors(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderActors holder, int position) {
        holder.bind(people.get(position), MyAdapterActors.this);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }


}
