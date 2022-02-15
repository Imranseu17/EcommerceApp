package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Additional {
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("super_attribute")
    @Expose
    private String superAttribute;
    @SerializedName("is_configurable_")
    @Expose
    private String isConfigurable;
    @SerializedName("selected_configurable_option")
    @Expose
    private String selectedConfigurableOption;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSuperAttribute() {
        return superAttribute;
    }

    public void setSuperAttribute(String superAttribute) {
        this.superAttribute = superAttribute;
    }

    public String getIsConfigurable() {
        return isConfigurable;
    }

    public void setIsConfigurable(String isConfigurable) {
        this.isConfigurable = isConfigurable;
    }

    public String getSelectedConfigurableOption() {
        return selectedConfigurableOption;
    }

    public void setSelectedConfigurableOption(String selectedConfigurableOption) {
        this.selectedConfigurableOption = selectedConfigurableOption;
    }
}
