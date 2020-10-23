package com.example.cssemobileapp.Adapter;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Model.Options;
import com.example.cssemobileapp.Model.Items;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.utils.QuestionTypes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Items> itemList;
    private Context context;
    private Application application;

    private List<Options> options = new ArrayList<Options>();
    String[] ITEMS = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
    ArrayAdapter<String> adapterDDL;

    public QuestionAdapter (List<Items> list, Context _context) {
        itemList = list;
        context = _context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      if(viewType == QuestionTypes.TEXT.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additemcardview, parent, false);
            return new TextViewHolder(view);
        }
        else {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additemcardview, parent, false);
          return new TextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == QuestionTypes.TEXT.ordinal()){
            InitLayoutText((TextViewHolder)holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
            return QuestionTypes.TEXT.ordinal();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public Spinner itemName;
        public TextView itemQty;
        public TextView unitPrice;
        Button btnEdit, btnDelete;


        public TextViewHolder(View itemView) {
            super(itemView);
           /* super(itemView);
            this.itemName = itemView.findViewById(R.id.spinner_item_name);
            this.itemQty = itemView.findViewById(R.id.item_unit_price);
            this.unitPrice = itemView.findViewById(R.id.item_qty);

            this.btnEdit = itemView.findViewById(R.id.btnEdit);
            this.btnDelete = itemView.findViewById(R.id.delete_item_card);

            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);*/
        }


      /*  @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()) {

                if (viewTxtQuestion.getVisibility() == View.VISIBLE) {
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    layoutOptions.setVisibility(View.VISIBLE);
                    layoutOptionsView.setVisibility(View.INVISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                layoutOptions.setVisibility(View.GONE);
                layoutOptionsView.setVisibility(View.VISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            } else if (view.getId() == btnDelete.getId()) {
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete " + viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size()) {
                                    if (questionList.get(idx).getItemName() == viewTxtQuestion.getTag()) {
                                        // Remove item
                                        questionList.remove(idx);
                                    } else {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }*/


        @Override
        public boolean onLongClick(View view) {
            return false;
        }


        @Override
        public void onClick(View v) {

        }
    }

        private void InitLayoutText(TextViewHolder holder, int pos) {
            Items Item = itemList.get(pos);

            FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
            CollectionReference itemsRef = rootRef.collection("items ");
            List<String> items = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_spinner_item, items);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.itemName.setAdapter(adapter);
            itemsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String itemName = document.getString("name");

                            items.add(itemName);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            });
            holder.itemQty.setText(Item.getQty());
            holder.unitPrice.setText(Item.getUnitPrice());

        }


        // Static inner class to initialize the views of rows


    }


