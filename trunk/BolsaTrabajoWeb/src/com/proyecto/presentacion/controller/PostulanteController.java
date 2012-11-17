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
import com.proyecto.negocio.service.PostulanteService;

@Controller
public class PostulanteController {
	private String idusuario;
	private static Logger logger=LogManager.getLogger(PostulanteController.class); 
	@Autowired
	private PostulanteService postulanteService;
	

	public void setPostulanteService(PostulanteService postulanteService) {
		this.postulanteService = postulanteService;
	}
	//metodo que carga la pagina del Postulante.jsp
	@RequestMapping(value = "/cargarPaginaPostulante")
	protected ModelAndView cargarPaginaPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de PostulanteController");
		System.out.println(request.getAttribute("IDUsuario"));
		setIdusuario((String)request.getAttribute("IDUsuario"));
		HttpSession session= request.getSession();
		Object lista=(Object)session.getAttribute("IDUsuario");
		System.out.println("idUsuario= "+lista.toString());
		logger.info("Dentro de PostulanteController");
//		try {
//			seguridadService.validar(u, p);
//			mv = new ModelAndView("redirect:portada.html");
//		} catch (LoginExcepcion e) {
//			mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
//		}

		return new ModelAndView("postulante");
	}
	//Metodo que inserta los datos personales del usuario o Postulante
	@SuppressWarnings("unused")
	@RequestMapping(value = "/insertarDatosPostulante")
	protected ModelAndView insertarDatosPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = null;
		HttpSession session= request.getSession();
		Object idUsuario=(Object)session.getAttribute("IDUsuario");
//		System.out.println("idUsuario2= "+idUsuario.toString());
		System.out.println("Dentro de insertarDatosPostulante");
		
		Postulante postulante=new Postulante();
//		postulante.setTipoPersona(request.getParameter("Postulante"));
		postulante.setTipoPersona("Postulante");
		System.out.println("tipoPostulante=="+postulante.getTipoPersona());
		postulante.setNombre(request.getParameter("txtNombre"));
		postulante.setApellidos(request.getParameter("txtApellido"));
		
		postulante.setDni(request.getParameter("txtDni"));

		postulante.setEmail(request.getParameter("txtEmail"));
		postulante.setPaisPostulante(request.getParameter("txtPais"));

//		postulante.setDireccion(request.getParameter("txtDireccion"));
		postulante.setDireccion("calle Teresa gonzales de fanning 137");
		postulante.setTelefonoFijo(request.getParameter("txtTelefonoFijo"));
		postulante.setTelefonoCel(request.getParameter("txtTelefonoCel"));
		postulante.setFechaNacimiento(request.getParameter("txtDia") + "/"
				+ request.getParameter("txtMes") + "/"
				+ request.getParameter("txtAnio"));
		if(request.getParameter("txtSexoM").equals(null)){
			postulante.setSexo(request.getParameter("txtSexoF"));
		}
		else{
			postulante.setSexo(request.getParameter("txtSexoM"));
		}
		
		postulante.setEstadoCivil(request.getParameter("txtEstadoCivil"));

		postulante.setIdUsuario(Integer.parseInt(idUsuario.toString()));


		try {
			 postulanteService.insertarPostulante(postulante);
			 logger.info("Se Inserto corretamente el postulante: "+postulante.getNombre());
			//mv = new ModelAndView("redirect:.html");
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
			logger.error("no se pudo Insertar al Postulante: "+postulante.getNombre());
			//mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}

		return mv=new ModelAndView("postulante");
	}
	
	//Metodo que inserta los datos personales del usuario o Postulante
	@SuppressWarnings("unused")
	@RequestMapping(value = "/actualizarDatosPostulante")
	protected ModelAndView actualizarDatosPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = null;
		HttpSession session= request.getSession();
		Object idUsuario=(Object)session.getAttribute("IDUsuario");
		System.out.println("idUsuario2= "+idUsuario.toString());
		System.out.println("Dentro de insertarDatosPostulante");
		
		Postulante postulante=new Postulante();
		postulante.setTipoPersona(request.getParameter("tipoPersona"));
		postulante.setNombre(request.getParameter("txtnombres"));
		postulante.setApellidos(request.getParameter("txtapellidos"));
		
		postulante.setDni(request.getParameter("txtDni"));

		postulante.setEmail(request.getParameter("txtEmail"));
		postulante.setPaisPostulante(request.getParameter("txtPais"));

		postulante.setDireccion(request.getParameter("txtDireccion"));
		postulante.setTelefonoFijo(request.getParameter("txtTelefonoFijo"));
		postulante.setTelefonoCel(request.getParameter("txtTelefonoCel"));
		postulante.setFechaNacimiento(request.getParameter("txtDia") + "/"
				+ request.getParameter("txtMes") + "/"
				+ request.getParameter("txtAnio"));
		postulante.setSexo(request.getParameter("txtSexo"));
		postulante.setEstadoCivil(request.getParameter("txtEstadoCivil"));

		postulante.setIdUsuario(Integer.parseInt(idUsuario.toString()));


		try {
			 postulanteService.actualizarPostulante(postulante);
			//mv = new ModelAndView("redirect:.html");
		} catch (Exception e) {
			System.out.println("error no se actualizo los datos del Postulante Exception");
			e.printStackTrace();
			//mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}

		return mv=new ModelAndView("postulante");
	}
	
	//GET and SET
	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
}
