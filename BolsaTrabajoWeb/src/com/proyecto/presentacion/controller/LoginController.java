package com.proyecto.presentacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

	
	private static Logger logger=LogManager.getLogger(LoginController.class);
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostulanteService postulanteService;
	
	@RequestMapping(value = "/cargarLogin")
	protected ModelAndView logeo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de LoginController");
		logger.info("Dentro de LoginController");
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
		
		String user=request.getParameter("txtUsuarioNuevo");
		String passw=request.getParameter("txtContrasenaNueva");
		String passwvalida=request.getParameter("txtContrasenavalidaNueva");
		System.out.println("user== "+user);
		System.out.println("passw== "+passw);
		System.out.println("passwvalida== "+passwvalida);
		String mensaje="";
		Usuario usuario=new Usuario();
		if(user.equals("")&&passw.equals("")){
			mensaje="ERROR!!!.. "+"los campos faltan llenar";
			System.out.println("Faltan llenar los campos");
			logger.error(mensaje);
		}
		else{
			if(passwvalida.equals(passw)){
				usuario.setNombreUsuario(user);
				usuario.setPasswordUsuario(passw);
				usuario.setIdRol(1);
				
				usuarioService.insertarUsuario(usuario);
				mensaje="el usuario: "+user+"ha sido registrado correctamente";
				//PrintWriter pw=response.getWriter();
				System.out.println(mensaje);
				logger.info(mensaje);
				mv=new ModelAndView("postulante");
				
			}else{
				mensaje="ERROR!!!.. "+user+"No ha sido registrado correctamente";
				System.out.println(mensaje);
				logger.error(mensaje);
				mv=new ModelAndView("mensajeErrorCreacion");
				
			}
		}

		return mv;
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
		logger.info("Dentro de ValidarUsuario");
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
			System.out.println("entro al login del tryyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
			System.out.println(usuario.getNombreUsuario());
			int id=usuarioService.obteneridUsuario(usuario);
		
			System.out.println("ID=="+id);
			postulante=postulanteService.obtenerPostulante(id);
			System.out.println("postulante=="+postulante);
			
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
							//request.setAttribute("usuario",postulante);
							////request.setAttribute("estado",0);
							System.out.println("Entro en Estado=1");
							
							logger.info("entro en la 1ra condiccion del try");
							usuario.setEstado(1);
							
							//mv=new ModelAndView("redirect:index.html","USUARIO",usuario);
							mv=new ModelAndView("inicio","USUARIO",usuario);
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
								System.out.println("Entro en Estado=0");
								HttpSession sesion=request.getSession();
								sesion.setAttribute("IDUsuario", id);
								usuario.setEstado(0);
								logger.info("entro en la 2da condiccion del try");
								mv=new ModelAndView("postulante","USUARIO",usuario);
							}
						}
					}
				}
				else{
					logger.info("enviando a la vista crearusuario");
					mv=new ModelAndView("crearUsuario");
				}
			}		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("fallo al obtener el Postulante: "+postulante);
		}
		return mv;
	}


	public PostulanteService getPostulanteService() {
		return postulanteService;
	}


	public void setPostulanteService(PostulanteService postulanteService) {
		this.postulanteService = postulanteService;
	}
}
