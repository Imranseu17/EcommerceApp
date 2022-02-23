package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.activities.ProductDetailsActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.models.CategoriesDatum;
import com.kcsl.ecommerce.models.ProductDatum;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCategoriesAdapter extends RecyclerView.Adapter {

    Context context;
    private List<CategoriesDatum> categoriesDatumList;
    ArrayList categoriesImages;

    public NumberOfCategoriesAdapter(Context context, List<CategoriesDatum> categoriesDatumList,ArrayList categoriesImages ) {
        this.context = context;
        this.categoriesDatumList = categoriesDatumList;
        this.categoriesImages = categoriesImages;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_design_updated, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder  = new  MyViewHolder(holder.itemView);
        final CategoriesDatum categoriesDatum = categoriesDatumList.get(position);
        viewHolder.categoryImage.setImageResource(Integer.parseInt(String.valueOf(categoriesImages.get(position))));
        viewHolder.categoryName.setText(categoriesDatum.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductsActivity.class);
                intent.putExtra("id", categoriesDatum.getId());
                intent.putExtra("name", categoriesDatum.getName());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return categoriesDatumList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;
        public MyViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categorySmallImage);
            categoryName = itemView.findViewById(R.id.category_name);
        }
    }

}
