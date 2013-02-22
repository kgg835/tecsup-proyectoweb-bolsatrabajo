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
		
		ModelAndView mv=null;
		System.err.println("Dentro de PostulanteController");
		System.err.println(request.getAttribute("IDUsuario"));
		setIdusuario((String)request.getAttribute("IDUsuario"));
		HttpSession session= request.getSession();
		Object lista=(Object)session.getAttribute("IDUsuario");
		
		Integer estadopos=1;
		session.setAttribute("ESTADOPOS",estadopos);
		System.err.println("idUsuarioooooooo= "+lista.toString());
	
		logger.info("Dentro de PostulanteController");
		try {
			Postulante postulante=postulanteService.obtenerPostulante(Integer.parseInt(lista.toString()));
			if(postulante.getIdPostulante()!=0){
				System.err.println("Pagina--> actualizarDatosPostulante.jsp");
				session.setAttribute("idPostulante",postulante.getIdPostulante());
				mv= new ModelAndView("actualizarPostulante","POSTULANTE",postulante);
			}
			else{
				System.err.println("Pagina--> postulante.jsp");
				mv= new ModelAndView("postulante");
			}
			
		} catch (Exception e) {
			logger.error("no se pude obtener data del Postulante"+postulanteService.obtenerPostulante(Integer.parseInt(lista.toString())));
		}
		return mv;
	}
	//Metodo que inserta los datos personales del usuario o Postulante
	@SuppressWarnings("unused")
	@RequestMapping(value = "/insertarDatosPostulante")
	protected ModelAndView insertarDatosPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = null;
		HttpSession session= request.getSession();
		Object idUsuario=(Object)session.getAttribute("IDUsuario");
		System.err.println("Dentro de insertarDatosPostulante");		
		Postulante postulante=new Postulante();
		postulante.setTipoPersona("Postulante");
		System.err.println("tipoPostulante=="+postulante.getTipoPersona());
		postulante.setNombrePersona(request.getParameter("txtNombre"));
		postulante.setApellidosPersona(request.getParameter("txtApellido"));
		
		postulante.setDni(request.getParameter("txtDni"));

		postulante.setEmail(request.getParameter("txtEmail"));
		postulante.setPaisPostulante(request.getParameter("txtPais"));
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
			 logger.info("Se Inserto corretamente el postulante: "+postulante.getNombrePersona());
			//mv = new ModelAndView("redirect:cargarPaginaPostulante.html");
		} catch (Exception e) {
			System.err.println("");
			e.printStackTrace();
			logger.error("no se pudo Insertar al Postulante: "+postulante.getNombrePersona());
			//mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}

		return mv=new ModelAndView("postulante");
	}
	
	//Metodo que inserta los datos personales del usuario o Postulante
	@SuppressWarnings("unused")
	@RequestMapping(value = "/actualizarDatosPostulante")
	protected ModelAndView actualizarDatosPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = null;
		System.err.println("/actualizarDatosPostulante.html");
		HttpSession session= request.getSession();
		Object idUsuario=(Object)session.getAttribute("IDUsuario");
		Object idpostulante=(Object)session.getAttribute("idPostulante");
		System.err.println("idUsuario2= "+idUsuario.toString());
		System.err.println("idPostulante2== "+idpostulante.toString());
		Postulante postulante=new Postulante();
		postulante.setIdPostulante(Integer.parseInt(idpostulante.toString()));
		postulante.setTipoPersona("Postulante");
		postulante.setNombrePersona(request.getParameter("txtNombre"));
		postulante.setApellidosPersona(request.getParameter("txtApellido"));
		
		postulante.setDni(request.getParameter("txtDni"));

		postulante.setEmail(request.getParameter("txtEmail"));
		postulante.setPaisPostulante(request.getParameter("txtPais"));
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
		System.err.println("ID_USUARIO== "+postulante.getIdUsuario());

		try {
			 postulanteService.actualizarPostulante(postulante);
			 logger.info("Se Actualizo corretamente el postulante: "+postulanteService.actualizarPostulante(postulante));
		} catch (Exception e) {
			System.err.println("error no se actualizo los datos del Postulante Exception");
			e.printStackTrace();
		}

		return mv=new ModelAndView("redirect:cargarPaginaPostulante.html");
	}
	
	//GET and SET
	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
}
