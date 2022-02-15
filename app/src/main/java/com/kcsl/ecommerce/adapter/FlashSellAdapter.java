package com.kcsl.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;

public class FlashSellAdapter  extends RecyclerView.Adapter{

    ArrayList goalImages;
    Context context;

    public FlashSellAdapter(ArrayList goalImages, Context context) {
        this.goalImages = goalImages;
        this.context = context;
    }

    @NonNull
    @Override
    public FlashSellAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        FlashSellAdapter.MyViewHolder vh = new FlashSellAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FlashSellAdapter.MyViewHolder viewHolder  = new FlashSellAdapter.MyViewHolder(holder.itemView);
        viewHolder.image.setImageResource(Integer.parseInt(String.valueOf(goalImages.get(position))));
    }

    @Override
    public int getItemCount() {
        return goalImages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            image =  itemView.findViewById(R.id.imageView);
        }
    }
}
