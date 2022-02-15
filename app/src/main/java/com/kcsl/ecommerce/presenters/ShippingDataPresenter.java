package com.kcsl.ecommerce.presenters;

import com.google.gson.JsonObject;
import com.kcsl.ecommerce.callbacks.PaymentDataUserView;
import com.kcsl.ecommerce.callbacks.ShippingDataUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.PaymentData;
import com.kcsl.ecommerce.models.ShippingData;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.ErrorCode;
import com.kcsl.ecommerce.utils.GetCardItemsEnum;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class ShippingDataPresenter {
    private ShippingDataUserView mViewInterface;
    private APIClient mApiClient;

    public  ShippingDataPresenter(ShippingDataUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptShippingMethod(String token) {

        final Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Authorization","Bearer "+token);

        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("shipping_method","flatrate_flatrate");


        mApiClient.getAPI()
                .getShippingData(map,jsonObject)
                .enqueue(new Callback<ShippingData>() {
                    @Override
                    public void onResponse(Call<ShippingData> call, Response<ShippingData> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            ShippingData shippingData = response.body();
                            if (shippingData!= null) {
                                mViewInterface.onSuccess(shippingData, GetCardItemsEnum.GetCardItems_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),GetCardItemsEnum.GetCardItems_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<ShippingData> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", GetCardItemsEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),GetCardItemsEnum.GetCardItems_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",GetCardItemsEnum.GetCardItems_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",GetCardItemsEnum.GetCardItems_FAILED.getCode());
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
