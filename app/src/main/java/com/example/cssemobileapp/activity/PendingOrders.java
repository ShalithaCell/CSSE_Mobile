package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cssemobileapp.Adapter.PendingOrderAdapter;
import com.example.cssemobileapp.Model.Item;
import com.example.cssemobileapp.Model.PendingOrderModel;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PendingOrders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PendingOrders extends Fragment {

   public RecyclerView recyclerView;

    public ArrayList<PendingOrderModel> pendingList = new ArrayList<PendingOrderModel>();

    public CardView cardView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PendingOrders() {
        // Required empty public constructor
    }
    public void onStart(){
        super.onStart();
        //update your fragment
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PendingOrders.
     */
    // TODO: Rename and change types and number of parameters
    public static PendingOrders newInstance(String param1, String param2) {
        PendingOrders fragment = new PendingOrders();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      super.onCreateView(inflater,container,savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pending_orders, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_pending_orders);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("orders").whereEqualTo("status", 1)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String, Object> pendingOrderHashMap = document.getData();
                                PendingOrderModel pendingOrder = new PendingOrderModel(pendingOrderHashMap.get("referenceID").toString(), pendingOrderHashMap.get("address").toString(), pendingOrderHashMap.get("amount").toString(), pendingOrderHashMap.get("dueDate").toString(), pendingOrderHashMap.get("status").toString(), pendingOrderHashMap.get("supplier").toString());
                                pendingOrder.setStatus("Pending");
                                pendingOrder.setId(document.getId());
                                pendingList.add(pendingOrder);
                                }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            PendingOrderAdapter myAdapter = new PendingOrderAdapter(pendingList, getContext());
                            recyclerView.setAdapter(myAdapter);
                            myAdapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }

                    }

                });


        return rootView;

    }

}