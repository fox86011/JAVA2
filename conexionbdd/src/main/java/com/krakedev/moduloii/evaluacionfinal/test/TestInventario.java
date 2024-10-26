package com.krakedev.moduloii.evaluacionfinal.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.krakedev.moduloii.evaluacionfinal.entidades.Item;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosInventario;

public class TestInventario {
    public static void main(String[] args) {
        try {
            ServiciosInventario inventario = new ServiciosInventario();
            
            System.out.println("Agregando items...");
            inventario.agregarItem(new Item("Lapicero", 50, new BigDecimal("1.50")));
            inventario.agregarItem(new Item("Cuaderno", 30, new BigDecimal("2.50")));

            System.out.println("\nMostrando inventario inicial:");
            ArrayList<Item> items = inventario.mostrarInventario();
            for (Item item : items) {
                System.out.println(item);
            }
          
            System.out.println("\nActualizando cantidad de Lapicero...");
            inventario.actualizarItem("Lapicero", 40);
            
           
            System.out.println("\nMostrando inventario actualizado:");
            items = inventario.mostrarInventario();
            for (Item item : items) {
                System.out.println(item);
            }

            BigDecimal valorTotal = inventario.calcularValorTotal();
            System.out.println("\nValor total del inventario: $" + valorTotal);

            System.out.println("\nEliminando Cuaderno...");
            inventario.eliminarItem("Cuaderno");

            System.out.println("\nMostrando inventario final:");
            items = inventario.mostrarInventario();
            for (Item item : items) {
                System.out.println(item);
            }
            
        } catch (InventarioException e) {
            System.err.println("Error en el inventario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
