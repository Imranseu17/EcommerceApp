package com.kcsl.ecommerce.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartData {
    @SerializedName("rates")
    @Expose
    private List<Rate> rates = null;
    @SerializedName("cart")
    @Expose
    private Cart cart;

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
