package com.kcsl.ecommerce.presenters;

import com.kcsl.ecommerce.callbacks.MessageUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.Message;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.ErrorCode;
import com.kcsl.ecommerce.utils.MessageEnum;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class ResetPasswordPresenter {
    private MessageUserView mViewInterface;
    private APIClient mApiClient;

    public  ResetPasswordPresenter(MessageUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptResetPassword(String email) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .customerResetPassword(map,email)
                .enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Message message = response.body();
                            if (message!= null) {
                                mViewInterface.onSuccess(message, MessageEnum.Message_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(), MessageEnum.Message_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", MessageEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(), MessageEnum.Message_FAILED.getCode());
                            else mViewInterface.onError("IO Exception", MessageEnum.Message_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error", MessageEnum.Message_FAILED.getCode());
                        }
                    }
                });
    }

    private void errorHandle(int code,int errorType, ResponseBody responseBody){


        ErrorCode errorCode = ErrorCode.getByCode(code);
        if(errorCode == null)return;
        switch (errorCode){

            case ERRORCODE500:
                mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),errorType);
                break;

            case ERRORCODE406:
                mViewInterface.onError(ApiError.get406ErrorMessage(responseBody),errorType);
                break;

            case ERRORCODE422:
                mViewInterface.onError(ApiError.getErrorMessage(responseBody), errorType);
                break;

            case ERROR_CODE401:
                mViewInterface.onError(ApiError.getErrorMessage(responseBody), errorType);
                break;

            default:
                mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),errorType);
        }
    }
}
