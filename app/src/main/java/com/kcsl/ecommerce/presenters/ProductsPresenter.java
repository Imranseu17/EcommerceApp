package com.kcsl.ecommerce.presenters;


import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.ErrorCode;
import com.kcsl.ecommerce.utils.ProductsEnum;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class ProductsPresenter {
    private ProductsUserView mViewInterface;
    private APIClient mApiClient;

    public  ProductsPresenter(ProductsUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptGetAllProduct(int category_id,int limit, int page) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .getAllProductsWithCategory(map,category_id,limit,page)
                .enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Products products  = response.body();
                            if (products!= null) {
                                mViewInterface.onSuccess(products, ProductsEnum.Products_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),ProductsEnum.Products_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Products> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", ProductsEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),ProductsEnum.Products_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",ProductsEnum.Products_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",ProductsEnum.Products_FAILED.getCode());
                        }
                    }
                });
    }

    public void attemptGetProductByID(int id) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .getProductsByID(map,id)
                .enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Product product  = response.body();
                            if (product!= null) {
                                mViewInterface.onOneProductSuccess(product, ProductsEnum.Products_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),ProductsEnum.Products_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", ProductsEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),ProductsEnum.Products_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",ProductsEnum.Products_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",ProductsEnum.Products_FAILED.getCode());
                        }
                    }
                });
    }

    public void attemptGetProductByName(String name,int page,int limit) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .getProductsByName(map,name,page,limit)
                .enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Products product  = response.body();
                            if (product!= null) {
                                mViewInterface.onSuccess(product, ProductsEnum.Products_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else errorHandle(response.code(),ProductsEnum.Products_FAILED.getCode(), response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<Products> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", ProductsEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),ProductsEnum.Products_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",ProductsEnum.Products_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",ProductsEnum.Products_FAILED.getCode());
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
