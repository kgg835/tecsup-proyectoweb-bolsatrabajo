package com.proyecto.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionPostulaciones;



/**
 * Servlet implementation class ServletRegistroPostulacion
 */
@WebServlet("/ServletRegistroPostulacion")
public class ServletRegistroPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletRegistroPostulacion() {
    }
	
    	public void insertarRegistroPostulacion(int idPostulacion,String fechPostulacion,String estadoPostulacion)	 {
    		GestionPostulaciones negocio= new GestionPostulaciones();
    		try{
    			negocio.insertar(idPostulacion, fechPostulacion, estadoPostulacion);

    		}catch(DAOExcepcion e){
    			System.out.println("error");
    		}
    	
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
		
	}

}
