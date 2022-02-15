package com.kcsl.ecommerce.activities;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.MessageUserView;
import com.kcsl.ecommerce.databinding.ActivityForgotPasswordBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Message;
import com.kcsl.ecommerce.presenters.ResetPasswordPresenter;

import es.dmoral.toasty.Toasty;

public class ForgetPasswordActivity extends AppCompatActivity implements MessageUserView {

    ActivityForgotPasswordBinding forgotPasswordBinding;
    float v = 0;
    ResetPasswordPresenter resetPasswordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        forgotPasswordBinding = DataBindingUtil. setContentView(this, R.layout.activity_forgot_password);
        resetPasswordPresenter = new ResetPasswordPresenter(this);

        forgotPasswordBinding.finishImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        forgotPasswordBinding. email.setTranslationX(800);
        forgotPasswordBinding.submit.setTranslationX(800);
        forgotPasswordBinding.bottomText.setTranslationX(800);

        forgotPasswordBinding. email.setAlpha(v);
        forgotPasswordBinding.submit.setAlpha(v);
        forgotPasswordBinding.bottomText.setAlpha(v);


        forgotPasswordBinding. email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgotPasswordBinding.bottomText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPasswordBinding.submit.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        forgotPasswordBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForgetPassword();
            }
        });
    }

    private void submitForgetPassword() {


        if (!validateEmail()) {
            return;
        }



        hideKeyboard(this);
        getForgetPassword();

    }

    private void getForgetPassword() {
        if (checkConnection()) {
            String email = forgotPasswordBinding.email.toString().trim();
            resetPasswordPresenter.attemptResetPassword(email);

        } else CustomAlertDialog.showError(this, getString(R.string.no_internet_connection));
    }

    private boolean validateEmail() {
        String email = forgotPasswordBinding.email.toString().trim();
        if (TextUtils.isEmpty(email)) {
            forgotPasswordBinding.email.setError("Email Fill required");
            requestFocus(forgotPasswordBinding.email);
            return false;
        }
        else {
            forgotPasswordBinding.email.setError(null);
        }

        return true;
    }





    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
          getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }



    private void clearFill(){
        forgotPasswordBinding.email.setText("");


    }

    @Override
    public void onSuccess(Message message, int code) {
        clearFill();
        Toasty.success(this,message.getMessage(),Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error, int code) {
        Toasty.error(this,error,Toasty.LENGTH_SHORT).show();
    }
}