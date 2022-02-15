package com.kcsl.ecommerce.callbacks;


import com.kcsl.ecommerce.models.Login;

public interface LoginUserView {
    public void onSuccess(Login login, int code);
    public void onError(String error, int code);
}
