package com.kcsl.ecommerce.presenters;

import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.CategoriesEnum;
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

public class CategoriesPresenter {
    private CategoriesUserView mViewInterface;
    private APIClient mApiClient;

    public  CategoriesPresenter(CategoriesUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptGetAllCategories(int page,int limit) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .getAllCategories(map,page,limit)
                .enqueue(new Callback<Categories>() {
                    @Override
                    public void onResponse(Call<Categories> call, Response<Categories> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Categories categories  = response.body();
                            if (categories!= null) {
                                mViewInterface.onSuccess(categories, CategoriesEnum.Categories_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),CategoriesEnum.Categories_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Categories> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", CategoriesEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),CategoriesEnum.Categories_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",CategoriesEnum.Categories_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",CategoriesEnum.Categories_FAILED.getCode());
                        }
                    }
                });
    }

    public void attemptGetAllCategories() {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .getAllCategories(map)
                .enqueue(new Callback<Categories>() {
                    @Override
                    public void onResponse(Call<Categories> call, Response<Categories> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Categories categories  = response.body();
                            if (categories!= null) {
                                mViewInterface.onSuccess(categories, CategoriesEnum.Categories_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),CategoriesEnum.Categories_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Categories> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", CategoriesEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),CategoriesEnum.Categories_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",CategoriesEnum.Categories_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",CategoriesEnum.Categories_FAILED.getCode());
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
