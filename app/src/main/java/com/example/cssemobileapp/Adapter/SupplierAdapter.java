package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.RejectedOrderHolder;
import com.example.cssemobileapp.Holder.SupplierHolder;
import com.example.cssemobileapp.Model.RejectedOrderModel;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierHolder> {

    Context c;
    ArrayList<Supplier> supplierList;
    CardView cardView;

    public SupplierAdapter(Context c, ArrayList<Supplier> models) {
        this.c = c;
        this.supplierList = models;
    }

    @NonNull
    @Override
    public SupplierHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.supplier_card, null);
        cardView = (CardView) view;
        return new SupplierHolder(view,c);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierHolder holder, int i) {
        String id = supplierList.get(i).getUserID();
        String name = supplierList.get(i).getName();
        String contact = supplierList.get(i).getContactNumber();
        String email = supplierList.get(i).getEmail();
        String location = supplierList.get(i).getLocation();

        holder.supplierId.setText(id);
        holder.supplierName.setText(name);
        holder.supplierContact.setText(contact);
        holder.supplierEmail.setText(email);
        holder.supplierLocation.setText(location);

    }

    @Override
    public int getItemCount() {
        if (supplierList == null) return 0;
        else
            return supplierList.size();
    }
}
