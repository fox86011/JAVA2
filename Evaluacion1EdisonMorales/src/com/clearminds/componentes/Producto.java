package com.clearminds.componentes;

public class Producto {
    // Atributos
    private String nombre;
    private double precio;
    private String codigo;

    // Constructor
    public Producto(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    // Método para incrementar el precio
    public void incrementarPrecio(int porcentaje) {
        double incremento = (precio * porcentaje) / 100;
        precio += incremento;
    }

    // Método para disminuir el precio
    public void disminuirPrecio(double descuento) {
        precio -= descuento;
    }

    // Getters (opcional, si necesitas acceder a los atributos)
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }
}
