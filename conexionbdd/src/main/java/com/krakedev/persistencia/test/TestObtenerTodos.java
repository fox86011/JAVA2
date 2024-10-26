package com.krakedev.persistencia.test;

import java.util.List;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class TestObtenerTodos {
	public static void main(String[] args) {
        List<Persona> personas = ConexionBDD.obtenerTodos();
        for (Persona persona : personas) {
            System.out.println("Persona: " + persona.getNombre());
        }
    }

}
