package com.proyecto.negocio.service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;

public interface UsuarioService {
	
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion;
	public int obteneridUsuario(Usuario user) throws DAOExcepcion;
	//Obtiene el Rol del Usuario 
	public String obtenerRol(int idRol) throws DAOExcepcion;
}
