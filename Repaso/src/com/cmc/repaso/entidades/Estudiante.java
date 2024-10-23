package com.cmc.repaso.entidades;

public class Estudiante {
    private String nombre;
    private double nota;
    private String resultado;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public void calificar(double nota) {
        this.nota = nota;
        this.resultado = nota >= 8 ? "A" : "F";
    }
}