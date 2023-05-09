package com.example.networking;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Mountain> listOfMountains;
    public MyAdapter(List<Mountain> listOfMountains) {
        this.listOfMountains = listOfMountains;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mountain mountain = listOfMountains.get(position);
        String mountainInfo = mountain.getName() + " " + mountain.getSize() + " " + mountain.getCost();
        holder.mountainInfo.setText(mountainInfo);
    }

    @Override
    public int getItemCount() {
        return listOfMountains.size();
    }
}