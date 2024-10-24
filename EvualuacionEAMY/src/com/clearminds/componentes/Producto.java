package com.clearminds.componentes;

public class Producto {
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
    public void incrementarPrecio(double porcentaje) {
        double aumento = precio * (porcentaje / 100);
        precio += aumento;
    }

    // Método para disminuir el precio
    public void disminuirPrecio(double descuento) {
        precio -= descuento;
    }

    // Getters y setters (opcional)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}