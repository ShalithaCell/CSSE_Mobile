package com.example.cssemobileapp.Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cssemobileapp.R;

public class SupplierHolder extends RejectedOrderHolder {

    public TextView supplierId;
    public TextView supplierName;
    public TextView supplierContact;
    public TextView supplierEmail;
    public TextView supplierLocation;


    public SupplierHolder(@NonNull View itemView, Context c) {
        super(itemView, c);
        this.supplierId = itemView.findViewById(R.id.supplier_id);
        this.supplierName = itemView.findViewById(R.id.supplier_name);
        this.supplierContact = itemView.findViewById(R.id.supplier_contact);
        this.supplierEmail = itemView.findViewById(R.id.supplier_email);
        this.supplierLocation = itemView.findViewById(R.id.supplier_location);
    }
}
