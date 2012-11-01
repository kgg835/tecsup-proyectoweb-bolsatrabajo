package com.proyecto.negocio;

import java.util.Collection;

import com.proyecto.dao.HistorialPostulacionesDAO;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;

public class GestionPostulaciones {

	public Collection<HistorialPostulaciones> listarpostulaciones()
			throws DAOExcepcion {
		HistorialPostulacionesDAO dao = new HistorialPostulacionesDAO();
		return dao.listarpostulaciones();
	}
	
	public HistorialPostulaciones insertar(String tituloAviso, String nombreEmpresa,String fechaPostulacion,String estado)throws DAOExcepcion{
		HistorialPostulacionesDAO dao=new HistorialPostulacionesDAO();
		HistorialPostulaciones vo=new HistorialPostulaciones();
		vo.setTituloAviso(tituloAviso);
		vo.setNombreEmpresa(nombreEmpresa);
		vo.setFechpostulacion(fechaPostulacion);
		vo.setEstado(estado);
				
		return dao.insertar(vo);
		
	}
}
