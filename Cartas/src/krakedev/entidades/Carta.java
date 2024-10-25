package krakedev.entidades;

public class Carta {
    // Atributos
    private Numero numero;
    private String palo;

    // Constructor que recibe número y palo
    public Carta(Numero numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    // Getters y setters
    // ...

    // Método para mostrar la información de la carta
    public void mostrarInformacion() {
        System.out.println(numero.getNumeroCarta() + "-" + palo);
    }

    public static void main(String[] args) {
        // Instanciando objetos
        Palos palos = new Palos();
        Numero numeroAs = new Numero("A", 11);
        Carta cartaAsCorazones = new Carta(numeroAs, palos.getCorazonRojo());

        // Mostrando la información de la carta
        cartaAsCorazones.mostrarInformacion(); // Imprimirá: A-CR
    }

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
}