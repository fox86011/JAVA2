package com.krakedev.persistencia.pruebas;

import com.krakedev.persistencia.entidades.*;
import com.krakedev.persistencia.servicios.*;

public class TestActualizar {
    public static void main(String[] args) {
       
        Persona persona = new Persona(null, null, null, 0, 0, null, null, null);
        AdminPersonas.actualizar(persona);
    }
}