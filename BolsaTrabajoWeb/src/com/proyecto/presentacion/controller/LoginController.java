package com.proyecto.presentacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.service.PostulanteService;
import com.proyecto.negocio.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostulanteService postulanteService;
	
	@RequestMapping(value = "/cargarLogin")
	protected ModelAndView logeo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de LoginController");
		//ModelAndView mv = null;

		return new ModelAndView("login");
	}

	
	@RequestMapping(value = "/insertarUsuario")
	protected ModelAndView insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("insertarUsuario");
		ModelAndView mv = null;
		

//		String u = request.getParameter("txtNuevoUsuario");
//		String p = request.getParameter("txtNuevaContrasena");
	
//		System.out.println(u);
//		System.out.println(p);

//		try {
//			seguridadService.validar(u, p);
//			mv = new ModelAndView("redirect:portada.html");
//		} catch (LoginExcepcion e) {
//			mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
//		}
		
		String user=request.getParameter("txtNuevoUsuario");
		String passw=request.getParameter("txtNuevaContrasena");
		String passwvalida=request.getParameter("txtNuevaContrasenavalidar");
		System.out.println("user== "+user);
		System.out.println("passw== "+passw);
		System.out.println("passwvalida== "+passwvalida);
		String mensaje="";
		Usuario usuario=new Usuario();
		if(user.equals("")&&passw.equals("")){
			mensaje="ERROR!!!.. "+"los campos faltan llenar";
			System.out.println("Faltan llenar los campos");
		}
		else{
			if(passwvalida.equals(passw)){
				usuario.setNombreUsuario(user);
				usuario.setPasswordUsuario(passw);
				usuario.setIdRol(3);
				
				usuarioService.insertarUsuario(usuario);
				mensaje="el usuario: "+user+"ha sido registrado correctamente";
				//PrintWriter pw=response.getWriter();
				System.out.println(mensaje);
				
				mv=new ModelAndView("postulante");
				
			}else{
				mensaje="ERROR!!!.. "+user+"No ha sido registrado correctamente";
				System.out.println(mensaje);
				mv=new ModelAndView("mensajeErrorCreacion");
				
			}
		}

		return mv;//new ModelAndView("postulante");
	}
	
	
	//GET and SET
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	//Para validar el usuario

	@RequestMapping(value = "/validarUsuario")
	protected ModelAndView validarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de Validar Usuario");
		ModelAndView mv = null;
		
		String user=request.getParameter("txtUsuario");
		String passw=request.getParameter("txtContrasena");
		System.out.println("userLOG== "+user);
		System.out.println("passLoG== "+passw);
		Usuario usuario=new Usuario();
		Postulante postulante=new Postulante();
		usuario.setNombreUsuario(request.getParameter("txtUsuario"));
		usuario.setPasswordUsuario(request.getParameter("txtContrasena"));
//		GestionLogin negocio=new GestionLogin();
//		GestionPostulante negocioP=new GestionPostulante();
		try {
			System.out.println("entro al login del try");
			int id=usuarioService.obteneridUsuario(usuario);
		//	postulante=postulanteService.obtenerPostulante(id);
			System.out.println("id1= "+id);
			System.out.println("PostulanteID1== "+postulante.getIdPostulante());
			if(id!=0 && postulante.getIdPostulante() !=0){
				System.out.println("id=="+id);
				
				String rol=usuarioService.obtenerRol(id);
				System.out.println("rol=="+rol);
				
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
							mv=new ModelAndView("postulante");
						}
					}
				}
			}else{
				if(id!=0 && postulante.getIdPostulante()==0){
					System.out.println("id2=="+id);
					System.out.println("postulante2=="+postulante.getIdPostulante());
					String rol=usuarioService.obtenerRol(id);
					
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
								mv=new ModelAndView("redirect:cargarPaginaPostulante.html","IDUsuario",id);
							}
						}
					}
				}
				else{
					mv=new ModelAndView("crearUsuario");
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}


}
