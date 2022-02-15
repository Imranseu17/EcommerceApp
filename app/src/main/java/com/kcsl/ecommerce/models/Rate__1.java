package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rate__1 {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("carrier_title")
    @Expose
    private String carrierTitle;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("method_title")
    @Expose
    private String methodTitle;
    @SerializedName("method_description")
    @Expose
    private String methodDescription;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("formated_price")
    @Expose
    private String formatedPrice;
    @SerializedName("base_price")
    @Expose
    private Integer basePrice;
    @SerializedName("formated_base_price")
    @Expose
    private String formatedBasePrice;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierTitle() {
        return carrierTitle;
    }

    public void setCarrierTitle(String carrierTitle) {
        this.carrierTitle = carrierTitle;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodTitle() {
        return methodTitle;
    }

    public void setMethodTitle(String methodTitle) {
        this.methodTitle = methodTitle;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFormatedPrice() {
        return formatedPrice;
    }

    public void setFormatedPrice(String formatedPrice) {
        this.formatedPrice = formatedPrice;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getFormatedBasePrice() {
        return formatedBasePrice;
    }

    public void setFormatedBasePrice(String formatedBasePrice) {
        this.formatedBasePrice = formatedBasePrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
