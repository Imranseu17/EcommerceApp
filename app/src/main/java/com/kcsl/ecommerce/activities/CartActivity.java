package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.CheckoutItemAdapter;
import com.kcsl.ecommerce.callbacks.CartDetailsUserView;
import com.kcsl.ecommerce.databinding.ActivityCartBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.CartDetails;
import com.kcsl.ecommerce.models.Item;
import com.kcsl.ecommerce.models.ShoppingData;
import com.kcsl.ecommerce.presenters.CartDetailsPresenter;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.SharedDataSaveLoad;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class CartActivity extends AppCompatActivity{

    ActivityCartBinding cartBinding;
    private int currentApiVersion;
    int value = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartBinding = DataBindingUtil.setContentView(this,R.layout.activity_cart);
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

        Item itemData = getIntent()
                .getParcelableExtra("item");

        if(itemData != null){
            if(getIntent().getStringExtra("imageUrl") != null){
                Glide.with(this).load(getIntent().getStringExtra("imageUrl")).
                        into(cartBinding.image);
            }else {
                cartBinding.image.setImageResource(R.drawable.prodct_display_border);
            }
            cartBinding.name.setText(itemData.getName());
            cartBinding.amount.setText("\u09F3"+ itemData.getFormatedPrice().substring(1));
            cartBinding.sku.setText("SKU: "+itemData.getSku());



            cartBinding.max.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    value++;
                    cartBinding.value.setText(""+value);
                    try {
                        double price =  Double.parseDouble(itemData.getFormatedPrice().substring(1));
                        double discount = Double.parseDouble(itemData.getFormatedDiscountAmount().substring(1));
                        double  subtotal = price * value;
                        double grandTotal = subtotal - discount;
                        cartBinding.subtotal.setText("Subtotal               :"+"\u09F3"+subtotal);
                        cartBinding.discount.setText("Discount              :"+"\u09F3"+discount );
                        cartBinding.grandTotal.setText("Grand Total         :"+"\u09F3"+grandTotal);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

            cartBinding.min.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    value--;
                    if(value<0){
                        value=0;
                    }
                    cartBinding.value.setText(""+value);
                    try {
                        double price =  Double.parseDouble(itemData.getFormatedPrice().substring(1));
                        double discount = Double.parseDouble(itemData.getFormatedDiscountAmount().substring(1));
                        double subtotalquentity = price * value;
                        double   subtotalMin = subtotalquentity ;
                        double grandTotalMin = subtotalMin - discount;
                        cartBinding.subtotal.setText("Subtotal               :"+"\u09F3"+subtotalMin);
                        cartBinding.discount.setText("Discount              :"+"\u09F3"+discount);
                        cartBinding.grandTotal.setText("Grand Total         :"+"\u09F3"+grandTotalMin);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

                cartBinding.value.setText(""+value);
            cartBinding.subtotal.setText("Subtotal               :"+"\u09F3"+
                    Double.parseDouble(itemData.getFormatedPrice().substring(1)));
            cartBinding.discount.setText("Discount              :"+"\u09F3"+
                    Double.parseDouble(itemData.getFormatedDiscountAmount().substring(1)));
            cartBinding.grandTotal.setText("Grand Total         :"+"\u09F3"+
                    Double.parseDouble(itemData.getFormatedTotal().substring(1)));

        }else {
            cartBinding.productData.setVisibility(View.GONE);
            cartBinding.couponData.setVisibility(View.GONE);
            cartBinding.couponText.setVisibility(View.GONE);
            cartBinding.priceData.setVisibility(View.GONE);
            cartBinding.emptyBagMsgLayout.setVisibility(View.VISIBLE);
            Toasty.warning(CartActivity.this,"Click Product and click add to cart",Toasty.LENGTH_SHORT).show();
        }

        cartBinding.checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,LoginActivity.class));
            }
        });

        cartBinding.applyCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(CartActivity.this,"Coupon not apply for this time",Toasty.LENGTH_SHORT).show();
            }
        });

        cartBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if(value == 0){
            cartBinding.subtotal.setText("Subtotal               :"+"\u09F3"+0.00);
            cartBinding.discount.setText("Discount              :"+"\u09F3"+0.00 );
            cartBinding.grandTotal.setText("Grand Total         :"+"\u09F3"+0.00);
        }

        cartBinding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartBinding.itemView.setVisibility(View.GONE);
                cartBinding.subtotal.setText("Subtotal               :"+  "\u09F3"+"0.00");
                cartBinding.discount.setText("Discount              :"+ "\u09F3"+"0.00");
                cartBinding.grandTotal.setText("Grand Total         :"+ "\u09F3"+"0.00");
                Toasty.success(CartActivity.this,"Product Delete Successfully",Toasty.LENGTH_SHORT).show();
            }
        });
    }



    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) this. getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
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