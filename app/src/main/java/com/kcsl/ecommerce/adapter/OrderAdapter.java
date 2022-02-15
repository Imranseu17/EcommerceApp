package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.row_orders, parent, false);
        viewHolder = new OrderAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        OrderAdapter.MyViewHolder viewHolder  = new OrderAdapter.MyViewHolder(holder.itemView);
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd MMM yyyy, HH:mm a");
        Date date = new Date();
        String dateString =  formatterDate.format(date);
        viewHolder.dateTime.setText(dateString);
        viewHolder.price.setText(" Price : "+"\u09F3"+500.25+" TK ");

    }



    @Override
    public int getItemCount() {
        return 10;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView dateTime,price;


        public MyViewHolder(View itemView) {
            super(itemView);
            dateTime = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);

        }
    }
}
