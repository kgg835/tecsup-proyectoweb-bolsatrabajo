package com.proyecto.modelo;

public class Administrador extends Persona {
	private Integer codigo;

	public Administrador(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
