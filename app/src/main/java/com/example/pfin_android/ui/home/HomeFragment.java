package com.example.pfin_android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfin_android.databinding.FragmentHomeBinding;
import com.example.pfin_android.db.DBPersonas;
import com.example.pfin_android.modelo.ListaPersAdapter;
import com.example.pfin_android.modelo.Persona;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<Persona> listPer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final RecyclerView rvLista = binding.rvListaPersonas;
        rvLista.setLayoutManager(new LinearLayoutManager(getContext()));

        DBPersonas dbPersonas = new DBPersonas(getContext());
        listPer = dbPersonas.mostrarPersonas();

        ListaPersAdapter adapter = new ListaPersAdapter(listPer);
        rvLista.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}