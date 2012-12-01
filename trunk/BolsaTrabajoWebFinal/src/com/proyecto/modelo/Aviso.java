package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the aviso database table.
 * 
 */
@Entity
public class Aviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAVISO;

    @Temporal( TemporalType.DATE)
	private Date fechacaducidad;

    @Temporal( TemporalType.DATE)
	private Date fechaPublicacion;

	private String tituloAviso;

	//bi-directional many-to-one association to Ofertante
    @ManyToOne
	@JoinColumn(name="idOFERTANTE")
	private Ofertante ofertante;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="avisos")
	private Set<Persona> personas;

    public Aviso() {
    }

	public int getIdAVISO() {
		return this.idAVISO;
	}

	public void setIdAVISO(int idAVISO) {
		this.idAVISO = idAVISO;
	}

	public Date getFechacaducidad() {
		return this.fechacaducidad;
	}

	public void setFechacaducidad(Date fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTituloAviso() {
		return this.tituloAviso;
	}

	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}

	public Ofertante getOfertante() {
		return this.ofertante;
	}

	public void setOfertante(Ofertante ofertante) {
		this.ofertante = ofertante;
	}
	
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	
}