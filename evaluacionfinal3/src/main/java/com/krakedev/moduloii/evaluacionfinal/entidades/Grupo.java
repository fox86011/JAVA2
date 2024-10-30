package com.krakedev.moduloii.evaluacionfinal.entidades;

public class Grupo {
    private String id;
    private String nombre;

    // Constructor vacío
    public Grupo() {}

    // Constructor con parámetros
    public Grupo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString
    @Override
    public String toString() {
        return "Grupo{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}

