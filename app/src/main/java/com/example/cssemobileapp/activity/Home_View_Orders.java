package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cssemobileapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_View_Orders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_View_Orders extends Fragment {

    Button btn1,btn2,btn3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home__view__orders, container, false);

        btn1 = (Button)rootView.findViewById(R.id.acceptordersbtn);
        btn2 = (Button)rootView.findViewById(R.id.pendingordersbtn);
        btn3 = (Button)rootView.findViewById(R.id.rejectordersbtn);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PlaceNewOrder()).addToBackStack(null).commit();

            }

        });


        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PendingOrdersNew()).addToBackStack(null).commit();

            }

        });


        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PlaceNewOrder()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}