package com.example.cssemobileapp.Holder;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

import static android.content.ContentValues.TAG;

public class PendingOrderHolder extends RecyclerView.ViewHolder {

    public TextView pendingOrderId;
    public TextView pendingOrderStatus;

    public PendingOrderHolder(@NonNull View itemView, Context c) {
        super(itemView);
        Log.d(TAG, "pending holder called");
        this.pendingOrderId = itemView.findViewById(R.id.order_id);
        this.pendingOrderStatus = itemView.findViewById(R.id.order_status);
        pendingOrderStatus.setTextColor(Color.parseColor("#3700B3"));

    }
}
