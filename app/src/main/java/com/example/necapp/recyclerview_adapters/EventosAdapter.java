package com.example.necapp.recyclerview_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.necapp.R;
import com.example.necapp.modelos.Evento;
import com.example.necapp.modelos.Evento_r;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.MyViewHolder>{

    private List<Evento> eventos;

    public EventosAdapter(List<Evento> listaEventos){
        this.eventos = listaEventos;
    }

    @Override
    public EventosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evento_item,parent,false);
        return new EventosAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventosAdapter.MyViewHolder holder, final int position) {
        final Evento evento = eventos.get(position);
        holder.titulo.setText(evento.getTitulo());
        Context context = holder.imagen.getContext();
        Picasso.get()
                .load(evento.getArchivo())
                .centerCrop()
                .fit()
                .into(holder.imagen);

        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, evento.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView contenedor;
        public TextView titulo;
        public ImageView imagen;
        private RelativeLayout itemLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            contenedor = itemView.findViewById(R.id.contenedor);
            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.imagen);
            itemLayout =  itemView.findViewById(R.id.itemLayout);
        }
    }

    public void updateData(List<Evento> dataSet)
    {
        System.out.println("UPDATE");
        for(int i = 0; i < dataSet.size(); i++)
        {
            //this.eventos.add(dataSet.get(i));
            System.out.println("ciclo: " + dataSet.get(i).getTitulo());
            this.eventos.add(dataSet.get(i));
        }
//
        //notifyItemInserted(getItemCount());
        /*
        if(flag == 0)
        {
            for(int i = 0; i < dataSet.size(); i++)
            {
                System.out.println(dataSet.get(i).getName());
                this.itemsList.add(dataSet.get(i));
            }
            Items item = new Items("Señalan en comparecencia aviadores y simulaciones");
            this.itemsList.add(item);
            notifyItemInserted(getItemCount());
        }

        else
        {
            itemsList.clear();
            notifyDataSetChanged();
        }
        */
    }

}
