package com.proyecto.presentacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.exception.LoginExcepcion;
import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/cargarLogin")
	protected ModelAndView logeo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de LoginController");
		//ModelAndView mv = null;

		return new ModelAndView("crearUsuario");
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

}
