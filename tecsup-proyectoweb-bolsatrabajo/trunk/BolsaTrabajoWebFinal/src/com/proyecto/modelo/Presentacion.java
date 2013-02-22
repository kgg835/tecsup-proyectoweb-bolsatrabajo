package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the presentacion database table.
 * 
 */
@Entity
public class Presentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPRESENTACION;

	private String descripcion_Pres;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public Presentacion() {
    }

	public int getIdPRESENTACION() {
		return this.idPRESENTACION;
	}

	public void setIdPRESENTACION(int idPRESENTACION) {
		this.idPRESENTACION = idPRESENTACION;
	}

	public String getDescripcion_Pres() {
		return this.descripcion_Pres;
	}

	public void setDescripcion_Pres(String descripcion_Pres) {
		this.descripcion_Pres = descripcion_Pres;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}