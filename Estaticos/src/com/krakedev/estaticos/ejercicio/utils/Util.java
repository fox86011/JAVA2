package com.krakedev.estaticos.ejercicio.utils;

public class Util {
    public static String formatearHora(int numero) {
        String valor = numero + "";
        if (numero < 10) {
            valor = "0" + numero;
        }
        return valor;
    }
    
    public static String formatearDia(int dia) {
        switch (dia) {
            case DiasSemana.LUNES: return "Lunes";
            case DiasSemana.MARTES: return "Martes";
            case DiasSemana.MIERCOLES: return "Miércoles";
            case DiasSemana.JUEVES: return "Jueves";
            case DiasSemana.VIERNES: return "Viernes";
            case DiasSemana.SABADO: return "Sábado";
            case DiasSemana.DOMINGO: return "Domingo";
            default: return "Día inválido";
        }
    }
}
