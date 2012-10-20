package com.proyecto.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.GestionLogin;

/**
 * Servlet implementation class ServletCrearCuenta
 */
@WebServlet("/ServletCrearUsuario")
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearUsuario() {
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
		String user=request.getParameter("txtUsuarioC");
		String passw=request.getParameter("txtContrasenaC");
		String passwvalida=request.getParameter("txtContrasenavalida");
		System.out.println("user== "+user);
		System.out.println("passw== "+passw);
		System.out.println("passwvalida== "+passwvalida);
		String mensaje="";
		Usuario usuario=new Usuario();
		try {
			if(passwvalida.equals(passw)){
				usuario.setNombreUsuario(user);
				usuario.setPasswordUsuario(passw);
				usuario.setIdRol(2);
				GestionLogin negocio=new GestionLogin();
				negocio.insertarUsuario(usuario);
				mensaje="el usuario: "+user+"ha sido registrado correctamente";
				PrintWriter pw=response.getWriter();
				pw.println(mensaje);
				
				RequestDispatcher rd=request.getRequestDispatcher("/page/mensajeCreacion.jsp");
				rd.forward(request, response);
			}else{
				mensaje="ERROR!!!.. "+user+"No ha sido registrado correctamente";
				PrintWriter pw=response.getWriter();
				pw.println(mensaje);
				RequestDispatcher rd=request.getRequestDispatcher("/page/mensajeErrorCreacion.jsp");
				rd.forward(request, response);
			}
		} catch (DAOExcepcion e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

}
