package com.champion.bero.menuapp.UI.Welcome.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.champion.bero.menuapp.R;

import java.util.ArrayList;

/**
 * Created by Champion on 24-Sep-18.
 */
public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder> {

    private String[] subCategoriesNames;


    public SubCategoryAdapter(String[] subCategoriesNames) {
        this.subCategoriesNames = subCategoriesNames;
    }

    public static class SubCategoryViewHolder extends RecyclerView.ViewHolder {

        TextView subCategoryName;

        SubCategoryViewHolder(View itemView) {
            super(itemView);

            subCategoryName = itemView.findViewById(R.id.subcategory_name);
        }

    }


    @NonNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcategory_title, parent, false);
        SubCategoryViewHolder tvh = new SubCategoryViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryViewHolder holder, int position) {
        holder.subCategoryName.setText(subCategoriesNames[position]);
    }

    @Override
    public int getItemCount() {
        return subCategoriesNames.length;
    }


}
