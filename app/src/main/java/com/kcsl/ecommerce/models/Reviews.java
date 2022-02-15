package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reviews {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_rating")
    @Expose
    private Integer totalRating;
    @SerializedName("average_rating")
    @Expose
    private Integer averageRating;
    @SerializedName("percentage")
    @Expose
    private List<Object> percentage = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    public List<Object> getPercentage() {
        return percentage;
    }

    public void setPercentage(List<Object> percentage) {
        this.percentage = percentage;
    }
}
