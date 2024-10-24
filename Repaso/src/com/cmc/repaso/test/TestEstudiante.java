package com.cmc.repaso.test;
import com.cmc.repaso.entidades.*;

public class TestEstudiante {
	 public static void main(String[] args) {
	        Estudiante estudiante = new Estudiante("Juan");

	        estudiante.calificar(9.5);

	        System.out.println(estudiante.resultado); // A

	        estudiante.calificar(6.5);
	        System.out.println(estudiante.resultado); // F
	    }

}
