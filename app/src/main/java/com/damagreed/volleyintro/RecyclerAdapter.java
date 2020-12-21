package com.damagreed.volleyintro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>  {

    ArrayList<ListBarang> arrayList;

    public RecyclerAdapter(ArrayList<ListBarang> arrayList){
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.barang.setText(arrayList.get(position).getBarang());
        holder.harga.setText(arrayList.get(position).getHarga());
        holder.qty.setText(arrayList.get(position).getQty());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView barang, harga, qty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            barang = itemView.findViewById(R.id.barang);
            harga= itemView.findViewById(R.id.harga);
            qty = itemView.findViewById(R.id.qty);

        }
    }
}
