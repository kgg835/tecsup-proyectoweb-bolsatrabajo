package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudio database table.
 * 
 */
@Entity
public class Estudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idESTUDIO;

	private String areaEstudio;

	private int cantidadMaterias;

	private String descrpcioninstitucion;

	private String estado;

	private String fechaFin;

	private String fechaInicio;

	private int materiasAprobadas;

	private String nivelEstudio;

	private String pais;

	private double promedio;

	private String tituloEstudio;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public Estudio() {
    }

	public int getIdESTUDIO() {
		return this.idESTUDIO;
	}

	public void setIdESTUDIO(int idESTUDIO) {
		this.idESTUDIO = idESTUDIO;
	}

	public String getAreaEstudio() {
		return this.areaEstudio;
	}

	public void setAreaEstudio(String areaEstudio) {
		this.areaEstudio = areaEstudio;
	}

	public int getCantidadMaterias() {
		return this.cantidadMaterias;
	}

	public void setCantidadMaterias(int cantidadMaterias) {
		this.cantidadMaterias = cantidadMaterias;
	}

	public String getDescrpcioninstitucion() {
		return this.descrpcioninstitucion;
	}

	public void setDescrpcioninstitucion(String descrpcioninstitucion) {
		this.descrpcioninstitucion = descrpcioninstitucion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getMateriasAprobadas() {
		return this.materiasAprobadas;
	}

	public void setMateriasAprobadas(int materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public String getNivelEstudio() {
		return this.nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getPromedio() {
		return this.promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public String getTituloEstudio() {
		return this.tituloEstudio;
	}

	public void setTituloEstudio(String tituloEstudio) {
		this.tituloEstudio = tituloEstudio;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}