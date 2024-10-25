package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;
import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiasSemana;

public class TestAlarmas {
    public static void main(String[] args) {
        AdminAlarmas admin = new AdminAlarmas();
        
        // Crear varias alarmas usando las constantes de DiasSemana
        Alarma alarma1 = new Alarma(DiasSemana.LUNES, 5, 45);
        Alarma alarma2 = new Alarma(DiasSemana.MIERCOLES, 14, 30);
        Alarma alarma3 = new Alarma(DiasSemana.VIERNES, 7, 15);
        
        // Agregar las alarmas al administrador
        admin.agregarAlarma(alarma1);
        admin.agregarAlarma(alarma2);
        admin.agregarAlarma(alarma3);
        
        // Recuperar e imprimir la lista de alarmas
        ArrayList<Alarma> alarmasActuales = admin.getAlarmas();
        System.out.println("Lista de Alarmas:");
        System.out.println(alarmasActuales);
    }
}