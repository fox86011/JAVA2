package com.cmc.evaluacion;

public class Prestamo {
	private double Monto, Interes;
	private int Plazo;
	private Cuota[] cuotas;
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}
	public double getInteres() {
		return Interes;
	}
	public void setInteres(double interes) {
		Interes = interes;
	}
	public int getPlazo() {
		return Plazo;
	}
	public void setPlazo(int plazo) {
		Plazo = plazo;
	}
	public Prestamo(double monto, double interes, int plazo) {
		super();
		Monto = monto;
		Interes = interes;
		Plazo = plazo;
	}
	

}
