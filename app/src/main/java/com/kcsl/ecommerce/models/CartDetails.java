package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDetails {
    @SerializedName("data")
    @Expose
    private CartData data;

    public CartData getData() {
        return data;
    }

    public void setData(CartData data) {
        this.data = data;
    }
}
