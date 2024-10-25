package krakedev.entidades;

import java.util.ArrayList;

public class Naipe {
    private ArrayList<Numero> numerosPosibles;
    private ArrayList<Carta> cartas;

    public Naipe() {
        // Inicializar la lista de números posibles
    	 numerosPosibles = new ArrayList<>();
         numerosPosibles.add(new Numero("A", 11));
         numerosPosibles.add(new Numero("2", 2));
         numerosPosibles.add(new Numero("3", 3));
         numerosPosibles.add(new Numero("4", 4));
         numerosPosibles.add(new Numero("5", 5));
         numerosPosibles.add(new Numero("6", 6));
         numerosPosibles.add(new Numero("7", 7));
         numerosPosibles.add(new Numero("8", 8));
         numerosPosibles.add(new Numero("9", 9));
         numerosPosibles.add(new Numero("10", 10));
         numerosPosibles.add(new Numero("J", 10));
         numerosPosibles.add(new Numero("Q", 10));
         numerosPosibles.add(new Numero("K", 10));

        // Inicializar la lista de cartas
        cartas = new ArrayList<>();

        // Crear todas las cartas posibles combinando números y palos
        // (Aquí asumiré que tienes una clase Palo con los palos posibles)
        for (Numero numero : numerosPosibles) {
            for (Palo palo : Palo.values()) {
                Carta carta = new Carta(numero, palo);
                cartas.add(carta);
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}

