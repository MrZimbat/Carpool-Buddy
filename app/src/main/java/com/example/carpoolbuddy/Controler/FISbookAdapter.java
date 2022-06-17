package com.example.carpoolbuddy.Controler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolbuddy.Model.Vehicle.Vehicle;
import com.example.carpoolbuddy.R;

import java.util.ArrayList;

public class FISbookAdapter extends RecyclerView.Adapter<FISbookViewHolder> {

    ArrayList<Vehicle> mData;
    OnNoteListener onNoteListener;

    private OnNoteListener mNoteListener;

    public FISbookAdapter(ArrayList<Vehicle> vehiclesList, OnNoteListener onNoteListener) {
        this.mData = vehiclesList;
        this.onNoteListener= onNoteListener;
        this.mNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public FISbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fis_row_view, parent, false);

        FISbookViewHolder holder = new FISbookViewHolder(myView, onNoteListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FISbookViewHolder holder, int position) {
        holder.nameText.setText(""+mData.get(position).getModal());
        holder.statusText.setText(""+mData.get(position).isOpen());
        holder.priceText.setText(""+mData.get(position).getBasePrice());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }



}
