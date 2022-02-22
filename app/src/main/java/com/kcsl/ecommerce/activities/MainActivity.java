package com.kcsl.ecommerce.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.kcsl.ecommerce.callbacks.MessageUserView;
import com.kcsl.ecommerce.dialog.ChooseAlertDialog;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.dialog.PromptDialog;
import com.kcsl.ecommerce.models.Message;
import com.kcsl.ecommerce.presenters.LogoutPresenter;
import com.kcsl.ecommerce.utils.BottomNavBar;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.SharedDataSaveLoad;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MessageUserView{

    private AppBarConfiguration mAppBarConfiguration;
    TextView mTextMessage;
    LinearLayout imageButton,searchButton;
    LogoutPresenter logoutPresenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFlag();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        imageButton = findViewById(R.id.drawer_open_button);
        searchButton = findViewById(R.id.drawer_search_button);


        setSupportActionBar(toolbar);
        logoutPresenter = new LogoutPresenter(this);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
         BottomNavBar.OnBottomNavigationListener mOnBottomNavItemSelectedListener =
                new BottomNavBar.OnBottomNavigationListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.navigation_home:
                                navController.navigate(R.id.nav_home);
                                break;
                            case R.id.navigation_chat:
                                startActivity(new Intent(MainActivity.this,ChatActivity.class));
                                break;
                            case R.id.navigation_new_cart:
                                startActivity(new Intent(MainActivity.this,CartActivity.class));
                                break;
                            case R.id.navigation_category:
                                navController.navigate(R.id.categoryFragment);
                                break;
                            case R.id.navigation_profile:
                                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                                break;
                        }
                        NavigationUI.onNavDestinationSelected ( menuItem, navController);
                        return true;
                    }
                };




        imageButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchProductActivity.class));
            }
        });
        mTextMessage = findViewById(R.id.message);
        BottomNavBar bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setBottomNavigationListener(mOnBottomNavItemSelectedListener);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.categoryFragment)
                .setOpenableLayout(drawer)
                .build();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.nav_programming:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,ProgrammingActivity.class));
                       break;
                   case  R.id.nav_mobile:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,MobileActivity.class));
                       break;
                   case R.id.nav_computer:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,ComputerActivity.class));
                       break;
                   case R.id.nav_tv:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,TVActivity.class));
                       break;
                   case R.id.nav_camera:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,CameraActivity.class));
                       break;
                   case R.id.nav_home:
                       drawer.close();
                       navController.navigate(R.id.nav_home);
                       break;
                   case R.id.nav_healthy:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,HealthyActivity.class));
                       break;
                   case R.id.nav_fashion:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,FashionActivity.class));
                       break;
                   case R.id.nav_wish_list:
                       drawer.close();
                       startActivity(new Intent(MainActivity.this,WishListActivity.class));
                       break;
               }
                return true;
            }
        });

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);



    }

    private void setFlag() {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void getLogout() {
        if (checkConnection()) {
            String token = SharedDataSaveLoad.load(MainActivity.this,"token");
            DebugLog.e("token: "+token);
            logoutPresenter.attemptLogout(token);

        } else CustomAlertDialog.showError(this, getString(R.string.no_internet_connection));
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Message message, int code) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();
        Toast.makeText(this,"Logout Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error, int code) {
        CustomAlertDialog.showError(this,error);
    }


    public void showExitDialog() {
        new ChooseAlertDialog(this)
                .setDialogType(PromptDialog.DIALOG_TYPE_WARNING)
                .setAnimationEnable(true)
                .setTitleText(R.string.warning)
                .setContentText("Are you sure you want to exit or log out this App ? ")
                .setNegativeListener(getString(R.string.no), new ChooseAlertDialog.OnNegativeListener() {
                    @Override
                    public void onClick(ChooseAlertDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setPositiveListener(getString(R.string.yes), new ChooseAlertDialog.OnPositiveListener() {
                    @Override
                    public void onClick(ChooseAlertDialog dialog) {
                        dialog.dismiss();
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        finish();
                      //  getLogout();
                    }
                }).show();
    }



}