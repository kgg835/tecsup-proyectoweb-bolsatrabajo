package com.proyecto.negocio;



import java.util.Collection;

import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;



public class Gestionofertante {
	public Ofertante insertar(String ruc, String razonsocial,String correo, String descempresa,String usua,String pass)
			throws DAOExcepcion {
		OFERTANTEDAO dao = new OFERTANTEDAO();
		Ofertante vo = new Ofertante();
		vo.setRuc(ruc);
		vo.setRazonsocial(razonsocial);
		vo.setCorreo(correo);
		vo.setDescempresa(descempresa);
		vo.setUsuario(usua);
		vo.setPassword(pass);

		return dao.insertar(vo);
}

	public Ofertante obtener(int idofertante) throws DAOExcepcion {
		OFERTANTEDAO dao = new OFERTANTEDAO();
		return dao.obtener(idofertante);
	}

	public void eliminar(int idofertante) throws DAOExcepcion{
		OFERTANTEDAO dao=new OFERTANTEDAO();
		dao.eliminar(idofertante);
	}

	public Collection<Ofertante> listar() throws DAOExcepcion{
		OFERTANTEDAO dao=new OFERTANTEDAO();
		
		return dao.listar();
	}
}
