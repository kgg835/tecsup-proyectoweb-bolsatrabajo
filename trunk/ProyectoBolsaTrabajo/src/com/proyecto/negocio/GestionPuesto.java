package com.proyecto.negocio;

import com.proyecto.dao.OFERTANTEDAO;
import com.proyecto.dao.PuestoLaboralDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.modelo.Puesto;

public class GestionPuesto {
	public Puesto insertar(int codigo,String puesto)
			throws DAOExcepcion {
		PuestoLaboralDAO dao = new PuestoLaboralDAO();
		Puesto vo = new Puesto();
		vo.setCodArea(codigo);
		vo.setDescripcion(puesto);
	

		return dao.insertar(vo);
}
}
