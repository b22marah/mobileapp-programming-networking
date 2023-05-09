package com.example.networking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView mountainInfo;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mountainInfo = itemView.findViewById(R.id.mountain_info);
    }
}