package com.proyecto.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.exception.LoginExcepcion;
import com.proyecto.modelo.consulta_ofertante1;
import com.proyecto.negocio.Gestionusuario;


/**
 * Servlet implementation class servletlogofertante
 */
@WebServlet("/servletlogofertante")
public class servletlogofertante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletlogofertante() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {


		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("contrasena");

		Gestionusuario negocio = new Gestionusuario();

		try {
			consulta_ofertante1 vo = negocio.validarUsuario(usuario, clave);
			
			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);
			
			response.sendRedirect("servletportofertante");
			return;
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error_login.jsp");
			rd.forward(request, response);
		}

	}
	}


