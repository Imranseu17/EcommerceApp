package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("increment_id")
    @Expose
    private String incrementId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_label")
    @Expose
    private String statusLabel;
    @SerializedName("channel_name")
    @Expose
    private String channelName;
    @SerializedName("is_guest")
    @Expose
    private Integer isGuest;
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
    private String shippingMethod;
    @SerializedName("shipping_title")
    @Expose
    private String shippingTitle;
    @SerializedName("payment_title")
    @Expose
    private String paymentTitle;
    @SerializedName("shipping_description")
    @Expose
    private String shippingDescription;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("is_gift")
    @Expose
    private Object isGift;
    @SerializedName("total_OrderItem_count")
    @Expose
    private Integer totalOrderItemCount;
    @SerializedName("total_qty_ordered")
    @Expose
    private String totalQtyOrdered;
    @SerializedName("base_currency_code")
    @Expose
    private String baseCurrencyCode;
    @SerializedName("channel_currency_code")
    @Expose
    private String channelCurrencyCode;
    @SerializedName("order_currency_code")
    @Expose
    private String orderCurrencyCode;
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
    @SerializedName("grand_total_invoiced")
    @Expose
    private Object grandTotalInvoiced;
    @SerializedName("formated_grand_total_invoiced")
    @Expose
    private String formatedGrandTotalInvoiced;
    @SerializedName("base_grand_total_invoiced")
    @Expose
    private Object baseGrandTotalInvoiced;
    @SerializedName("formated_base_grand_total_invoiced")
    @Expose
    private String formatedBaseGrandTotalInvoiced;
    @SerializedName("grand_total_refunded")
    @Expose
    private Object grandTotalRefunded;
    @SerializedName("formated_grand_total_refunded")
    @Expose
    private String formatedGrandTotalRefunded;
    @SerializedName("base_grand_total_refunded")
    @Expose
    private Object baseGrandTotalRefunded;
    @SerializedName("formated_base_grand_total_refunded")
    @Expose
    private String formatedBaseGrandTotalRefunded;
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
    @SerializedName("sub_total_invoiced")
    @Expose
    private Object subTotalInvoiced;
    @SerializedName("formated_sub_total_invoiced")
    @Expose
    private String formatedSubTotalInvoiced;
    @SerializedName("base_sub_total_invoiced")
    @Expose
    private Object baseSubTotalInvoiced;
    @SerializedName("formated_base_sub_total_invoiced")
    @Expose
    private String formatedBaseSubTotalInvoiced;
    @SerializedName("sub_total_refunded")
    @Expose
    private Object subTotalRefunded;
    @SerializedName("formated_sub_total_refunded")
    @Expose
    private String formatedSubTotalRefunded;
    @SerializedName("discount_percent")
    @Expose
    private Object discountPercent;
    @SerializedName("discount_amount")
    @Expose
    private String discountAmount;
    @SerializedName("formated_discount_amount")
    @Expose
    private String formatedDiscountAmount;
    @SerializedName("base_discount_amount")
    @Expose
    private String baseDiscountAmount;
    @SerializedName("formated_base_discount_amount")
    @Expose
    private String formatedBaseDiscountAmount;
    @SerializedName("discount_invoiced")
    @Expose
    private Object discountInvoiced;
    @SerializedName("formated_discount_invoiced")
    @Expose
    private String formatedDiscountInvoiced;
    @SerializedName("base_discount_invoiced")
    @Expose
    private Object baseDiscountInvoiced;
    @SerializedName("formated_base_discount_invoiced")
    @Expose
    private String formatedBaseDiscountInvoiced;
    @SerializedName("discount_refunded")
    @Expose
    private Object discountRefunded;
    @SerializedName("formated_discount_refunded")
    @Expose
    private String formatedDiscountRefunded;
    @SerializedName("base_discount_refunded")
    @Expose
    private Object baseDiscountRefunded;
    @SerializedName("formated_base_discount_refunded")
    @Expose
    private String formatedBaseDiscountRefunded;
    @SerializedName("tax_amount")
    @Expose
    private String taxAmount;
    @SerializedName("formated_tax_amount")
    @Expose
    private String formatedTaxAmount;
    @SerializedName("base_tax_amount")
    @Expose
    private String baseTaxAmount;
    @SerializedName("formated_base_tax_amount")
    @Expose
    private String formatedBaseTaxAmount;
    @SerializedName("tax_amount_invoiced")
    @Expose
    private Object taxAmountInvoiced;
    @SerializedName("formated_tax_amount_invoiced")
    @Expose
    private String formatedTaxAmountInvoiced;
    @SerializedName("base_tax_amount_invoiced")
    @Expose
    private Object baseTaxAmountInvoiced;
    @SerializedName("formated_base_tax_amount_invoiced")
    @Expose
    private String formatedBaseTaxAmountInvoiced;
    @SerializedName("tax_amount_refunded")
    @Expose
    private Object taxAmountRefunded;
    @SerializedName("formated_tax_amount_refunded")
    @Expose
    private String formatedTaxAmountRefunded;
    @SerializedName("base_tax_amount_refunded")
    @Expose
    private Object baseTaxAmountRefunded;
    @SerializedName("formated_base_tax_amount_refunded")
    @Expose
    private String formatedBaseTaxAmountRefunded;
    @SerializedName("shipping_amount")
    @Expose
    private Integer shippingAmount;
    @SerializedName("formated_shipping_amount")
    @Expose
    private String formatedShippingAmount;
    @SerializedName("base_shipping_amount")
    @Expose
    private Integer baseShippingAmount;
    @SerializedName("formated_base_shipping_amount")
    @Expose
    private String formatedBaseShippingAmount;
    @SerializedName("shipping_invoiced")
    @Expose
    private Object shippingInvoiced;
    @SerializedName("formated_shipping_invoiced")
    @Expose
    private String formatedShippingInvoiced;
    @SerializedName("base_shipping_invoiced")
    @Expose
    private Object baseShippingInvoiced;
    @SerializedName("formated_base_shipping_invoiced")
    @Expose
    private String formatedBaseShippingInvoiced;
    @SerializedName("shipping_refunded")
    @Expose
    private Object shippingRefunded;
    @SerializedName("formated_shipping_refunded")
    @Expose
    private String formatedShippingRefunded;
    @SerializedName("base_shipping_refunded")
    @Expose
    private Object baseShippingRefunded;
    @SerializedName("formated_base_shipping_refunded")
    @Expose
    private String formatedBaseShippingRefunded;
    @SerializedName("channel")
    @Expose
    private Channel channel;
    @SerializedName("shipping_address")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("billing_address")
    @Expose
    private BillingAddress billingAddress;
    @SerializedName("OrderItems")
    @Expose
    private List<OrderItem> OrderItems = null;
    @SerializedName("invoices")
    @Expose
    private List<Object> invoices = null;
    @SerializedName("shipments")
    @Expose
    private List<Object> shipments = null;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(String incrementId) {
        this.incrementId = incrementId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Integer isGuest) {
        this.isGuest = isGuest;
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

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingTitle() {
        return shippingTitle;
    }

    public void setShippingTitle(String shippingTitle) {
        this.shippingTitle = shippingTitle;
    }

    public String getPaymentTitle() {
        return paymentTitle;
    }

    public void setPaymentTitle(String paymentTitle) {
        this.paymentTitle = paymentTitle;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Object getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    public Object getIsGift() {
        return isGift;
    }

    public void setIsGift(Object isGift) {
        this.isGift = isGift;
    }

    public Integer getTotalOrderItemCount() {
        return totalOrderItemCount;
    }

    public void setTotalOrderItemCount(Integer totalOrderItemCount) {
        this.totalOrderItemCount = totalOrderItemCount;
    }

    public String getTotalQtyOrdered() {
        return totalQtyOrdered;
    }

    public void setTotalQtyOrdered(String totalQtyOrdered) {
        this.totalQtyOrdered = totalQtyOrdered;
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

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public void setOrderCurrencyCode(String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
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

    public Object getGrandTotalInvoiced() {
        return grandTotalInvoiced;
    }

    public void setGrandTotalInvoiced(Object grandTotalInvoiced) {
        this.grandTotalInvoiced = grandTotalInvoiced;
    }

    public String getFormatedGrandTotalInvoiced() {
        return formatedGrandTotalInvoiced;
    }

    public void setFormatedGrandTotalInvoiced(String formatedGrandTotalInvoiced) {
        this.formatedGrandTotalInvoiced = formatedGrandTotalInvoiced;
    }

    public Object getBaseGrandTotalInvoiced() {
        return baseGrandTotalInvoiced;
    }

    public void setBaseGrandTotalInvoiced(Object baseGrandTotalInvoiced) {
        this.baseGrandTotalInvoiced = baseGrandTotalInvoiced;
    }

    public String getFormatedBaseGrandTotalInvoiced() {
        return formatedBaseGrandTotalInvoiced;
    }

    public void setFormatedBaseGrandTotalInvoiced(String formatedBaseGrandTotalInvoiced) {
        this.formatedBaseGrandTotalInvoiced = formatedBaseGrandTotalInvoiced;
    }

    public Object getGrandTotalRefunded() {
        return grandTotalRefunded;
    }

    public void setGrandTotalRefunded(Object grandTotalRefunded) {
        this.grandTotalRefunded = grandTotalRefunded;
    }

    public String getFormatedGrandTotalRefunded() {
        return formatedGrandTotalRefunded;
    }

    public void setFormatedGrandTotalRefunded(String formatedGrandTotalRefunded) {
        this.formatedGrandTotalRefunded = formatedGrandTotalRefunded;
    }

    public Object getBaseGrandTotalRefunded() {
        return baseGrandTotalRefunded;
    }

    public void setBaseGrandTotalRefunded(Object baseGrandTotalRefunded) {
        this.baseGrandTotalRefunded = baseGrandTotalRefunded;
    }

    public String getFormatedBaseGrandTotalRefunded() {
        return formatedBaseGrandTotalRefunded;
    }

    public void setFormatedBaseGrandTotalRefunded(String formatedBaseGrandTotalRefunded) {
        this.formatedBaseGrandTotalRefunded = formatedBaseGrandTotalRefunded;
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

    public Object getSubTotalInvoiced() {
        return subTotalInvoiced;
    }

    public void setSubTotalInvoiced(Object subTotalInvoiced) {
        this.subTotalInvoiced = subTotalInvoiced;
    }

    public String getFormatedSubTotalInvoiced() {
        return formatedSubTotalInvoiced;
    }

    public void setFormatedSubTotalInvoiced(String formatedSubTotalInvoiced) {
        this.formatedSubTotalInvoiced = formatedSubTotalInvoiced;
    }

    public Object getBaseSubTotalInvoiced() {
        return baseSubTotalInvoiced;
    }

    public void setBaseSubTotalInvoiced(Object baseSubTotalInvoiced) {
        this.baseSubTotalInvoiced = baseSubTotalInvoiced;
    }

    public String getFormatedBaseSubTotalInvoiced() {
        return formatedBaseSubTotalInvoiced;
    }

    public void setFormatedBaseSubTotalInvoiced(String formatedBaseSubTotalInvoiced) {
        this.formatedBaseSubTotalInvoiced = formatedBaseSubTotalInvoiced;
    }

    public Object getSubTotalRefunded() {
        return subTotalRefunded;
    }

    public void setSubTotalRefunded(Object subTotalRefunded) {
        this.subTotalRefunded = subTotalRefunded;
    }

    public String getFormatedSubTotalRefunded() {
        return formatedSubTotalRefunded;
    }

    public void setFormatedSubTotalRefunded(String formatedSubTotalRefunded) {
        this.formatedSubTotalRefunded = formatedSubTotalRefunded;
    }

    public Object getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Object discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getFormatedDiscountAmount() {
        return formatedDiscountAmount;
    }

    public void setFormatedDiscountAmount(String formatedDiscountAmount) {
        this.formatedDiscountAmount = formatedDiscountAmount;
    }

    public String getBaseDiscountAmount() {
        return baseDiscountAmount;
    }

    public void setBaseDiscountAmount(String baseDiscountAmount) {
        this.baseDiscountAmount = baseDiscountAmount;
    }

    public String getFormatedBaseDiscountAmount() {
        return formatedBaseDiscountAmount;
    }

    public void setFormatedBaseDiscountAmount(String formatedBaseDiscountAmount) {
        this.formatedBaseDiscountAmount = formatedBaseDiscountAmount;
    }

    public Object getDiscountInvoiced() {
        return discountInvoiced;
    }

    public void setDiscountInvoiced(Object discountInvoiced) {
        this.discountInvoiced = discountInvoiced;
    }

    public String getFormatedDiscountInvoiced() {
        return formatedDiscountInvoiced;
    }

    public void setFormatedDiscountInvoiced(String formatedDiscountInvoiced) {
        this.formatedDiscountInvoiced = formatedDiscountInvoiced;
    }

    public Object getBaseDiscountInvoiced() {
        return baseDiscountInvoiced;
    }

    public void setBaseDiscountInvoiced(Object baseDiscountInvoiced) {
        this.baseDiscountInvoiced = baseDiscountInvoiced;
    }

    public String getFormatedBaseDiscountInvoiced() {
        return formatedBaseDiscountInvoiced;
    }

    public void setFormatedBaseDiscountInvoiced(String formatedBaseDiscountInvoiced) {
        this.formatedBaseDiscountInvoiced = formatedBaseDiscountInvoiced;
    }

    public Object getDiscountRefunded() {
        return discountRefunded;
    }

    public void setDiscountRefunded(Object discountRefunded) {
        this.discountRefunded = discountRefunded;
    }

    public String getFormatedDiscountRefunded() {
        return formatedDiscountRefunded;
    }

    public void setFormatedDiscountRefunded(String formatedDiscountRefunded) {
        this.formatedDiscountRefunded = formatedDiscountRefunded;
    }

    public Object getBaseDiscountRefunded() {
        return baseDiscountRefunded;
    }

    public void setBaseDiscountRefunded(Object baseDiscountRefunded) {
        this.baseDiscountRefunded = baseDiscountRefunded;
    }

    public String getFormatedBaseDiscountRefunded() {
        return formatedBaseDiscountRefunded;
    }

    public void setFormatedBaseDiscountRefunded(String formatedBaseDiscountRefunded) {
        this.formatedBaseDiscountRefunded = formatedBaseDiscountRefunded;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getFormatedTaxAmount() {
        return formatedTaxAmount;
    }

    public void setFormatedTaxAmount(String formatedTaxAmount) {
        this.formatedTaxAmount = formatedTaxAmount;
    }

    public String getBaseTaxAmount() {
        return baseTaxAmount;
    }

    public void setBaseTaxAmount(String baseTaxAmount) {
        this.baseTaxAmount = baseTaxAmount;
    }

    public String getFormatedBaseTaxAmount() {
        return formatedBaseTaxAmount;
    }

    public void setFormatedBaseTaxAmount(String formatedBaseTaxAmount) {
        this.formatedBaseTaxAmount = formatedBaseTaxAmount;
    }

    public Object getTaxAmountInvoiced() {
        return taxAmountInvoiced;
    }

    public void setTaxAmountInvoiced(Object taxAmountInvoiced) {
        this.taxAmountInvoiced = taxAmountInvoiced;
    }

    public String getFormatedTaxAmountInvoiced() {
        return formatedTaxAmountInvoiced;
    }

    public void setFormatedTaxAmountInvoiced(String formatedTaxAmountInvoiced) {
        this.formatedTaxAmountInvoiced = formatedTaxAmountInvoiced;
    }

    public Object getBaseTaxAmountInvoiced() {
        return baseTaxAmountInvoiced;
    }

    public void setBaseTaxAmountInvoiced(Object baseTaxAmountInvoiced) {
        this.baseTaxAmountInvoiced = baseTaxAmountInvoiced;
    }

    public String getFormatedBaseTaxAmountInvoiced() {
        return formatedBaseTaxAmountInvoiced;
    }

    public void setFormatedBaseTaxAmountInvoiced(String formatedBaseTaxAmountInvoiced) {
        this.formatedBaseTaxAmountInvoiced = formatedBaseTaxAmountInvoiced;
    }

    public Object getTaxAmountRefunded() {
        return taxAmountRefunded;
    }

    public void setTaxAmountRefunded(Object taxAmountRefunded) {
        this.taxAmountRefunded = taxAmountRefunded;
    }

    public String getFormatedTaxAmountRefunded() {
        return formatedTaxAmountRefunded;
    }

    public void setFormatedTaxAmountRefunded(String formatedTaxAmountRefunded) {
        this.formatedTaxAmountRefunded = formatedTaxAmountRefunded;
    }

    public Object getBaseTaxAmountRefunded() {
        return baseTaxAmountRefunded;
    }

    public void setBaseTaxAmountRefunded(Object baseTaxAmountRefunded) {
        this.baseTaxAmountRefunded = baseTaxAmountRefunded;
    }

    public String getFormatedBaseTaxAmountRefunded() {
        return formatedBaseTaxAmountRefunded;
    }

    public void setFormatedBaseTaxAmountRefunded(String formatedBaseTaxAmountRefunded) {
        this.formatedBaseTaxAmountRefunded = formatedBaseTaxAmountRefunded;
    }

    public Integer getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Integer shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getFormatedShippingAmount() {
        return formatedShippingAmount;
    }

    public void setFormatedShippingAmount(String formatedShippingAmount) {
        this.formatedShippingAmount = formatedShippingAmount;
    }

    public Integer getBaseShippingAmount() {
        return baseShippingAmount;
    }

    public void setBaseShippingAmount(Integer baseShippingAmount) {
        this.baseShippingAmount = baseShippingAmount;
    }

    public String getFormatedBaseShippingAmount() {
        return formatedBaseShippingAmount;
    }

    public void setFormatedBaseShippingAmount(String formatedBaseShippingAmount) {
        this.formatedBaseShippingAmount = formatedBaseShippingAmount;
    }

    public Object getShippingInvoiced() {
        return shippingInvoiced;
    }

    public void setShippingInvoiced(Object shippingInvoiced) {
        this.shippingInvoiced = shippingInvoiced;
    }

    public String getFormatedShippingInvoiced() {
        return formatedShippingInvoiced;
    }

    public void setFormatedShippingInvoiced(String formatedShippingInvoiced) {
        this.formatedShippingInvoiced = formatedShippingInvoiced;
    }

    public Object getBaseShippingInvoiced() {
        return baseShippingInvoiced;
    }

    public void setBaseShippingInvoiced(Object baseShippingInvoiced) {
        this.baseShippingInvoiced = baseShippingInvoiced;
    }

    public String getFormatedBaseShippingInvoiced() {
        return formatedBaseShippingInvoiced;
    }

    public void setFormatedBaseShippingInvoiced(String formatedBaseShippingInvoiced) {
        this.formatedBaseShippingInvoiced = formatedBaseShippingInvoiced;
    }

    public Object getShippingRefunded() {
        return shippingRefunded;
    }

    public void setShippingRefunded(Object shippingRefunded) {
        this.shippingRefunded = shippingRefunded;
    }

    public String getFormatedShippingRefunded() {
        return formatedShippingRefunded;
    }

    public void setFormatedShippingRefunded(String formatedShippingRefunded) {
        this.formatedShippingRefunded = formatedShippingRefunded;
    }

    public Object getBaseShippingRefunded() {
        return baseShippingRefunded;
    }

    public void setBaseShippingRefunded(Object baseShippingRefunded) {
        this.baseShippingRefunded = baseShippingRefunded;
    }

    public String getFormatedBaseShippingRefunded() {
        return formatedBaseShippingRefunded;
    }

    public void setFormatedBaseShippingRefunded(String formatedBaseShippingRefunded) {
        this.formatedBaseShippingRefunded = formatedBaseShippingRefunded;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> OrderItems) {
        this.OrderItems = OrderItems;
    }

    public List<Object> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Object> invoices) {
        this.invoices = invoices;
    }

    public List<Object> getShipments() {
        return shipments;
    }

    public void setShipments(List<Object> shipments) {
        this.shipments = shipments;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
