package com.example.pfin_android.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.pfin_android.MainActivity;
import com.example.pfin_android.databinding.FragmentDashboardBinding;
import com.example.pfin_android.db.DBPersonas;
import com.example.pfin_android.modelo.Persona;
import com.example.pfin_android.ui.home.HomeFragment;
import com.example.pfin_android.ui.home.HomeViewModel;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Persona pers;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        TextView nom = binding.mostrarNom;
        TextView ape1 = binding.mostratApe1;
        TextView ape2 = binding.mostrarApe2;
        TextView edad = binding.mostrarEdad;
        Button atr = binding.button2;
        if(HomeViewModel.getIdSel() > 0) {
            DBPersonas db = new DBPersonas(getContext());
            this.pers = db.mostrarDatos(HomeViewModel.getIdSel());
            nom.setText(this.pers.getNom());
            ape1.setText(this.pers.getApe1());
            ape2.setText(this.pers.getApe2());
            edad.setText(""+com.example.fin_android.controlador.MyTools.calculaEdad(this.pers.getFec_nac()));

            GregorianCalendar date = (GregorianCalendar) Calendar.getInstance();

            db.insertar(com.example.fin_android.controlador.MyTools.gregCalFecHorToString(date) +
                    " > Consultados los datos de " + this.pers.getNom() + " " + this.pers.getApe1());

            System.out.println(com.example.fin_android.controlador.MyTools.gregCalFecHorToString(date) +
                    " > Consultados los datos de " + this.pers.getNom() + " " + this.pers.getApe1());
        }
        atr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment frag = new HomeFragment();
                FragmentTransaction fg = getActivity().getSupportFragmentManager().beginTransaction();
                fg.replace(getId(), frag);
                fg.commit();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}