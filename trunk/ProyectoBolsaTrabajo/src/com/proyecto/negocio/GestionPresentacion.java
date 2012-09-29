/**
 * 
 */
package com.proyecto.negocio;

import com.proyecto.dao.PresentacionDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Presentacion;


/**
 * @author alumno
 *
 */
public class GestionPresentacion {

	public Presentacion insertar(String descripcionPres)
			throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();

		Presentacion vo = new Presentacion();
		vo.setDescripcionPres(descripcionPres);
				
		return dao.insertar(vo);
	}

	public Presentacion obtener(int idCategoria) throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		return dao.obtener(idCategoria);
	}

	public void eliminar(int idPresentacion) throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		dao.eliminar(idPresentacion);
	}

	public Presentacion actualizar(int idPresentacion, String descripcionPres) throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();

		Presentacion vo = new Presentacion();
		vo.setIdPresentacion(idPresentacion);
		vo.setDescripcionPres(descripcionPres);

		return dao.actualizar(vo);
	}
}
