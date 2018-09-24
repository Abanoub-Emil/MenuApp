package com.champion.bero.menuapp.Model;

/**
 * Created by Champion on 23-Sep-18.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;
    @SerializedName("list")
    @Expose
    private ArrayList<MenuList> menuList = null;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<MenuList> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<MenuList> menuList) {
        this.menuList = menuList;
    }

}
