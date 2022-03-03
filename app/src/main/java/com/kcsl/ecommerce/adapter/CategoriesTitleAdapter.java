package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.models.CategoriesDatum;

import java.util.ArrayList;
import java.util.List;

public class CategoriesTitleAdapter extends RecyclerView.Adapter {
    Context context;
    private List<String> categoriesTitleList;


    public CategoriesTitleAdapter(Context context, List<String> categoriesTitleList) {
        this.context = context;
        this.categoriesTitleList = categoriesTitleList;
    }
    @Override
    public CategoriesTitleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_title_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CategoriesTitleAdapter.MyViewHolder vh = new CategoriesTitleAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CategoriesTitleAdapter.MyViewHolder viewHolder  = new CategoriesTitleAdapter.MyViewHolder(holder.itemView);
        viewHolder.categories_title_name.setText(categoriesTitleList.get(position));
        if(viewHolder.categories_title_name.getText().equals("All")){
            viewHolder.title_layout.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.categories_title_checked_backgroud));
        }else if(viewHolder.categories_title_name.getText().equals("Woman's Fashion")){
            viewHolder.title_layout.getLayoutParams().width = 300;
            viewHolder.title_layout.requestLayout();
            viewHolder.title_layout.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.categories_title_unchecked_background));
            viewHolder.categories_title_name.setTextColor(context.getColor(R.color.text_color));
        }else if(viewHolder.categories_title_name.getText().equals("Man's Fashion")){

            viewHolder.title_layout.getLayoutParams().width = 300;
            viewHolder.title_layout.requestLayout();
            viewHolder.title_layout.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.categories_title_unchecked_background));
            viewHolder.categories_title_name.setTextColor(context.getColor(R.color.text_color));
        }

        else{
            viewHolder.title_layout.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.categories_title_unchecked_background));
            viewHolder.categories_title_name.setTextColor(context.getColor(R.color.text_color));
        }

    }



    @Override
    public int getItemCount() {
        return categoriesTitleList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView categories_title_name;
      LinearLayout title_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            title_layout = itemView.findViewById(R.id.titleLayout);
            categories_title_name = itemView.findViewById(R.id.categories_title);
        }
    }
}
