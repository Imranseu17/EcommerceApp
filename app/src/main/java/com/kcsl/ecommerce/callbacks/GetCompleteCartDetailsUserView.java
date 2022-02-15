package com.kcsl.ecommerce.callbacks;

import com.kcsl.ecommerce.models.GetCardItems;

public interface GetCompleteCartDetailsUserView {

    public void onSuccess(GetCardItems GetCardItems, int code);
    public void onError(String error, int code);
}
