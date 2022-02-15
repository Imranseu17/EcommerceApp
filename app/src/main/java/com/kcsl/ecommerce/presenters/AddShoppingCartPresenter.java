package com.kcsl.ecommerce.presenters;

import com.google.gson.JsonObject;
import com.kcsl.ecommerce.callbacks.AddShoppingCartUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.AddShoppingCart;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.AddShoppingCartEnum;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.ErrorCode;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class AddShoppingCartPresenter {
    private AddShoppingCartUserView mViewInterface;
    private APIClient mApiClient;

    public  AddShoppingCartPresenter(AddShoppingCartUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptAddShoppingCart(int product_id,int quantity,String token) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");
        map.put("Authorization","Bearer "+token);

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("product_id", product_id);
        jsonObject.addProperty("quantity", quantity);


        mApiClient.getAPI()
                .addShoppingCart(map,product_id,jsonObject)
                .enqueue(new Callback<AddShoppingCart>() {
                    @Override
                    public void onResponse(Call<AddShoppingCart> call, Response<AddShoppingCart> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            AddShoppingCart addShoppingCart  = response.body();
                            if (addShoppingCart!= null) {
                                mViewInterface.onSuccess(addShoppingCart, AddShoppingCartEnum.AddShoppingCart_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),AddShoppingCartEnum.AddShoppingCart_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<AddShoppingCart> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", AddShoppingCartEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),AddShoppingCartEnum.AddShoppingCart_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",AddShoppingCartEnum.AddShoppingCart_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",AddShoppingCartEnum.AddShoppingCart_FAILED.getCode());
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
