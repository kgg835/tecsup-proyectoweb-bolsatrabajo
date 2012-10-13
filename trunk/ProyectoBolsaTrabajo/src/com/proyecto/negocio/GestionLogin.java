package com.proyecto.negocio;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;

public class GestionLogin {

	// Para validar el usuario del Postulante o Administrador
	public boolean validarUsuario() {
		return true;
	}

	// Para validar su Password del Postulante o Administrador
	public boolean validarPassword() {
		return true;
	}

	// Par aIniciar sesion del Postulante o Administrador
	public void iniciarSesion() {

	}
	//Metodo para Ingresar un Usuario
	public Usuario insertarUsuario(Usuario usuario) throws DAOExcepcion {
		UsuarioDAO dao=new UsuarioDAO();
		return dao.insertarUsuario(usuario);
	}
	
//	//Obtiene el Usuario deacuerdo al ID
//	public Usuario obtenerUsuario(int idUsuario) throws DAOExcepcion {
//		UsuarioDAO dao=new UsuarioDAO();
//		return dao.obtenerUsuario(idUsuario);
//	}
	
	//metodo que valida el Usuario
	
	//Obtiene el idUsuario 
	public int obteneridUsuario(Usuario user) throws DAOExcepcion {
		UsuarioDAO dao=new UsuarioDAO();
		return dao.obteneridUsuario(user);
	}
	
	//Obtiene el Rol del Usuario 
	public String obtenerRol(int idRol) throws DAOExcepcion {
		UsuarioDAO dao=new UsuarioDAO();
		return dao.obtenerRol(idRol);
	}
}
