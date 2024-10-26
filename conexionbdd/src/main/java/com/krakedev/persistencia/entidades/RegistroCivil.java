package com.krakedev.persistencia.entidades;

public class RegistroCivil {
	private String codigo;
	private String descripcion;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public RegistroCivil(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public RegistroCivil() {
		
	}
	@Override
	public String toString() {
		return "RegistroCivil [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
