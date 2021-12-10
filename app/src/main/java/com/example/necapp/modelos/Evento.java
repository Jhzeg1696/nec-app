package com.example.necapp.modelos;

public class Evento {
    String id;
    String titulo;
    String tipo;
    String fecha;
    String archivo;
    String descripcion;
    String fecha2;
    String destacada;
    String visible;


    public Evento(String id, String titulo, String tipo, String fecha, String archivo, String descripcion,String fecha2, String destacada, String visible) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.archivo = archivo;
        this.descripcion = descripcion;
        this.fecha2 = fecha2;
        this.destacada = destacada;
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDescripcion() { return this.descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public String getDestacada() {
        return destacada;
    }

    public void setDestacada(String destacada) {
        this.destacada = destacada;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}
