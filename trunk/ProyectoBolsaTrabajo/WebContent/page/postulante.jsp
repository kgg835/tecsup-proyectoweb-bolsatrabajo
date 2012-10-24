<%@page import="com.proyecto.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
		<link href="/ProyectoBolsaTrabajo//bootstrap/css/bootstrap.css" rel="stylesheet">

		<style type="text/css">
			body { 
				padding-bottom: 40px;
				padding-top: 10px; 
			}
		</style>
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/docs.css" rel="stylesheet">
		
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/jquery.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-transition.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-alert.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-modal.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-dropdown.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-scrollspy.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-tab.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-popover.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-button.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-collapse.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-carousel.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-typeahead.js"></script>
		
		<script type="text/javascript">
			var activador=${estado};
			
	    	$(document).ready(function(){
		    	if(activador==0){
		    		jQuery("#mostrarDatos").show();
					jQuery("#mostrarResidencia").show();
			    }else{
				    if(activador==1){
				    	jQuery("#datosPersonal").show();
				    	jQuery("#mostrarDatos").hide();
					}
			    	
				    }
			});
	   		 function ActivaEditar(){
			  jQuery("#datosPersonal").show();
			   $("#mostrarDatos").hide();
			}
			function cerrartabla(){
			  jQuery("#datosPersonal").hide();
			  jQuery("#mostrarDatos").show();
			}
			
			 function ActivaEditarResidencia(){
			  jQuery("#EditarResidencia").show();
			   $("#mostrarResidencia").hide();
			}
			function cerrarResidencia(){
			  jQuery("#EditarResidencia").hide();
			  jQuery("#mostrarResidencia").show();
			}	
	 </script>
	
	

	</head>
	<!-- Este es el Body -->
	<body>

		<!-- Este es la parte del cuepo-->
		
		<div class="container">
			<div class="navbar navbar-inner">
				<div class="navbar-inner">
					<div class="container">
						 <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            					<span class="icon-bar"></span>
            					<span class="icon-bar"></span>
           	 					<span class="icon-bar"></span>
          				</a>
						<a class="brand" href="#">Bolsa de Empleo</a>
						<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="active"><a href="http://localhost:8080/ProyectoBolsaTrabajo/page/inicio.jsp">Inicio</a></li>
							<li><a href="#bio">Buscar Avisos</a></li>
							<li><a href="#bio">Mis Postulaciones</a></li>
							<li><a href="#contacto">Mi CV</a></li>
							<li><a href="#bio">Herramientas</a></li>
						</ul>
						</div>
					</div>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="row-fluid">
						<div class="span12">
							<h2>Registro de Postulante</h2>
						</div>
					</div>
					<div class="row-fluid">
						<div class="alert alert-info">
						<p>
							<strong>Bienvenido a Bolsa de trabajo,por favor completa tu datos personales</strong>
						</p>
						</div>
					</div>
					<br>
					<!-- EL FORMULARIO -->
					<form class="navbar-form well" name="f1" action="/ProyectoBolsaTrabajo/ServletPostulante" method="post">
						
							
						<div class="span2" style="width:100px; height:100px;" >
							<!--Sidebar content-->
							<img src="/ProyectoBolsaTrabajo/bootstrap/img/fotoCvGenericaGrande.jpg" class="fotoCvBox" color="green">
						</div>
							
						
						<div class="span8">
							<!--Body content-->
							<div class="container">
								
									
								<div class="navbar">
									<i class=" icon-edit"></i>
									<input name="input" type="button" class="ui-icon-pencil" value="Editar" onClick="ActivaEditar()" >
		
									<input name="inputcerrar" type="button" class="boton" value="Cancelar" onClick="cerrartabla()" >
								</div>
								
							<div id="descripcionDatos" >	
								
										<div id="mostrarDatos">
											<table >
												<tr>
													<td><output><h4>${usuario.nombre} ${usuario.apellidos}</h4></output></td>
												</tr>
												<tr>
													<td><output>${usuario.fechaNacimiento}</output></td>
												</tr>
												<tr>
													<td><output>${usuario.estadoCivil}</output></td>
												</tr>
												<tr>
													<td><output>Documento ${usuario.dni}</output></td>
												</tr>
												<tr>
													<td><output>casa ${usuario.telefonoFijo}</output></td>
												</tr>
												<tr>
													<td><output>Movil ${usuario.telefonoCel}</output></td>
												</tr>
												<tr>
													<td><output>${usuario.email}</output></td>
												</tr>
											</table>
										</div>
									
									</div>
									<div class="navbar" style="display:none">
										<button class="btn btn-primary" type="submit">Guardar datos personales</button>
									</div>
									
							  <div id="datosPersonal" style="display:none;">	
								<label>Nombres(s)</label>
								<input name="txtNombre" type="text" class="span3" placeholder="nombres"><br>
								<label>Apellido(s)</label>
								<input name="txtApellido" type="text" class="span3" placeholder="apellidos"><br>
								<label>E-mail</label>
								<input name="txtEmail" type="text" class="span3" placeholder="hackromanux@gmail.com"><br>


								<label>telefono fijo</label>
								<input name="txtTelefonoFijo" class="span3" type="text" placeholder="fijo"><br>
								<label>telefono celular</label>
								<input name="txtTelefonoCel" class="span3" type="text" placeholder="celular"><br>
			
								<p><label>Nacionalidad</label>
									<select type="combobox">
										<option selected="" value="">-</option>
										<option value="AR">Argentina</option>
										<option value="BR">Brazil</option>
										<option value="BO">Bolivia</option>
										<option value="CO">Colombia</option>
										<option value="CH">Chile</option>
										<option value="EC">Ecuador</option>
										<option value="PA">Paraguay</option>
										<option value="PE">Peru</option>
										<option value="VE">Venezuela</option>
									</select>
								</p>
								<p>
									<label>Tipo y numero de Documento</label>
									<select >
										<option selected="" value="">-</option>
										<option value="PA">Pasaporte</option>
										<option value="DN">DNI</option>
									</select>
									<input name="txtDni" type="text" placeholder="....">									
								</p>
								<p>
									
										
											<label>Fecha de nacimiento</label>
											<select name="txtDia" class="span1"> 
												<option selected="" value="">-</option>
												<option value="1">1</option>

											</select>	
										
										
											<select name="txtMes" type="combobox" class="span2">
												<option selected="" value="">-</option>
												<option value="1">Enero</option>
												<option value="2">Febrero</option>
												<option value="3">Marzo</option>
												<option value="4">Abril</option>
												<option value="5">Mayo</option>
												<option value="6">Junio</option>
												<option value="7">Julio</option>
												<option value="8">Agosto</option>
												<option value="9">Septiembre</option>
												<option value="10">Octubre</option>
												<option value="11">Noviembre</option>
												<option value="12">Diciembre</option>
											</select>
								

											<select name="txtAnio"  class="span1">
												<option selected="" value="">-</option>
												<option value="01">2006</option>
												<option value="02">2007</option>
												<option value="03">2008</option>
												<option value="04">2009</option>
												<option value="05">2010</option>
												<option value="06">2011</option>
												<option value="07">2012</option>
											</select>
								</p>	
									</br>
									
								<div class="control-group">
									<label>Sexo</label>
									<br>
									<input  type="radio" name="txtSexo" value="M" >
									<span>Masculino</span>
									<br>
									<input type="radio" name="txtSexo" value="F">
									<span>Femenino</span>
									<br>
								</div>
								<br><br>
								<p>
									<label>Estado civil</label>
									<select name="txtEstadoCivil" class="span2">
										<option selected="" value="">-</option>
										<option value="1">Viudo/a</option>
										<option value="2">Unión Libre</option>
										<option value="3">Casado/a</option>
										<option value="4">Soltero/a</option>
										<option value="5">Divorciado/a</option>
										<option value="6">Pareja de Hecho</option>
									</select>
								</p>
								<br/>
								<div class="navbar">
									<button class="btn btn-primary" type="submit">Guardar datos personales</button>
									<button class="btn">Cancelar</button>
								</div>
							</div>													
							</div><!--Residencia  -->
							<br>
							<br>
						<div id="Residencia">
							<h4>Lugar de Residencia</h4>	
							<div >
								<i class=" icon-edit"></i>
								<input name="input" type="button" class="btn btn-primary" value="Editar" onClick="ActivaEditarResidencia()" >
								<input name="inputcerrar" type="button" class="btn" value="Cancelar" onClick="cerrarResidencia()" >
							</div>
							<br/>
							<div id="EditarResidencia" style="display: none;">
								<label>Direccion</label>
								<input type="text" name="direccion" class="span4">
								<br>
								<br/>
								<div style="display: none;">
									<input type="text" value="${IDUsuario}" name="usuarioID">
								</div>
								<div class="navbar" >
									<button class="btn btn-primary" type="submit">Guardar Residencia</button>
									<button class="btn">Cancelar</button>
								</div>
							</div>
							<div id="mostrarResidencia">
								<output>calle Trinitaria 281 El Agustino</output>
							</div>
		
						</div>
						</div><!--Residencia fin -->
						<br>
					
					</form>
				</div>
			
		</div><br>	
		<footer>
        <p>&copy; Anderson Company 2012</p>
      </footer>
		</div>
	
		
			
	</body>
</html>