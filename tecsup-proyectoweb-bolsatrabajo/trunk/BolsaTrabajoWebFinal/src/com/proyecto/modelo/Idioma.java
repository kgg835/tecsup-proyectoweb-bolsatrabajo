package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the idioma database table.
 * 
 */
@Entity
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idIDIOMA;

	private String nivelEscrito;

	private String nivelOral;

	private String nombreIdioma;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="idiomas")
	private Set<Persona> personas;

    public Idioma() {
    }

	public int getIdIDIOMA() {
		return this.idIDIOMA;
	}

	public void setIdIDIOMA(int idIDIOMA) {
		this.idIDIOMA = idIDIOMA;
	}

	public String getNivelEscrito() {
		return this.nivelEscrito;
	}

	public void setNivelEscrito(String nivelEscrito) {
		this.nivelEscrito = nivelEscrito;
	}

	public String getNivelOral() {
		return this.nivelOral;
	}

	public void setNivelOral(String nivelOral) {
		this.nivelOral = nivelOral;
	}

	public String getNombreIdioma() {
		return this.nombreIdioma;
	}

	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}

	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	
}