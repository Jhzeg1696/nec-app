package com.example.necapp.recyclerview_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.modelos.Tramite;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TramiteAdapter extends RecyclerView.Adapter<TramiteAdapter.MyViewHolder>{

    private List<Tramite> tramites;

    public TramiteAdapter(List<Tramite> listaTramites){
        this.tramites = listaTramites;
    }

    @Override
    public TramiteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tramite_item,parent,false);
        return new TramiteAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TramiteAdapter.MyViewHolder holder, final int position) {
        final Tramite tramite = tramites.get(position);
        holder.titulo.setText(tramite.getTitulo());
        Context context = holder.imagen.getContext();
        Picasso.get()
                .load(tramite.getImagen())
                .centerCrop()
                .fit()
                .into(holder.imagen);

        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, tramite.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tramites.size();
    }

    /*
    @Override
    public int getItemViewType(int position) {
        return (position == getItemCount() - 1) ? 0 : 1; // If the item is last, `itemViewType` will be 0
    }
    */

    @Override
    public int getItemViewType(int position) {
        return (position == getItemCount() - 1) ? 0 : 1; // If the item is last, `itemViewType` will be 0
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView contenedor;
        public TextView titulo;
        public ImageView imagen;
       // private RelativeLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            contenedor = itemView.findViewById(R.id.contenedor);
            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);
           // itemLayout =  itemView.findViewById(R.id.itemLayout);
        }
    }
}
