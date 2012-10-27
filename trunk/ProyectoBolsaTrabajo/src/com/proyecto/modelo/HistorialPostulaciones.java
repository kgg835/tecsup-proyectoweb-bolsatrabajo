package com.proyecto.modelo;


public class HistorialPostulaciones {
	private int idpostulacion;
	private String nombreEmpresa;
	private String tituloAviso;
	private String fechpostulacion;
	private String Estado;
	public HistorialPostulaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistorialPostulaciones(int idpostulacion, String nombreEmpresa,
			String tituloAviso, String fechpostulacion, String estado) {
		super();
		this.idpostulacion = idpostulacion;
		this.nombreEmpresa = nombreEmpresa;
		this.tituloAviso = tituloAviso;
		this.fechpostulacion = fechpostulacion;
		Estado = estado;
	}
	public int getIdpostulacion() {
		return idpostulacion;
	}
	public void setIdpostulacion(int idpostulacion) {
		this.idpostulacion = idpostulacion;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getTituloAviso() {
		return tituloAviso;
	}
	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}
	public String getFechpostulacion() {
		return fechpostulacion;
	}
	public void setFechpostulacion(String fechpostulacion) {
		this.fechpostulacion = fechpostulacion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}

	
	}
