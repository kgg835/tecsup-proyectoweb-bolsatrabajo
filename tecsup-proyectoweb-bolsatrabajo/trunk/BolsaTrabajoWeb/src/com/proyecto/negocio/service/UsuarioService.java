package com.proyecto.negocio.service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;

public interface UsuarioService {
	
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion;
	public Usuario obtenerUsuario(String usuario,String password) throws DAOExcepcion;
	//Obtiene el Rol del Usuario 
	public String obtenerRol(int idRol) throws DAOExcepcion;
}
