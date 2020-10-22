package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class PendingOrdersNew extends Fragment {

    LinearLayout list_new;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pending_orders_new, container, false);

        list_new = view.findViewById(R.id.orders_list);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("pending_orders")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                com.example.cssemobileapp.Model.PendingOrders i = d.toObject(com.example.cssemobileapp.Model.PendingOrders.class);

                                View card = getLayoutInflater().inflate(R.layout.pending_orders_list, null, false);

                                TextView id = (TextView) card.findViewById(R.id.order_id);
                                TextView address = (TextView) card.findViewById(R.id.order_address);
                                TextView date = (TextView) card.findViewById(R.id.order_date);
                                TextView item = (TextView) card.findViewById(R.id.item);
                                TextView supplier = (TextView) card.findViewById(R.id.supplier);
                                TextView price = (TextView) card.findViewById(R.id.price);
                                TextView qty = (TextView) card.findViewById(R.id.qty);

                                id.setText(i.getId());
                                address.setText(i.getAddress());
                                date.setText(i.getDate());
                                item.setText(i.getItem());
                                supplier.setText(i.getSupplier());
                                price.setText(i.getPrice());
                                qty.setText(i.getQty());

                                list_new.addView(card);
                            }
                        }
                    }
                });

        return view;
    }
}