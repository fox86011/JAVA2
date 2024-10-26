package com.krakedev.moduloii.evaluacionfinal.excepciones;

public class InventarioException extends Exception {
    public InventarioException(String mensaje) {
        super(mensaje);
    }

    public InventarioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}