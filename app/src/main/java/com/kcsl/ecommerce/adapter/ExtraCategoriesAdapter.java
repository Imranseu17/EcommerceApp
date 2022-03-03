package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class ExtraCategoriesAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList  extra_categoriesImages;
    private List<String> extra_categories_Name = new ArrayList<>();

    public ExtraCategoriesAdapter(Context context, ArrayList  extra_categoriesImages, List<String> extra_categories_Name) {
        this.context = context;
        this. extra_categoriesImages =  extra_categoriesImages;
        this.extra_categories_Name = extra_categories_Name;
    }
    @Override
    public  ExtraCategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.extra_categories_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
         ExtraCategoriesAdapter.MyViewHolder vh = new  ExtraCategoriesAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         ExtraCategoriesAdapter.MyViewHolder viewHolder  = new  ExtraCategoriesAdapter.MyViewHolder(holder.itemView);
        viewHolder.categories_image.setImageResource(Integer.parseInt(String.valueOf( extra_categoriesImages.get(position))));
        viewHolder.categories_name.setText(extra_categories_Name.get(position));

    }



    @Override
    public int getItemCount() {
        return  extra_categoriesImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView categories_image ;
        TextView categories_name  ;

        public MyViewHolder(View itemView) {
            super(itemView);
             categories_image = itemView.findViewById(R.id.categories_image);
             categories_name = itemView.findViewById(R.id.categories_name);

        }
    }

}
