package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cart {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("customer_first_name")
    @Expose
    private String customerFirstName;
    @SerializedName("customer_last_name")
    @Expose
    private String customerLastName;
    @SerializedName("shipping_method")
    @Expose
    private Object shippingMethod;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("is_gift")
    @Expose
    private Integer isGift;
    @SerializedName("items_count")
    @Expose
    private Integer itemsCount;
    @SerializedName("items_qty")
    @Expose
    private String itemsQty;
    @SerializedName("exchange_rate")
    @Expose
    private Object exchangeRate;
    @SerializedName("global_currency_code")
    @Expose
    private String globalCurrencyCode;
    @SerializedName("base_currency_code")
    @Expose
    private String baseCurrencyCode;
    @SerializedName("channel_currency_code")
    @Expose
    private String channelCurrencyCode;
    @SerializedName("cart_currency_code")
    @Expose
    private String cartCurrencyCode;
    @SerializedName("grand_total")
    @Expose
    private String grandTotal;
    @SerializedName("formated_grand_total")
    @Expose
    private String formatedGrandTotal;
    @SerializedName("base_grand_total")
    @Expose
    private String baseGrandTotal;
    @SerializedName("formated_base_grand_total")
    @Expose
    private String formatedBaseGrandTotal;
    @SerializedName("sub_total")
    @Expose
    private String subTotal;
    @SerializedName("formated_sub_total")
    @Expose
    private String formatedSubTotal;
    @SerializedName("base_sub_total")
    @Expose
    private String baseSubTotal;
    @SerializedName("formated_base_sub_total")
    @Expose
    private String formatedBaseSubTotal;
    @SerializedName("tax_total")
    @Expose
    private String taxTotal;
    @SerializedName("formated_tax_total")
    @Expose
    private String formatedTaxTotal;
    @SerializedName("base_tax_total")
    @Expose
    private String baseTaxTotal;
    @SerializedName("formated_base_tax_total")
    @Expose
    private String formatedBaseTaxTotal;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("formated_discount")
    @Expose
    private String formatedDiscount;
    @SerializedName("base_discount")
    @Expose
    private String baseDiscount;
    @SerializedName("formated_base_discount")
    @Expose
    private String formatedBaseDiscount;
    @SerializedName("checkout_method")
    @Expose
    private Object checkoutMethod;
    @SerializedName("is_guest")
    @Expose
    private Integer isGuest;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("conversion_time")
    @Expose
    private Object conversionTime;
    @SerializedName("channel")
    @Expose
    private Object channel;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("selected_shipping_rate")
    @Expose
    private Object selectedShippingRate;
    @SerializedName("payment")
    @Expose
    private Object payment;
    @SerializedName("billing_address")
    @Expose
    private BillingAddress billingAddress;
    @SerializedName("shipping_address")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("taxes")
    @Expose
    private String taxes;
    @SerializedName("formated_taxes")
    @Expose
    private String formatedTaxes;
    @SerializedName("base_taxes")
    @Expose
    private String baseTaxes;
    @SerializedName("formated_base_taxes")
    @Expose
    private String formatedBaseTaxes;
    @SerializedName("formated_discounted_sub_total")
    @Expose
    private String formatedDiscountedSubTotal;
    @SerializedName("formated_base_discounted_sub_total")
    @Expose
    private String formatedBaseDiscountedSubTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Object getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(Object shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Object getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getItemsQty() {
        return itemsQty;
    }

    public void setItemsQty(String itemsQty) {
        this.itemsQty = itemsQty;
    }

    public Object getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Object exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getGlobalCurrencyCode() {
        return globalCurrencyCode;
    }

    public void setGlobalCurrencyCode(String globalCurrencyCode) {
        this.globalCurrencyCode = globalCurrencyCode;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getChannelCurrencyCode() {
        return channelCurrencyCode;
    }

    public void setChannelCurrencyCode(String channelCurrencyCode) {
        this.channelCurrencyCode = channelCurrencyCode;
    }

    public String getCartCurrencyCode() {
        return cartCurrencyCode;
    }

    public void setCartCurrencyCode(String cartCurrencyCode) {
        this.cartCurrencyCode = cartCurrencyCode;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getFormatedGrandTotal() {
        return formatedGrandTotal;
    }

    public void setFormatedGrandTotal(String formatedGrandTotal) {
        this.formatedGrandTotal = formatedGrandTotal;
    }

    public String getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(String baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public String getFormatedBaseGrandTotal() {
        return formatedBaseGrandTotal;
    }

    public void setFormatedBaseGrandTotal(String formatedBaseGrandTotal) {
        this.formatedBaseGrandTotal = formatedBaseGrandTotal;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getFormatedSubTotal() {
        return formatedSubTotal;
    }

    public void setFormatedSubTotal(String formatedSubTotal) {
        this.formatedSubTotal = formatedSubTotal;
    }

    public String getBaseSubTotal() {
        return baseSubTotal;
    }

    public void setBaseSubTotal(String baseSubTotal) {
        this.baseSubTotal = baseSubTotal;
    }

    public String getFormatedBaseSubTotal() {
        return formatedBaseSubTotal;
    }

    public void setFormatedBaseSubTotal(String formatedBaseSubTotal) {
        this.formatedBaseSubTotal = formatedBaseSubTotal;
    }

    public String getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
    }

    public String getFormatedTaxTotal() {
        return formatedTaxTotal;
    }

    public void setFormatedTaxTotal(String formatedTaxTotal) {
        this.formatedTaxTotal = formatedTaxTotal;
    }

    public String getBaseTaxTotal() {
        return baseTaxTotal;
    }

    public void setBaseTaxTotal(String baseTaxTotal) {
        this.baseTaxTotal = baseTaxTotal;
    }

    public String getFormatedBaseTaxTotal() {
        return formatedBaseTaxTotal;
    }

    public void setFormatedBaseTaxTotal(String formatedBaseTaxTotal) {
        this.formatedBaseTaxTotal = formatedBaseTaxTotal;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFormatedDiscount() {
        return formatedDiscount;
    }

    public void setFormatedDiscount(String formatedDiscount) {
        this.formatedDiscount = formatedDiscount;
    }

    public String getBaseDiscount() {
        return baseDiscount;
    }

    public void setBaseDiscount(String baseDiscount) {
        this.baseDiscount = baseDiscount;
    }

    public String getFormatedBaseDiscount() {
        return formatedBaseDiscount;
    }

    public void setFormatedBaseDiscount(String formatedBaseDiscount) {
        this.formatedBaseDiscount = formatedBaseDiscount;
    }

    public Object getCheckoutMethod() {
        return checkoutMethod;
    }

    public void setCheckoutMethod(Object checkoutMethod) {
        this.checkoutMethod = checkoutMethod;
    }

    public Integer getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Integer isGuest) {
        this.isGuest = isGuest;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Object getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Object conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Object getChannel() {
        return channel;
    }

    public void setChannel(Object channel) {
        this.channel = channel;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Object getSelectedShippingRate() {
        return selectedShippingRate;
    }

    public void setSelectedShippingRate(Object selectedShippingRate) {
        this.selectedShippingRate = selectedShippingRate;
    }

    public Object getPayment() {
        return payment;
    }

    public void setPayment(Object payment) {
        this.payment = payment;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getFormatedTaxes() {
        return formatedTaxes;
    }

    public void setFormatedTaxes(String formatedTaxes) {
        this.formatedTaxes = formatedTaxes;
    }

    public String getBaseTaxes() {
        return baseTaxes;
    }

    public void setBaseTaxes(String baseTaxes) {
        this.baseTaxes = baseTaxes;
    }

    public String getFormatedBaseTaxes() {
        return formatedBaseTaxes;
    }

    public void setFormatedBaseTaxes(String formatedBaseTaxes) {
        this.formatedBaseTaxes = formatedBaseTaxes;
    }

    public String getFormatedDiscountedSubTotal() {
        return formatedDiscountedSubTotal;
    }

    public void setFormatedDiscountedSubTotal(String formatedDiscountedSubTotal) {
        this.formatedDiscountedSubTotal = formatedDiscountedSubTotal;
    }

    public String getFormatedBaseDiscountedSubTotal() {
        return formatedBaseDiscountedSubTotal;
    }

    public void setFormatedBaseDiscountedSubTotal(String formatedBaseDiscountedSubTotal) {
        this.formatedBaseDiscountedSubTotal = formatedBaseDiscountedSubTotal;
    }
}
