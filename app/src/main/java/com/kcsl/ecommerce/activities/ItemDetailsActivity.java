package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.BannerListAdapter;
import com.kcsl.ecommerce.adapter.CategoriesTitleAdapter;
import com.kcsl.ecommerce.adapter.ColorAdapterLayout;
import com.kcsl.ecommerce.adapter.NewUserGiftAdapter;
import com.kcsl.ecommerce.adapter.SizeAdapterLayout;
import com.kcsl.ecommerce.databinding.ActivityItemDetailsBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemDetailsActivity extends AppCompatActivity {

    private int currentApiVersion;
    ActivityItemDetailsBinding itemDetailsBinding;

    ArrayList<String> newGiftProductParcentege;
    ArrayList<String> newGiftProductName;
    ArrayList<String> newGiftProductPrice;
    ArrayList<String> newGiftProductOldPrice;
    RecyclerView newGiftProductList;

    ArrayList newUserGiftImages =
            new ArrayList<>(Arrays.asList(R.drawable.dkny,R.drawable.tommy,R.drawable.dkny,
                    R.drawable.tommy,R.drawable.dkny));

    ArrayList<String> sizeAdapterListName;

    ArrayList sizeImages =
            new ArrayList<>(Arrays.asList(R.drawable.color_image_one,R.drawable.color_image_two,R.drawable.color_image_three,
                    R.drawable.color_image_one,R.drawable.color_image_three));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        itemDetailsBinding = DataBindingUtil. setContentView(this,R.layout.activity_item_details);
        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                 newGiftProductList = itemDetailsBinding.relatedProductList;
        itemDetailsBinding.productOldPrice.setPaintFlags(itemDetailsBinding.productOldPrice.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);
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

        itemDetailsBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        itemDetailsBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemDetailsActivity.this,NotificationActivity.class));
            }
        });

        itemDetailsBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemDetailsActivity.this,SearchProductActivity.class));
            }
        });

        itemDetailsBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemDetailsActivity.this,SearchProductActivity.class));
            }
        });

        getAllColourList();
        getAllSizeList();
        getAllGiftList();

    }

    private void getAllGiftList()
    {
        newGiftProductParcentege = new ArrayList<>();
        newGiftProductName = new ArrayList<>();
        newGiftProductPrice = new ArrayList<>();
        newGiftProductOldPrice = new ArrayList<>();

        newGiftProductParcentege.add("-60%");
        newGiftProductParcentege.add("-50%");
        newGiftProductParcentege.add("-40%");
        newGiftProductParcentege.add("-30%");
        newGiftProductParcentege.add("-20%");

        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");
        newGiftProductName.add("Tommy Hilfiger padded \n jackets - black with...");
        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");
        newGiftProductName.add("Tommy Hilfiger padded \n jackets - black with...");
        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");

        newGiftProductPrice.add("BDT 19");
        newGiftProductPrice.add("BDT 55");
        newGiftProductPrice.add("BDT 19");
        newGiftProductPrice.add("BDT 55");
        newGiftProductPrice.add("BDT 19");

        newGiftProductOldPrice.add("BDT69");
        newGiftProductOldPrice.add("BDT110");
        newGiftProductOldPrice.add("BDT69");
        newGiftProductOldPrice.add("BDT110");
        newGiftProductOldPrice.add("BDT69");

        newGiftProductList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newGiftProductList.setLayoutManager(layoutManager);

        NewUserGiftAdapter newUserGiftAdapter = new NewUserGiftAdapter(this,newGiftProductParcentege,
                newGiftProductName,newGiftProductPrice,newGiftProductOldPrice,newUserGiftImages);
        newGiftProductList.setAdapter(newUserGiftAdapter);
    }

    private void getAllSizeList()
    {
        sizeAdapterListName = new ArrayList<>();
        itemDetailsBinding.sizesList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        itemDetailsBinding.sizesList.setLayoutManager(layoutManager);
        sizeAdapterListName.add("XXS");
        sizeAdapterListName.add("XS");
        sizeAdapterListName.add("S");
        sizeAdapterListName.add("M");
        sizeAdapterListName.add("L");
        sizeAdapterListName.add("XL");
        SizeAdapterLayout sizeAdapterLayout = new SizeAdapterLayout(this,sizeAdapterListName);
        itemDetailsBinding.sizesList.setAdapter(sizeAdapterLayout);
    }

    private void getAllColourList()
    {
        itemDetailsBinding.coloursList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        itemDetailsBinding.coloursList.setLayoutManager(layoutManager);
        ColorAdapterLayout colorAdapterLayout = new ColorAdapterLayout(this,sizeImages);
        itemDetailsBinding.coloursList.setAdapter(colorAdapterLayout);
    }
}