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

import com.proyecto.modelo.Usuario;
import com.proyecto.negocio.service.PostulanteService;
import com.proyecto.negocio.service.UsuarioService;

@Controller
public class LoginController {

	private static Logger logger = LogManager.getLogger(LoginController.class);
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PostulanteService postulanteService;

	@RequestMapping(value = "/cargarLogin")
	protected ModelAndView logeo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("Dentro de LoginController");
		logger.info("Dentro de LoginController");
		// ModelAndView mv = null;

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/insertarUsuario")
	protected ModelAndView insertarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("insertarUsuario");
		ModelAndView mv = null;

		// String u = request.getParameter("txtNuevoUsuario");
		// String p = request.getParameter("txtNuevaContrasena");

		// System.out.println(u);
		// System.out.println(p);

		// try {
		// seguridadService.validar(u, p);
		// mv = new ModelAndView("redirect:portada.html");
		// } catch (LoginExcepcion e) {
		// mv = new ModelAndView("error", "mensaje",
		// "Usuario y/o clave incorrectos");
		// }

		String user = request.getParameter("txtUsuarioNuevo");
		String passw = request.getParameter("txtContrasenaNueva");
		String passwvalida = request.getParameter("txtContrasenavalidaNueva");
		System.out.println("user== " + user);
		System.out.println("passw== " + passw);
		System.out.println("passwvalida== " + passwvalida);
		String mensaje = "";
		Usuario usuario = new Usuario();
		if (user.equals("") && passw.equals("")) {
			mensaje = "ERROR!!!.. " + "los campos faltan llenar";
			System.out.println("Faltan llenar los campos");
			logger.error(mensaje);
		} else {
			if (passwvalida.equals(passw)) {
				usuario.setNombreUsuario(user);
				usuario.setPasswordUsuario(passw);
				usuario.setIdRol(1);

				usuarioService.insertarUsuario(usuario);
				mensaje = "el usuario: " + user
						+ "ha sido registrado correctamente";
				System.out.println(mensaje);
				logger.info(mensaje);
				mv = new ModelAndView("postulante");

			} else {
				mensaje = "ERROR!!!.. " + user
						+ "No ha sido registrado correctamente";
				System.out.println(mensaje);
				logger.error(mensaje);
				mv = new ModelAndView("mensajeErrorCreacion");

			}
		}

		return mv;
	}

	// GET and SET
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	// Para validar el usuario

	@RequestMapping(value = "/validarUsuario")
	protected ModelAndView validarUsuario(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.err.println("Dentro de Validar Usuario");
		logger.info("Dentro de ValidarUsuario");
		ModelAndView mv = null;

		String user = request.getParameter("txtUsuario");
		String passw = request.getParameter("txtContrasena");
		System.err.println("userLOG== " + user);
		System.err.println("passLoG== " + passw);
		Usuario usuario = new Usuario();

		try {
			System.err
					.println("entro al login del tryyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
			System.err.println(usuario.getNombreUsuario());
			usuario = usuarioService.obtenerUsuario(user.trim(), passw.trim());// Obtine
																				// el
																				// id
																				// de
																				// usuario
			logger.info("ID_USUARIO ---> " + usuario.getIdUsuario());
			System.err.println("ID_USUARIO==" + usuario.getIdUsuario());

			if (usuario.getIdUsuario() != 0) {
				String rol = usuarioService.obtenerRol(usuario.getIdRol());// Obtine
																			// el
																			// Rol
																			// del
																			// usuario
				System.err.println("rol==" + rol);
				logger.info("ROL_USUARIO ---> " + rol);
				if (rol.equals("A")) {
					// RequestDispatcher
					// rd=request.getRequestDispatcher("/page/postulante.jsp");
					// rd.forward(request, response);
					logger.info("ROL_USUARIO ---> " + rol);
				} else {
					if (rol.equals("OF")) {
						// RequestDispatcher
						// rd=request.getRequestDispatcher("/page/postulante.jsp");
						// rd.forward(request, response);
						logger.info("ROL_USUARIO ---> " + rol);
					} else {
						if (rol.equals("P")) {
							logger.info("ROL_USUARIO ---> " + rol);
							// PrintWriter out=response.getWriter();
							// out.println(usuario);
							// request.setAttribute("usuario",postulante);
							// //request.setAttribute("estado",0);
							System.err.println("Entro en Estado=1");

							usuario.setEstado(1);
							HttpSession sesion = request.getSession();
							sesion.setAttribute("IDUsuario",
									usuario.getIdUsuario());
							// mv=new
							// ModelAndView("redirect:index.html","USUARIO",usuario);
							logger.info("USUARIO ---> " + usuario);
							mv = new ModelAndView("inicio", "USUARIO", usuario);
						}
					}
				}
			} else {
				logger.info("se redireccionio a:--> redirect:cargarLogin.html");
				mv = new ModelAndView("redirect:cargarLogin.html");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("fallo al obtener el Postulante: "+postulante);
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
