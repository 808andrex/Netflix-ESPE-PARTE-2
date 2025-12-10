package org.example.crud.model;

public class Pelicula {
    private Object id;
    private String titulo;
    private String director;
    private int anio;

    public Pelicula(){
    }

    public Pelicula( String titulo, String director, int anio) {
        this.anio = anio;
        this.director = director;
        this.titulo = titulo;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pelicula{id="+id+", titulo='"+titulo+"', director='"+director+"', anio='"+anio+"'}";
    }
}
