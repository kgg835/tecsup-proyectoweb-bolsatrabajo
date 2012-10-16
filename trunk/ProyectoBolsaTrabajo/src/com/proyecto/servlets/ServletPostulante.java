package com.proyecto.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.GestionPostulante;

/**
 * Servlet implementation class ServletPostulante
 */
@WebServlet("/ServletPostulante")
public class ServletPostulante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPostulante() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		try {
////			GestionPostulante negocio = new GestionPostulante();
//			Postulante postulante = new Postulante();
//			postulante.setTipoPersona("Postulante");
//			postulante.setNombre(request.getParameter("txtNombre"));
//			postulante.setApellidos(request.getParameter("txtApellido"));
//			postulante.setDni(request.getParameter("txtDni"));
//			postulante.setCodPostulante("000000");
//			postulante.setPasswordPE("123456");
//			postulante.setEmail(request.getParameter("txtEmail"));
//			postulante.setPaisPostulante(request.getParameter("txtPais"));
//			postulante.setProvinciaPostulante(request
//					.getParameter("txtProvincia"));
//			postulante.setCiudadPostulante(request.getParameter("txtCuidad"));
//			postulante.setDireccion(request.getParameter("txtDireccion"));
//			postulante.setTelefonoFijo(request.getParameter("txtTelefonoFijo"));
//			postulante.setTelefonoCel(request.getParameter("txtTelefonoCel"));
//			postulante.setFechaNacimiento(request.getParameter("txtDia") + "/"
//					+ request.getParameter("txtMes") + "/"
//					+ request.getParameter("txtAnio"));
//			postulante.setSexo(request.getParameter("txtSexo"));
//			postulante.setEstadoCivil(request.getParameter("txtEstadoCivil"));
//			postulante.setIdPresentacion(1);
//			postulante.setIdPreferencia_Salarial(1);
//			negocio.insertarPostulante(postulante);
//
//			RequestDispatcher rd = request
//					.getRequestDispatcher("postulante.jsp");
//			rd.forward(request, response);
//		} catch (DAOExcepcion e) {
//			e.printStackTrace();
//		}
		String postulante=request.getParameter("postulante");
		if(postulante!=null && postulante!=""){
			RequestDispatcher rd = request.getRequestDispatcher("postulante.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("error_postulante.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
