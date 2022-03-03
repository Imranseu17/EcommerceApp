package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
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
import java.util.List;

public class TrandingAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList trandingImages;
    private  List<String> trandingNames = new ArrayList<>();

    public TrandingAdapter(Context context,ArrayList trandingImages, List<String> trandingNames) {
        this.context = context;
        this.trandingImages = trandingImages;
        this.trandingNames = trandingNames;
    }
    @Override
    public TrandingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tranding_xml_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        TrandingAdapter.MyViewHolder vh = new TrandingAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TrandingAdapter.MyViewHolder viewHolder  = new TrandingAdapter.MyViewHolder(holder.itemView);
        viewHolder.trandingImage.setImageResource(Integer.parseInt(String.valueOf(trandingImages.get(position))));
        viewHolder.trandingName.setText(trandingNames.get(position));

    }



    @Override
    public int getItemCount() {
        return trandingImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView trandingImage;
        TextView trandingName;

        public MyViewHolder(View itemView) {
            super(itemView);
            trandingImage = itemView.findViewById(R.id.tranding_image);
            trandingName = itemView.findViewById(R.id.trandingName);

        }
    }

}
