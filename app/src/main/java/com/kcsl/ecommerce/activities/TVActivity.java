package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityTvactivityBinding;

public class TVActivity extends AppCompatActivity {

    ActivityTvactivityBinding activityTvactivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
       activityTvactivityBinding = DataBindingUtil. setContentView(this,R.layout.activity_tvactivity);
        WebSettings webSettings = activityTvactivityBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        activityTvactivityBinding.webview.loadUrl("https://www.samsung.com/us/tvs/");
    }
}