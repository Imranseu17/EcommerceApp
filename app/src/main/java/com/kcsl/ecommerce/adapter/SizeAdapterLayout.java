package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class SizeAdapterLayout extends RecyclerView.Adapter {
    Context context;
    private List<String> sizeName = new ArrayList<>();

    public SizeAdapterLayout(Context context, List<String> sizeName) {
        this.context = context;
        this.sizeName = sizeName;

    }

    @Override
    public SizeAdapterLayout.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.size_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        SizeAdapterLayout.MyViewHolder vh = new SizeAdapterLayout.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        SizeAdapterLayout.MyViewHolder viewHolder = new SizeAdapterLayout.MyViewHolder(holder.itemView);
        viewHolder.sizes.setText(sizeName.get(position));


    }


    @Override
    public int getItemCount() {
        return sizeName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sizes;

        public MyViewHolder(View itemView) {
            super(itemView);
             sizes = itemView.findViewById(R.id.xxs);
        }
    }

}