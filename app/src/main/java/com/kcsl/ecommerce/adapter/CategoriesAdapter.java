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

public class CategoriesAdapter  extends RecyclerView.Adapter {
    Context context;
    private List<CategoriesDatum> categoriesDatumList = new ArrayList<>();
    ArrayList categoriesImages;

    public CategoriesAdapter(Context context, List<CategoriesDatum> categoriesDatumList,ArrayList categoriesImages ) {
        this.context = context;
        this.categoriesDatumList = categoriesDatumList;
        this.categoriesImages = categoriesImages;
    }
    @Override
    public CategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_adapter_all, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CategoriesAdapter.MyViewHolder vh = new CategoriesAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CategoriesAdapter.MyViewHolder viewHolder  = new CategoriesAdapter.MyViewHolder(holder.itemView);
        final CategoriesDatum categoriesDatum = categoriesDatumList.get(position);
        viewHolder.categories_image.setImageResource(Integer.parseInt(String.valueOf(categoriesImages.get(position))));
        viewHolder.categories_name.setText(categoriesDatum.getName());

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
        return 9;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView categories_name;
        ImageView categories_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            categories_name = itemView.findViewById(R.id.categoryName);
            categories_image = itemView.findViewById(R.id.categorySmallImage);
        }
    }
}
