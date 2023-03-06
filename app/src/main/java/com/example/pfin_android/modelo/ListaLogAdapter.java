package com.example.pfin_android.modelo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfin_android.R;

import java.util.ArrayList;

public class ListaLogAdapter extends RecyclerView.Adapter<ListaLogAdapter.LogViewHolder> {

    ArrayList<String> listLog;
    Activity acti;

    public ListaLogAdapter(ArrayList<String> list, FragmentActivity activity){
        this.listLog = list;
        acti = activity;
    }
    @NonNull
    @Override
    public ListaLogAdapter.LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_log, null, false);
        return new LogViewHolder(view, this.acti);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaLogAdapter.LogViewHolder holder, int position) {
        holder.log.setText(listLog.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return this.listLog.size();
    }

    public class LogViewHolder extends RecyclerView.ViewHolder {
        //En esta clase se colocan los elementos que va a haber en cada fila del recyclerView
        TextView log;
        int id;
        public LogViewHolder(@NonNull View itemView, Activity acti) {
            super(itemView);
            log = itemView.findViewById(R.id.logView);
            
        }
    }
}
