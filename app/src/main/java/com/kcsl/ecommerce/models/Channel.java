package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("timezone")
    @Expose
    private Object timezone;
    @SerializedName("theme")
    @Expose
    private String theme;
    @SerializedName("home_page_content")
    @Expose
    private String homePageContent;
    @SerializedName("footer_content")
    @Expose
    private String footerContent;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("logo")
    @Expose
    private Object logo;
    @SerializedName("logo_url")
    @Expose
    private Object logoUrl;
    @SerializedName("favicon")
    @Expose
    private Object favicon;
    @SerializedName("favicon_url")
    @Expose
    private Object faviconUrl;
    @SerializedName("default_locale")
    @Expose
    private DefaultLocale defaultLocale;
    @SerializedName("root_category_id")
    @Expose
    private Integer rootCategoryId;
    @SerializedName("root_category")
    @Expose
    private RootCategory rootCategory;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getTimezone() {
        return timezone;
    }

    public void setTimezone(Object timezone) {
        this.timezone = timezone;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getHomePageContent() {
        return homePageContent;
    }

    public void setHomePageContent(String homePageContent) {
        this.homePageContent = homePageContent;
    }

    public String getFooterContent() {
        return footerContent;
    }

    public void setFooterContent(String footerContent) {
        this.footerContent = footerContent;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Object getLogo() {
        return logo;
    }

    public void setLogo(Object logo) {
        this.logo = logo;
    }

    public Object getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(Object logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Object getFavicon() {
        return favicon;
    }

    public void setFavicon(Object favicon) {
        this.favicon = favicon;
    }

    public Object getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(Object faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public DefaultLocale getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(DefaultLocale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    public void setRootCategoryId(Integer rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    public RootCategory getRootCategory() {
        return rootCategory;
    }

    public void setRootCategory(RootCategory rootCategory) {
        this.rootCategory = rootCategory;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
