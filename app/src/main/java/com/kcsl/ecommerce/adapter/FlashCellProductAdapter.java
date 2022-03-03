package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.models.CategoriesDatum;

import java.util.ArrayList;
import java.util.List;

public class FlashCellProductAdapter  extends RecyclerView.Adapter {

    Context context;
    ArrayList flashCellImages;

    public FlashCellProductAdapter(Context context,ArrayList flashCellImages) {
        this.context = context;
        this.flashCellImages = flashCellImages;
    }
    @Override
    public FlashCellProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flash_sell_product_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        FlashCellProductAdapter.MyViewHolder vh = new FlashCellProductAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        FlashCellProductAdapter.MyViewHolder viewHolder  = new FlashCellProductAdapter.MyViewHolder(holder.itemView);
        viewHolder.flashcellImage.setImageResource(Integer.parseInt(String.valueOf(flashCellImages.get(position))));
        viewHolder.flashCellOldPrice.setPaintFlags(viewHolder.flashCellOldPrice.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);

    }



    @Override
    public int getItemCount() {
        return flashCellImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView flashcellImage;
        TextView flashCellOldPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            flashcellImage = itemView.findViewById(R.id.flash_cell_image);
            flashCellOldPrice = itemView.findViewById(R.id.productOldPrice);

        }
    }

}
