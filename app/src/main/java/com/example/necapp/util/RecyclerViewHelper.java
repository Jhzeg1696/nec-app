package com.example.necapp.util;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewHelper {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adaptador;
    private Context context;
    private int orientacion;

    public RecyclerViewHelper(RecyclerView recyclerView, RecyclerView.Adapter adaptador, int orientacion,Context context)
    {
        this.recyclerView = recyclerView;
        this.adaptador = adaptador;
        this.orientacion = orientacion;
        this.context = context;
    }

    public void prepararEventos()
    {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptador);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, orientacion, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void prepararTramites()
    {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptador);
        GridLayoutManager layoutManagerGrid = new GridLayoutManager(context, 2);
        layoutManagerGrid.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManagerGrid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                position += 1;
                if (adaptador != null) {
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
        recyclerView.setLayoutManager(layoutManagerGrid);
    }
}
