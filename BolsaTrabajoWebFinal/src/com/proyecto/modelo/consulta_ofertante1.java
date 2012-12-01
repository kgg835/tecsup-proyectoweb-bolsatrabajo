package com.proyecto.modelo;

public class consulta_ofertante1 {
 private	String nombreUsuario;
private	String descEmpresa;
private	String tipoRol;

public consulta_ofertante1(){}
public consulta_ofertante1(String nombre,String desc,String tipo){
	this.nombreUsuario=nombre;
	this.descEmpresa=desc;
	this.tipoRol=tipo;
	
}
public String getNombreUsuario() {
	return nombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}
public String getDescEmpresa() {
	return descEmpresa;
}
public void setDescEmpresa(String descEmpresa) {
	this.descEmpresa = descEmpresa;
}
public String getTipoRol() {
	return tipoRol;
}
public void setTipoRol(String tipoRol) {
	this.tipoRol = tipoRol;
}

}
