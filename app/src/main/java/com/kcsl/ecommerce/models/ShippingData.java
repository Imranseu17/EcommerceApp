package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingData {
    @SerializedName("data")
    @Expose
    private ShippingMethodData data;

    public ShippingMethodData getData() {
        return data;
    }

    public void setData(ShippingMethodData data) {
        this.data = data;
    }
}
