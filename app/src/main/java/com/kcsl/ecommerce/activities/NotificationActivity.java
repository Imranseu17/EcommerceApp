package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.NotificationAdapter;
import com.kcsl.ecommerce.adapter.PaymentMethodAdapter;
import com.kcsl.ecommerce.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {
    
    ActivityNotificationBinding notificationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        notificationBinding = DataBindingUtil. setContentView(this,R.layout.activity_notification);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notificationBinding.shimmer.stopShimmerAnimation();
                notificationBinding.shimmer.setVisibility(View.GONE);
                notificationBinding.rvPaymentMethod.setVisibility(View.VISIBLE);
                // New product List
                notificationBinding.rvPaymentMethod.setHasFixedSize(false);
                // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
                LinearLayoutManager layoutManager =
                        new LinearLayoutManager(NotificationActivity.this, LinearLayoutManager.VERTICAL, false);
                notificationBinding.rvPaymentMethod.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                NotificationAdapter notificationAdapter = new NotificationAdapter(NotificationActivity.this);

                notificationBinding.rvPaymentMethod.setAdapter(notificationAdapter);
            }
        },2000);

        notificationBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        notificationBinding.shimmer.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
       notificationBinding.shimmer.stopShimmerAnimation();

    }
}