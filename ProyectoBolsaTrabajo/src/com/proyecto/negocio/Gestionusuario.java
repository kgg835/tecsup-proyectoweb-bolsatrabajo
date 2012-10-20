package com.proyecto.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.dao.UsuarioDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.exception.LoginExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.modelo.Usuario;
import com.proyecto.modelo.consulta_ofertante1;

public class Gestionusuario {
	public Usuario insertar(String nombre, String password)
			throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario vo = new Usuario();
		vo.setNombreUsuario(nombre);
		vo.setPasswordUsuario(password);
		
		return dao.insertar(vo);		

		
}
	public void insertar_urol(int cod,int tipo) throws DAOExcepcion
	{		UsuarioDAO dao = new UsuarioDAO();

		dao.insertar(cod,tipo);
		
	}

	
	public consulta_ofertante1 validarUsuario(String idUsuario, String clave)
			throws DAOExcepcion, LoginExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(idUsuario, clave);
	}

	
	
}
