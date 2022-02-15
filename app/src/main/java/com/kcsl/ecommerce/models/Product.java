package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("data")
    @Expose
    private ProductDatum data;

    public ProductDatum getData() {
        return data;
    }

    public void setData(ProductDatum data) {
        this.data = data;
    }
}
