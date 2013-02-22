package com.proyecto.servlets;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionAviso;

/**
 * Servlet implementation class servletaviso
 */
@WebServlet("/servletaviso")
public class servletaviso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void insertaraviso(int idofertante,int idpuesto,String tituloaviso){
		GestionAviso negocio= new GestionAviso();
		try{
			GregorianCalendar gc=new GregorianCalendar(2012,9,10);
			GregorianCalendar gc1=new GregorianCalendar(2012,10,10);
			negocio.insertar(idofertante,idpuesto,tituloaviso, gc.getTime(), gc1.getTime());


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
	
    public servletaviso() {
        super();
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
		// TODO Auto-generated method stub
		String titulo=request.getParameter("titulo");
		String desc_area=request.getParameter("descripcionarea");
		String des_trabajo=request.getParameter("descripcion");
		String area=request.getParameter("area");
		int codarea=0;
		if(area.equalsIgnoreCase("INGENIERIA"))
		{
			codarea=1;
		}
		else if(area.equalsIgnoreCase("CONTABILIDAD"))
		{
			codarea=2;
		}
		
		insertaraviso(4,codarea,titulo);
	
	}

}
