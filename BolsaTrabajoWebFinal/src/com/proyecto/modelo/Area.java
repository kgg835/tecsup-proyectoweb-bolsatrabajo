package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAREA;

	private String descripcionArea;

	//bi-directional many-to-one association to Puesto
	@OneToMany(mappedBy="area")
	private Set<Puesto> puestos;

    public Area() {
    }

	public int getIdAREA() {
		return this.idAREA;
	}

	public void setIdAREA(int idAREA) {
		this.idAREA = idAREA;
	}

	public String getDescripcionArea() {
		return this.descripcionArea;
	}

	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}

	public Set<Puesto> getPuestos() {
		return this.puestos;
	}

	public void setPuestos(Set<Puesto> puestos) {
		this.puestos = puestos;
	}
	
}