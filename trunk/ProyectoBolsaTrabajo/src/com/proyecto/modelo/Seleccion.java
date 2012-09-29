package com.proyecto.modelo;

public class Seleccion {
	private int codaviso;
	private int codofertante;
	private int codpostulante;
	
	public Seleccion(){}
	public Seleccion(int codaviso, int codofertante, int codpostulante) {
		super();
		this.codaviso = codaviso;
		this.codofertante = codofertante;
		this.codpostulante = codpostulante;
	}
	public int getCodaviso() {
		return codaviso;
	}
	public void setCodaviso(int codaviso) {
		this.codaviso = codaviso;
	}
	public int getCodofertante() {
		return codofertante;
	}
	public void setCodofertante(int codofertante) {
		this.codofertante = codofertante;
	}
	public int getCodpostulante() {
		return codpostulante;
	}
	public void setCodpostulante(int codpostulante) {
		this.codpostulante = codpostulante;
	}
	

	



}
