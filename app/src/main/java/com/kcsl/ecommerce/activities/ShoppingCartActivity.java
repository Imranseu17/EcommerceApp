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
import com.kcsl.ecommerce.adapter.CardProductAdapter;
import com.kcsl.ecommerce.adapter.FlashCellProductAdapter;
import com.kcsl.ecommerce.databinding.ActivityShoppingCartBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCartActivity extends AppCompatActivity {

    private int currentApiVersion;
    ActivityShoppingCartBinding shoppingCartBinding;
    ArrayList<String> product_name,product_price,product_sub_name;
    ArrayList product_images =  new ArrayList<>(Arrays.asList(R.drawable.nike_air_max,
            R.drawable.new_nike_air,R.drawable.nike_air_max));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        shoppingCartBinding = DataBindingUtil. setContentView(this,R.layout.activity_shopping_cart);
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

        shoppingCartBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        shoppingCartBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShoppingCartActivity.this,NotificationActivity.class));
            }
        });

        shoppingCartBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShoppingCartActivity.this,SearchProductActivity.class));
            }
        });

        shoppingCartBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShoppingCartActivity.this,SearchProductActivity.class));
            }
        });

        shoppingCartBinding.checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShoppingCartActivity.this,CardPropertiesActivity.class));
            }
        });



        getAllProductList();
    }

    private void getAllProductList()
    {
        product_name = new ArrayList<>();
        product_name.add("Nike Air Zoom Pegasus");
        product_name.add("Nike Air Zoom max Pegasus");
        product_name.add("Nike Air Zoom max Pegasus");

        product_sub_name = new ArrayList<>();
        product_sub_name.add("36 Miami");
        product_sub_name.add("46 Miami");
        product_sub_name.add("56 Miami");

        product_price = new ArrayList<>();
        product_price.add("BDT 1099.25");
        product_price.add("BDT 2099.25");
        product_price.add("BDT 3099.25");

        shoppingCartBinding.cardProductList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        shoppingCartBinding.cardProductList.setLayoutManager(layoutManager);
        CardProductAdapter cardProductAdapter  = new CardProductAdapter(this,product_images,
                product_name,product_sub_name,product_price);
        shoppingCartBinding.cardProductList.setAdapter(cardProductAdapter);
    }
}