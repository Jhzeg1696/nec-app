package com.example.necapp.iu.noticias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.databinding.FragmentRegistroBinding;
import com.example.necapp.modelos.Items;
import com.example.necapp.recyclerview_adapters.NoticiasAdapter;

import java.util.ArrayList;
import java.util.List;

public class RegistroFragment extends Fragment {

    private RegistroViewModel registroViewModel;
    private FragmentRegistroBinding binding;
    // TEST
    private RecyclerView recyclerView;
    private NoticiasAdapter recyclerviewItemAdapter;
    private List<Items> itemsList;
    // TEST

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        itemsList = new ArrayList<>();
        Items item1 = new Items("Señalan en comparecencia aviadores y simulaciones", "https://noticias.nld.gob.mx//archivos/14bdc272c5f69b4e5e0c444717c088f5.jpeg", "#009B72", "GOBIERNO");
        Items item2 = new Items("Concientiza municipio sobre la eliminación de la ", "https://noticias.nld.gob.mx//archivos/1a82bd129d29aaf06260da9a50897b54.jpeg", "#3C4F76", "POLITICA");
        Items item3 = new Items("Realiza municipio mega jornada de vacunacion con", "https://noticias.nld.gob.mx//archivos/d61d9a1a443c6459f9b3e927fb6effcb.jpeg", "#9A031E", "ANUNCIOS");
        Items item4 = new Items("Ofrecen 90% de descuento en regularización de   ", "https://noticias.nld.gob.mx//archivos/70eaeb7de4ac206b6be2e6a6993ad76d.JPG", "#7B8CDE", "COMUNIDAD");
        Items item5 = new Items("Los dos laredos serán sede del foro binacional", "https://noticias.nld.gob.mx//archivos/c6b33a8612d3b4e2607bb1ee2edbcedd.jpeg", "#BB955E", "INTERNACIONAL");
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        recyclerView = (RecyclerView)view.findViewById(R.id.rvTest);
        recyclerviewItemAdapter = new NoticiasAdapter(itemsList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}