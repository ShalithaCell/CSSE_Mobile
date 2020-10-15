package com.example.cssemobileapp.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

public class PendingOrderHolder extends RecyclerView.ViewHolder {


    public TextView pendingOrderName;
    public TextView pendingOrderId;

    public PendingOrderHolder(@NonNull View itemView) {
        super(itemView);

        this.pendingOrderName = itemView.findViewById(R.id.pending_order_name);
        this.pendingOrderId = itemView.findViewById(R.id.pending_order_id);
    }
}
