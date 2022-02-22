package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityHealthyBinding;

public class HealthyActivity extends AppCompatActivity {

    ActivityHealthyBinding healthyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        healthyBinding = DataBindingUtil. setContentView(this,R.layout.activity_healthy);
        WebSettings webSettings =  healthyBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        healthyBinding.webview.loadUrl("https://www.webmd.com/beauty/default.htm");
    }
}