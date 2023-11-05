package com.example.hackathon1;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv_company, tv_sum, tv_product;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_company = itemView.findViewById(R.id.tv_company);
        tv_sum = itemView.findViewById(R.id.tv_sum);
        tv_product = itemView.findViewById(R.id.tv_product);

    }
}
