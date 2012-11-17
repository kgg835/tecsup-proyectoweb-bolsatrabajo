<%@page import="com.proyecto.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Mi Bolsa de Empleo</title>
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
			var activador=${estado};
			
	    	$(document).ready(function(){
		 /*    	if(activador==0){
		    		jQuery("#mostrarDatos").show();
					jQuery("#mostrarResidencia").show();
			    }else{
				    if(activador==1){
				    	jQuery("#datosPersonal").show();
				    	jQuery("#mostrarDatos").hide();
					}
			    	
				    } */
			});
	   		 function ActivaEditar(){
			  jQuery("#datosPersonal").show();
			   $("#mostrarDatos").hide();
			}
			function cerrartabla(){
			  jQuery("#datosPersonal").hide();
			  jQuery("#mostrarDatos").show();
			}
			
/* 			 function ActivaEditarResidencia(){
			  jQuery("#EditarResidencia").show();
			   $("#mostrarResidencia").hide();
			}
			function cerrarResidencia(){
			  jQuery("#EditarResidencia").hide();
			  jQuery("#mostrarResidencia").show();
			} */	
			
	 </script>
	
	

	</head>
	<!-- Este es el Body -->
	<body>
		estado=${USUARIO.estado}
		id_Usuario=${USUARIO.idUsuario}
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
							<li class="active"><a href="http://localhost:8080/BolsaTrabajoWeb/jsp/index.jsp">Inicio</a></li>
							<li><a href="buscarAviso.jsp">Buscar Avisos</a></li>
							<li><a href="postulaciones.jsp">Mis Postulaciones</a></li>
							<li><a href="postulante.jsp">Mi CV</a></li>
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
					<form class="navbar-form well" name="f1" action="insertarDatosPostulante.html" method="post">
						
							
						<div class="span2" style="width:100px; height:100px;" >
							<!--Sidebar content-->
							<img src="/BolsaTrabajoWeb/bootstrap/img/fotoCvGenericaGrande.jpg" class="fotoCvBox" color="green">
						</div>
							
						
						<div class="span8">
							<!--Body content-->
							<div class="container">
								
									
								<div class="navbar">
									<i class=" icon-edit"></i>
									<input name="input" type="button" class="ui-icon-pencil" value="Editar" onClick="ActivaEditar()" >
		
									<input name="inputcerrar" type="button" class="boton" value="Cancelar" onClick="cerrartabla()" >
								</div>
								
							<div id="descripcionDatos" style="display:none" >	
								
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
									<div>
									</div>
									
							  <div id="datosPersonal" >	
								<label>Nombres(s)</label>
								<input name="txtNombre" type="text" class="span3" placeholder="txtnombres"><br>
								<label>Apellido(s)</label>
								<input name="txtApellido" type="text" class="span3" placeholder="txtapellidos"><br>
								<label>E-mail</label>
								<input name="txtEmail" type="text" class="span3" placeholder="hackromanux@gmail.com"><br>


								<label>telefono fijo</label>
								<input name="txtTelefonoFijo" class="span3" type="text" placeholder="fijo"><br>
								<label>telefono celular</label>
								<input name="txtTelefonoCel" class="span3" type="text" placeholder="celular"><br>
			
								<p><label>Nacionalidad</label>
									<select type="combobox" name="txtPais">
										<option selected="" value="">-</option>
										<option value="Argentina">Argentina</option>
										<option value="Brazil">Brazil</option>
										<option value="Bolivia">Bolivia</option>
										<option value="Colombia">Colombia</option>
										<option value="Chile">Chile</option>
										<option value="Ecuador">Ecuador</option>
										<option value="Paraguay">Paraguay</option>
										<option value="Peru">Peru</option>
										<option value="Venezuela">Venezuela</option>
									</select>
								</p>
								<p>
									<label>Tipo y numero de Documento</label>
									<select name="txttipoDocumento">
										<option selected="" value="">-</option>
										<option value="1">Pasaporte</option>
										<option value="2">DNI</option>
									</select>
									<input name="txtDni" type="text" placeholder="....">									
								</p>
								
								<p>
									
											
											<label>Fecha de nacimiento</label>
											
											<select name="txtDia" class="span1"> 
												<option selected="" value="">-</option>
												<option value="1">1</option>
												<option value="2">2</option><option value="3">3</option>
												<option value="4">4</option><option value="5">5</option>
												<option value="6">6</option><option value="7">7</option>
												<option value="8">8</option><option value="9">9</option>
												<option value="10">10</option><option value="11">11</option>
												<option value="12">12</option><option value="13">13</option>
												<option value="14">14</option><option value="15">15</option>
												<option value="16">16</option><option value="17">17</option>
												<option value="18">18</option><option value="19">19</option>
												<option value="20">20</option><option value="21">21</option>
												<option value="22">22</option><option value="23">23</option>
												<option value="24">24</option><option value="25">25</option>
												<option value="26">26</option><option value="27">27</option>
												<option value="28">28</option><option value="29">29</option>
												<option value="30">30</option><option value="31">31</option>

											</select>	
											
											<select name="txtMes" type="combobox" class="span2">
												<option selected="" value="">-</option>
												<option value="01">Enero</option>
												<option value="02">Febrero</option>
												<option value="03">Marzo</option>
												<option value="04">Abril</option>
												<option value="05">Mayo</option>
												<option value="06">Junio</option>
												<option value="07">Julio</option>
												<option value="08">Agosto</option>
												<option value="09">Septiembre</option>
												<option value="10">Octubre</option>
												<option value="11">Noviembre</option>
												<option value="12">Diciembre</option>
											</select>
								

											<select name="txtAnio"  class="span1">
												<option selected="" value="">-</option>
												<option value="2006">2006</option>
												<option value="2007">2007</option>
												<option value="2008">2008</option>
												<option value="2009">2009</option>
												<option value="2010">2010</option>
												<option value="2011">2011</option>
												<option value="2012">2012</option>
											</select>
										
								</p>
									
									
									
								<div class="control-group">
									<label>Sexo</label>
								
									<input  type="radio" name="txtSexoM" value="M" >
									<span>Masculino</span>
									<br>
									<input type="radio" name="txtSexoF" value="F">
									<span>Femenino</span>
									<br>
								</div>
								<br><br>
								<p>
									<label>Estado civil</label>
									<select name="txtEstadoCivil" class="span2">
										<option selected="" value="">-</option>
										<option value="Viudo/a">Viudo/a</option>
										<option value="Unión Libre">Unión Libre</option>
										<option value="Casado/a">Casado/a</option>
										<option value="Soltero/a">Soltero/a</option>
										<option value="Divorciado/a">Divorciado/a</option>
										<option value="Pareja de Hecho">Pareja de Hecho</option>
									</select>
								</p>
								<br/>
								
								<div >
								
									<button class="btn btn-primary" type="submit">Guardar datos personales</button>
									<button class="btn">Cancelar</button>
								</div>
							</div>													
							</div><!--Residencia  -->
							<br>
							<br>
						<div id="Residencia" style="display: none;">
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