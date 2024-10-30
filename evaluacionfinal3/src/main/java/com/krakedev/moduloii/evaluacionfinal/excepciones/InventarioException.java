package com.krakedev.moduloii.evaluacionfinal.excepciones;

public class InventarioException extends Exception {
    public InventarioException(String message) {
        super(message);
    }

    public InventarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
