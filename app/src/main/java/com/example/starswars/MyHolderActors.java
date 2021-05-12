package com.example.starswars;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class MyHolderActors extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mBrand;

    public MyHolderActors(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.image_2);
        this.mBrand = itemView.findViewById(R.id.brand);


    }

    public void bind(People people, MyAdapterActors adapter){
        mBrand.setText(people.getName());

    }
}
