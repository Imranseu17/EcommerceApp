package com.kcsl.ecommerce.models;



import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coupon_code")
    @Expose
    private Object couponCode;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("total_weight")
    @Expose
    private String totalWeight;
    @SerializedName("base_total_weight")
    @Expose
    private String baseTotalWeight;
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
    @SerializedName("custom_price")
    @Expose
    private Object customPrice;
    @SerializedName("formated_custom_price")
    @Expose
    private String formatedCustomPrice;
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
    @SerializedName("additional")
    @Expose
    private Additional additional;
    @SerializedName("child")
    @Expose
    private Object child;
    @SerializedName("product")
    @Expose
    private ShoppingProduct product;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    protected Item(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            quantity = null;
        } else {
            quantity = in.readInt();
        }
        sku = in.readString();
        type = in.readString();
        name = in.readString();
        weight = in.readString();
        totalWeight = in.readString();
        baseTotalWeight = in.readString();
        price = in.readString();
        formatedPrice = in.readString();
        basePrice = in.readString();
        formatedBasePrice = in.readString();
        formatedCustomPrice = in.readString();
        total = in.readString();
        formatedTotal = in.readString();
        baseTotal = in.readString();
        formatedBaseTotal = in.readString();
        taxPercent = in.readString();
        taxAmount = in.readString();
        formatedTaxAmount = in.readString();
        baseTaxAmount = in.readString();
        formatedBaseTaxAmount = in.readString();
        discountPercent = in.readString();
        discountAmount = in.readString();
        formatedDiscountAmount = in.readString();
        baseDiscountAmount = in.readString();
        formatedBaseDiscountAmount = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getBaseTotalWeight() {
        return baseTotalWeight;
    }

    public void setBaseTotalWeight(String baseTotalWeight) {
        this.baseTotalWeight = baseTotalWeight;
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

    public Object getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(Object customPrice) {
        this.customPrice = customPrice;
    }

    public String getFormatedCustomPrice() {
        return formatedCustomPrice;
    }

    public void setFormatedCustomPrice(String formatedCustomPrice) {
        this.formatedCustomPrice = formatedCustomPrice;
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

    public ShoppingProduct getProduct() {
        return product;
    }

    public void setProduct(ShoppingProduct product) {
        this.product = product;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        if (quantity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(quantity);
        }
        parcel.writeString(sku);
        parcel.writeString(type);
        parcel.writeString(name);
        parcel.writeString(weight);
        parcel.writeString(totalWeight);
        parcel.writeString(baseTotalWeight);
        parcel.writeString(price);
        parcel.writeString(formatedPrice);
        parcel.writeString(basePrice);
        parcel.writeString(formatedBasePrice);
        parcel.writeString(formatedCustomPrice);
        parcel.writeString(total);
        parcel.writeString(formatedTotal);
        parcel.writeString(baseTotal);
        parcel.writeString(formatedBaseTotal);
        parcel.writeString(taxPercent);
        parcel.writeString(taxAmount);
        parcel.writeString(formatedTaxAmount);
        parcel.writeString(baseTaxAmount);
        parcel.writeString(formatedBaseTaxAmount);
        parcel.writeString(discountPercent);
        parcel.writeString(discountAmount);
        parcel.writeString(formatedDiscountAmount);
        parcel.writeString(baseDiscountAmount);
        parcel.writeString(formatedBaseDiscountAmount);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
    }
}
