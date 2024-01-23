package com.example.eatxpiryinventory;

public class MainModel {

    String ExpiryDate, FoodName, Location;


    MainModel()
    {
    }

    public MainModel(String expiryDate, String foodName, String location) {
        ExpiryDate = expiryDate;
        FoodName = foodName;
        Location = location;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getLocation() {
        return Location;
    }

    public void setRemarks(String location) {
        Location = location;
    }
}
