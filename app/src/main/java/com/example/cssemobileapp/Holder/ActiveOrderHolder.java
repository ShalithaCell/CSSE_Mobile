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

public class ActiveOrderHolder extends RecyclerView.ViewHolder{


    public TextView activeOrderId;
    public TextView activeOrderStatus;

    public ActiveOrderHolder(@NonNull View itemView, Context c) {
        super(itemView);
        Log.d(TAG, "pending holder called");
        this.activeOrderId = itemView.findViewById(R.id.order_id);
        this.activeOrderStatus = itemView.findViewById(R.id.order_status);
        activeOrderStatus.setTextColor(Color.parseColor("#00C853"));
    }
}