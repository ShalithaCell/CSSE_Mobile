package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.ActiveOrderHolder;
import com.example.cssemobileapp.Holder.RejectedOrderHolder;
import com.example.cssemobileapp.Model.ActiveOrderModel;
import com.example.cssemobileapp.Model.RejectedOrderModel;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

public class RejectedOrderAdapter  extends RecyclerView.Adapter<RejectedOrderHolder> {

    Context c;
    ArrayList<RejectedOrderModel> rejectedList;
    CardView cardView;

    public RejectedOrderAdapter(Context c, ArrayList<RejectedOrderModel> models) {
        this.c = c;
        this.rejectedList = models;
    }

    @NonNull
    @Override
    public RejectedOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, null);
        cardView = (CardView) view;
        return new RejectedOrderHolder(view,c);
    }

    @Override
    public void onBindViewHolder(@NonNull RejectedOrderHolder holder, int i) {
        String code = rejectedList.get(i).getReferenceID();
        String status = rejectedList.get(i).getStatus();
        holder.rejectedOrderId.setText("Ref code : " + code);
        holder.rejectedOrderStatus.setText("Order Status : " + status);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (rejectedList == null) return 0;
        else
            return rejectedList.size();
    }

}

