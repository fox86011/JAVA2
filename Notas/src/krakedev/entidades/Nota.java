package krakedev.entidades;

public class Nota {
    private String codigoMateria;
    private double calificacion;

    public Nota(String codigoMateria, double calificacion) {
        this.codigoMateria = codigoMateria;
        setCalificacion(calificacion);
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 10.");
        }
    }

    public void mostrar() {
        System.out.println("Código de materia: " + codigoMateria + ", Calificación: " + calificacion);
    }
}