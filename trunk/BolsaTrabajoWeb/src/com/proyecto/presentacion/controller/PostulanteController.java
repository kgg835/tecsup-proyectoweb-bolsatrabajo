package com.proyecto.presentacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.service.PostulanteService;

@Controller
public class PostulanteController {
	private String idusuario;
	
	@Autowired
	private PostulanteService postulanteService;
	

	public void setPostulanteService(PostulanteService postulanteService) {
		this.postulanteService = postulanteService;
	}

	@RequestMapping(value = "/cargarPaginaPostulante")
	protected ModelAndView cargarPaginaPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de PostulanteController");
		System.out.println(request.getAttribute("IDUsuario"));
		setIdusuario((String)request.getAttribute("IDUsuario"));
		System.out.println("idUsuario= "+getIdusuario());
//		try {
//			seguridadService.validar(u, p);
//			mv = new ModelAndView("redirect:portada.html");
//		} catch (LoginExcepcion e) {
//			mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
//		}

		return new ModelAndView("postulante");
	}

	@RequestMapping(value = "/insertarDatosPostulante")
	protected ModelAndView insertarDatosPostulante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Dentro de insertarDatosPostulante");
		ModelAndView mv = null;
		System.out.println("idUsuario== "+request.getAttribute("id"));
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

		postulante.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));


		try {
			 postulanteService.insertarPostulante(postulante);
			//mv = new ModelAndView("redirect:.html");
		} catch (Exception e) {
			System.out.println("error no se inserto El Postulante Exception");
			e.printStackTrace();
			//mv = new ModelAndView("error", "mensaje", "Usuario y/o clave incorrectos");
		}

		return mv=new ModelAndView("postulante");
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
}
