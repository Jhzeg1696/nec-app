package com.example.necapp.models;

public class Evento {
    public String titulo;
    public String imagen;

    public Evento(String titulo, String imagen)
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

