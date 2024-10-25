package com.krakedev.sobrecarga;
import com.krakedev.herencia.*;
public class TestPersona {
    public static void main(String[] args) {
        // Crear una instancia de Cuenta
        Cuenta cuenta = new Cuenta("123456789", 1000.50);

        // Imprimir la referencia de la cuenta
        System.out.println(cuenta);
    }
}