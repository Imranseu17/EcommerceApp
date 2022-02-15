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
import com.kcsl.ecommerce.adapter.PaymentMethodAdapter;
import com.kcsl.ecommerce.databinding.ActivityPaymentMethodBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentMethodActivity extends AppCompatActivity {

    ActivityPaymentMethodBinding paymentMethodBinding;

    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.bkash,R.drawable.visa,
            R.drawable.mastercard,R.drawable.dbbl,R.drawable.merchant));
    ArrayList<String> paymentMethod = new ArrayList<String>();
    ArrayList<String> accountNo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        paymentMethodBinding = DataBindingUtil. setContentView(this,R.layout.activity_payment_method);
        paymentMethod.add("Bkash");
        paymentMethod.add("Visa Card");
        paymentMethod.add("Master Card");
        paymentMethod.add("DBBL");
        paymentMethod.add("Merchent Card");
        accountNo.add("01764310157");
        accountNo.add("01526569648566");
        accountNo.add("016265959655988748");
        accountNo.add("01769999494984984994");
        accountNo.add("018265696485666525876749");
        paymentMethodBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                paymentMethodBinding.shimmer.stopShimmerAnimation();
                paymentMethodBinding.shimmer.setVisibility(View.GONE);
                paymentMethodBinding.rvPaymentMethod.setVisibility(View.VISIBLE);
                // New product List
                paymentMethodBinding.rvPaymentMethod.setHasFixedSize(false);
                // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
                LinearLayoutManager layoutManager =
                        new LinearLayoutManager(PaymentMethodActivity.this, LinearLayoutManager.VERTICAL, false);
                paymentMethodBinding.rvPaymentMethod.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                PaymentMethodAdapter paymentMethodAdapter = new PaymentMethodAdapter(PaymentMethodActivity.this
                                                             ,images,paymentMethod,accountNo);
                paymentMethodBinding.rvPaymentMethod.setAdapter(paymentMethodAdapter);
            }
        },2000);

    }

    @Override
    public void onPause() {
        super.onPause();
        paymentMethodBinding.shimmer.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
        paymentMethodBinding.shimmer.stopShimmerAnimation();

    }
}