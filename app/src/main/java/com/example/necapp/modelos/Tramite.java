package com.example.necapp.modelos;

public class Tramite {
    public String titulo;
    public String imagen;

    public Tramite(String titulo, String imagen)
    {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getImagen()
    {
        return imagen;
    }
}
