package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cssemobileapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class PlaceNewOrder extends Fragment {

    private Button btn1, btn2;

    TextInputLayout orderId, orderAddress, orderDate;
    String id, address, date;

    public PlaceNewOrder() {
        // Required empty public constructor
    }

    public static PlaceNewOrder newInstance(String param1, String param2) {
        PlaceNewOrder fragment = new PlaceNewOrder();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_place_new_order, container, false);

        btn1 = (Button) rootView.findViewById(R.id.additempagebtn);

        btn2 = (Button) rootView.findViewById(R.id.exitbtn2);

        orderId = rootView.findViewById(R.id.order_id);
        orderAddress = rootView.findViewById(R.id.order_address);
        orderDate = rootView.findViewById(R.id.order_date);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                id = orderId.getEditText().getText().toString();
                address = orderAddress.getEditText().getText().toString();
                date = orderDate.getEditText().getText().toString();

                if (id.equals("")) {
                    orderId.setErrorEnabled(true);
                    orderId.setError("Order ID cannot be empty");
                } else if (address.equals("")) {
                    orderAddress.setErrorEnabled(true);
                    orderAddress.setError("Order Date cannot be empty");
                } else if (date.equals("")) {
                    orderDate.setErrorEnabled(true);
                    orderDate.setError("Order Address cannot be empty");
                }else{
                    AddItemsForOrder addItemsForOrder = new AddItemsForOrder();
                    Bundle args = new Bundle();
                    args.putString("id", id);
                    args.putString("address", address);
                    args.putString("date", date);

                    addItemsForOrder.setArguments(args);

                    getFragmentManager().beginTransaction().add(R.id.fragmentContainer, addItemsForOrder).addToBackStack(null).commit();
                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();

            }

        });


        return rootView;
    }

}