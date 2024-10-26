package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class TestBuscarPorID {
	public static void main(String[] args) {
        Persona persona = ConexionBDD.buscarPorId(123); // Reemplazar 123 con el ID a buscar
        if (persona != null) {
            System.out.println("Persona encontrada: " + persona.getNombre());
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

}
