package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;


public class AddItemsForOrder extends Fragment {

    ImageView addnewitembtn;
    LinearLayout list;

    List<String> no;
    List<String> no2;
    List<String> no3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_items_for_order, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addnewitembtn = view.findViewById(R.id.addnewitembtn);
        list = view.findViewById(R.id.list);

        no = new ArrayList<String>();
        no2 = new ArrayList<String>();

        addnewitembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View journeyView = getLayoutInflater().inflate(R.layout.additemcardview, null, false);

                MaterialSpinner spinner = (MaterialSpinner) journeyView.findViewById(R.id.spinner);
                spinner.setItems(no);

                MaterialSpinner spinner1 = (MaterialSpinner) journeyView.findViewById(R.id.spinner_supplier);
                TextView spinner_price = (TextView) journeyView.findViewById(R.id.spinner_price);
                TextView spinner_qty = (TextView) journeyView.findViewById(R.id.spinner_aqty);

                spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                        final String[] supplier = new String[1];


                        FirebaseFirestore db = FirebaseFirestore.getInstance();

                        db.collection("items")
                                .get()
                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                    @Override
                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                        if (!queryDocumentSnapshots.isEmpty()) {
                                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                            for (DocumentSnapshot d : list) {
                                                Item i = d.toObject(Item.class);
                                                if ((i.getName()).equals(item)){
                                                    supplier[0] = i.getSupplier();
                                                    spinner_price.setText(i.getUnitPrice());
                                                    spinner_qty.setText(i.getQty());
                                                }
                                            }
                                        }

                                        db.collection("suppliers")
                                                .get()
                                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                                        for (DocumentSnapshot d : list) {
                                                            Supplier i = d.toObject(Supplier.class);

                                                            if (d.getId().equals(supplier[0]))
                                                                spinner1.setItems(i.getName());

                                                        }
                                                    }
                                                });
                                    }
                                });
                    }
                });
                journeyView.findViewById(R.id.aaa);
                list.addView(journeyView);
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("items")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Item i = d.toObject(Item.class);
                                no.add(i.getName());
                                no2.add(i.getSupplier());
                            }
                        }
                    }
                });
    }
}