package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductDetailsActivity;
import com.kcsl.ecommerce.models.ProductDatum;

import java.util.ArrayList;
import java.util.List;

public class NewUserGiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    private List<String> parcentegeText;
    private List<String> productName;
    private List<String> productPrice;
    private List<String> productOldPrice;
    ArrayList images;

    public NewUserGiftAdapter(Context context, List<String> parcentegeText,List<String> productName,
                              List<String> productPrice,List<String> productOldPrice,ArrayList images) {
        this.context = context;
        this.parcentegeText = parcentegeText;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOldPrice = productOldPrice;
        this.images = images;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.new_user_gift_list, parent, false);
        viewHolder = new NewUserGiftAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        NewUserGiftAdapter.MyViewHolder viewHolder  = new NewUserGiftAdapter.MyViewHolder(holder.itemView);

        viewHolder.product_name.setText(productName.get(position));
        viewHolder.product_price.setText(productPrice.get(position));
        viewHolder.product_old_price.setText(productOldPrice.get(position));
        viewHolder.product_parcentege.setText(parcentegeText.get(position));
        viewHolder.gift_image.setImageResource(Integer.parseInt(String.valueOf(images.get(position))));

        viewHolder.product_old_price.setPaintFlags(viewHolder.product_old_price.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);

        if(position%2==0){
            viewHolder.favorite_image.setImageResource(R.drawable.wishlist);
        }

        else{
            viewHolder.favorite_image.setImageResource(R.drawable.love);
        }



    }



    @Override
    public int getItemCount() {
        return productName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView favorite_image,gift_image;
        RelativeLayout relativeLayout;
        TextView product_name,product_price,product_old_price,product_parcentege;


        public MyViewHolder(View itemView) {
            super(itemView);
            favorite_image = itemView.findViewById(R.id.favoriteImage);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
            product_name = itemView.findViewById(R.id.productName);
            product_price = itemView.findViewById(R.id.productPrice);
            product_old_price = itemView.findViewById(R.id.productOldPrice);
            product_parcentege = itemView.findViewById(R.id.percerntege);
            gift_image = itemView.findViewById(R.id.giftImage);

        }
    }
}
