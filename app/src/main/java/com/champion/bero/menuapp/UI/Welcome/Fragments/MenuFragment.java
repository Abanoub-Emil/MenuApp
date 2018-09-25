package com.champion.bero.menuapp.UI.Welcome.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.Data;
import com.champion.bero.menuapp.Model.Item;
import com.champion.bero.menuapp.Model.MenuList;
import com.champion.bero.menuapp.Model.SubCategory;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.UI.Welcome.Activities.WelcomeActivity;
import com.champion.bero.menuapp.UI.Welcome.Activities.WelcomeActivityInt;
import com.champion.bero.menuapp.UI.Welcome.Adapters.CategoriesAdapter;
import com.champion.bero.menuapp.UI.Welcome.Presenter.MenuPresenter;
import com.champion.bero.menuapp.UI.Welcome.Presenter.MenuPresenterInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements MenuFragmentInt {

    ImageView resturantImage;
    ImageButton languageButton;
    ImageButton categoriesButton;
    WelcomeActivityInt welcomeActivityInt;
    private RecyclerView mRecyclerView;
    private CategoriesAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Data data;
    MenuPresenterInt menuPresenter ;
    HashMap<String ,ArrayList<SubCategory>> categoryAndSubCategoriesMap = new HashMap<>();

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        menuPresenter = new MenuPresenter(this);

        languageButton = view.findViewById(R.id.language_button);
        categoriesButton = view.findViewById(R.id.categories_button);
        resturantImage = view.findViewById(R.id.resturant_image);
        mRecyclerView =  view.findViewById(R.id.categories_recyclerView);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        data = (Data) getArguments().getSerializable("data");
        if (data != null) {
            Glide.with(this)
                    .load(data.getRestaurant().getImage())
                    .into(resturantImage);
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        welcomeActivityInt = (WelcomeActivity)getActivity();
        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainView();
            }
        });

        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainView();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
       categoryAndSubCategoriesMap = menuPresenter.getCategoriesAndSubCategories(data.getMenuList());
        adapter = new CategoriesAdapter(getActivity(), categoryAndSubCategoriesMap, this);
        mRecyclerView.setAdapter(adapter);
        }

    @Override
    public void getItems(String categoryName) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<MenuList> menuLists = data.getMenuList();
        for (MenuList ml : menuLists){
            if (ml.getTitle().equals(categoryName)){
                if (ml.getSubCategories() == null){
                    items = (ArrayList<Item>) ml.getItems();
                }else{
                    for (SubCategory cat : ml.getSubCategories()){
                        ArrayList<Item> myItems = (ArrayList<Item>)cat.getItems();
                        for (Item item : myItems)
                            items.add(item);
                    }
                }
            }
        }

        welcomeActivityInt.sendItemsToDetailsFragment(items, categoryName);

    }

    private void returnToMainView(){
        welcomeActivityInt.changeVisibility();
    }
}
