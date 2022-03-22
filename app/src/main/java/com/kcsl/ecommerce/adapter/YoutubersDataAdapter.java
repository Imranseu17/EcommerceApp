package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class YoutubersDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    private List<String> productName;
    private List<String> productPrice;
    private List<String> productRating;
    ArrayList images;

    public YoutubersDataAdapter(Context context, List<String> productName,
                              List<String> productPrice,List<String>  productRating,ArrayList images) {
        this.context = context;
        this.productName = productName;
        this.productPrice = productPrice;
        this. productRating =  productRating;
        this.images = images;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.youtubers_xml_data, parent, false);
        viewHolder = new YoutubersDataAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       YoutubersDataAdapter.MyViewHolder viewHolder  = new YoutubersDataAdapter.MyViewHolder(holder.itemView);

        viewHolder.product_name.setText(productName.get(position));
        viewHolder.product_price.setText(productPrice.get(position));
        viewHolder.product_rating.setText(productRating.get(position));
        viewHolder.youtubers_image.setImageResource(Integer.parseInt(String.valueOf(images.get(position))));


    }



    @Override
    public int getItemCount() {
        return productName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView youtubers_image;
        TextView product_name,product_price,product_rating;


        public MyViewHolder(View itemView) {
            super(itemView);
            youtubers_image = itemView.findViewById(R.id.image);
            product_name = itemView.findViewById(R.id.usb_microph);
            product_price = itemView.findViewById(R.id.usb_price);
            product_rating = itemView.findViewById(R.id.rating);

        }
    }
}
