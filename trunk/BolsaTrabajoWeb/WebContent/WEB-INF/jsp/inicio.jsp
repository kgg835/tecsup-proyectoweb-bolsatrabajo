<%@page import="com.proyecto.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8">
		<title>Proyecto con Bootstrap 2.0</title>
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
				ocultarCrearCuenta();
				//alert("esta funcionado jQuery");
				console.log("se esta ejecutando Jquery");
				console.log("");
			});
			function ocultarCrearCuenta(){
				var estadoCrear=${USUARIO.estado}
				//var estadoCrear=${ESTADO}
				console.log("estadoCrear=="+estadoCrear);
				if(estadoCrear==0){
					//jQuery("#mostrarDatos").show();//mostrar
					jQuery("#crearCuenta").show();//ocultar
					console.log("Muestra crear Cuenta");
				}else{
					console.log("Muestra no crear Cuenta");
					if(estadoCrear==1){
						jQuery("#crearCuenta").hide();//mostrar
					}
					
				}
			}
		</script>
		
</head>
<body><!-- Este es el Body -->
	
	
	ESTADO=${USUARIO.estado}
	<div class="container-fluid">
		<table width="100%">
			<tr>
				<td style="width: 246px" width="246">
					<label><h1 style="color: blue;">BolsaTrabajo.com</h1></label>
					<!-- <img src="../bootstrap/img/logo.jpg" width="307" height="40">-->
				</td> 
				<td align="right" style="width: 885px; " width="688">
					<div>
						<button  class="btn btn-large" onclick="location.href='cargarLogin.html'">Iniciar Sesion</button>
						<button type="submit" class="btn btn-large btn-primary disabled">Cargar mi CV</button>
					</div>
				</td>
			</tr>
		</table>
	<!--  -->
	<div class="row-fluid"> 
		<div class="span3" >
		<div id="crearCuenta" style="display:inline;">
			<form class="well" action="insertarUsuario.html" method="post">	
	    		<label><h3>Crear Cuenta</h3></label><br/>
	    		<label>Email o Nombre de usuario</label>
	    		<input type="text" class="span12" placeholder="Escribe algo?" name="txtUsuarioNuevo"><br/>
	    		<label>Contraseña</label>
	    		<input type="password" class="span12" placeholder="Escribe contraseña" name="txtContrasenaNueva"><br/>
	    		<label>Vuelve a escribir tu Contraseña</label>
	    		<input type="password" class="span12" placeholder="Escribe contraseña" name="txtContrasenavalidaNueva"><br/>
	    		<label class="checkbox">
	    			<input type="checkbox"> Seguir conectado
	    		</label><br/>
	   			<button type="submit" class="btn btn-success btn-large" >Crear Cuenta y Cargar CV</button>
			</form>
			</div>
			<div class="well">
			<label><h3>Areas</h3></label>
			<table>
				<tr>
					<td>
						<a>Administracion</a>
							</td>
				</tr>
				<tr>
					<td>
						
					<a>Call center</a>
							</td>
				</tr>
				<tr>
					<td>
						
					<a>Diseño</a>
							</td>
				</tr>
				<tr>
					<td>
						
					<a>Construccion</a>
							</td>
				</tr>
				<tr>
					<td>
						
					<a>Educacion</a>
							</td>
				</tr>
				<tr>
					<td>
						
						<a>Finanzas</a>
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

	    </div>	
	</div>
</div>
</body>
</html>