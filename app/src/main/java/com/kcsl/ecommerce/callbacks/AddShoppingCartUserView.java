package com.kcsl.ecommerce.callbacks;

import com.kcsl.ecommerce.models.AddShoppingCart;

public interface AddShoppingCartUserView {
    public void onSuccess(AddShoppingCart addShoppingCart, int code);
    public void onError(String error, int code);
}
