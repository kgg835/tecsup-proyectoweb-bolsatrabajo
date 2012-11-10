<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8">
		<title>Nuevo proyecto con Bootstrap 2.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<meta name="description" content="Bootstrap 2.0">
		<meta name="author" content="">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
		<link href="/BolsaTrabajoWeb/bootstrap/css/bootstrap.css" rel="stylesheet">

		<style type="text/css">
			body { 
				padding-bottom: 40px;
				padding-top: 10px; 
			}
		</style>
		<link href="/BolsaTrabajoWeb/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<link href="/BolsaTrabajoWeb/bootstrap/css/docs.css" rel="stylesheet">
		
		<script src="/BolsaTrabajoWeb/bootstrap/js/jquery.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-transition.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-alert.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-modal.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-dropdown.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-scrollspy.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-tab.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-popover.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-button.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-collapse.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-carousel.js"></script>
		<script src="/BolsaTrabajoWeb/bootstrap/js/bootstrap-typeahead.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				//$('#myusuario').val('');
			});

		</script>
		
</head>
<body><!-- Este es el Body -->

	<div class="container-fluid">
		<table width="100%">
			<tr>
				<td style="width: 246px" width="246">
					<label><h1 style="color: blue;">BolsaTrabajo.com</h1></label>
					<!-- <img src="../bootstrap/img/logo.jpg" width="307" height="40"></td> -->
				<td align="right" style="width: 885px; " width="688">
					<div>
						<button class="btn btn-large" onclick="location.href='cargarLogin.html'">Iniciar Sesion</button>
						<button type="submit" class="btn btn-large btn-primary disabled">Cargar mi CV</button>
					</div>
				</td>
			</tr>
		</table>
		
	<!--  -->
	<div class="row-fluid"> 
		<div class="span3" >
			<form class="well" >
	    		<label><h3>Crear Cuenta</h3></label><br/>
	    		
	    		<label>Email o Nombre de usuario</label>
	    		<input type="text" class="span12" placeholder="Escribe algo?" name="txtUsuarioC"><br/>
	    		<label>Contraseña</label>
	    		<input type="password" class="span12" placeholder="Escribe contraseña" name="txtContrasenaC"><br/>
	    		<label>Vuelve a escribir tu Contraseña</label>
	    		<input type="password" class="span12" placeholder="Escribe contraseña" name="txtContrasenavalida"><br/>
	    		<label class="checkbox">
	    			<input type="checkbox"> Seguir conectado
	    		</label><br/>
	   			<button type="submit" class="btn btn-success btn-large" >Crear Cuenta y Cargar CV</button>
			</form>
			<div class="well">
		
			<label><h3>Areas</h3></label>
			<table>
				<tr>
					<td>
						Administracion
					</td>
				</tr>
				<tr>
					<td>
						Call center
					</td>
				</tr>
				<tr>
					<td>
						Diseño
					</td>
				</tr>
				<tr>
					<td>
						Construccion
					</td>
				</tr>
				<tr>
					<td>
						Educaciion
					</td>
				</tr>
				<tr>
					<td>
						Finanzas
					</td>
				</tr>
			</table>
			</div>
		</div>
		<div class="span9" >
			<form class="well form-search">
				<label><h3> Búsqueda avanzada &nbsp;</h3></label>
				<input class="input-xlarge search-query" type="text">
				<button class="btn btn-large" type="submit">Buscar</button>
			</form>

				<label><h3>Empleos destacados en Lima</h3></label>
			
			<form action=inicio method=post>
			
					
  <%@page import="java.util.*, com.proyecto.modelo.Aviso" %>
<%
Collection<Aviso> avisos = (ArrayList<Aviso>)request.getAttribute("avisos");
int i = 1;
for(Aviso avi : avisos) {
%>  
			<div class="well">
<div class="avisos-list ">
	            	
	            	<div id="titulo-avisos-home">Empleos destacados en <strong>Lima</strong></div>
	            	
                    <a href="mostrar_aviso.html?titulo=<% out.print(avi.getTitulo()); %>" target="_blank" method=post class="aviso_box aviso_listado " title="Gerente de Estaciones Biológicas">
                        <img src="/BolsaTrabajoWeb/bootstrap/img/AVISO.jpg" width="111" height="70" alt="ONG Internacional"/>
                        <div class="aviso_content">
                            <h3><% out.print(avi.getTitulo()); %></h3>
							<h4><% out.print(avi.getDescripcion()); %></h4>                     
 							<div class="aviso-datos">
                                <h5 class="aviso_donde">Distrito de Barranco</h5>  &middot;
                                
                                <span class="aviso-dato">Full-time</span> &middot;
                                
                                <span class="aviso_cuando">Ayer</span>
                                
                            </div>
                        </div>
                        <span class="aviso-badge aviso-nuevo-badge"></span>
                        <span class="aviso-badge aviso-oportunidad-badge"></span>
                    </a>
                    </div>
</div>
</form>
<% }  
   %>




	    </div>	
	</div>
</div>
</body>
</html>