package com.kcsl.ecommerce.services;



import com.google.gson.JsonObject;
import com.kcsl.ecommerce.models.AddShoppingCart;
import com.kcsl.ecommerce.models.CartDetails;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.models.GetCardItems;
import com.kcsl.ecommerce.models.Login;
import com.kcsl.ecommerce.models.Message;
import com.kcsl.ecommerce.models.PaymentData;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.models.SaveOrder;
import com.kcsl.ecommerce.models.ShippingData;
import com.kcsl.ecommerce.models.ShoppingData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIServices {


    @GET("/api/products")
    Call<Products> getAllProductsWithCategory(@HeaderMap Map<String, String> headers,
                                              @Query("category_id") int category_id, @Query("page") int page, @Query("limit") int limit);


    @GET("/api/categories")
    Call<Categories> getAllCategories(@HeaderMap Map<String, String> headers);

    @GET("/api/categories")
    Call<Categories> getAllCategories(@HeaderMap Map<String, String> headers,
                                      @Query("page") int page, @Query("limit") int limit);

    @GET("/api/products")
    Call<Products> getAllNewProducts(@HeaderMap Map<String, String> headers, @Query("new") int newValue);

    @GET("/api/products")
    Call<Products> getAllFeaturedProducts(@HeaderMap Map<String, String> headers, @Query("featured") int featuredValue);

    @GET("/api/products/{id}")
    Call<Product> getProductsByID(@HeaderMap Map<String, String> headers, @Path("id") int id);

    @GET("/api/products")
    Call<Products> getAllNewProducts(@HeaderMap Map<String, String> headers, @Query("new") int newValue,
                                     @Query("page") int page, @Query("limit") int limit);

    @GET("/api/products")
    Call<Products> getAllFeaturedProducts(@HeaderMap Map<String, String> headers, @Query("feature") int featuredValue,
                                          @Query("page") int page, @Query("limit") int limit);

    @POST("/api/customer/login")
    Call<Login> loginCustomer(@HeaderMap Map<String, String> headers,
                              @Query("token") String token,
                              @Query("email") String email, @Query("password") String password);

    @POST("/api/customer/register")
    Call<Message> registrationCustomer(@HeaderMap Map<String, String> headers,
                                       @Query("email") String email,
                                       @Query("first_name") String first_name,
                                       @Query("last_name") String last_name,
                                       @Query("password") String password,
                                       @Query("password_confirmation") String confirmPassword);


    @GET("/api/customer/logout")
    Call<Message> customerLogout(@HeaderMap Map<String, String> headers);

    @POST("/api/customer/forgot-password")
    Call<Message> customerResetPassword(@HeaderMap Map<String, String> headers, @Query("email") String email);


    @GET("/api/products")
    Call<Products> getProductsByName(@HeaderMap Map<String, String> headers, @Query("name") String name,
                                     @Query("page") int page, @Query("limit") int limit);


    @POST("/api/checkout/cart/add/{product_id}")
    Call<AddShoppingCart> addShoppingCart(@HeaderMap Map<String, String> headers,
                                          @Path("product_id") int id,
                                          @Body JsonObject addProduct);

    @GET("/api/checkout/cart")
    Call<GetCardItems> getCartDetails(@HeaderMap Map<String, String> headers);

    @POST("/api/checkout/save-address")
    Call<CartDetails> getCartAllData(@HeaderMap Map<String, String> headers , @Body JsonObject cartAllData);

    @POST("/api/checkout/save-payment")
    Call<PaymentData> getPaymentData(@HeaderMap Map<String, String> headers , @Body JsonObject paymentData);

    @POST("/api/checkout/save-shipping")
    Call<ShippingData> getShippingData(@HeaderMap Map<String, String> headers , @Body JsonObject shippingData);

    @POST("/api/checkout/save-order")
    Call<SaveOrder> getSaveOrder(@HeaderMap Map<String, String> headers);

}