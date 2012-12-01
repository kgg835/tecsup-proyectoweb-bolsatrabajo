package com.proyecto.modelo;

public class PreferenciaSalarial {
	private int idSalario;
	private double montoSoles;
	private double montoDolares;

	// Get and Set
	public double getMontoSoles() {
		return montoSoles;
	}

	public void setMontoSoles(double montoSoles) {
		this.montoSoles = montoSoles;
	}

	public double getMontoDolares() {
		return montoDolares;
	}

	public void setMontoDolares(double montoDolares) {
		this.montoDolares = montoDolares;
	}

	public void setIdSalario(int idSalario) {
		this.idSalario = idSalario;
	}

	public int getIdSalario() {
		return idSalario;
	}

}
