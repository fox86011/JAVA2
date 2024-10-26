package com.krakedev.persistencia.pruebas;

import com.krakedev.persistencia.entidades.*;
import com.krakedev.persistencia.servicios.*;

public class TestActualizar {
    public static void main(String[] args) {
        // Crear una instancia de Persona con la cédula que ya existe en la base de datos
        Persona persona = new Persona("123456789", "Juan", "Pérez", 0, 0, null, null, null);
        AdminPersonas.actualizar(persona);
    }
}