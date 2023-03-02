package com.example.pfin_android.modelo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfin_android.R;
import com.example.pfin_android.ui.home.HomeFragment;
import com.example.pfin_android.ui.home.HomeViewModel;

import java.util.ArrayList;

public class ListaPersAdapter extends RecyclerView.Adapter<ListaPersAdapter.PersonaViewHolder> {

    ArrayList<Persona> listPers;

    public ListaPersAdapter(ArrayList<Persona> list){
        this.listPers = list;
    }
    @NonNull
    @Override
    public ListaPersAdapter.PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_personas, null, false);
        return new PersonaViewHolder(view);
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
        int id;
        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nomView);

            nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //System.out.println(nombre.getText() + ": " + id);
                    HomeViewModel.setIdSel(id);
                }
            });
        }
    }
}
