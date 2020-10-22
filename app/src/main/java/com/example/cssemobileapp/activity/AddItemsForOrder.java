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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItemsForOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemsForOrder extends Fragment {

    ImageView addnewitembtn;
    LinearLayout list;

    List<String> no2;
    List<String> no;
    List<String> no3;


    public AddItemsForOrder() {
        // Required empty public constructor
    }

    public static AddItemsForOrder newInstance(String param1, String param2) {
        AddItemsForOrder fragment = new AddItemsForOrder();

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
        no3 = new ArrayList<String>();


        addnewitembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View journeyView = getLayoutInflater().inflate(R.layout.additemcardview, null, false);

                MaterialSpinner spinner = (MaterialSpinner) journeyView.findViewById(R.id.spinner);
                spinner.setItems(no);

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
    }
}