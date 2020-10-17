package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cssemobileapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItemsForOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemsForOrder extends Fragment {


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
        return inflater.inflate(R.layout.fragment_add_items_for_order, container, false);
    }

}