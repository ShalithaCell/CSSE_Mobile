package com.example.cssemobileapp.Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

public class ItemHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemSupplier;
    public TextView itemQty;
    public TextView itemUnitprice;
    public TextView itemAvailability;

    public ItemHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.itemName = itemView.findViewById(R.id.item_name);
        this.itemSupplier = itemView.findViewById(R.id.item_supplier);
        this.itemQty = itemView.findViewById(R.id.item_qty);
        this.itemUnitprice = itemView.findViewById(R.id.item_unit_price);
        this.itemAvailability = itemView.findViewById(R.id.item_avl);
    }
}
