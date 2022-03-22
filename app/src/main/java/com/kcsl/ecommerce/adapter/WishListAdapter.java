package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    private List<String> parcentegeText;
    private List<String> productName;
    private List<String> productPrice;
    private List<String> productOldPrice;

    public WishListAdapter(Context context, List<String> parcentegeText, List<String> productName,
                           List<String> productPrice, List<String> productOldPrice) {
        this.context = context;
        this.parcentegeText = parcentegeText;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOldPrice = productOldPrice;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.wish_list_design, parent, false);
        viewHolder = new WishListAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        WishListAdapter.MyViewHolder viewHolder  = new WishListAdapter.MyViewHolder(holder.itemView);

        viewHolder.product_name.setText(productName.get(position));
        viewHolder.product_price.setText(productPrice.get(position));
        viewHolder.product_old_price.setText(productOldPrice.get(position));
        viewHolder.product_parcentege.setText(parcentegeText.get(position));

        viewHolder.product_old_price.setPaintFlags(viewHolder.product_old_price.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);

        if(position%2==0){
            viewHolder.favorite_image.setImageResource(R.drawable.wishlist);
            viewHolder.productImage.setImageResource(R.drawable.dkny);
        }

        else{
            viewHolder.favorite_image.setImageResource(R.drawable.love);
            viewHolder.productImage.setImageResource(R.drawable.tommy);
        }



    }



    @Override
    public int getItemCount() {
        return productName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView favorite_image;
        ImageView productImage;
        TextView product_name,product_price,product_old_price,product_parcentege;


        public MyViewHolder(View itemView) {
            super(itemView);
            favorite_image = itemView.findViewById(R.id.favoriteImage);
            productImage = itemView.findViewById(R.id.productImage);
            product_name = itemView.findViewById(R.id.productName);
            product_price = itemView.findViewById(R.id.productPrice);
            product_old_price = itemView.findViewById(R.id.productOldPrice);
            product_parcentege = itemView.findViewById(R.id.percerntege);

        }
    }
}
