package com.clearminds.componentes;

public class Celda {
    // Atributos
    private Producto producto;
    private int stock;
    private String codigo;

    // Constructor
    public Celda(String codigo) {
        this.codigo = codigo;
        this.stock = 0; // Inicializamos el stock en 0
    }

    // Método para ingresar producto
    public void ingresarProducto(Producto producto, int stockInicial) {
        this.producto = producto;
        this.stock = stockInicial;
    }

    // Getters (opcional, si necesitas acceder a los atributos)
    public Producto getProducto() {
        return producto;
    }

    public int getStock() {
        return stock;
    }

    public String getCodigo() {
        return codigo;
    }
}