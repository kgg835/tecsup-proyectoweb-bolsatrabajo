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

import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.GestionLogin;
import com.proyecto.negocio.GestionPostulaciones;
import com.proyecto.negocio.GestionPostulante;

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
		System.out.println("userLOG== "+user);
		System.out.println("passLoG== "+passw);
		Usuario usuario=new Usuario();
		Postulante postulante=new Postulante();
		usuario.setNombreUsuario(request.getParameter("txtUsuario"));
		usuario.setPasswordUsuario(request.getParameter("txtContrasena"));
		GestionLogin negocio=new GestionLogin();
		GestionPostulante negocioP=new GestionPostulante();
		try {
			System.out.println("entro al login del try");
			int id=negocio.obteneridUsuario(usuario);
			postulante=negocioP.obtenerPostulante(id);
			System.out.println("id1=0 "+id);
			System.out.println("PostulanteID1== "+postulante.getIdPostulante());
			if(id!=0 && postulante.getIdPostulante() !=0){
				System.out.println("id=="+id);
				
				String rol=negocio.obtenerRol(id);
				
				if(rol.equals("A")){
					//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
					//rd.forward(request, response);
				}else{
					if(rol.equals("OF")){
						//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
						//rd.forward(request, response);
					}else{
						if(rol.equals("P")){
							//PrintWriter out=response.getWriter();
							//out.println(usuario);
							request.setAttribute("usuario",postulante);
							request.setAttribute("estado",0);
							System.out.println("Entro en Estado=0");
							RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
							rd.forward(request, response);
						}
					}
				}
			}else{
				if(id!=0 && postulante.getIdPostulante()==0){
					System.out.println("id2=="+id);
					System.out.println("postulante2=="+postulante.getIdPostulante());
					String rol=negocio.obtenerRol(id);
					
					if(rol.equals("A")){
						//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
						//rd.forward(request, response);
					}else{
						if(rol.equals("OF")){
							//RequestDispatcher rd=request.getRequestDispatcher("/page/postulante.jsp");
							//rd.forward(request, response);
						}else{
							if(rol.equals("P")){
								//PrintWriter out=response.getWriter();
								//out.println(usuario);
								request.setAttribute("estado",1);
								request.setAttribute("IDUsuario",id);
								System.out.println("Entro en Estado=1");
								RequestDispatcher rd=request.getRequestDispatcher("page/postulante.jsp");
								rd.forward(request, response);
							}
						}
					}
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("/page/crearUsuario.jsp");
					rd.forward(request, response);
				}
//				RequestDispatcher rd=request.getRequestDispatcher("/page/error.jsp");
//				rd.forward(request, response);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
//		JSONObject json = new JSONObject();
//		System.out.println("user=="+user);
//		System.out.println("password=="+passw);
//		json.put("usuario",user);
//		response.setContentType("text/plain");
//        PrintWriter output = response.getWriter();
//	
//		output.println(json);
	}
	
	
}
