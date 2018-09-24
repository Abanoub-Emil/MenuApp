package com.champion.bero.menuapp.UI.Welcome.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.champion.bero.menuapp.Model.Item;
import com.champion.bero.menuapp.Model.SubCategory;
import com.champion.bero.menuapp.R;
import com.champion.bero.menuapp.UI.Welcome.Fragments.MenuFragmentInt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Champion on 24-Sep-18.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    ArrayList<Item> items;


    public ItemAdapter(Context context, ArrayList<Item> items ) {
        this.context = context;
        this.items = items;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView item_cv;
        ImageView itemImage;
        TextView itemTitle;
        TextView itemPrice;
        TextView itemDescription;


        ItemViewHolder(View itemView) {
            super(itemView);
            item_cv = itemView.findViewById(R.id.item_cardview);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemDescription = itemView.findViewById(R.id.item_description);
        }

    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        ItemViewHolder tvh = new ItemViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(items.get(position).getImage())
                .into(holder.itemImage);
        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemPrice.setText(String.valueOf(items.get(position).getPrice()));
        holder.itemDescription.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
