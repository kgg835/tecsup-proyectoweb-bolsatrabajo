package com.proyecto.modelo;

import java.util.Collection;

public class Administrador extends Persona {

	private Integer codigo;
	
	public Administrador(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	//Get and Set
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
