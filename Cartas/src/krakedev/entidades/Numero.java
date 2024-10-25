package krakedev.entidades;

public class Numero {
    // Atributos
    private String numeroCarta;
    private int valor;

    // Constructor que recibe ambos parámetros
    public Numero(String numeroCarta, int valor) {
        this.numeroCarta = numeroCarta;
        this.valor = valor;
    }

    // Getters y setters
    // ...

    // Método para mostrar la información de la carta
    public void mostrarInformacion() {
        System.out.println(numeroCarta + "-" + valor);
    }

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}