package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddShoppingCart {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ShoppingData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ShoppingData getData() {
        return data;
    }

    public void setData(ShoppingData data) {
        this.data = data;
    }
}
