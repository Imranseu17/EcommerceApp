package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.activities.ProductDetailsActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.models.ProductDatum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NumberOfProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    private List<ProductDatum> productDatumList;

    public NumberOfProductAdapter(Context context, List<ProductDatum> productDatumList) {
        this.context = context;
        this.productDatumList = productDatumList;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.product_display, parent, false);
        viewHolder = new NumberOfProductAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        NumberOfProductAdapter.MyViewHolder viewHolder  = new NumberOfProductAdapter.MyViewHolder(holder.itemView);
        final ProductDatum productDatum = productDatumList.get(position);

        if(productDatum.getBaseImage().getSmallImageUrl() != null){
            Glide.with(context).load(productDatum.getBaseImage().getMediumImageUrl()).
                    into(viewHolder.product_image);
        }else {
            viewHolder.product_image.setImageResource(R.drawable.prodct_display_border);
        }

        viewHolder.ratingBar.setRating(productDatum.getReviews().getTotalRating());
        viewHolder.product_name.setText(productDatum.getName());
        viewHolder.product_price.setText("\u09F3"+ productDatum.getFormatedPrice().substring(1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("id",productDatum.getId());
                context.startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return productDatumList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        RatingBar ratingBar;
        TextView product_name,product_price;
        public MyViewHolder(View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.productSmallImage);
            ratingBar = itemView.findViewById(R.id.productRating);
            product_name = itemView.findViewById(R.id.productName);
            product_price = itemView.findViewById(R.id.productPrice);
        }
    }
}
