package com.champion.bero.menuapp.UI.Welcome.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.champion.bero.menuapp.Model.SubCategory;
import com.champion.bero.menuapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Champion on 24-Sep-18.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private Context context;
    String[] categoriesNames;
    String[] subCategoryNames = {"ASD", "ASsad","asd"};
    HashMap<String, ArrayList<SubCategory>> categoryAndSubCategoriesMap;

    public CategoriesAdapter(Context context, HashMap<String, ArrayList<SubCategory>> categoryAndSubCategoriesMap) {
        this.categoryAndSubCategoriesMap = categoryAndSubCategoriesMap;
        this.context = context;
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CardView category_cv;
        TextView categoryName;
        RecyclerView subCategories_rv;


        CategoryViewHolder(View itemView) {
            super(itemView);
            category_cv = itemView.findViewById(R.id.cardview);
            categoryName = itemView.findViewById(R.id.category_name);
            subCategories_rv = itemView.findViewById(R.id.subCategory_list);
        }

    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cardview, parent, false);
        CategoryViewHolder tvh = new CategoryViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        getCategoriesArray();
        holder.categoryName.setText(categoriesNames[position]);
        if (categoryAndSubCategoriesMap.get(categoriesNames[position]) != null) {
            getSubCategories(categoryAndSubCategoriesMap.get(categoriesNames[position]));
           initChildLayoutManager(holder.subCategories_rv, subCategoryNames);
        }
        holder.category_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.subCategories_rv.getVisibility() == View.GONE && categoryAndSubCategoriesMap.get(categoriesNames[position])!=null) {
                    holder.subCategories_rv.setVisibility(View.VISIBLE);
                } else {
                    holder.subCategories_rv.setVisibility(View.GONE);
                }
            }
        });

    }

    private void initChildLayoutManager(RecyclerView subCategories_rv, String[] subCategoryNames) {
        subCategories_rv.setLayoutManager(new NestedRecyclerLinearLayoutManager(context));
        SubCategoryAdapter childAdapter = new SubCategoryAdapter(subCategoryNames);
        subCategories_rv.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return categoryAndSubCategoriesMap.size();
    }


    private void getCategoriesArray() {
        int i = 0;
        categoriesNames = new String[categoryAndSubCategoriesMap.size()];
        for (String key : categoryAndSubCategoriesMap.keySet()) {
            categoriesNames[i] = key;
            i++;
        }
    }

    private void getSubCategories(ArrayList<SubCategory> subCategories){
        subCategoryNames = new String[subCategories.size()];
        int i = 0;
        for (SubCategory value : subCategories) {
            subCategoryNames[i] = value.getTitle();
            i++;
        }
    }


}
