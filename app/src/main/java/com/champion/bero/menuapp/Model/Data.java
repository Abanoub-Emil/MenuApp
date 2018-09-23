package com.champion.bero.menuapp.Model;

/**
 * Created by Champion on 23-Sep-18.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;
    @SerializedName("list")
    @Expose
    private List<MenuList> menuList = null;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuList> menuList) {
        this.menuList = menuList;
    }

}
