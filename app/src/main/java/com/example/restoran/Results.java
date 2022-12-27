package com.example.restoran;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("foodName")
    private String superFoodName;

    @SerializedName("price")
    private String superPrice;

    @SerializedName("details")
    private String superDetails;


    public Results(String foodName, String price, String details) {
        this.superFoodName = foodName;
        this.superPrice = price;
        this.superDetails = details;
    }

    public String getFoodName() {
        return superFoodName;
    }
    public String getPrice() {
        return superPrice;
    }
    public String getDetails() {
        return superDetails;
    }
}
