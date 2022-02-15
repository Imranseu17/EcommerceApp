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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PaymentMethodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    ArrayList paymentMethodImages;
    ArrayList<String> paymentMethodName;
    ArrayList<String> accountName;

    public PaymentMethodAdapter(Context context, ArrayList paymentMethodImages,
                                ArrayList<String> paymentMethodName,ArrayList<String> accountName) {
        this.context = context;
        this.paymentMethodImages = paymentMethodImages;
        this.paymentMethodName = paymentMethodName;
        this.accountName = accountName;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.payment_method_list, parent, false);
        viewHolder = new PaymentMethodAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PaymentMethodAdapter.MyViewHolder viewHolder  = new PaymentMethodAdapter.MyViewHolder(holder.itemView);
        viewHolder.paymentMethodName.setText(paymentMethodName.get(position));
        viewHolder.account.setText(" A/C: "+accountName.get(position));
        viewHolder.logo.setImageResource(Integer.parseInt(String.valueOf(paymentMethodImages.get(position))));
    }

    @Override
    public int getItemCount() {
        return paymentMethodImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView paymentMethodName,account;
        ImageView logo;

        public MyViewHolder(View itemView) {
            super(itemView);
           paymentMethodName = itemView.findViewById(R.id.paymentMethodName);
           account = itemView.findViewById(R.id.account);
           logo = itemView.findViewById(R.id.image);

        }
    }
}
