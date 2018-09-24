package com.champion.bero.menuapp.UI.Welcome.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.champion.bero.menuapp.Model.Item;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.UI.Welcome.Adapters.CategoriesAdapter;
import com.champion.bero.menuapp.UI.Welcome.Adapters.ItemAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailFragmentInt {

    ImageView backgroundImage;
    TextView itemCategory;
    ArrayList<Item> items;
    private RecyclerView mRecyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        itemCategory = view.findViewById(R.id.item_category);
        backgroundImage = view.findViewById(R.id.background_image);
        mRecyclerView =  view.findViewById(R.id.item_recyclerview);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void updateView(ArrayList<Item> items, String categoryName) {
        this.items = items;
        backgroundImage.setVisibility(View.GONE);
        itemCategory.setText(categoryName);
        adapter = new ItemAdapter(getActivity(), items);
        mRecyclerView.setAdapter(adapter);
    }
}
