package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String buscarEstudiantePorCedula(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return "Estudiante encontrado: " + estudiante.mostrar();
            }
        }
        return null;
    }

    public void matricularEstudiante(Estudiante estudiante) {
        if (buscarEstudiantePorCedula(estudiante.getCedula()) == null) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante matriculado: " + estudiante.getCedula());
        } else {
            System.out.println("El estudiante ya está matriculado.");
        }
    }

    public double calcularPromedioCurso() {
        if (estudiantes.isEmpty()) {
            return 0.0;
        }
        double sumaPromedios = 0.0;
        for (Estudiante estudiante : estudiantes) {
            sumaPromedios += estudiante.calcularPromedioNotasEstudiante();
        }
        return sumaPromedios / estudiantes.size();
    }

    public void mostrar() {
        System.out.println("Curso: " + nombre);
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.mostrar());
        }
    }
}