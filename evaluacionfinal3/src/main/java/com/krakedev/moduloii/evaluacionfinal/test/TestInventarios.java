// TestInventarios.java
package com.krakedev.moduloii.evaluacionfinal.test;


import com.krakedev.moduloii.evaluacionfinal.entidades.*;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TestInventarios {
    private static final Logger LOGGER = LogManager.getLogger(TestInventarios.class);

    public static void main(String[] args) {
        // Instanciar el servicio
        ServiciosArticulo serviciosArticulo = new ServiciosArticulo();

        try {
            // 1. Probar inserción de un nuevo artículo
            System.out.println("=== Test 1: Insertar Artículo ===");
            Articulo nuevoArticulo = new Articulo(
                "A0011",
                "Sprite 300ml",
                new BigDecimal("0.75"),
                new BigDecimal("0.50"),
                "G001"
            );
            serviciosArticulo.insertar(nuevoArticulo);
            System.out.println("Artículo insertado exitosamente");

            // 2. Probar búsqueda por ID
            System.out.println("\n=== Test 2: Buscar Artículo por ID ===");
            Articulo articuloEncontrado = serviciosArticulo.buscarArticuloPorId("A0011");
            if (articuloEncontrado != null) {
                System.out.println("Artículo encontrado: " + articuloEncontrado);
            } else {
                System.out.println("Artículo no encontrado");
            }

            // 3. Probar actualización
            System.out.println("\n=== Test 3: Actualizar Artículo ===");
            articuloEncontrado.setPrecioVenta(new BigDecimal("0.80"));
            serviciosArticulo.actualizar(articuloEncontrado);
            System.out.println("Artículo actualizado exitosamente");

            // 4. Verificar la actualización
            System.out.println("\n=== Test 4: Verificar Actualización ===");
            Articulo articuloActualizado = serviciosArticulo.buscarArticuloPorId("A0011");
            System.out.println("Artículo después de actualizar: " + articuloActualizado);

            // 5. Recuperar todos los artículos
            System.out.println("\n=== Test 5: Recuperar Todos los Artículos ===");
            ArrayList<Articulo> todosLosArticulos = serviciosArticulo.recuperarTodos();
            System.out.println("Total de artículos encontrados: " + todosLosArticulos.size());
            for (Articulo art : todosLosArticulos) {
                System.out.println(art);
            }

            // 6. Probar manejo de errores
            System.out.println("\n=== Test 6: Probar Manejo de Errores ===");
            try {
                serviciosArticulo.buscarArticuloPorId(null);
            } catch (InventarioException e) {
                System.out.println("Error controlado correctamente: " + e.getMessage());
            }

        } catch (InventarioException e) {
            LOGGER.error("Error en las pruebas", e);
            System.err.println("Error en las pruebas: " + e.getMessage());
        }
    }
}