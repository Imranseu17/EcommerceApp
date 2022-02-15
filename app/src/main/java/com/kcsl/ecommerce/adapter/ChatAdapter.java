package com.kcsl.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatAdapter extends RecyclerView.Adapter{
    int size;
    Context context;
    ArrayList<String> timeList;
    ArrayList<String>  message;

    public ChatAdapter(int size, Context context,ArrayList<String> message,
                      ArrayList<String> timeList) {
        this.size = size;
        this.context = context;
        this.message = message;
        this.timeList = timeList;
    }

    @NonNull
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_adapter, parent, false);
        // set the view's size, margins, paddings and layout parameters
       ChatAdapter.MyViewHolder vh = new ChatAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ChatAdapter.MyViewHolder viewHolder  = new ChatAdapter.MyViewHolder(holder.itemView);

        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateString =  formatterDate.format(date);

        viewHolder.text_date.setText(dateString);
        viewHolder.text_timestamp.setText(timeList.get(position));
        viewHolder.text_message.setText(message.get(position));

    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView text_timestamp,text_message,text_date;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            text_date = itemView.findViewById(R.id.text_date);
            text_message = itemView.findViewById(R.id.text_message);
            text_timestamp = itemView.findViewById(R.id.text_timestamp);
        }
    }
}
