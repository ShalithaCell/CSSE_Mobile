package com.example.cssemobileapp.Holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

import static android.content.ContentValues.TAG;

public class RejectedOrderHolder extends RecyclerView.ViewHolder{

    public TextView rejectedOrderId;
    public TextView rejectedOrderStatus;


    public RejectedOrderHolder(@NonNull View itemView, Context c) {
        super(itemView);
        Log.d(TAG, "pending holder called");
        this.rejectedOrderId = itemView.findViewById(R.id.order_id);
        this.rejectedOrderStatus = itemView.findViewById(R.id.order_status);
    }
}

