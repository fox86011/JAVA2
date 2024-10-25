package com.krakedev.sobrecarga;
import com.krakedev.herencia.*;
public class TestSobrecarga {
    public static void main(String[] args) {
        // Crear una instancia de Gato
        Gato miGato = new Gato();
        
        // Invocar el método maullar sin parámetros
        miGato.maullar();
        
        // Invocar el método maullar con un adjetivo
        miGato.maullar("fuerte");
    }
}
