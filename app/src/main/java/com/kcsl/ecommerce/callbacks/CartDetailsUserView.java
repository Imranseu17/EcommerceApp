package com.kcsl.ecommerce.callbacks;

import com.kcsl.ecommerce.models.CartDetails;


public interface CartDetailsUserView {
    public void onSuccess(CartDetails cartDetails, int code);
    public void onError(String error, int code);
}
