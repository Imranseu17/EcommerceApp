package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.CategoryProductDesignAdapter;
import com.kcsl.ecommerce.adapter.ItemProductList;
import com.kcsl.ecommerce.adapter.PaymentAdapter;
import com.kcsl.ecommerce.databinding.ActivityCardPropertiesBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CardPropertiesActivity extends AppCompatActivity {

    private int currentApiVersion;
    ActivityCardPropertiesBinding cardPropertiesBinding;

    ArrayList paymentIcon =  new ArrayList<>(Arrays.asList(R.drawable.ic_credit_card_black_24dp,R.drawable.bkash,
            R.drawable.nogod,R.drawable.cash_on_delivery,R.drawable.ic_outline_account_balance_wallet_24));

    ArrayList<String> paymentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        cardPropertiesBinding = DataBindingUtil. setContentView(this,R.layout.activity_card_properties);
        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        cardPropertiesBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cardPropertiesBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardPropertiesActivity.this,NotificationActivity.class));
            }
        });

        cardPropertiesBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardPropertiesActivity.this,SearchProductActivity.class));
            }
        });

        cardPropertiesBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardPropertiesActivity.this,SearchProductActivity.class));
            }
        });

        cardPropertiesBinding.paymentList.setHasFixedSize(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cardPropertiesBinding.paymentList.setLayoutManager(layoutManager1);
        paymentName = new ArrayList<>();
        paymentName.add("Credit Card Or Debit");
        paymentName.add("BKash");
        paymentName.add("Nagod");
        paymentName.add("Cash On Delivery");
        paymentName.add("Wallet");
        PaymentAdapter paymentAdapter =
                new PaymentAdapter(this,paymentIcon,paymentName);
        cardPropertiesBinding.paymentList.setAdapter(paymentAdapter);

        cardPropertiesBinding.itemList.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cardPropertiesBinding.itemList.setLayoutManager(layoutManager2);
        ItemProductList itemProductList =
                new ItemProductList(this);
        cardPropertiesBinding.itemList.setAdapter(itemProductList);

        cardPropertiesBinding.addAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardPropertiesActivity.this,AddAddressActivity.class));
            }
        });

    }
}