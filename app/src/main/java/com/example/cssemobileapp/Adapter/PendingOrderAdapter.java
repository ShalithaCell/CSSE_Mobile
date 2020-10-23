package com.example.cssemobileapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.PendingOrderHolder;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.activity.PendingOrders;
import com.example.cssemobileapp.activity.ViewPendingOrder;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.gson.Gson;

import java.security.AccessController;
import java.util.ArrayList;

public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderHolder> {


    ArrayList<PendingOrderModel> pendingList;
    Context c;
    CardView cardView;

    public PendingOrderAdapter( ArrayList<PendingOrderModel> pendingList, Context c) {
        this.c = c;
        this.pendingList = pendingList;
    }


    @NonNull
    @Override
    public PendingOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        cardView = (CardView) view;
        return new PendingOrderHolder(view, c);
    }

    @Override
    public void onBindViewHolder(@NonNull final PendingOrderHolder holder, final int i) {
        String code = pendingList.get(i).getReferenceID();
        String status = pendingList.get(i).getStatus();
        holder.pendingOrderId.setText("Ref code : " + code);
        holder.pendingOrderStatus.setText("Order Status : " + status);

       cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                        Fragment myFragment = new ViewPendingOrder();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new ViewPendingOrder()).addToBackStack(null).commit();
                        break;
                }

            }

        });

    }



    @Override
    public int getItemCount() {
        if (pendingList == null) return 0;
        else
            return pendingList.size();
    }

}

