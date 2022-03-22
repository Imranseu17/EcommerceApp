package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

public class ItemProductList extends RecyclerView.Adapter {
    Context context;


    public  ItemProductList(Context context) {
        this.context = context;
    }

    @Override
    public  ItemProductList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_xml, parent, false);
        // set the view's size, margins, paddings and layout parameters
         ItemProductList.MyViewHolder vh = new  ItemProductList.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         ItemProductList.MyViewHolder viewHolder = new  ItemProductList.MyViewHolder(holder.itemView);


    }


    @Override
    public int getItemCount() {
        return 4;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {



        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }

}
