package com.example.necapp.iu.principal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.databinding.FragmentHomeBinding;
import com.example.necapp.modelos.Evento;
import com.example.necapp.modelos.Evento_r;
import com.example.necapp.modelos.Tramite;
import com.example.necapp.recyclerview_adapters.EventosAdapter;
import com.example.necapp.recyclerview_adapters.TramiteAdapter;
import com.example.necapp.servicios.ServicioHttp;
import com.example.necapp.util.RecyclerViewHelper;

import java.util.ArrayList;
import java.util.List;

public class PrincipalFragment extends Fragment {

    private PrincipalViewModel principalViewModel;
    private FragmentHomeBinding binding;

    // TEST
    private RecyclerView recyclerView;
    private EventosAdapter recyclerviewEventoAdapter;
    private List<Evento> eventos;
    // TEST
    RecyclerViewHelper recyclerViewHelper;
    RecyclerViewHelper recyclerViewHelperTramites;
    //Tramites
    private RecyclerView recyclerViewTramites;
    private TramiteAdapter tramitesAdapter;
    private List<Tramite> tramites;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        principalViewModel = new ViewModelProvider(this).get(PrincipalViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textHome;
        principalViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        Evento item1 = new Evento("218", "Abre municipio registro de vacunación", "sdasd", "noticias", "https://noticias.nld.gob.mx//archivos/30bf67775f9d75e5d961ecbdcebdeb13.jpeg", "https://noticias.nld.gob.mx//archivos/e460b1ff6cf97e2c785307ec1b133f53.jpeg", "29 de noviembre","0");
        Evento item2 = new Evento("218", "Aprueba cabildo presupuesto de egresos historico", "sdasd", "noticias", "https://noticias.nld.gob.mx//archivos/969dc47202103be382453194ef244a8c.jpeg", "https://noticias.nld.gob.mx//archivos/e460b1ff6cf97e2c785307ec1b133f53.jpeg", "29 de noviembre","0");

        eventos.add(item1);
        eventos.add(item2);
        recyclerView = view.findViewById(R.id.rvEventos);
        recyclerviewEventoAdapter = new EventosAdapter(eventos);
        recyclerViewHelper = new RecyclerViewHelper(recyclerView, recyclerviewEventoAdapter, LinearLayoutManager.HORIZONTAL, getActivity());
        recyclerViewHelper.prepararEventos();
        new ServicioHttp().execute("google");
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
        recyclerViewHelperTramites = new RecyclerViewHelper(recyclerViewTramites, tramitesAdapter, LinearLayoutManager.HORIZONTAL, getActivity());
        recyclerViewHelperTramites.prepararTramites();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}