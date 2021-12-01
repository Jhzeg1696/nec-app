package com.example.necapp.iu.principal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        recyclerView = view.findViewById(R.id.rvEventos);
        new ServicioHttp().execute("https://noticias.nld.gob.mx/assets/php/getNoticias.php?limit=20");
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

    public class ServicioHttp extends AsyncTask<String, Integer, List<Evento>> {

        @Override
        protected List<Evento> doInBackground(String... params)
        {
            List<Evento> eventosListado = new ArrayList<>();
            URL url;
            try
            {
                // Creando la conexión
                url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                // Especificando el metodo
                con.setRequestMethod("GET");

                // Obteniendo el codigo http de la petición
                int status = con.getResponseCode();

                // Obteniendo la respuesta
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // Cerrando el stream y la conexión
                in.close();
                con.disconnect();

                // Obteniendo los datos en json
                Gson gson = new Gson();
                Evento[] tests = gson.fromJson(content.toString(), Evento[].class);

                // Agregando cada elemento a una nueva lista
                for(Evento item : tests)
                {
                    eventosListado.add(item);
                }
            }
            catch(Exception exception)
            {
                Log.d("Error: ", exception.getMessage());
            }

            // Devolviendo el listado de eventos
            return eventosListado;
        }

        @Override
        protected void onPostExecute(final List<Evento> list) {
            recyclerviewEventoAdapter = new EventosAdapter(list);
            recyclerViewHelper = new RecyclerViewHelper(recyclerView, recyclerviewEventoAdapter, LinearLayoutManager.HORIZONTAL, getActivity());
            recyclerViewHelper.prepararEventos();
        }
    }

}