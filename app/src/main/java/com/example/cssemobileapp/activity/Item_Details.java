package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cssemobileapp.Adapter.ItemsAdapter;
import com.example.cssemobileapp.Adapter.SupplierAdapter;
import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.Model.RejectedOrderModel;
import com.example.cssemobileapp.Model.Supplier;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class Item_Details extends Fragment {

    public RecyclerView recyclerView;

    public ArrayList<Item> itemList = new ArrayList<Item>();

    public CardView cardView;


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
        View rootView =  inflater.inflate(R.layout.fragment_item__details, container, false);

        recyclerView = rootView.findViewById(R.id.items_recycler_view);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("items")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String,Object> itemsHashMap = document.getData();
                                Item item = new Item(Boolean.parseBoolean(itemsHashMap.get("availability").toString()),itemsHashMap.get("name").toString(),itemsHashMap.get("qty").toString(),itemsHashMap.get("supplier").toString(),itemsHashMap.get("unitPrice").toString());
                                if (Boolean.parseBoolean(itemsHashMap.get("availability").toString())){
                                    item.setAvailability(true);
                                }else{
                                    item.setAvailability(false);
                                }
                                itemList.add(item);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            ItemsAdapter myAdapter = new ItemsAdapter(getContext(), itemList);
                            recyclerView.setAdapter(myAdapter);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        return rootView;
    }


}