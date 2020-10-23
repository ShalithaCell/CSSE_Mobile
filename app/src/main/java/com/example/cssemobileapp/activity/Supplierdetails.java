package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cssemobileapp.Adapter.RejectedOrderAdapter;
import com.example.cssemobileapp.Adapter.SupplierAdapter;
import com.example.cssemobileapp.Model.RejectedOrderModel;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class Supplierdetails extends Fragment {

    public RecyclerView recyclerView;

    public ArrayList<Supplier> supplierList = new ArrayList<Supplier>();

    public CardView cardView;

    public Supplierdetails() {
        // Required empty public constructor
    }

    public static Supplierdetails newInstance(String param1, String param2) {
        Supplierdetails fragment = new Supplierdetails();
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
        View rootView = inflater.inflate(R.layout.fragment_supplierdetails, container, false);
        recyclerView = rootView.findViewById(R.id.suppliers_recycler_view);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("suppliers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String,Object> suppliersHashMap = document.getData();
                                Supplier suppliers = new Supplier(suppliersHashMap.get("contactNumber").toString(),suppliersHashMap.get("email").toString(),suppliersHashMap.get("location").toString(),suppliersHashMap.get("name").toString(),suppliersHashMap.get("userID").toString());
                                supplierList.add(suppliers);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            SupplierAdapter myAdapter = new SupplierAdapter( getContext(), supplierList);
                            recyclerView.setAdapter(myAdapter);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        return rootView;
    }
}