package com.example.necapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.databinding.FragmentHomeBinding;
import com.example.necapp.models.Evento;
import com.example.necapp.models.Items;
import com.example.necapp.models.Tramite;
import com.example.necapp.rvadapters.EventosAdapter;
import com.example.necapp.rvadapters.TramiteAdapter;
import com.example.necapp.rvadapters.WarningsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    // TEST
    private RecyclerView recyclerView;
    private EventosAdapter recyclerviewEventoAdapter;
    private List<Evento> eventos;
    // TEST

    //Tramites
    private RecyclerView recyclerViewTramites;
    private TramiteAdapter tramitesAdapter;
    private List<Tramite> tramites;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        //Eventos
        eventos = new ArrayList<>();
        Evento item1 = new Evento("El gobierno de Nuevo Laredo te invita", "https://noticias.nld.gob.mx/archivos/20fb4dbe35c3ac0f8891357ea060f86b.jpeg");
        Evento item2 = new Evento("Conmemora gobierno municipal revolución mexicana con", "https://noticias.nld.gob.mx//archivos/def390e0f8dbdf877a50e1f39f69c433.jpeg");
        eventos.add(item1);
        eventos.add(item2);
        recyclerView = view.findViewById(R.id.rvEventos);
        recyclerviewEventoAdapter = new EventosAdapter(eventos);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewEventoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Tramites
        tramites = new ArrayList<>();
        Tramite tramite1 = new Tramite("", "https://nld.gob.mx/assets/img/imagen2.jpg");
        Tramite tramite2 = new Tramite("", "https://nld.gob.mx/assets/img/imagen4.jpg");
        Tramite tramite3 = new Tramite("", "https://nld.gob.mx/assets/img/imagen3.jpg");

        tramites.add(tramite1);
        tramites.add(tramite2);
        tramites.add(tramite3);
        recyclerViewTramites = view.findViewById(R.id.rvTramites);
        tramitesAdapter = new TramiteAdapter(tramites);
        recyclerViewTramites.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerTramites = new LinearLayoutManager(requireActivity());
       // recyclerViewTramites.setLayoutManager(layoutManagerTramites);
        //recyclerViewTramites.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTramites.setAdapter(tramitesAdapter);
        //LinearLayoutManager linearLayoutManagerTramites = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        GridLayoutManager layoutManagerGrid = new GridLayoutManager(getActivity(), 2);
        layoutManagerGrid.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManagerGrid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                position += 1;
                if (tramitesAdapter != null) {
                    if(position % 3 == 0)
                    {
                        return 2;
                    }
                    else
                    {
                        return 1;
                    }
                    /*
                    switch (tramitesAdapter.getItemViewType(position)) {
                        case 1:
                            return 1;
                        case 0:
                            return 2; //number of columns of the grid
                        default:
                            return -1;
                    }
                     */
                } else {
                    return -1;
                }
            }
        });
        recyclerViewTramites.setLayoutManager(layoutManagerGrid);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}