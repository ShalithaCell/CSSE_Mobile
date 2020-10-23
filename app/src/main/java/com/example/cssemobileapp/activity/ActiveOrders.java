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

import com.example.cssemobileapp.Adapter.ActiveOrderAdapter;
import com.example.cssemobileapp.Adapter.PendingOrderAdapter;
import com.example.cssemobileapp.Model.ActiveOrderModel;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActiveOrders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActiveOrders extends Fragment {

    public RecyclerView recyclerView;

    public ArrayList<ActiveOrderModel> activeList = new ArrayList<ActiveOrderModel>();

    public CardView cardView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActiveOrders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActiveOrders.
     */
    // TODO: Rename and change types and number of parameters
    public static ActiveOrders newInstance(String param1, String param2) {
        ActiveOrders fragment = new ActiveOrders();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_active_orders, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_active_orders);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("orders").whereEqualTo("status", 2)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String,Object> activeOrderHashMap = document.getData();
                                ActiveOrderModel activeOrder = new ActiveOrderModel(activeOrderHashMap.get("referenceID").toString(),activeOrderHashMap.get("address").toString(),activeOrderHashMap.get("amount").toString(),activeOrderHashMap.get("dueDate").toString(),activeOrderHashMap.get("status").toString(),activeOrderHashMap.get("supplier").toString());
                                activeOrder.setStatus("Active");
                                activeOrder.setId(document.getId());
                                activeList.add(activeOrder);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            ActiveOrderAdapter myAdapter = new ActiveOrderAdapter(getContext(), activeList);
                            recyclerView.setAdapter(myAdapter);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        return rootView;
    }
}