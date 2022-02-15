package com.kcsl.ecommerce.callbacks;


import com.kcsl.ecommerce.models.Message;

public interface MessageUserView {
    public void onSuccess(Message message, int code);
    public void onError(String error, int code);


}
