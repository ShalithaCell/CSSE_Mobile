package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.cssemobileapp.Adapter.CallBackListener;
import com.example.cssemobileapp.Adapter.QuestionAdapter;
import com.example.cssemobileapp.Model.Options;
import com.example.cssemobileapp.Model.Items;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.utils.QuestionTypes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.nambimobile.widgets.efab.FabOption;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class addItems extends Fragment implements CallBackListener {

    public List<Items> questionList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionAdapter mAdapter;
    private ImageView btnPublish;
    private FabOption btnText;
    private List<Options> options = new ArrayList<Options>();
    public Spinner dropdown;



    public addItems() {
        // Required empty public constructor
    }


    public static addItems newInstance(String param1, String param2) {
        addItems fragment = new addItems();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_items, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_inventory);

        btnText = rootView.findViewById(R.id.btnText);

        btnPublish = rootView.findViewById(R.id.btnPublish);



        mAdapter = new QuestionAdapter(questionList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        LoadCustomerList("Question name", QuestionTypes.MULTI_CHOICE);

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PendingOrderListMain()).addToBackStack(null).addToBackStack(null).commit();
            }
        });


        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Item Name", QuestionTypes.TEXT);
            }
        });



      /*  fDatabaseRoot.child("items").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot){

                final List<String> itemNameList = new ArrayList<String>();

                for (DataSnapshot addressSnapshot : dataSnapshot.getChildren()) {
                    String itemName = addressSnapshot.child("name").getValue(String.class);
                    if (itemName != null) {
                        itemNameList.add(itemName);
                    }
                }

                dropdown = (Spinner) rootView.findViewById(R.id.spinner_item_name);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, itemNameList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dropdown.setAdapter(adapter);
                dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.v("item", (String) parent.getItemAtPosition(position));
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/



        return rootView;
    }



    @Override
    public void onDismiss() {

    }

    public void LoadCustomerList(String questionName, QuestionTypes type){
        // questionList.clear();
        String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));

        mAdapter.notifyDataSetChanged();
    }


}