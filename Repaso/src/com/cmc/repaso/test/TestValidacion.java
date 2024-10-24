package com.cmc.repaso.test;

import com.cmc.repaso.entidades.*;

public class TestValidacion {
    public static void main(String[] args) {
        Validacion validacion = new Validacion();
        // Pruebas
        System.out.println(validacion.validarMonto(100)); // true
        System.out.println(validacion.validarMonto(0)); // false
        System.out.println(validacion.validarMonto(-50)); // false
    }
}