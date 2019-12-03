package com.hoodini.obesity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AdapterIdentitasRecyclerView extends RecyclerView.Adapter<AdapterIdentitasRecyclerView.ViewHolder> {
    private ArrayList<ListDataDiri> daftarIdentitas;
    private HistoryFragment context;
    public AdapterIdentitasRecyclerView(ArrayList<ListDataDiri> listDataDiris, HistoryFragment ctx){
        daftarIdentitas = listDataDiris;
        context = ctx;
        class ViewHolder{
        }
    }

    @NonNull
    @Override
    public AdapterIdentitasRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_identitas, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIdentitasRecyclerView.ViewHolder holder, int position) {
        final String ket = daftarIdentitas.get(position).getKet();
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });
        holder.tvTitle.setText(ket);
    }

    @Override
    public int getItemCount() {
        return daftarIdentitas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_identitas);
        }
    }
}
