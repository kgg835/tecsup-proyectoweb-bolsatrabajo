package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referencia database table.
 * 
 */
@Entity
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idREFERENCIA;

	private String apellidosRefer;

	private String emailRef;

	private String experienciaRelacionadaRef;

	private String nombreRef;

	private String puestoEmpresaRef;

	private String relacionRef;

	private String telefonoRef;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public Referencia() {
    }

	public int getIdREFERENCIA() {
		return this.idREFERENCIA;
	}

	public void setIdREFERENCIA(int idREFERENCIA) {
		this.idREFERENCIA = idREFERENCIA;
	}

	public String getApellidosRefer() {
		return this.apellidosRefer;
	}

	public void setApellidosRefer(String apellidosRefer) {
		this.apellidosRefer = apellidosRefer;
	}

	public String getEmailRef() {
		return this.emailRef;
	}

	public void setEmailRef(String emailRef) {
		this.emailRef = emailRef;
	}

	public String getExperienciaRelacionadaRef() {
		return this.experienciaRelacionadaRef;
	}

	public void setExperienciaRelacionadaRef(String experienciaRelacionadaRef) {
		this.experienciaRelacionadaRef = experienciaRelacionadaRef;
	}

	public String getNombreRef() {
		return this.nombreRef;
	}

	public void setNombreRef(String nombreRef) {
		this.nombreRef = nombreRef;
	}

	public String getPuestoEmpresaRef() {
		return this.puestoEmpresaRef;
	}

	public void setPuestoEmpresaRef(String puestoEmpresaRef) {
		this.puestoEmpresaRef = puestoEmpresaRef;
	}

	public String getRelacionRef() {
		return this.relacionRef;
	}

	public void setRelacionRef(String relacionRef) {
		this.relacionRef = relacionRef;
	}

	public String getTelefonoRef() {
		return this.telefonoRef;
	}

	public void setTelefonoRef(String telefonoRef) {
		this.telefonoRef = telefonoRef;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}