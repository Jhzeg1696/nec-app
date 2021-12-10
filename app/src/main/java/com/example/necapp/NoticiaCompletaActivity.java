package com.example.necapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class NoticiaCompletaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_completa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            
        }

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("com.example.myfirstapp.TITULO");
        String fecha = intent.getStringExtra("com.example.myfirstapp.FECHA");
        String tipo = intent.getStringExtra("com.example.myfirstapp.TIPO");
        String archivo = intent.getStringExtra("com.example.myfirstapp.ARCHIVO");
        String descripcion = intent.getStringExtra("com.example.myfirstapp.DESCRIPCION");

        TextView tvTitulo = findViewById(R.id.titulo);
        TextView tvFecha = findViewById(R.id.fecha);
        TextView tvTipo = findViewById(R.id.seccion);
        ImageView ivArchivo = findViewById(R.id.imagen);
        TextView tvDescripcion = findViewById(R.id.descripcion);

        tvTitulo.setText(titulo);
        tvFecha.setText(fecha);
        tvTipo.setText(tipo);
        Picasso.get()
                .load(archivo)
                .centerCrop()
                .fit()
                .into(ivArchivo);
        tvDescripcion.setText(descripcion);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


}
