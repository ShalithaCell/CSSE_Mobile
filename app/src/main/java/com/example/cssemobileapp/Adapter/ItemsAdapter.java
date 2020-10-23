package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.ItemHolder;
import com.example.cssemobileapp.Holder.SupplierHolder;
import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemHolder>{

    Context c;
    ArrayList<Item> itemList;
    CardView cardView;

    public ItemsAdapter(Context c, ArrayList<Item> models) {
        this.c = c;
        this.itemList = models;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, null);
        cardView = (CardView) view;
        return new ItemHolder(view,c);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int i) {
        String name = itemList.get(i).getName();
        String supplier = itemList.get(i).getSupplier();
        String qty = itemList.get(i).getQty();
        String unitPrice = itemList.get(i).getUnitPrice();
        String availability = itemList.get(i).getAvailability() ? "available" : "not available";

        holder.itemName.setText(name);
        holder.itemSupplier.setText(supplier);
        holder.itemQty.setText(qty);
        holder.itemUnitprice.setText(unitPrice);
        holder.itemAvailability.setText(availability);
    }

    @Override
    public int getItemCount() {
        if (itemList == null) return 0;
        else
            return itemList.size();
    }
}
