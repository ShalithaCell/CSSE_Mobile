package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cssemobileapp.R;


public class Main__Bord extends Fragment {

    private ImageView btn1,btn3,btn5,btn7;
    private TextView btn2,btn4,btn6,btn8;


    public Main__Bord() {
        // Required empty public constructor
    }


    public static Main__Bord newInstance(String param1, String param2) {
        Main__Bord fragment = new Main__Bord();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main___bord, container, false);

        btn1 = rootView.findViewById(R.id.supplierbtn1);
        btn2 = rootView.findViewById(R.id.supplierbtn2);

        btn3 = rootView.findViewById(R.id.itembtn1);
        btn4 = rootView.findViewById(R.id.itembtn2);

        btn5 = rootView.findViewById(R.id.oderbtn1);
        btn6 = rootView.findViewById(R.id.oderbtn2);

        btn7 = rootView.findViewById(R.id.oderstatus1);
        btn8 = rootView.findViewById(R.id.oderstatu2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Supplierdetails()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Supplierdetails()).addToBackStack(null).commit();
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Item_Details()).addToBackStack(null).commit();
            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Item_Details()).addToBackStack(null).commit();
            }

        });

        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();
            }

        });
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();
            }

        });

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home_View_Orders()).addToBackStack(null).commit();
            }

        });
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home_View_Orders()).addToBackStack(null).commit();
            }

        });
        return rootView;
    }
}

