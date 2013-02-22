package com.proyecto.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.negocio.GestionPostulaciones;




/**
 * Servlet implementation class ServletPostulaciones
 */
@WebServlet("/ServletPostulaciones")
public class ServletPostulaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletPostulaciones() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionPostulaciones postulaciones=new GestionPostulaciones();
		try{
			Collection<HistorialPostulaciones> listapostulaciones;
		
			listapostulaciones =postulaciones.listarpostulaciones();
				
				request.setAttribute("postulaciones", listapostulaciones);
			
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/page/postulaciones.jsp");
		rd.forward(request, response);
	}

}
