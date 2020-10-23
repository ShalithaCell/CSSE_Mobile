package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.ActiveOrderHolder;
import com.example.cssemobileapp.Holder.PendingOrderHolder;
import com.example.cssemobileapp.Model.ActiveOrderModel;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.activity.ActiveOrders;

import java.util.ArrayList;

public class ActiveOrderAdapter extends RecyclerView.Adapter<ActiveOrderHolder> {

    Context c;
    ArrayList<ActiveOrderModel> activeList;
    CardView cardView;

    public
    ActiveOrderAdapter(Context c, ArrayList<ActiveOrderModel> activeList) {
        this.c = c;
        this.activeList = activeList;
    }


    @NonNull
    @Override
    public ActiveOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        cardView = (CardView) view;
        return new ActiveOrderHolder(view, c);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveOrderHolder holder, int i) {
        String code = activeList.get(i).getReferenceID();
        String status = activeList.get(i).getStatus();
        holder.activeOrderId.setText("Ref code : " + code);
        holder.activeOrderStatus.setText("Order Status : " + status);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (activeList == null) return 0;
        else
            return activeList.size();
    }

}

