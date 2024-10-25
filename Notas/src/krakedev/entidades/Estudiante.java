package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
    private String cedula;
    private String nombre;
    private ArrayList<Nota> notas;

    public Estudiante(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void agregarNota(Nota nuevaNota) {
        for (Nota nota : notas) {
            if (nota.getCodigoMateria().equals(nuevaNota.getCodigoMateria())) {
                System.out.println("Error: Ya existe una nota para la materia con código " + nuevaNota.getCodigoMateria());
                return;
            }
        }
        if (nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
            notas.add(nuevaNota);
        } else {
            System.out.println("Error: La calificación debe estar entre 0 y 10.");
        }
    }

    public void modificarNota(String codigo, double nuevaCalificacion) {
        for (Nota nota : notas) {
            if (nota.getCodigoMateria().equals(codigo)) {
                nota.setCalificacion(nuevaCalificacion);
                return;
            }
        }
        System.out.println("No se encontró una nota con el código " + codigo);
    }

    public double calcularPromedioNotasEstudiante() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Nota nota : notas) {
            suma += nota.getCalificacion();
        }
        return suma / notas.size();
    }

    public String mostrar() {
        StringBuilder info = new StringBuilder("Estudiante: " + nombre + " (Cédula: " + cedula + ")\nNotas:\n");
        for (Nota nota : notas) {
            info.append("- ");
            nota.mostrar();
        }
        return info.toString();
    }
}