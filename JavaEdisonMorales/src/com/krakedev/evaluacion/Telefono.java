package com.krakedev.evaluacion;

public class Telefono {
    private String numero;
    private String tipo;
    private String estado;

    public Telefono(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        validarTelefono();
    }

    private void validarTelefono() {
        if (numero == null || tipo == null) {
            estado = "E"; // Error si alguno es null
            return;
        }

        if (!tipo.equals("Movil") && !tipo.equals("Convencional")) {
            estado = "E"; // Error si el tipo no es válido
            return;
        }

        if (tipo.equals("Movil") && numero.length() != 10) {
            estado = "E"; // Error si el móvil no tiene 10 caracteres
            return;
        }

        if (tipo.equals("Convencional") && numero.length() != 7) {
            estado = "E"; // Error si el convencional no tiene 7 caracteres
            return;
        }

        estado = "C"; // Correcto si pasa todas las validaciones
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
}
