package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityFashionBinding;

public class FashionActivity extends AppCompatActivity {

    ActivityFashionBinding fashionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
       fashionBinding = DataBindingUtil. setContentView(this,R.layout.activity_fashion);
        WebSettings webSettings =  fashionBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        fashionBinding.webview.loadUrl("https://fashionmagazine.com/");
    }
}