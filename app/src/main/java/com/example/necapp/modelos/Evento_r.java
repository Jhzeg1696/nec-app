package com.example.necapp.modelos;

public class Evento_r {
    public String titulo;
    public String imagen;

    public Evento_r(String titulo, String imagen)
    {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public String getImagen()
    {
        return this.imagen;
    }
}

