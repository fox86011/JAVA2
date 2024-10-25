package com.cmc.evaluacion;

public class Cuota {
    private final int numero;
    private double cuota;
    private double capital;
    private double inicio;
    private double interes;
    private double abonoCapital;
    private double saldo;


    // Constructor
    public Cuota(int numero) {
        this.numero = numero;
    }

    // Getters y setters (excepto para numero)
    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    // ... (resto de getters y setters)

    // Método para mostrar la información de la cuota
    public void mostrarPrestamo() {
        System.out.printf("%d %.2f %.2f %.2f %.2f %.2f%n",
                numero, cuota, capital, inicio, interes, saldo);
    }

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getInicio() {
		return inicio;
	}

	public void setInicio(double inicio) {
		this.inicio = inicio;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getAbonoCapital() {
		return abonoCapital;
	}

	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}
}
