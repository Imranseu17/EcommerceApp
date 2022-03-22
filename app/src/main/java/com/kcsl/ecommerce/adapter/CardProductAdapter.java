package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class CardProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    ArrayList product_image;
    private List<String> productName;
    private List<String> productSubName;
    private List<String> productPrice;


    public CardProductAdapter(Context context, ArrayList product_image, List<String> productName,
                              List<String> productSubName, List<String> productPrice) {

        this.context = context;
        this.product_image = product_image;
        this.productName = productName;
        this.productSubName = productSubName;
        this.productPrice = productPrice;


    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.card_product_xml, parent, false);
        viewHolder = new CardProductAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CardProductAdapter.MyViewHolder viewHolder  = new CardProductAdapter.MyViewHolder(holder.itemView);

        viewHolder.product_name.setText(productName.get(position));
        viewHolder.product_price.setText(productPrice.get(position));
        viewHolder.product_sub_name.setText(productSubName.get(position));
        viewHolder.product_image.setImageResource(Integer.parseInt(String.valueOf(product_image.get(position))));

        if(position%2==0){
            viewHolder.love_icon.setImageResource(R.drawable.wishlist);
        }

        else{
            viewHolder.love_icon.setImageResource(R.drawable.love);
        }



    }



    @Override
    public int getItemCount() {
        return 3;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView love_icon,product_image,delete_icon;
        LinearLayout min_icon,max_icon;
        TextView value_text,product_name,product_sub_name,product_price;


        public MyViewHolder(View itemView) {
            super(itemView);
            love_icon = itemView.findViewById(R.id.love_icon);
            product_image = itemView.findViewById(R.id.product_image);
            delete_icon = itemView.findViewById(R.id.delete_icon);
            min_icon = itemView.findViewById(R.id.min_icon);
            max_icon = itemView.findViewById(R.id.add_icon);
            value_text = itemView.findViewById(R.id.value_text);
            product_name = itemView.findViewById(R.id.product_name);
            product_sub_name = itemView.findViewById(R.id.product_sub_name);
            product_price = itemView.findViewById(R.id.product_price);

        }
    }
}
