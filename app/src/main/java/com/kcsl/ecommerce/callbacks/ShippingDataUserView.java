package com.kcsl.ecommerce.callbacks;


import com.kcsl.ecommerce.models.ShippingData;

public interface ShippingDataUserView {
    public void onSuccess(ShippingData shippingData, int code);
    public void onError(String error, int code);
}
