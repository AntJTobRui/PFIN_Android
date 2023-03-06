package com.example.pfin_android.ui.notifications;

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

import com.example.pfin_android.databinding.FragmentNotificationsBinding;
import com.example.pfin_android.db.DBPersonas;
import com.example.pfin_android.modelo.ListaLogAdapter;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private ArrayList<String> listalog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final RecyclerView rvLog = binding.rvLog;
        rvLog.setLayoutManager(new LinearLayoutManager(getContext()));

        DBPersonas dbPersonas = new DBPersonas(getContext());
        listalog = dbPersonas.mostrarLog();

        ListaLogAdapter adapter = new ListaLogAdapter(listalog, getActivity());
        rvLog.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}