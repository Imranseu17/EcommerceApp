package com.kcsl.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotificationAdapter extends RecyclerView.Adapter{

        Context context;


    public NotificationAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public NotificationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // infalte the item Layout
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification, parent, false);
            // set the view's size, margins, paddings and layout parameters
            NotificationAdapter.MyViewHolder vh = new NotificationAdapter.MyViewHolder(v); // pass the view to View Holder
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            NotificationAdapter.MyViewHolder viewHolder  = new NotificationAdapter.MyViewHolder(holder.itemView);
            if (position % 2 == 0) {
                Glide.with(context)
                .asDrawable()
                        .load(R.drawable.ic_error)
                        .into(viewHolder.thumb);
            } else {
                Glide.with(context)
                .asDrawable()
                        .load(R.drawable.ic_success)
                        .into(viewHolder.thumb);
            }


        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            // init the item view's
           ImageView thumb;

            public MyViewHolder(View itemView) {
                super(itemView);
                // get the reference of item view's
                thumb = itemView.findViewById(R.id.thumb);

            }
        }
}
