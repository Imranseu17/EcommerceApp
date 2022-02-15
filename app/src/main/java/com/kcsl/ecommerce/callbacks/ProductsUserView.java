package com.kcsl.ecommerce.callbacks;


import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.Products;

public interface ProductsUserView {
    public void onSuccess(Products products, int code);
    public void onError(String error, int code);
    public void onNewProductSuccess(Products products, int code);
    public void onFeaturedProductSuccess(Products products, int code);
    public void onOneProductSuccess(Product product, int code);
    public void retryPageLoad();
}
