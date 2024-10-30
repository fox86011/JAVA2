// TestMovimientos.java
package com.krakedev.moduloii.evaluacionfinal.test;

import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;

public class TestMovimientos {
    private static final Logger LOGGER = LogManager.getLogger(TestMovimientos.class);

    public static void main(String[] args) {
        // Instanciar el servicio de movimientos
        ServiciosArticulo serviciosMovimiento = new ServiciosArticulo();

        try {
            // 1. Probar inserción de un nuevo movimiento
            System.out.println("=== Test 1: Insertar Movimiento ===");
            RegistroMovimiento nuevoMovimiento = new RegistroMovimiento();
            nuevoMovimiento.setIdArticulo("A0001");
            nuevoMovimiento.setCantidad(5);
            nuevoMovimiento.setFechaMovimiento(new Date());
            
            serviciosMovimiento.insertar(nuevoMovimiento);
            System.out.println("Movimiento insertado exitosamente");

            // 2. Recuperar movimientos por fecha
            System.out.println("\n=== Test 2: Recuperar Movimientos por Fecha ===");
            ArrayList<RegistroMovimiento> movimientosDeFecha = serviciosMovimiento.recuperarMovimientosPorFecha(new Date());
            System.out.println("Movimientos encontrados para la fecha actual: " + movimientosDeFecha.size());
            for (RegistroMovimiento mov : movimientosDeFecha) {
                System.out.println(mov);
            }

        } catch (Exception e) {
            LOGGER.error("Error en las pruebas de movimientos", e);
            System.err.println("Error en las pruebas: " + e.getMessage());
        }
    }
}