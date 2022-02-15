package com.kcsl.ecommerce.callbacks;


import com.kcsl.ecommerce.models.PaymentData;

public interface PaymentDataUserView {
    public void onSuccess(PaymentData paymentData, int code);
    public void onError(String error, int code);
}
