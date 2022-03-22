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

public class PaymentAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList paymentListIcon;
    private List<String> paymentListText=new ArrayList<>();


    public PaymentAdapter(Context context, ArrayList paymentListIcon, List<String> paymentListText) {
        this.context = context;
        this.paymentListIcon = paymentListIcon;
        this.paymentListText = paymentListText;
    }

    @Override
    public PaymentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PaymentAdapter.MyViewHolder vh = new PaymentAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PaymentAdapter.MyViewHolder viewHolder = new PaymentAdapter.MyViewHolder(holder.itemView);
        viewHolder.payment_text.setText(paymentListText.get(position));
        viewHolder.payment_icon.setImageResource(Integer.parseInt(String.valueOf(paymentListIcon.get(position))));

    }


    @Override
    public int getItemCount() {
        return paymentListText.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView payment_icon ;
        TextView   payment_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            payment_icon = itemView.findViewById(R.id.payment_icon);
            payment_text = itemView.findViewById(R.id.payment_name);

        }
    }

}
