package com.kcsl.ecommerce.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCardItems {
        @SerializedName("data")
        @Expose
        private ShoppingData data;

        public ShoppingData getData() {
            return data;
        }

        public void setData(ShoppingData data) {
            this.data = data;
        }
}
