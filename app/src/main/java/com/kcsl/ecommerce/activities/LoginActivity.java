package com.kcsl.ecommerce.activities;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.LoginAdapter;
import com.kcsl.ecommerce.databinding.ActivityLoginBinding;
import com.kcsl.ecommerce.fragment.LoginFragment;
import com.kcsl.ecommerce.fragment.SignUpFragment;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding loginBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil. setContentView(this, R.layout.activity_login);


       loginBinding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupViewPager(loginBinding.viewPager);
        loginBinding.tabLayout.setupWithViewPager(loginBinding.viewPager);

        loginBinding.tabLayout.setTranslationY(300);
        loginBinding.tabLayout.setAlpha(0);
        loginBinding.tabLayout.animate().translationY(0).alpha(1).setDuration(100).setStartDelay(100).start();




    }

    private void setupViewPager(ViewPager viewPager) {
        LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(), "Login");
        adapter.addFragment(new SignUpFragment(), "Signup");
        viewPager.setAdapter(adapter);
    }
}