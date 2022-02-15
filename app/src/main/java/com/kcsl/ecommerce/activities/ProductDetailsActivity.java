package com.kcsl.ecommerce.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.AddShoppingCartUserView;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.databinding.ActivityProductDetailsBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.AddShoppingCart;
import com.kcsl.ecommerce.models.Item;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.AddShoppingCartPresenter;
import com.kcsl.ecommerce.presenters.ProductsPresenter;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.SharedDataSaveLoad;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class ProductDetailsActivity extends AppCompatActivity implements ProductsUserView, AddShoppingCartUserView {

            ActivityProductDetailsBinding productDetailsBinding;
            ProductsPresenter productsPresenter;
            AddShoppingCartPresenter addShoppingCartPresenter;
            private int currentApiVersion;
            int quantityValue;
            String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productDetailsBinding = DataBindingUtil. setContentView(this, R.layout.activity_product_details);
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
        productsPresenter = new ProductsPresenter(this);
        addShoppingCartPresenter = new AddShoppingCartPresenter(this);
        productDetailsBinding.finishImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        getProductDetails(getIntent().getIntExtra("id",0));

        quantityValue = Integer.parseInt(productDetailsBinding.value.getText().toString().trim());

        productDetailsBinding.slidePanel.setDragView(productDetailsBinding.dragView);
        productDetailsBinding.slidePanel.setScrollableView(productDetailsBinding.itemView);

        productDetailsBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityValue ++;
                productDetailsBinding.value.setText(""+quantityValue);
            }
        });

        productDetailsBinding.min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(quantityValue > 1)
                     quantityValue --;
                productDetailsBinding.value.setText(""+quantityValue);
            }
        });

        productDetailsBinding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     addShoppingCart();
            }
        });
    }

    private void getProductDetails(int id){
        if (checkConnection()){
            productsPresenter.attemptGetProductByID(id);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void addShoppingCart(){
        if (checkConnection()){
            int number = quantityValue;
            String token = SharedDataSaveLoad.load(ProductDetailsActivity.this,"token");
           addShoppingCartPresenter.attemptAddShoppingCart(getIntent().getIntExtra("id",0),number,token);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) this. getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }



    @Override
    public void onSuccess(Products products, int code) {

    }

    @Override
    public void onSuccess(AddShoppingCart addShoppingCart, int code) {
        Toasty.success(this,addShoppingCart.getMessage(),Toasty.LENGTH_SHORT).show();
        DebugLog.e("Grand Total: "+addShoppingCart.getData().getFormatedGrandTotal());
        for (Item item : addShoppingCart.getData().getItems()){
            DebugLog.e("Name: "+item.getName());
            Intent intent = new Intent(this, CartActivity.class);
            intent.putExtra("item", item);
            intent.putExtra("imageUrl",url);
            startActivity(intent);
        }

    }

    @Override
    public void onError(String error, int code) {
        Toasty.error(this,error,Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onNewProductSuccess(Products products, int code) {

    }

    @Override
    public void onFeaturedProductSuccess(Products products, int code) {

    }

    @Override
    public void onOneProductSuccess(Product product, int code) {
        if(product.getData().getBaseImage().getLargeImageUrl() != null){
            Glide.with(this).load(product.getData().getBaseImage().getSmallImageUrl()).
                    into(productDetailsBinding.productImage);
        }else {
            productDetailsBinding.productImage.setImageResource(R.drawable.profile_image);
        }

        url = product.getData().getBaseImage().getLargeImageUrl();

        productDetailsBinding.name.setText(product.getData().getName());
        productDetailsBinding.sku.setText("Sku: "+product.getData().getSku());
        productDetailsBinding.price.setText("\u09F3"+ product.getData().getFormatedPrice().substring(1));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            productDetailsBinding.description.setText(Html.fromHtml("<p>"+product.getData().getDescription()+"</p>",
                    Html.FROM_HTML_MODE_COMPACT));
        } else {
            productDetailsBinding.description.setText(Html.fromHtml("<p>"+product.getData().getDescription()+"</p>"));
        }
    }

    @Override
    public void retryPageLoad() {

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        // Hides the status and navigation bar until the user clicks
        // on the screeen.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}