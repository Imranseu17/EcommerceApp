package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    ActivitySettingsBinding settingsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        settingsBinding = DataBindingUtil. setContentView(this,R.layout.activity_settings);
        SharedPreferences  sharedpreferences = getSharedPreferences("MyPrefs" , Context.MODE_PRIVATE);

        settingsBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settingsBinding.saveSettingSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name", settingsBinding.name.getText().toString());
                editor.putString("email", settingsBinding.email.getText().toString());
                editor.putString("phone number", settingsBinding.phone.getText().toString());
                editor.putString("age", settingsBinding.age.getText().toString());
                editor.putString("nid", settingsBinding.nid.getText().toString());
                editor.commit();
                settingsBinding.name.setText("");
                settingsBinding.email.setText("");
                settingsBinding.phone.setText("");
                settingsBinding.age.setText("");
                settingsBinding.nid.setText("");
                Toast.makeText(SettingsActivity.this," Personal information save successfully ",Toast.LENGTH_LONG).show();
            }
        });

        settingsBinding.name.setText(sharedpreferences.getString("name","name"));
        settingsBinding.email.setText(sharedpreferences.getString("email","email"));
        settingsBinding.phone.setText(sharedpreferences.getString("phone number","phone number"));
        settingsBinding.age.setText(sharedpreferences.getString("age","age"));
        settingsBinding.nid.setText(sharedpreferences.getString("nid","nid"));

    }
}