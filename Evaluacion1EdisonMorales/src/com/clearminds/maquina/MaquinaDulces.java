package com.clearminds.maquina;
import com.clearminds.componentes.*;

import java.util.ArrayList;

public class MaquinaDulces {
    // Atributos
    private ArrayList<Celda> celdas;
    private double saldo;

    // Constructor por defecto
    public MaquinaDulces() {
        this.celdas = new ArrayList<>();
        this.saldo = 0.0; // Inicializamos el saldo en 0
    }

    // Método para agregar celda
    public void agregarCelda(String codigo) {
        Celda nuevaCelda = new Celda(codigo);
        celdas.add(nuevaCelda);
    }

    // Método para mostrar configuración
    public void mostrarConfiguracion() {
        System.out.println("Códigos de las celdas en la máquina:");
        for (Celda celda : celdas) {
            System.out.println(celda.getCodigo());
        }
    }

    // Getter para el saldo (opcional)
    public double getSaldo() {
        return saldo;
    }

    // Método para agregar saldo (opcional)
    public void agregarSaldo(double monto) {
        this.saldo += monto;
    }
}