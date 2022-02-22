package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityMobileBinding;

public class MobileActivity extends AppCompatActivity {

    ActivityMobileBinding activityMobileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        activityMobileBinding = DataBindingUtil. setContentView(this,R.layout.activity_mobile);
        WebSettings webSettings = activityMobileBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        activityMobileBinding.webview.loadUrl("https://www.xiaomibangladesh.com.bd/");
    }
}