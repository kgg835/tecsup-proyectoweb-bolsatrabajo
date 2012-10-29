package com.proyecto.persistencia.dao;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;

public interface UsuarioDAO {
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion;
}
