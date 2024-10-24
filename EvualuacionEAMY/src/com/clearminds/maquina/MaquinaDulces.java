package com.clearminds.maquina;
import com.clearminds.componentes.*;

class MaquinaDulces {
    private Celda celda1;
    private Celda celda2;
    private Celda celda3;
    private Celda celda4;
    private double saldo;

    public MaquinaDulces() {
        celda1 = new Celda("C1");
        celda2 = new Celda("C2");
        celda3 = new Celda("C3");
        celda4 = new Celda("C4");
        saldo = 0.0;
    }

    public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
        celda1 = new Celda(codigo1);
        celda2 = new Celda(codigo2);
        celda3 = new Celda(codigo3);
        celda4 = new Celda(codigo4);
    }

    public void mostrarConfiguracion() {
        System.out.println("Configuración de la máquina:");
        System.out.println("Celda 1: " + celda1.getCodigo());
        System.out.println("Celda 2: " + celda2.getCodigo());
        System.out.println("Celda 3: " + celda3.getCodigo());
        System.out.println("Celda 4: " + celda4.getCodigo());
    }

    public Celda buscarCelda(String codigoCelda) {
        if (celda1.getCodigo().equals(codigoCelda)) return celda1;
        if (celda2.getCodigo().equals(codigoCelda)) return celda2;
        if (celda3.getCodigo().equals(codigoCelda)) return celda3;
        if (celda4.getCodigo().equals(codigoCelda)) return celda4;
        return null;
    }

    public void cargarProducto(Producto producto, String codigoCelda, int cantidad) {
        Celda celdaRecuperada = buscarCelda(codigoCelda);
        if (celdaRecuperada != null) {
            celdaRecuperada.ingresarProducto(producto, cantidad);
        }
    }

    public void mostrarProductos() {
        System.out.println("Productos en la máquina:");
        mostrarProductoEnCelda(celda1);
        mostrarProductoEnCelda(celda2);
        mostrarProductoEnCelda(celda3);
        mostrarProductoEnCelda(celda4);
        System.out.println("Saldo actual: " + saldo);
    }

    private void mostrarProductoEnCelda(Celda celda) {
        Producto producto = celda.getProducto();
        if (producto != null) {
            System.out.println("Código: " + celda.getCodigo() +
                    ", Stock: " + celda.getStock() +
                    ", Nombre: " + producto.getNombre() +
                    ", Precio: " + producto.getPrecio());
        }
    }

    public Producto buscarProductoEnCelda(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        return (celda != null) ? celda.getProducto() : null;
    }

    public double consultarPrecio(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        Producto producto = (celda != null) ? celda.getProducto() : null;
        return (producto != null) ? producto.getPrecio() : 0.0;
    }

    public Celda buscarCeldaProducto(String codigoProducto) {
        for (Celda celda : new Celda[]{celda1, celda2, celda3, celda4}) {
            Producto producto = celda.getProducto();
            if (producto != null && producto.getNombre().equals(codigoProducto)) {
                return celda;
            }
        }
        return null;
    }

    public void incrementarProductos(String codigoProducto, int cantidad) {
        Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
        if (celdaEncontrada != null) {
            celdaEncontrada.getProducto().setStock(celdaEncontrada.getStock() + cantidad);
        }
    }

    public void vender(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null) {
            celda.disminuirStock();
            saldo += celda.getProducto().getPrecio();
        }
    }

    public double venderConCambio(String codigoCelda, double valorIngresado) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null) {
            celda.disminuirStock();
            double precio = celda.getProducto().getPrecio();
            saldo += precio;
            return valorIngresado - precio;
        }
        return 0.0; // Si la celda no existe, no hay cambio.
    }
    return 0.0; // Si la celda no existe, no hay cambio.
}
}
