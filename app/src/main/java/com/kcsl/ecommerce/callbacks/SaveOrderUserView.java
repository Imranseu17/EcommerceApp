package com.kcsl.ecommerce.callbacks;

import com.kcsl.ecommerce.models.SaveOrder;


public interface SaveOrderUserView {
    public void onSuccess(SaveOrder saveOrder, int code);
    public void onError(String error, int code);
}
