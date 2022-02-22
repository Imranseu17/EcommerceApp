package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityComputerBinding;

public class ComputerActivity extends AppCompatActivity {

    ActivityComputerBinding computerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        computerBinding = DataBindingUtil. setContentView(this,R.layout.activity_computer);
        WebSettings webSettings =  computerBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        computerBinding.webview.loadUrl("https://www.hp.com/us-en/shop/cat/desktops");
    }
}