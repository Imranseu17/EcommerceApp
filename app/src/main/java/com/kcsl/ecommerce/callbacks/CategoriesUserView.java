package com.kcsl.ecommerce.callbacks;

import com.kcsl.ecommerce.models.Categories;

public interface CategoriesUserView {
    public void onSuccess(Categories categories, int code);
    public void onError(String error, int code);
    public void retryPageLoad();
}
