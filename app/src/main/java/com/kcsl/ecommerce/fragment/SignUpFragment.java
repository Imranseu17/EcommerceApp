package com.kcsl.ecommerce.fragment;

import android.app.Activity;
import android.content.Context;
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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.MessageUserView;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Message;
import com.kcsl.ecommerce.presenters.RegistrationPresenter;

import es.dmoral.toasty.Toasty;


public class SignUpFragment extends Fragment implements MessageUserView {

        EditText emailText, fullNameText, passwordText, confirmPasswordText;
        Button signUpButton;
        float v = 0;
        RegistrationPresenter registrationPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        registrationPresenter = new RegistrationPresenter(this);
        emailText = root.findViewById(R.id.emailEt_signUpPage);
        fullNameText = root.findViewById(R.id.nameEt_signUpPage);
        passwordText = root.findViewById(R.id.PassEt_signUpPage);
        confirmPasswordText = root.findViewById(R.id.cPassEt_signUpPage);
        signUpButton = root.findViewById(R.id.signUpBtn_signUpPage);


        emailText.setTranslationX(800);
        fullNameText.setTranslationX(800);
        passwordText.setTranslationX(800);
        confirmPasswordText.setTranslationX(800);
        signUpButton.setTranslationX(800);

        emailText.setAlpha(v);
        fullNameText.setAlpha(v);
        passwordText.setAlpha(v);
        confirmPasswordText.setAlpha(v);
        signUpButton.setAlpha(v);


        emailText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        fullNameText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmPasswordText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signUpButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegistration();
            }
        });


        return root;
    }

    private void getRegistration() {
        if (checkConnection()) {
            String email = emailText.getText().toString().trim();
            String[] fullName = fullNameText.getText().toString().trim().split("");
            String firstName = fullName[0];
            String lastName = fullName[1];
            String password = passwordText.getText().toString().trim();
            String confirmPassword = confirmPasswordText.getText().toString().trim();
            registrationPresenter.attemptRegistration(email,firstName,lastName,password,confirmPassword);

        } else CustomAlertDialog.showError(getContext(), getString(R.string.no_internet_connection));
    }




    /**
     * Validating form
     */
    private void submitRegistration() {


        if (!validateEmail()) {
            return;
        }

        if (!validateFullName()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        if (!validateConfirmPassword()) {
            return;
        }


        hideKeyboard(getActivity());
        getRegistration();

    }

    private boolean validateEmail() {
        String email = emailText.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Email Fill required");
            requestFocus(emailText);
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Email is not valid");
            requestFocus(emailText);
            return false;
        }
        else {
            emailText.setError(null);

        }

        return true;
    }

    private boolean validateFullName() {
        String firstName = fullNameText.getText().toString().trim();
        if (TextUtils.isEmpty(firstName)) {
            fullNameText.setError("Name Fill required");
            requestFocus(fullNameText);
            return false;
        }
        else {
           fullNameText.setError(null);

        }

        return true;
    }



    private boolean validatePassword() {
        String password = passwordText.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Password Fill required");
            requestFocus(passwordText);
            return false;
        }else if(password.length() < 6){
            passwordText.setError("Password is too short");
            requestFocus(passwordText);
            return false;
        }
        else {
           passwordText.setError(null);

        }

        return true;
    }

    private boolean validateConfirmPassword() {
        String confirmPassword = confirmPasswordText.getText().toString().trim();
        if (TextUtils.isEmpty(confirmPassword)) {
            confirmPasswordText.setError("Confirm Password Fill required");
            requestFocus(confirmPasswordText);
            return false;
        }else if(confirmPassword.length() < 6){
            confirmPasswordText.setError("Password is too short");
            requestFocus(confirmPasswordText);
            return false;
        }else if(!confirmPassword.equals(passwordText.getText().toString().trim())){
            confirmPasswordText.setError("Password does not match to confirm password");
            requestFocus(confirmPasswordText);
            return false;
        }
        else {
           confirmPasswordText.setError(null);

        }

        return true;
    }




    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getContext(). getSystemService(Context.CONNECTIVITY_SERVICE);
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
       fullNameText.setText("");
       passwordText.setText("");
       confirmPasswordText.setText("");

    }

    @Override
    public void onSuccess(Message message, int code) {
        clearFill();
        Toasty.success(getContext(),message.getMessage(),Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error, int code) {
        Toasty.success(getContext(),error,Toasty.LENGTH_SHORT).show();
    }
}