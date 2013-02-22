package com.proyecto.negocio;

import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.dao.SeleccionDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.modelo.Seleccion;

public class GestionSeleccion {
	public Seleccion insertar(int codaviso, int codofertante,int codpostulante)
			throws DAOExcepcion {
		SeleccionDAO dao = new SeleccionDAO();
		Seleccion vo = new Seleccion();
		vo.setCodaviso(codaviso);
		vo.setCodofertante(codofertante);
		vo.setCodpostulante(codpostulante);
	

		return dao.insertar(vo);
}
	public Ofertante obtener(int idofertante) throws DAOExcepcion {
		OFERTANTEDAO dao = new OFERTANTEDAO();
		
		
		
		return dao.obtener(idofertante);
		
	}
}
