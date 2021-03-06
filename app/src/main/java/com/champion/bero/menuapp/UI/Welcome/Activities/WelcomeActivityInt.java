package com.champion.bero.menuapp.UI.Welcome.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.champion.bero.menuapp.Model.Item;

import java.util.ArrayList;

/**
 * Created by Champion on 23-Sep-18.
 */
public interface WelcomeActivityInt {

    public void setRestaurantImage(String url);
    public void setBundle(Bundle bundle);
    public void changeVisibility();
    public void sendItemsToDetailsFragment(ArrayList<Item> items, String categoryName);
}
