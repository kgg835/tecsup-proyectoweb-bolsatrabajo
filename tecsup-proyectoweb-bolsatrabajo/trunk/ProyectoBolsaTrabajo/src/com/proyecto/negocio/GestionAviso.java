package com.proyecto.negocio;

import java.util.Date;

import com.proyecto.dao.AvisoDAO;
import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.Ofertante;

public class GestionAviso {
	
	public Aviso insertar(int codofertante,int codplaboral,String titulo,Date f_publi,Date f_cadu)
			throws DAOExcepcion {
		AvisoDAO dao = new AvisoDAO();
		Aviso vo = new Aviso();
		vo.setIdOfertante(codofertante);
		vo.setId_puesto(codplaboral);
		vo.setTitulo(titulo);
		vo.setFec_publicacion(f_publi);
		vo.setFec_caduc(f_cadu);
		return dao.insertar(vo);
}
}
