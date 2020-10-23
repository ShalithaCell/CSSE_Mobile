package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AddItemsForOrder extends Fragment {

    ImageView addnewitembtn;
    LinearLayout list;
    EditText qty;


    List<String> no2;
    List<String> no;
    List<String> no3;

    String id, address, date;

    Button save;

    ImageView delete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_items_for_order, container, false);

        id = getArguments().getString("id");
        address = getArguments().getString("address");
        date = getArguments().getString("date");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addnewitembtn = view.findViewById(R.id.addnewitembtn);
        list = view.findViewById(R.id.list);
        qty = view.findViewById(R.id.spinner_qty);

        no = new ArrayList<String>();
        no2 = new ArrayList<String>();
        no3 = new ArrayList<String>();

        save = view.findViewById(R.id.btn_save);


        addnewitembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View journeyView = getLayoutInflater().inflate(R.layout.additemcardview, null, false);

                MaterialSpinner spinner = (MaterialSpinner) journeyView.findViewById(R.id.spinner);
                spinner.setItems(no);

                MaterialSpinner spinner1 = (MaterialSpinner) journeyView.findViewById(R.id.spinner_supplier);
                TextView spinner_price = (TextView) journeyView.findViewById(R.id.spinner_price);
                TextView spinner_qty = (TextView) journeyView.findViewById(R.id.spinner_aqty);

                ImageView delete = (ImageView) journeyView.findViewById(R.id.delete_pending_order);

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        journeyView.setVisibility(View.GONE);
                    }
                });

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
                                                if ((i.getName()).equals(item)) {
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

                                                            if (d.getId().equals(supplier[0])) {
                                                                spinner1.setItems(i.getName());
                                                                no3.add(i.getName());
                                                            }
                                                        }
                                                    }
                                                });
                                    }
                                });
                    }
                });
                journeyView.findViewById(R.id.aaa);

                MaterialSpinner spinner2 = (MaterialSpinner) journeyView.findViewById(R.id.spinner_supplier);
                spinner2.setItems(no3);

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

                            for (int i = 0; i < no2.size(); i++){
                                db.collection("suppliers")
                                        .get()
                                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                            @Override
                                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                                for(DocumentSnapshot d :list){
                                                    Supplier i = d.toObject(Supplier.class);
                                                    System.out.println(no2.get(0));
                                                    if(i.equals(no2.get(0)))
                                                        no3.add(i.getName());
                                                }
                                            }
                                        });
                            }
                        }
                    }
                });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = list.getChildCount();
                for (int i = 0; i < count; i++) {
                    final View card = list.getChildAt(i);

                    MaterialSpinner spinner = (MaterialSpinner) card.findViewById(R.id.spinner);
                    int selectedIndex = spinner.getSelectedIndex();
                    String selectedItem = no.get(selectedIndex);

                    MaterialSpinner spinner1 = (MaterialSpinner) card.findViewById(R.id.spinner_supplier);
                    int selectedIndex_supplier = spinner.getSelectedIndex();
                    String selectedItem_supplier = no3.get(selectedIndex_supplier);


                    TextView spinner_price = (TextView) card.findViewById(R.id.spinner_price);
                    String selected_price = spinner_price.getText().toString();

                    TextView spinner_qty = (TextView) card.findViewById(R.id.spinner_aqty);
                    String selected_qty = spinner_qty.getText().toString();

                    EditText need_qty = (EditText) card.findViewById(R.id.spinner_qty);
                    String selected_need_qty = need_qty.getText().toString();

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    Map<String, Object> item = new HashMap<>();

                    item.put("id",id);
                    item.put("address",address);
                    item.put("date",date);
                    item.put("item",selectedItem);
                    item.put("supplier",selectedItem_supplier);
                    item.put("price",selected_price);
                    item.put("qty",selected_qty);
                    item.put("need_qty",selected_need_qty);

                    db.collection("pending_orders")
                            .add(item)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();

                                    getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PendingOrdersNew()).addToBackStack(null).commit();
                                }
                            });
                }
            }
        });
    }
}