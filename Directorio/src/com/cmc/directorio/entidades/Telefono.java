package com.cmc.directorio.entidades;

public class Telefono {
	private String operadora;
	private String numero;
	private int codigo;
	private boolean tieneWhatsapp;
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isTieneWhatsapp() {
		return tieneWhatsapp;
	}
	public void setTieneWhatsapp(boolean tieneWhatsapp) {
		this.tieneWhatsapp = tieneWhatsapp;
	}
	public Telefono(String operadora, String numero, int codigo, boolean tieneWhatsapp) {
		super();
		this.operadora = operadora;
		this.numero = numero;
		this.codigo = codigo;
		this.tieneWhatsapp = tieneWhatsapp;
	}
	public void activarWhatsapp() {
        if (operadora.equalsIgnoreCase("movi")) {
            tieneWhatsapp = true;
        }
    }
	@Override
    public String toString() {
        return "Telefono{" +
                "operadora='" + operadora + '\'' +
                ", numero='" + numero + '\'' +
                ", codigo=" + codigo +
                ", tieneWhatsapp=" + tieneWhatsapp +
                '}';
    }
	
}

