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
import android.widget.BaseAdapter;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.AdjustListAdapter;
import com.kcsl.ecommerce.adapter.BasedOnAdapter;
import com.kcsl.ecommerce.adapter.CategoriesTitleAdapter;
import com.kcsl.ecommerce.adapter.PeopleSearchAdapter;
import com.kcsl.ecommerce.adapter.WorkSpaceAdapter;
import com.kcsl.ecommerce.adapter.YoutubersDataAdapter;
import com.kcsl.ecommerce.databinding.ActivityWorkSpaceBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkSpaceActivity extends AppCompatActivity {

    private int currentApiVersion;
    ActivityWorkSpaceBinding workSpaceBinding;
    ArrayList<String> workSpaceTitleList;
    ArrayList<String> productName;
    ArrayList<String> productPrice;
    ArrayList<String> productRating;
    ArrayList youtuberImages =
            new ArrayList<>(Arrays.asList(R.drawable.usb_microphone,R.drawable.headphone_workspce,R.drawable.huawei_laptop,
                    R.drawable.usb_microphone,R.drawable.huawei_laptop));
    ArrayList workspaceImages =
            new ArrayList<>(Arrays.asList(R.drawable.huawei_laptop,R.drawable.digital_marketing,R.drawable.huawei_laptop,
                    R.drawable.digital_marketing,R.drawable.huawei_laptop));
    ArrayList<String> workspaceName;
    ArrayList<String> workspaceContent;

    ArrayList basedOnImages =
            new ArrayList<>(Arrays.asList(R.drawable.huawei_laptop,R.drawable.jvc_preview,R.drawable.headphone_workspce,
                    R.drawable.apple,R.drawable.jvc_preview));
    ArrayList<String> basedOnName;
    ArrayList<String> basedOnContent;
    ArrayList<String> basedOnRating;
    ArrayList<String> basedOnPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        workSpaceBinding = DataBindingUtil. setContentView(this,R.layout.activity_work_space);
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

        workSpaceBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        workSpaceBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkSpaceActivity.this,NotificationActivity.class));
            }
        });

        workSpaceBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkSpaceActivity.this,SearchProductActivity.class));
            }
        });

        workSpaceBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkSpaceActivity.this,SearchProductActivity.class));
            }
        });

        getAllWorkspaceList();
        getAllYoutubeList();
        getAllPeopleSearchFor();
        getAllBrowsingHistoryList();

    }

    private void getAllWorkspaceList()
    {
        workSpaceTitleList = new ArrayList<>();
        workSpaceBinding.browseWorkspaceList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        workSpaceBinding.browseWorkspaceList.setLayoutManager(layoutManager);
        workSpaceTitleList.add("Show all");
        workSpaceTitleList.add("Developer");
        workSpaceTitleList.add("Podcast creator");
        workSpaceTitleList.add("Filmaking");
        workSpaceTitleList.add("Photography");
        CategoriesTitleAdapter categoriesTitleAdapter = new CategoriesTitleAdapter(this,workSpaceTitleList);
        workSpaceBinding.browseWorkspaceList.setAdapter(categoriesTitleAdapter);
    }

    private void getAllYoutubeList()
    {
        productName = new ArrayList<>();
        productPrice = new ArrayList<>();
        productRating = new ArrayList<>();
        workSpaceBinding.youtuberList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        workSpaceBinding.youtuberList.setLayoutManager(layoutManager);

        productName.add("USB Microphone");
        productName.add("Wireless headset");
        productName.add("Huawei Laptop");
        productName.add("USB Microphone");
        productName.add("Huawei Laptop");

        productPrice.add("BDT 87.00");
        productPrice.add("BDT 74.00");
        productPrice.add("BDT 599.00");
        productPrice.add("BDT 87.00");
        productPrice.add("BDT 599.00");

        productRating.add("4.8");
        productRating.add("3.8");
        productRating.add("2.8");
        productRating.add("1.8");
        productRating.add("5.8");



        YoutubersDataAdapter youtubersDataAdapter = new YoutubersDataAdapter(this,
                productName,productPrice,productRating,youtuberImages);
        workSpaceBinding.youtuberList.setAdapter(youtubersDataAdapter);
    }

    private void getAllPeopleSearchFor()
    {
        workspaceName = new ArrayList<>();
        workspaceContent = new ArrayList<>();
        workSpaceBinding.searchForList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        workSpaceBinding.searchForList.setLayoutManager(layoutManager);
        workspaceName.add("Developer");
        workspaceName.add("Digital Marketing");
        workspaceName.add("Developer");
        workspaceName.add("Digital Marketing");
        workspaceName.add("Developer");
        workspaceContent.add("21 suggested items");
        workspaceContent.add("19 suggested items");
        workspaceContent.add("21 suggested items");
        workspaceContent.add("19 suggested items");
        workspaceContent.add("21 suggested items");
        PeopleSearchAdapter peopleSearchAdapter = new PeopleSearchAdapter(this,workspaceImages,workspaceName,workspaceContent);
        workSpaceBinding.searchForList.setAdapter(peopleSearchAdapter);
    }

    private void getAllBrowsingHistoryList()
    {
        basedOnName = new ArrayList<>();
        basedOnContent = new ArrayList<>();
        basedOnRating = new ArrayList<>();
        basedOnPrice = new ArrayList<>();
        workSpaceBinding.basedOnList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        workSpaceBinding.basedOnList.setLayoutManager(layoutManager);

        basedOnName.add("Apple Macbook Pro 12inch");
        basedOnName.add("JVC Recording Camera 1500L");
        basedOnName.add("Logitech G433 Headset");
        basedOnName.add("Apple iPad Pro Wifi -512GB");
        basedOnName.add("JVC Recording Camera 1500L");

        basedOnContent.add("Apple");
        basedOnContent.add("Jodde Electronics");
        basedOnContent.add("Zone Electroncs");
        basedOnContent.add("Apple");
        basedOnContent.add("Jodde Electronics");

        basedOnPrice.add("BDT 1187.00");
        basedOnPrice.add("BDT 1174.00");
        basedOnPrice.add("BDT 11599.00");
        basedOnPrice.add("BDT 1187.00");
        basedOnPrice.add("BDT 11599.00");

        basedOnRating.add("4.8");
        basedOnRating.add("3.8");
        basedOnRating.add("2.8");
        basedOnRating.add("1.8");
        basedOnRating.add("5.8");



        BasedOnAdapter basedOnAdapter = new BasedOnAdapter(this,basedOnImages,
                basedOnName,basedOnContent,basedOnRating,basedOnPrice);
        workSpaceBinding.basedOnList.setAdapter(basedOnAdapter);
    }




}