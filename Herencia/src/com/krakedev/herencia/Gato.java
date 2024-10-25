package com.krakedev.herencia;

public class Gato extends Animal {
    @Override
    public void dormir() {
        System.out.println("El gato se acurruca y se duerme.");
    }

    // Método maullar sin parámetros
    public void maullar() {
        System.out.println("El gato maulla.");
    }

    // Sobrecarga del método maullar con un parámetro
    public void maullar(String adjetivo) {
        System.out.println("El gato maullando " + adjetivo + ".");
    }
}