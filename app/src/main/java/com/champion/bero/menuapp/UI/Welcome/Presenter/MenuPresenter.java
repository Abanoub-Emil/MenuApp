package com.champion.bero.menuapp.UI.Welcome.Presenter;

import com.champion.bero.menuapp.Model.MenuList;
import com.champion.bero.menuapp.Model.SubCategory;
import com.champion.bero.menuapp.UI.Welcome.Fragments.MenuFragmentInt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Champion on 24-Sep-18.
 */
public class MenuPresenter implements MenuPresenterInt {

    MenuFragmentInt menuFragment;

    public MenuPresenter(MenuFragmentInt menuFragment) {
        this.menuFragment = menuFragment;
    }

    @Override
    public HashMap<String, ArrayList<SubCategory>> getCategoriesAndSubCategories(ArrayList<MenuList> menuList) {
        HashMap<String, ArrayList<SubCategory>> categoryAndSubCategoriesMap = new HashMap<>();
        for (MenuList category : menuList) {
            String categoryName = category.getTitle();
            if(category.getSubCategories() != null) {
                ArrayList<SubCategory> subCategories =  category.getSubCategories();
                categoryAndSubCategoriesMap.put(categoryName, subCategories);
            } else {
                categoryAndSubCategoriesMap.put(categoryName, null);
            }
        }
        return categoryAndSubCategoriesMap;
    }
}