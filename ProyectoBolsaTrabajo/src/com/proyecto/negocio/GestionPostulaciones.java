package com.proyecto.negocio;

import java.util.Collection;

import com.proyecto.dao.HistorialPostulacionesDAO;
import com.proyecto.dao.RegistroPostulacionDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.modelo.RegistroPostulacion;

public class GestionPostulaciones {
	public RegistroPostulacion insertar(int idPostulacion,String fechPostulacion,String estadoPostulacion)
			throws DAOExcepcion {
		RegistroPostulacionDAO dao = new RegistroPostulacionDAO();
		RegistroPostulacion vo = new RegistroPostulacion();
		
		vo.setIdPostulacion(idPostulacion);
		vo.setFechPostulacion(fechPostulacion);
		vo.setEstadoPostulacion(estadoPostulacion);
		
		return dao.insertar(vo);
}

	
public    Collection<HistorialPostulaciones> obtenerPostulaciones(String idPostulacion) throws DAOExcepcion {
	HistorialPostulacionesDAO dao = new HistorialPostulacionesDAO();
	return dao.obtenerPostulaciones(idPostulacion);
}}