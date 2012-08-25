package com.proyecto.modelo;

import java.util.Collection;

public class Administrador extends Persona {

	private Integer codigo;
	//Un Puesto pertenece a un Area
	private Area areapuesto;
	
	// Un Administrador Registra a muchos puestos de Trabajo
	private Collection<Puesto> listaPuestos;

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

	public void setListaPuestos(Collection<Puesto> listaPuestos) {
		this.listaPuestos = listaPuestos;
	}

	public Collection<Puesto> getListaPuestos() {
		return listaPuestos;
	}

	public void setAreapuesto(Area areapuesto) {
		this.areapuesto = areapuesto;
	}

	public Area getAreapuesto() {
		return areapuesto;
	}

}
