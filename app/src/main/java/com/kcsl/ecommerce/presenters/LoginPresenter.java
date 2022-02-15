package com.kcsl.ecommerce.presenters;



import com.kcsl.ecommerce.callbacks.LoginUserView;
import com.kcsl.ecommerce.errors.ApiError;
import com.kcsl.ecommerce.models.Login;
import com.kcsl.ecommerce.services.APIClient;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.ErrorCode;
import com.kcsl.ecommerce.utils.LoginEnum;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class LoginPresenter {
    private LoginUserView mViewInterface;
    private APIClient mApiClient;

    public  LoginPresenter(LoginUserView view) {
        this.mViewInterface = view;

        if (this.mApiClient == null) {
            this.mApiClient = new APIClient();
        }
    }

    public void attemptLogin(String token,String email,String password) {

        final Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");

        mApiClient.getAPI()
                .loginCustomer(map,token,email,password)
                .enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        DebugLog.e("CODE: "+response.code());
                        if (response.isSuccessful()) {
                            Login login  = response.body();
                            if (login!= null) {
                                mViewInterface.onSuccess(login, LoginEnum.LOGIN_SUCCESS.getCode());
                            } else {
                                mViewInterface.onError("Error fetching data",response.code());
                            }
                        } else  mViewInterface.onError("Email or password  does not match please Sign up first",response.code());
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable e) {
                        e.printStackTrace();

                        e.fillInStackTrace();
                        //DebugLog.e(call.request().toString());

                        if (e instanceof HttpException) {

                            int code = ((HttpException) e).response().code();
                            ResponseBody responseBody = ((HttpException) e).response().errorBody();
                            mViewInterface.onError(ApiError.get500ErrorMessage(responseBody),code);

                        } else if (e instanceof SocketTimeoutException) {
                            mViewInterface.onError("Server connection error", LoginEnum.SERVER_ERROR.getCode());
                        } else if (e instanceof IOException) {
                            if (e.getMessage() != null) mViewInterface.onError(e.getMessage(),LoginEnum.LOGIN_FAILED.getCode());
                            else mViewInterface.onError("IO Exception",LoginEnum.LOGIN_FAILED.getCode());
                        } else {
                            mViewInterface.onError("Unknown error",LoginEnum.LOGIN_FAILED.getCode());
                        }
                    }
                });
    }


}
