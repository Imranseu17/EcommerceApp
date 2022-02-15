package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentData {
    @SerializedName("data")
    @Expose
    private PaymentMethodData data;

    public PaymentMethodData getData() {
        return data;
    }

    public void setData(PaymentMethodData data) {
        this.data = data;
    }
}
