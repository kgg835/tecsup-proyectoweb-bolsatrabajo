package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puesto database table.
 * 
 */
@Entity
public class Puesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPUESTO;

	private String descPuesto;

	private String nombrePuesto;

	//bi-directional many-to-one association to Area
    @ManyToOne
	@JoinColumn(name="idAREA")
	private Area area;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public Puesto() {
    }

	public int getIdPUESTO() {
		return this.idPUESTO;
	}

	public void setIdPUESTO(int idPUESTO) {
		this.idPUESTO = idPUESTO;
	}

	public String getDescPuesto() {
		return this.descPuesto;
	}

	public void setDescPuesto(String descPuesto) {
		this.descPuesto = descPuesto;
	}

	public String getNombrePuesto() {
		return this.nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}