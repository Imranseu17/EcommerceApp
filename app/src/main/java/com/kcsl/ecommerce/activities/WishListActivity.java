package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.OrderAdapter;
import com.kcsl.ecommerce.databinding.ActivityWishListBinding;

public class WishListActivity extends AppCompatActivity {
    
    ActivityWishListBinding wishListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        wishListBinding = DataBindingUtil. setContentView(this,R.layout.activity_wish_list);
         wishListBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 wishListBinding.shimmer.stopShimmerAnimation();
                 wishListBinding.shimmer.setVisibility(View.GONE);
                 wishListBinding.rvNewParcel.setVisibility(View.VISIBLE);
                // New product List
                 wishListBinding.rvNewParcel.setHasFixedSize(false);
                // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
                LinearLayoutManager layoutManager =
                        new LinearLayoutManager(WishListActivity.this, LinearLayoutManager.VERTICAL, false);
                 wishListBinding.rvNewParcel.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                OrderAdapter orderAdapter = new OrderAdapter(WishListActivity.this);
                 wishListBinding.rvNewParcel.setAdapter(orderAdapter);
            }
        },2000);
        
    }

    @Override
    public void onPause() {
        super.onPause();
         wishListBinding.shimmer.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
         wishListBinding.shimmer.stopShimmerAnimation();

    }
}