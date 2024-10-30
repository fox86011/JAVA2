package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.util.Date;

public class RegistroMovimiento {
    private int id;
    private String idArticulo;
    private int cantidad;
    private Date fechaMovimiento;

    // Constructor vacío
    public RegistroMovimiento() {}

    // Constructor con parámetros
    public RegistroMovimiento(int id, String idArticulo, int cantidad, Date fechaMovimiento) {
        this.id = id;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
        this.fechaMovimiento = fechaMovimiento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    // Método toString
    @Override
    public String toString() {
        return "RegistroMovimiento{" +
                "id=" + id +
                ", idArticulo='" + idArticulo + '\'' +
                ", cantidad=" + cantidad +
                ", fechaMovimiento=" + fechaMovimiento +
                '}';
    }
}
