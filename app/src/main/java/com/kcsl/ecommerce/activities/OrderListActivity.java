package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.NumberOfProductAdapter;
import com.kcsl.ecommerce.adapter.OrderAdapter;
import com.kcsl.ecommerce.databinding.ActivityOrderListBinding;

public class OrderListActivity extends AppCompatActivity {

    ActivityOrderListBinding orderListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        orderListBinding = DataBindingUtil. setContentView(this,R.layout.activity_order_list);

        orderListBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                orderListBinding.shimmer.stopShimmerAnimation();
                orderListBinding.shimmer.setVisibility(View.GONE);
                orderListBinding.rvNewParcel.setVisibility(View.VISIBLE);
                // New product List
                orderListBinding.rvNewParcel.setHasFixedSize(false);
                // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
               LinearLayoutManager  layoutManager =
                       new LinearLayoutManager(OrderListActivity.this, LinearLayoutManager.VERTICAL, false);
                orderListBinding.rvNewParcel.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                OrderAdapter orderAdapter = new OrderAdapter(OrderListActivity.this);
                orderListBinding.rvNewParcel.setAdapter(orderAdapter);
            }
        },2000);



    }

    @Override
    public void onPause() {
        super.onPause();
        orderListBinding.shimmer.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
        orderListBinding.shimmer.stopShimmerAnimation();

    }
}