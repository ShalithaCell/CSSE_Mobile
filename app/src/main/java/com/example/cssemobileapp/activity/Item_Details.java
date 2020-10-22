package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Item_Details extends Fragment {


    LinearLayout list;

    List<String> no1;
    List<String> no2;
    List<String> no3;
    List<String> no4;
    List<Boolean> no5;

    public Item_Details() {
        // Required empty public constructor
    }


    public static Item_Details newInstance(String param1, String param2) {
        Item_Details fragment = new Item_Details();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_item__details, container, false);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = view.findViewById(R.id.list);

        no1 = new ArrayList<String>();
        no2 = new ArrayList<String>();
        no3 = new ArrayList<String>();
        no4 = new ArrayList<String>();
        no5 = new ArrayList<Boolean>();



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
                                no1.add(i.getName());
                                no2.add(i.getSupplier());
                                no3.add(i.getUnitPrice());
                                no4.add(i.getQty());
                                no5.add(i.getAvailability());
                            }


                        }
                    }

                });
    }
}