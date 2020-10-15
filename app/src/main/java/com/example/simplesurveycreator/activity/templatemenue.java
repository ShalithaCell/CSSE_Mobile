package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link templatemenue#newInstance} factory method to
 * create an instance of this fragment.
 */
public class templatemenue extends Fragment {


    public templatemenue() {
        // Required empty public constructor
    }


    public static templatemenue newInstance(String param1, String param2) {
        templatemenue fragment = new templatemenue();

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

        View rootView = inflater.inflate(R.layout.fragment_templatemenue, container, false);


        return rootView;
    }
}

