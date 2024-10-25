package com.cmc.evaluacion;

public class CalculadoraAmortizacion {
    public void generarTabla(Prestamo prestamo) {
        // Calcular la cuota (utilizar una fórmula adecuada)
        double cuota = calcularCuota(prestamo.getMonto(), prestamo.getTasaInteres(), prestamo.getPlazo());

        prestamo.cuotas = new Cuota[prestamo.getPlazo()];
        for (int i = 0; i < prestamo.getPlazo(); i++) {
            prestamo.cuotas[i] = new Cuota(i + 1, cuota);
        }

        // Establecer valor inicial del período para la primera cuota
        prestamo.cuotas[0].setSaldo(prestamo.getMonto());

        // Calcular valores para cada cuota
        for (int i = 0; i < prestamo.getPlazo(); i++) {
            calcularValoresCuota(prestamo.cuotas[i], prestamo.getTasaInteres());
            if (i < prestamo.getPlazo() - 1) {
                prestamo.cuotas[i + 1].setSaldo(prestamo.cuotas[i].getSaldo());
            } else {
                // Ajustar la última cuota
                prestamo.cuotas[i].setSaldo(0); // O ajustar el valor de la cuota si es necesario
            }
        }
    }

    private void calcularValoresCuota(Cuota cuota, double tasaInteres) {
        // Calcular interés, abono al capital y actualizar saldo
        // ...
    }

    public void mostrarTabla(Prestamo prestamo) {
        // Iterar sobre las cuotas y mostrar los valores en consola
        // ...
    }
}