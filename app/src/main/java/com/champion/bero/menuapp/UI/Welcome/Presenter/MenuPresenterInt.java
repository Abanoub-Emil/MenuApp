package com.champion.bero.menuapp.UI.Welcome.Presenter;

import com.champion.bero.menuapp.Model.MenuList;
import com.champion.bero.menuapp.Model.SubCategory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Champion on 24-Sep-18.
 */
public interface MenuPresenterInt  {

    public HashMap<String, ArrayList<SubCategory>> getCategoriesAndSubCategories(ArrayList<MenuList>menuList);
}
