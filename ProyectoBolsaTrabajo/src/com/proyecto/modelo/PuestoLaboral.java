package com.proyecto.modelo;

public class PuestoLaboral {
	private String codarea;
	private String descarea;
	private String descpuesto;
	//Un PuestoLaboral puede 
	public PuestoLaboral() {
	}

	public PuestoLaboral(String codarea, String descarea, String descpuesto) {
		this.codarea = codarea;
		this.descarea = descarea;
		this.descpuesto = descpuesto;
	}

	public String getCodarea() {
		return codarea;
	}

	public void setCodarea(String codarea) {
		this.codarea = codarea;
	}

	public String getDescarea() {
		return descarea;
	}

	public void setDescarea(String descarea) {
		this.descarea = descarea;
	}

	public String getDescpuesto() {
		return descpuesto;
	}

	public void setDescpuesto(String descpuesto) {
		this.descpuesto = descpuesto;
	}

}
