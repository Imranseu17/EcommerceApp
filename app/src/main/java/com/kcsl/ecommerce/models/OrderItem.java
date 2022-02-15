package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderItem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ProductDatum")
    @Expose
    private ProductDatum ProductDatum;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("total_weight")
    @Expose
    private String totalWeight;
    @SerializedName("qty_ordered")
    @Expose
    private Integer qtyOrdered;
    @SerializedName("qty_canceled")
    @Expose
    private Integer qtyCanceled;
    @SerializedName("qty_invoiced")
    @Expose
    private Integer qtyInvoiced;
    @SerializedName("qty_shipped")
    @Expose
    private Integer qtyShipped;
    @SerializedName("qty_refunded")
    @Expose
    private Integer qtyRefunded;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("formated_price")
    @Expose
    private String formatedPrice;
    @SerializedName("base_price")
    @Expose
    private String basePrice;
    @SerializedName("formated_base_price")
    @Expose
    private String formatedBasePrice;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("formated_total")
    @Expose
    private String formatedTotal;
    @SerializedName("base_total")
    @Expose
    private String baseTotal;
    @SerializedName("formated_base_total")
    @Expose
    private String formatedBaseTotal;
    @SerializedName("total_invoiced")
    @Expose
    private String totalInvoiced;
    @SerializedName("formated_total_invoiced")
    @Expose
    private String formatedTotalInvoiced;
    @SerializedName("base_total_invoiced")
    @Expose
    private String baseTotalInvoiced;
    @SerializedName("formated_base_total_invoiced")
    @Expose
    private String formatedBaseTotalInvoiced;
    @SerializedName("amount_refunded")
    @Expose
    private String amountRefunded;
    @SerializedName("formated_amount_refunded")
    @Expose
    private String formatedAmountRefunded;
    @SerializedName("base_amount_refunded")
    @Expose
    private String baseAmountRefunded;
    @SerializedName("formated_base_amount_refunded")
    @Expose
    private String formatedBaseAmountRefunded;
    @SerializedName("discount_percent")
    @Expose
    private String discountPercent;
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
    private String discountInvoiced;
    @SerializedName("formated_discount_invoiced")
    @Expose
    private String formatedDiscountInvoiced;
    @SerializedName("base_discount_invoiced")
    @Expose
    private String baseDiscountInvoiced;
    @SerializedName("formated_base_discount_invoiced")
    @Expose
    private String formatedBaseDiscountInvoiced;
    @SerializedName("discount_refunded")
    @Expose
    private String discountRefunded;
    @SerializedName("formated_discount_refunded")
    @Expose
    private String formatedDiscountRefunded;
    @SerializedName("base_discount_refunded")
    @Expose
    private String baseDiscountRefunded;
    @SerializedName("formated_base_discount_refunded")
    @Expose
    private String formatedBaseDiscountRefunded;
    @SerializedName("tax_percent")
    @Expose
    private String taxPercent;
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
    private String taxAmountInvoiced;
    @SerializedName("formated_tax_amount_invoiced")
    @Expose
    private String formatedTaxAmountInvoiced;
    @SerializedName("base_tax_amount_invoiced")
    @Expose
    private String baseTaxAmountInvoiced;
    @SerializedName("formated_base_tax_amount_invoiced")
    @Expose
    private String formatedBaseTaxAmountInvoiced;
    @SerializedName("tax_amount_refunded")
    @Expose
    private String taxAmountRefunded;
    @SerializedName("formated_tax_amount_refunded")
    @Expose
    private String formatedTaxAmountRefunded;
    @SerializedName("base_tax_amount_refunded")
    @Expose
    private String baseTaxAmountRefunded;
    @SerializedName("formated_base_tax_amount_refunded")
    @Expose
    private String formatedBaseTaxAmountRefunded;
    @SerializedName("grant_total")
    @Expose
    private Integer grantTotal;
    @SerializedName("formated_grant_total")
    @Expose
    private String formatedGrantTotal;
    @SerializedName("base_grant_total")
    @Expose
    private Integer baseGrantTotal;
    @SerializedName("formated_base_grant_total")
    @Expose
    private String formatedBaseGrantTotal;
    @SerializedName("downloadable_links")
    @Expose
    private List<Object> downloadableLinks = null;
    @SerializedName("additional")
    @Expose
    private Additional additional;
    @SerializedName("child")
    @Expose
    private Object child;
    @SerializedName("children")
    @Expose
    private List<Object> children = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDatum getProductDatum() {
        return ProductDatum;
    }

    public void setProductDatum(ProductDatum ProductDatum) {
        this.ProductDatum = ProductDatum;
    }

    public Object getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Object couponCode) {
        this.couponCode = couponCode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(Integer qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Integer getQtyCanceled() {
        return qtyCanceled;
    }

    public void setQtyCanceled(Integer qtyCanceled) {
        this.qtyCanceled = qtyCanceled;
    }

    public Integer getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(Integer qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }

    public Integer getQtyShipped() {
        return qtyShipped;
    }

    public void setQtyShipped(Integer qtyShipped) {
        this.qtyShipped = qtyShipped;
    }

    public Integer getQtyRefunded() {
        return qtyRefunded;
    }

    public void setQtyRefunded(Integer qtyRefunded) {
        this.qtyRefunded = qtyRefunded;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFormatedPrice() {
        return formatedPrice;
    }

    public void setFormatedPrice(String formatedPrice) {
        this.formatedPrice = formatedPrice;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getFormatedBasePrice() {
        return formatedBasePrice;
    }

    public void setFormatedBasePrice(String formatedBasePrice) {
        this.formatedBasePrice = formatedBasePrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFormatedTotal() {
        return formatedTotal;
    }

    public void setFormatedTotal(String formatedTotal) {
        this.formatedTotal = formatedTotal;
    }

    public String getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(String baseTotal) {
        this.baseTotal = baseTotal;
    }

    public String getFormatedBaseTotal() {
        return formatedBaseTotal;
    }

    public void setFormatedBaseTotal(String formatedBaseTotal) {
        this.formatedBaseTotal = formatedBaseTotal;
    }

    public String getTotalInvoiced() {
        return totalInvoiced;
    }

    public void setTotalInvoiced(String totalInvoiced) {
        this.totalInvoiced = totalInvoiced;
    }

    public String getFormatedTotalInvoiced() {
        return formatedTotalInvoiced;
    }

    public void setFormatedTotalInvoiced(String formatedTotalInvoiced) {
        this.formatedTotalInvoiced = formatedTotalInvoiced;
    }

    public String getBaseTotalInvoiced() {
        return baseTotalInvoiced;
    }

    public void setBaseTotalInvoiced(String baseTotalInvoiced) {
        this.baseTotalInvoiced = baseTotalInvoiced;
    }

    public String getFormatedBaseTotalInvoiced() {
        return formatedBaseTotalInvoiced;
    }

    public void setFormatedBaseTotalInvoiced(String formatedBaseTotalInvoiced) {
        this.formatedBaseTotalInvoiced = formatedBaseTotalInvoiced;
    }

    public String getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(String amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getFormatedAmountRefunded() {
        return formatedAmountRefunded;
    }

    public void setFormatedAmountRefunded(String formatedAmountRefunded) {
        this.formatedAmountRefunded = formatedAmountRefunded;
    }

    public String getBaseAmountRefunded() {
        return baseAmountRefunded;
    }

    public void setBaseAmountRefunded(String baseAmountRefunded) {
        this.baseAmountRefunded = baseAmountRefunded;
    }

    public String getFormatedBaseAmountRefunded() {
        return formatedBaseAmountRefunded;
    }

    public void setFormatedBaseAmountRefunded(String formatedBaseAmountRefunded) {
        this.formatedBaseAmountRefunded = formatedBaseAmountRefunded;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
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

    public String getDiscountInvoiced() {
        return discountInvoiced;
    }

    public void setDiscountInvoiced(String discountInvoiced) {
        this.discountInvoiced = discountInvoiced;
    }

    public String getFormatedDiscountInvoiced() {
        return formatedDiscountInvoiced;
    }

    public void setFormatedDiscountInvoiced(String formatedDiscountInvoiced) {
        this.formatedDiscountInvoiced = formatedDiscountInvoiced;
    }

    public String getBaseDiscountInvoiced() {
        return baseDiscountInvoiced;
    }

    public void setBaseDiscountInvoiced(String baseDiscountInvoiced) {
        this.baseDiscountInvoiced = baseDiscountInvoiced;
    }

    public String getFormatedBaseDiscountInvoiced() {
        return formatedBaseDiscountInvoiced;
    }

    public void setFormatedBaseDiscountInvoiced(String formatedBaseDiscountInvoiced) {
        this.formatedBaseDiscountInvoiced = formatedBaseDiscountInvoiced;
    }

    public String getDiscountRefunded() {
        return discountRefunded;
    }

    public void setDiscountRefunded(String discountRefunded) {
        this.discountRefunded = discountRefunded;
    }

    public String getFormatedDiscountRefunded() {
        return formatedDiscountRefunded;
    }

    public void setFormatedDiscountRefunded(String formatedDiscountRefunded) {
        this.formatedDiscountRefunded = formatedDiscountRefunded;
    }

    public String getBaseDiscountRefunded() {
        return baseDiscountRefunded;
    }

    public void setBaseDiscountRefunded(String baseDiscountRefunded) {
        this.baseDiscountRefunded = baseDiscountRefunded;
    }

    public String getFormatedBaseDiscountRefunded() {
        return formatedBaseDiscountRefunded;
    }

    public void setFormatedBaseDiscountRefunded(String formatedBaseDiscountRefunded) {
        this.formatedBaseDiscountRefunded = formatedBaseDiscountRefunded;
    }

    public String getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(String taxPercent) {
        this.taxPercent = taxPercent;
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

    public String getTaxAmountInvoiced() {
        return taxAmountInvoiced;
    }

    public void setTaxAmountInvoiced(String taxAmountInvoiced) {
        this.taxAmountInvoiced = taxAmountInvoiced;
    }

    public String getFormatedTaxAmountInvoiced() {
        return formatedTaxAmountInvoiced;
    }

    public void setFormatedTaxAmountInvoiced(String formatedTaxAmountInvoiced) {
        this.formatedTaxAmountInvoiced = formatedTaxAmountInvoiced;
    }

    public String getBaseTaxAmountInvoiced() {
        return baseTaxAmountInvoiced;
    }

    public void setBaseTaxAmountInvoiced(String baseTaxAmountInvoiced) {
        this.baseTaxAmountInvoiced = baseTaxAmountInvoiced;
    }

    public String getFormatedBaseTaxAmountInvoiced() {
        return formatedBaseTaxAmountInvoiced;
    }

    public void setFormatedBaseTaxAmountInvoiced(String formatedBaseTaxAmountInvoiced) {
        this.formatedBaseTaxAmountInvoiced = formatedBaseTaxAmountInvoiced;
    }

    public String getTaxAmountRefunded() {
        return taxAmountRefunded;
    }

    public void setTaxAmountRefunded(String taxAmountRefunded) {
        this.taxAmountRefunded = taxAmountRefunded;
    }

    public String getFormatedTaxAmountRefunded() {
        return formatedTaxAmountRefunded;
    }

    public void setFormatedTaxAmountRefunded(String formatedTaxAmountRefunded) {
        this.formatedTaxAmountRefunded = formatedTaxAmountRefunded;
    }

    public String getBaseTaxAmountRefunded() {
        return baseTaxAmountRefunded;
    }

    public void setBaseTaxAmountRefunded(String baseTaxAmountRefunded) {
        this.baseTaxAmountRefunded = baseTaxAmountRefunded;
    }

    public String getFormatedBaseTaxAmountRefunded() {
        return formatedBaseTaxAmountRefunded;
    }

    public void setFormatedBaseTaxAmountRefunded(String formatedBaseTaxAmountRefunded) {
        this.formatedBaseTaxAmountRefunded = formatedBaseTaxAmountRefunded;
    }

    public Integer getGrantTotal() {
        return grantTotal;
    }

    public void setGrantTotal(Integer grantTotal) {
        this.grantTotal = grantTotal;
    }

    public String getFormatedGrantTotal() {
        return formatedGrantTotal;
    }

    public void setFormatedGrantTotal(String formatedGrantTotal) {
        this.formatedGrantTotal = formatedGrantTotal;
    }

    public Integer getBaseGrantTotal() {
        return baseGrantTotal;
    }

    public void setBaseGrantTotal(Integer baseGrantTotal) {
        this.baseGrantTotal = baseGrantTotal;
    }

    public String getFormatedBaseGrantTotal() {
        return formatedBaseGrantTotal;
    }

    public void setFormatedBaseGrantTotal(String formatedBaseGrantTotal) {
        this.formatedBaseGrantTotal = formatedBaseGrantTotal;
    }

    public List<Object> getDownloadableLinks() {
        return downloadableLinks;
    }

    public void setDownloadableLinks(List<Object> downloadableLinks) {
        this.downloadableLinks = downloadableLinks;
    }

    public Additional getAdditional() {
        return additional;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public Object getChild() {
        return child;
    }

    public void setChild(Object child) {
        this.child = child;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }
}
