package com.example.carpoolbuddy.Controler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolbuddy.R;

public class FISbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView nameText;
    protected TextView statusText;
    protected TextView priceText;

    FISbookAdapter.OnNoteListener onNoteListener;

    public FISbookViewHolder(@NonNull View itemView, FISbookAdapter.OnNoteListener onNoteListener) {
        super(itemView);

        nameText = itemView.findViewById(R.id.nameTextView);
        statusText = itemView.findViewById(R.id.statusTextView);
        priceText = itemView.findViewById(R.id.priceTextView);
        this.onNoteListener = onNoteListener;

        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        onNoteListener.onNoteClick(getAdapterPosition());

    }
}
