package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experiencia_laboral database table.
 * 
 */
@Entity
@Table(name="experiencia_laboral")
public class ExperienciaLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEXPERIENCIA_LABORAL;

	private String area;

	private String descripcionResponsabilidad;

	private String empresa;

	private String fechaFinal;

	private String fechaInicio;

	private int numeroPersonasCargo;

	private String pais;

	private String subArea;

	private String titulo_Puesto;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public ExperienciaLaboral() {
    }

	public int getIdEXPERIENCIA_LABORAL() {
		return this.idEXPERIENCIA_LABORAL;
	}

	public void setIdEXPERIENCIA_LABORAL(int idEXPERIENCIA_LABORAL) {
		this.idEXPERIENCIA_LABORAL = idEXPERIENCIA_LABORAL;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescripcionResponsabilidad() {
		return this.descripcionResponsabilidad;
	}

	public void setDescripcionResponsabilidad(String descripcionResponsabilidad) {
		this.descripcionResponsabilidad = descripcionResponsabilidad;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getNumeroPersonasCargo() {
		return this.numeroPersonasCargo;
	}

	public void setNumeroPersonasCargo(int numeroPersonasCargo) {
		this.numeroPersonasCargo = numeroPersonasCargo;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSubArea() {
		return this.subArea;
	}

	public void setSubArea(String subArea) {
		this.subArea = subArea;
	}

	public String getTitulo_Puesto() {
		return this.titulo_Puesto;
	}

	public void setTitulo_Puesto(String titulo_Puesto) {
		this.titulo_Puesto = titulo_Puesto;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}