package com.proyecto.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.service.UsuarioService;
import com.proyecto.persistencia.dao.UsuarioDAO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion {

		return usuarioDAO.insertarUsuario(usuario);
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public int obteneridUsuario(Usuario user) throws DAOExcepcion {
		return usuarioDAO.obteneridUsuario(user);
	}

	@Override
	public String obtenerRol(int idRol) throws DAOExcepcion {
		
		return usuarioDAO.obtenerRol(idRol);
	}

}
