package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kcsl.ecommerce.models.Rate__1;

import java.util.List;

public class Rate {
    @SerializedName("carrier_title")
    @Expose
    private String carrierTitle;
    @SerializedName("rates")
    @Expose
    private List<Rate__1> rates = null;

    public String getCarrierTitle() {
        return carrierTitle;
    }

    public void setCarrierTitle(String carrierTitle) {
        this.carrierTitle = carrierTitle;
    }

    public List<Rate__1> getRates() {
        return rates;
    }

    public void setRates(List<Rate__1> rates) {
        this.rates = rates;
    }
}
