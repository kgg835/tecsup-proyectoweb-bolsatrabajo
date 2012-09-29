package com.proyecto.negocio;

import com.proyecto.dao.AreaDAO;
import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Area;
import com.proyecto.modelo.Ofertante;

public class GestionArea {
	public Area insertar(String desc)
			throws DAOExcepcion {
		AreaDAO dao = new AreaDAO();
		Area vo = new Area();
		vo.setDescripcion(desc);
	
		return dao.insertar(vo);
}
}
