package com.proyecto.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.GestionLogin;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		
		//json.put("verdad", true);
		
		String user=request.getParameter("txtUsuario");
		String passw=request.getParameter("txtContrasena");
//		Usuario usuario=new Usuario();
//		usuario.setNombreUsuario(request.getParameter("txtUsuario"));
//		usuario.setPasswordUsuario(request.getParameter("txtContrasena"));
//		GestionLogin negocio=new GestionLogin();
//		try {
//			int id=negocio.obteneridUsuario(usuario);
//			if(id!=0){
//				System.out.println("id=="+id);
//				String rol=negocio.obtenerRol(id);
//				
//				if(rol.equals("A")){
//					//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
//					//rd.forward(request, response);
//				}else{
//					if(rol.equals("OF")){
//						//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
//						//rd.forward(request, response);
//					}else{
//						if(rol.equals("P")){
//							RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
//							rd.forward(request, response);
//						}
//					}
//				}
//			}else{
//				RequestDispatcher rd=request.getRequestDispatcher("/page/error.jsp");
//				rd.forward(request, response);
//			}		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		JSONObject json = new JSONObject();
		System.out.println("user=="+user);
		System.out.println("password=="+passw);
		json.put("usuario",user);
		response.setContentType("text/plain");
        PrintWriter output = response.getWriter();
	
		output.println(json);
	}
	
	
}
