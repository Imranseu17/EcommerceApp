package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivityCameraBinding;

public class CameraActivity extends AppCompatActivity {

    ActivityCameraBinding activityCameraBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        activityCameraBinding = DataBindingUtil. setContentView(this,R.layout.activity_camera);
        WebSettings webSettings =  activityCameraBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        activityCameraBinding.webview.loadUrl("https://www.samys.com/");
    }
}