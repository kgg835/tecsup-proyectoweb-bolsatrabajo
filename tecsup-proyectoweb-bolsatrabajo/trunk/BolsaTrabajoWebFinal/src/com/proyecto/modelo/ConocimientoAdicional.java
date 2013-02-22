package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conocimiento_adicional database table.
 * 
 */
@Entity
@Table(name="conocimiento_adicional")
public class ConocimientoAdicional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCONOCIMIENTO_ADICIONAL;

	private String descripcionConocimiento;

	private String nombreConocimiento;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	private Persona persona;

    public ConocimientoAdicional() {
    }

	public int getIdCONOCIMIENTO_ADICIONAL() {
		return this.idCONOCIMIENTO_ADICIONAL;
	}

	public void setIdCONOCIMIENTO_ADICIONAL(int idCONOCIMIENTO_ADICIONAL) {
		this.idCONOCIMIENTO_ADICIONAL = idCONOCIMIENTO_ADICIONAL;
	}

	public String getDescripcionConocimiento() {
		return this.descripcionConocimiento;
	}

	public void setDescripcionConocimiento(String descripcionConocimiento) {
		this.descripcionConocimiento = descripcionConocimiento;
	}

	public String getNombreConocimiento() {
		return this.nombreConocimiento;
	}

	public void setNombreConocimiento(String nombreConocimiento) {
		this.nombreConocimiento = nombreConocimiento;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}