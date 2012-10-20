package com.proyecto.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.RegistroPostulacion;
import com.proyecto.negocio.GestionPostulaciones;



/**
 * Servlet implementation class ServletRegistroPostulacion
 */
@WebServlet("/ServletRegistroPostulacion")
public class ServletHistorialPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletHistorialPostulacion() {
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
String idPostulacion = request.getParameter("id");
		
		GestionPostulaciones historial = new GestionPostulaciones();
//		try {
//			
//			Collection<RegistroPostulacion> o = historial.obtenerRegistroPostulaciones(idPostulacion);
//			Collection<RegistroPostulacion> lista = new ArrayList<RegistroPostulacion>();
//			
//			lista.addAll(o);
//			// Guardar en el ambiente de request
//			request.setAttribute("postulaciones", lista);
//			RequestDispatcher rd = request
//					.getRequestDispatcher("postulaciones.jsp");
//			rd.forward(request, response);
//
//		} catch (DAOExcepcion e) {
//			System.out.println(e.getMessage());
//			//RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//			//rd.forward(request, response);
//		}	
	}

}
