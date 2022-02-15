package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.models.CategoriesDatum;
import com.kcsl.ecommerce.models.Item;
import com.kcsl.ecommerce.models.ShoppingData;
import com.kcsl.ecommerce.models.ShoppingProduct;
import com.kcsl.ecommerce.utils.SharedDataSaveLoad;

import java.util.List;

public class CheckoutItemAdapter extends RecyclerView.Adapter {

    Context context;
    private List<Item> shoppingProductList;
    int value = 1;

    public CheckoutItemAdapter(Context context, List<Item> shoppingProductList ) {
        this.context = context;
        this.shoppingProductList = shoppingProductList;
    }
    @Override
    public CheckoutItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CheckoutItemAdapter.MyViewHolder vh = new CheckoutItemAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CheckoutItemAdapter.MyViewHolder viewHolder  = new CheckoutItemAdapter.MyViewHolder(holder.itemView);
        final Item shoppingProduct = shoppingProductList.get(position);
        if(shoppingProduct.getProduct().getBaseImage().getLargeImageUrl() != null){
            Glide.with(context).load(shoppingProduct.getProduct().getBaseImage().getLargeImageUrl()).
                    into(viewHolder.image);
        }else {
            viewHolder.image.setImageResource(R.drawable.prodct_display_border);
        }
        viewHolder.name.setText(shoppingProduct.getProduct().getName());
        viewHolder.amount.setText(shoppingProduct.getProduct().getFormatedPrice());
        viewHolder.sku.setText("SKU: "+shoppingProduct.getProduct().getSku());

        viewHolder.max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value++;
                SharedDataSaveLoad.save(context,"value",value);
            }
        });

        viewHolder.min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value--;
                SharedDataSaveLoad.save(context,"value",value);
            }
        });

        viewHolder.value.setText(SharedDataSaveLoad.loadInt(context,"value")==0?
                1:SharedDataSaveLoad.loadInt(context,"value"));

    }



    @Override
    public int getItemCount() {
        return shoppingProductList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,amount,sku,value;
        AppCompatImageView image,max,min;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            sku = itemView.findViewById(R.id.sku);
            image = itemView.findViewById(R.id.image);
            max = itemView.findViewById(R.id.max);
            min = itemView.findViewById(R.id.min);
            value = itemView.findViewById(R.id.value);
        }
    }
}
