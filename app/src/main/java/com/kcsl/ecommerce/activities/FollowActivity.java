package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.ProductDesignAdapter;
import com.kcsl.ecommerce.databinding.ActivityFollowBinding;

import java.util.ArrayList;

public class FollowActivity extends AppCompatActivity {

    ActivityFollowBinding followBinding;
    private int currentApiVersion;

    RecyclerView productDesignList1;
    RecyclerView  productDesignList2;
    RecyclerView  productDesignList3;
    RecyclerView  productDesignList4;

    ArrayList<String> productDesignName_one;
    ArrayList<String> productDesignName_two;
    ArrayList<String> productDesignName_three;
    ArrayList<String> productDesignName_four;

    ArrayList<String> productDesignPrice_one;
    ArrayList<String> productDesignPrice_two;
    ArrayList<String> productDesignPrice_three;
    ArrayList<String> productDesignPrice_four;

    ArrayList<String> productDesignOldPrice_one;
    ArrayList<String> productDesignOldPrice_two;
    ArrayList<String> productDesignOldPrice_three;
    ArrayList<String> productDesignOldPrice_four;

    ArrayList<String> productDesignPercentege_one;
    ArrayList<String> productDesignPercentege_two;
    ArrayList<String> productDesignPercentege_three;
    ArrayList<String> productDesignPercentege_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        followBinding = DataBindingUtil. setContentView(this,R.layout.activity_follow);
        productDesignList1 = followBinding.productDesignListOne;
        productDesignList2 = followBinding.productDesignListTwo;
        productDesignList3 = followBinding.productDesignListThree;
        productDesignList4 = followBinding.productDesignListFour;

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

        followBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        followBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FollowActivity.this,NotificationActivity.class));
            }
        });

        followBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FollowActivity.this,SearchProductActivity.class));
            }
        });

        followBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FollowActivity.this,SearchProductActivity.class));
            }
        });

        getAllProductDataList();
    }

    private void getAllProductDataList()
    {
        productDesignName_one = new ArrayList<>();
        productDesignName_two = new ArrayList<>();
        productDesignName_three = new ArrayList<>();
        productDesignName_four = new ArrayList<>();

        productDesignPrice_one = new ArrayList<>();
        productDesignPrice_two = new ArrayList<>();
        productDesignPrice_three = new ArrayList<>();
        productDesignPrice_four = new ArrayList<>();

        productDesignOldPrice_one = new ArrayList<>();
        productDesignOldPrice_two = new ArrayList<>();
        productDesignOldPrice_three = new ArrayList<>();
        productDesignOldPrice_four = new ArrayList<>();

        productDesignPercentege_one = new ArrayList<>();
        productDesignPercentege_two = new ArrayList<>();
        productDesignPercentege_three = new ArrayList<>();
        productDesignPercentege_four = new ArrayList<>();

        productDesignPercentege_one.add("-60%");
        productDesignPercentege_one.add("-50%");
        productDesignPercentege_one.add("-40%");
        productDesignPercentege_one.add("-30%");

        productDesignPercentege_two.add("-60%");
        productDesignPercentege_two.add("-50%");
        productDesignPercentege_two.add("-40%");
        productDesignPercentege_two.add("-30%");

        productDesignPercentege_three.add("-60%");
        productDesignPercentege_three.add("-50%");
        productDesignPercentege_three.add("-40%");
        productDesignPercentege_three.add("-30%");

        productDesignPercentege_four.add("-60%");
        productDesignPercentege_four.add("-50%");
        productDesignPercentege_four.add("-40%");
        productDesignPercentege_four.add("-30%");

        productDesignName_one.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_one.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_one.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_one.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_two.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_two.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_two.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_two.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_three.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_three.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_three.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_three.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_four.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_four.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_four.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_four.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignPrice_one.add("BDT 19");
        productDesignPrice_one.add("BDT 55");
        productDesignPrice_one.add("BDT 19");
        productDesignPrice_one.add("BDT 55");

        productDesignPrice_two.add("BDT 19");
        productDesignPrice_two.add("BDT 55");
        productDesignPrice_two.add("BDT 19");
        productDesignPrice_two.add("BDT 55");

        productDesignPrice_three.add("BDT 19");
        productDesignPrice_three.add("BDT 55");
        productDesignPrice_three.add("BDT 19");
        productDesignPrice_three.add("BDT 55");

        productDesignPrice_four.add("BDT 19");
        productDesignPrice_four.add("BDT 55");
        productDesignPrice_four.add("BDT 19");
        productDesignPrice_four.add("BDT 55");


        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");

        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");

        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");

        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");


        productDesignList1.setHasFixedSize(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productDesignList1.setLayoutManager(layoutManager1);
        ProductDesignAdapter productDesignAdapter1 = new ProductDesignAdapter(this,productDesignPercentege_one,
                productDesignName_one,productDesignPrice_one,productDesignOldPrice_one);
        productDesignList1.setAdapter(productDesignAdapter1);

        productDesignList2.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productDesignList2.setLayoutManager(layoutManager2);
        ProductDesignAdapter productDesignAdapter2 = new ProductDesignAdapter(this,productDesignPercentege_two,
                productDesignName_two,productDesignPrice_two,productDesignOldPrice_two);
        productDesignList2.setAdapter(productDesignAdapter2);

        productDesignList3.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productDesignList3.setLayoutManager(layoutManager3);
        ProductDesignAdapter productDesignAdapter3 = new ProductDesignAdapter(this,productDesignPercentege_three,
                productDesignName_three,productDesignPrice_three,productDesignOldPrice_three);
        productDesignList3.setAdapter(productDesignAdapter3);

        productDesignList4.setHasFixedSize(false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productDesignList4.setLayoutManager(layoutManager4);
        ProductDesignAdapter productDesignAdapter4 = new ProductDesignAdapter(this,productDesignPercentege_four,
                productDesignName_four,productDesignPrice_four,productDesignOldPrice_four);
        productDesignList4.setAdapter(productDesignAdapter4);
    }
}