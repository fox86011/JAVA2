package com.krakedev.persistencia.pruebas;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestEliminar {
    public static void main(String[] args) {
        String cedula = "123456789"; // Cédula de la persona a eliminar
        AdminPersonas.eliminar(cedula);
    }
}
