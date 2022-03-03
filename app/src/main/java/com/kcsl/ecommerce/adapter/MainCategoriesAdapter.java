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
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.models.CategoriesDatum;

import java.util.ArrayList;
import java.util.List;

public class MainCategoriesAdapter extends RecyclerView.Adapter {
    Context context;
    private List<String> categoriesName = new ArrayList<>();
    ArrayList categoriesImages;

    public MainCategoriesAdapter(Context context, List<String> categoriesName, ArrayList categoriesImages) {
        this.context = context;
        this.categoriesName = categoriesName;
        this.categoriesImages = categoriesImages;
    }

    @Override
    public MainCategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MainCategoriesAdapter.MyViewHolder vh = new MainCategoriesAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MainCategoriesAdapter.MyViewHolder viewHolder = new MainCategoriesAdapter.MyViewHolder(holder.itemView);
        viewHolder.categories_image.setImageResource(Integer.parseInt(String.valueOf(categoriesImages.get(position))));
        viewHolder.categories_name.setText(categoriesName.get(position));


    }


    @Override
    public int getItemCount() {
        return categoriesImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView categories_name;
        ImageView categories_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            categories_name = itemView.findViewById(R.id.category_name);
            categories_image = itemView.findViewById(R.id.categorySmallImage);
        }
    }

}
