package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;

public class ColorAdapterLayout extends RecyclerView.Adapter {
    Context context;
    ArrayList colorImages;

    public ColorAdapterLayout(Context context, ArrayList colorImages) {
        this.context = context;
        this.colorImages = colorImages;
    }

    @Override
    public ColorAdapterLayout.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.colour_adapter_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ColorAdapterLayout.MyViewHolder vh = new ColorAdapterLayout.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ColorAdapterLayout.MyViewHolder viewHolder = new ColorAdapterLayout.MyViewHolder(holder.itemView);
        viewHolder.colours_image.setImageResource(Integer.parseInt(String.valueOf(colorImages.get(position))));


    }


    @Override
    public int getItemCount() {
        return colorImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView colours_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            colours_image = itemView.findViewById(R.id.colours_image);
        }
    }

}
