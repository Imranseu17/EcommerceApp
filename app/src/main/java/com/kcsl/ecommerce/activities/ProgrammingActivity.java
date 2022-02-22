package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityProgrammingBinding;

public class ProgrammingActivity extends AppCompatActivity {

    ActivityProgrammingBinding programmingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        programmingBinding = DataBindingUtil. setContentView(this,R.layout.activity_programming);
        WebSettings webSettings = programmingBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        programmingBinding.webview.loadUrl("https://www.journaldev.com");
    }
}