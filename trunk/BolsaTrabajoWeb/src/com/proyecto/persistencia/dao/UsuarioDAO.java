package com.proyecto.persistencia.dao;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;

public interface UsuarioDAO {
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion;
	public int obteneridUsuario(Usuario user) throws DAOExcepcion;
}
