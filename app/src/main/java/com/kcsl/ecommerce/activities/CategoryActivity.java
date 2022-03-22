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
import com.kcsl.ecommerce.adapter.MainCategoriesAdapter;
import com.kcsl.ecommerce.databinding.ActivityCategoryBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryActivity extends AppCompatActivity {
    private int currentApiVersion;
    ActivityCategoryBinding categoryBinding;

    ArrayList<String> categoriesProductNameOne;
    ArrayList<String> categoriesProductNameTwo;
    ArrayList<String> categoriesProductNameThree;
    ArrayList<String> categoriesProductNameFour;
    ArrayList<String> categoriesProductNameFive;

    ArrayList categoryProductOneImages =  new ArrayList<>(Arrays.asList(R.drawable.women_shoes_preview,
            R.drawable.men_shoes_preview,R.drawable.women_shoes_preview,
            R.drawable.men_shoes_preview,R.drawable.women_shoes_preview));

    ArrayList categoryProductTwoImages =  new ArrayList<>(Arrays.asList(R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview));

    ArrayList categoryProductThreeImages =  new ArrayList<>(Arrays.asList(R.drawable.women_shoes_preview,
            R.drawable.men_shoes_preview,R.drawable.women_shoes_preview,
            R.drawable.men_shoes_preview,R.drawable.women_shoes_preview));

    ArrayList categoryProductFourImages =  new ArrayList<>(Arrays.asList(R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview));

    ArrayList categoryProductFiveImages =  new ArrayList<>(Arrays.asList(R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview,
            R.drawable.men_jacket_preview,R.drawable.women_jacket_preview));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        categoryBinding = DataBindingUtil.setContentView(this,R.layout.activity_category);
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

        categoryBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        categoryBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this,NotificationActivity.class));
            }
        });

        categoryBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this,SearchProductActivity.class));
            }
        });

        categoryBinding.searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this,SearchProductActivity.class));
            }
        });
        getMainCategoryList();

    }

    private void getMainCategoryList()
    {
        categoriesProductNameOne = new ArrayList<>();
        categoriesProductNameTwo = new ArrayList<>();
        categoriesProductNameThree = new ArrayList<>();
        categoriesProductNameFour = new ArrayList<>();
        categoriesProductNameFive = new ArrayList<>();


        categoriesProductNameOne.add("Woman's Shoes");
        categoriesProductNameOne.add("Man's Shoes");
        categoriesProductNameOne.add("Woman's Shoes");
        categoriesProductNameOne.add("Man's Shoes");
        categoriesProductNameOne.add("Woman's Shoes");

        categoriesProductNameTwo.add("Woman's Jacket");
        categoriesProductNameTwo.add("Man's Jacket");
        categoriesProductNameTwo.add("Woman's Jacket");
        categoriesProductNameTwo.add("Man's Jacket");
        categoriesProductNameTwo.add("Woman's Jacket");

        categoriesProductNameThree.add("Woman's Shoes");
        categoriesProductNameThree.add("Man's Shoes");
        categoriesProductNameThree.add("Woman's Shoes");
        categoriesProductNameThree.add("Man's Shoes");
        categoriesProductNameThree.add("Woman's Shoes");

        categoriesProductNameFour.add("Woman's Jacket");
        categoriesProductNameFour.add("Man's Jacket");
        categoriesProductNameFour.add("Woman's Jacket");
        categoriesProductNameFour.add("Man's Jacket");
        categoriesProductNameFour.add("Woman's Jacket");

        categoriesProductNameFive.add("Woman's Jacket");
        categoriesProductNameFive.add("Man's Jacket");
        categoriesProductNameFive.add("Woman's Jacket");
        categoriesProductNameFive.add("Man's Jacket");
        categoriesProductNameFive.add("Woman's Jacket");

        categoryBinding.productDesignListOne.setHasFixedSize(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryBinding.productDesignListOne.setLayoutManager(layoutManager1);
        CategoryProductDesignAdapter categoryProductDesignAdapter1 =
                new CategoryProductDesignAdapter(this,categoriesProductNameOne,categoryProductOneImages);
        categoryBinding.productDesignListOne.setAdapter(categoryProductDesignAdapter1);

        categoryBinding.productDesignListTwo.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryBinding.productDesignListTwo.setLayoutManager(layoutManager2);
        CategoryProductDesignAdapter categoryProductDesignAdapter2 =
                new CategoryProductDesignAdapter(this,categoriesProductNameTwo,categoryProductTwoImages);
        categoryBinding.productDesignListTwo.setAdapter(categoryProductDesignAdapter2);

        categoryBinding.productDesignListThree.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryBinding.productDesignListThree.setLayoutManager(layoutManager3);
        CategoryProductDesignAdapter categoryProductDesignAdapter3 =
                new CategoryProductDesignAdapter(this,categoriesProductNameThree,categoryProductThreeImages);
        categoryBinding.productDesignListThree.setAdapter(categoryProductDesignAdapter3);

        categoryBinding.productDesignListFour.setHasFixedSize(false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryBinding.productDesignListFour.setLayoutManager(layoutManager4);
        CategoryProductDesignAdapter categoryProductDesignAdapter4 =
                new CategoryProductDesignAdapter(this,categoriesProductNameFour,categoryProductFourImages);
        categoryBinding.productDesignListFour.setAdapter(categoryProductDesignAdapter4);

        categoryBinding.productDesignListFive.setHasFixedSize(false);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryBinding.productDesignListFive.setLayoutManager(layoutManager5);
        CategoryProductDesignAdapter categoryProductDesignAdapter5 =
                new CategoryProductDesignAdapter(this,categoriesProductNameFive,categoryProductFiveImages);
        categoryBinding.productDesignListFive.setAdapter(categoryProductDesignAdapter5);


    }
}