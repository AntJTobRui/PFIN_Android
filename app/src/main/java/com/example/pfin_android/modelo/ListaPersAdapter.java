package com.example.pfin_android.modelo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfin_android.R;
import com.example.pfin_android.ui.dashboard.DashboardFragment;
import com.example.pfin_android.ui.home.HomeViewModel;

import java.util.ArrayList;

public class ListaPersAdapter extends RecyclerView.Adapter<ListaPersAdapter.PersonaViewHolder> {

    ArrayList<Persona> listPers;
    Activity acti;

    public ListaPersAdapter(ArrayList<Persona> list, FragmentActivity activity){
        this.listPers = list;
        acti = activity;
    }
    @NonNull
    @Override
    public ListaPersAdapter.PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_personas, null, false);
        return new PersonaViewHolder(view, this.acti);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPersAdapter.PersonaViewHolder holder, int position) {
        holder.nombre.setText(listPers.get(position).getNom());
        holder.id = listPers.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return this.listPers.size();
    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder {
        //En esta clase se colocan los elementos que va a haber en cada fila del recyclerView
        TextView nombre;
        Activity act;
        int id;
        public PersonaViewHolder(@NonNull View itemView, Activity acti) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nomView);
            act = acti;
            nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //System.out.println(nombre.getText() + ": " + id);
                    HomeViewModel.setIdSel(id);
                    //view.getContext();
                }
            });
        }
    }
}
