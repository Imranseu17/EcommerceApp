package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class BannerListAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList bannerImages;


    public BannerListAdapter(Context context,    ArrayList bannerImages) {
        this.context = context;
        this.bannerImages = bannerImages;
    }
    @Override
    public BannerListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_list_adapter, parent, false);
        // set the view's size, margins, paddings and layout parameters
        BannerListAdapter.MyViewHolder vh = new BannerListAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        BannerListAdapter.MyViewHolder viewHolder  = new BannerListAdapter.MyViewHolder(holder.itemView);
        viewHolder.bannerImage.setImageResource(Integer.parseInt(String.valueOf(bannerImages.get(position))));
    }



    @Override
    public int getItemCount() {
        return bannerImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView bannerImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.banner_image);
        }
    }
}
