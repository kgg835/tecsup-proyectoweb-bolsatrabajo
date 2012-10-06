package com.proyecto.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.Gestionofertante;

/**
 * Servlet implementation class Servletofertante
 */
@WebServlet("/Servletofertante")
public class Servletofertante extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

    /**
     * Default constructor. 
     */
    public Servletofertante() {
        // TODO Auto-generated constructor stub
    }
    //metodos base de datos
    public void insertarofertante(String ruc,String rs,String correo,String descripcion,String usuario,String password){
		Gestionofertante negocio= new Gestionofertante();
		try{
			negocio.insertar(ruc,rs,correo,descripcion,usuario,password);
			System.out.println("Sus datos fueron registrados correctamente");

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
		String ruc=request.getParameter("ruc");
		String rasonsocial=request.getParameter("rasonsocial");
		String correo=request.getParameter("correo");
		String descempresa=request.getParameter("descripcion");
		String usuario=request.getParameter("correo");
		String password=request.getParameter("password");
		insertarofertante(ruc,rasonsocial,correo,descempresa,usuario,password);
	
		
	}
	

}
