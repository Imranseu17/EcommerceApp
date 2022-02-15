package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShoppingProduct {
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
    @SerializedName("url_key")
    @Expose
    private String urlKey;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("formated_price")
    @Expose
    private String formatedPrice;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("videos")
    @Expose
    private List<Object> videos = null;
    @SerializedName("base_image")
    @Expose
    private BaseImage baseImage;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("reviews")
    @Expose
    private Reviews reviews;
    @SerializedName("in_stock")
    @Expose
    private Boolean inStock;
    @SerializedName("is_saved")
    @Expose
    private Boolean isSaved;
    @SerializedName("is_wishlisted")
    @Expose
    private Boolean isWishlisted;
    @SerializedName("is_item_in_cart")
    @Expose
    private Boolean isItemInCart;
    @SerializedName("show_quantity_changer")
    @Expose
    private Boolean showQuantityChanger;

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

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Object> getVideos() {
        return videos;
    }

    public void setVideos(List<Object> videos) {
        this.videos = videos;
    }

    public BaseImage getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(BaseImage baseImage) {
        this.baseImage = baseImage;
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

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }

    public Boolean getIsWishlisted() {
        return isWishlisted;
    }

    public void setIsWishlisted(Boolean isWishlisted) {
        this.isWishlisted = isWishlisted;
    }

    public Boolean getIsItemInCart() {
        return isItemInCart;
    }

    public void setIsItemInCart(Boolean isItemInCart) {
        this.isItemInCart = isItemInCart;
    }

    public Boolean getShowQuantityChanger() {
        return showQuantityChanger;
    }

    public void setShowQuantityChanger(Boolean showQuantityChanger) {
        this.showQuantityChanger = showQuantityChanger;
    }

}





