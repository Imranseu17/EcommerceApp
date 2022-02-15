package com.kcsl.ecommerce.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ForgetPasswordActivity;
import com.kcsl.ecommerce.activities.MainActivity;
import com.kcsl.ecommerce.callbacks.LoginUserView;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Login;
import com.kcsl.ecommerce.presenters.LoginPresenter;
import com.kcsl.ecommerce.utils.SharedDataSaveLoad;

import es.dmoral.toasty.Toasty;


public class LoginFragment extends Fragment implements LoginUserView {

    EditText emailText, passwordText;
    TextView forgetPassword;
    AppCompatButton loginButton;
    float v = 0;
    LoginPresenter loginPresenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_login, container, false);
        loginPresenter = new LoginPresenter(this);
        emailText = root.findViewById(R.id.emailEt);
        passwordText = root.findViewById(R.id.PassEt);
        forgetPassword = root.findViewById(R.id.forgottenPassTv);
        loginButton = root.findViewById(R.id.loginBtn);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ForgetPasswordActivity.class));
            }
        });

        emailText.setTranslationX(800);
        passwordText.setTranslationX(800);
        forgetPassword.setTranslationX(800);
        loginButton.setTranslationX(800);

        emailText.setAlpha(v);
        passwordText.setAlpha(v);
        forgetPassword.setAlpha(v);
        loginButton.setAlpha(v);

        emailText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        loginButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLogin();
            }
        });

        return root;
    }

    private void submitLogin() {


        if (!validateEmail()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }


        hideKeyboard(getActivity());
        getLogin();

    }

    private void getLogin() {
        if (checkConnection()) {
            String email = emailText.getText().toString().trim();
            String password = passwordText.getText().toString().trim();
            loginPresenter.attemptLogin("true",email,password);

        } else CustomAlertDialog.showError(getContext(), getString(R.string.no_internet_connection));
    }

    private boolean validateEmail() {
        String email = emailText.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Email Fill required");
            requestFocus(emailText);
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Email is not valid");
            requestFocus(emailText);
            return false;
        }
        else {
            emailText.setError(null);

        }

        return true;
    }



    private boolean validatePassword() {
        String password = passwordText.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Password Fill required");
            requestFocus(passwordText);
            return false;
        }  else if(password.length() < 6){
            passwordText.setError("Password is too short");
            requestFocus(passwordText);
            return false;
        }
        else {
            passwordText.setError(null);

        }

        return true;
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
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
           getActivity(). getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }



    private void clearFill(){
        emailText.setText("");
        passwordText.setText("");

    }

    @Override
    public void onSuccess(Login login, int code) {
        Toasty.success(getContext(),login.getMessage(),Toasty.LENGTH_SHORT).show();
        clearFill();
        SharedDataSaveLoad.save(getContext(),"token",login.getToken());
        Intent intent = new Intent(getContext(),MainActivity.class);
        intent.putExtra("token",login.getToken());
        startActivity(intent);

    }

    @Override
    public void onError(String error, int code) {
        Toasty.error(getContext(),error,Toasty.LENGTH_SHORT).show();
    }
}