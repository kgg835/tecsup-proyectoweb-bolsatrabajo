package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seleccion_postulante database table.
 * 
 */
@Entity
@Table(name="seleccion_postulante")
public class SeleccionPostulante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSELECCIONPOSTULANTE;

	private String codAviso;

	private String codPostulante;

	private String codSeleccion;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public SeleccionPostulante() {
    }

	public int getIdSELECCIONPOSTULANTE() {
		return this.idSELECCIONPOSTULANTE;
	}

	public void setIdSELECCIONPOSTULANTE(int idSELECCIONPOSTULANTE) {
		this.idSELECCIONPOSTULANTE = idSELECCIONPOSTULANTE;
	}

	public String getCodAviso() {
		return this.codAviso;
	}

	public void setCodAviso(String codAviso) {
		this.codAviso = codAviso;
	}

	public String getCodPostulante() {
		return this.codPostulante;
	}

	public void setCodPostulante(String codPostulante) {
		this.codPostulante = codPostulante;
	}

	public String getCodSeleccion() {
		return this.codSeleccion;
	}

	public void setCodSeleccion(String codSeleccion) {
		this.codSeleccion = codSeleccion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}