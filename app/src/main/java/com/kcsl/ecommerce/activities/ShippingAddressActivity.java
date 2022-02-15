package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityShippingAddressBinding;

public class ShippingAddressActivity extends AppCompatActivity {

    ActivityShippingAddressBinding shippingAddressBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        shippingAddressBinding = DataBindingUtil. setContentView(this,R.layout.activity_shipping_address);
        shippingAddressBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shippingAddressBinding.searchIvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShippingAddressActivity.this,AddressActivity.class));
            }
        });
    }


}