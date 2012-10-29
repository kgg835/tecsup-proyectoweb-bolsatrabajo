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
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/bootstrap.css" rel="stylesheet">

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
</head>
<body><!-- Este es el Body -->

	<div class="container">
		<table width="100%">
			<tr>
				<td style="width: 246px" width="246">
					<label><h3 style="color: blue;">bolsaTrabajo.com</h3></label>
					<!-- <img src="/ProyectoBolsaTrabajo/bootstrap/img/logo.jpg" width="307" height="40"></td> -->
				<td align="right" style="width: 885px; " width="688">
					<form>
						<button type="submit" class="btn btn-large">Iniciar Sesion</button>
						<button type="submit" class="btn btn-large btn-primary">Cargar mi CV</button>
					</form>
				</td>
			</tr>
		</table>
		<br/><br/><br/><br/>
	<!--  -->
	<div class="row"> 
		<div class="span4" >
			<form ></form>
		</div>
		<div class="span4" >
			<form class="well" action="/ProyectoBolsaTrabajo/ServletCrearUsuario" method="post">
	    		<label><h3>Crear Cuenta para bolsaTrabajo.com</h3></label><br/>
	    		<!--span class="help-inline">Texto de ayuda asociado!</span><br/>-->
	    		<label>Email o Nombre de usuario</label>
	    		<input type="text" class="span3" placeholder="Escribe algo?" name="txtUsuarioC"><br/>
	    		<label>Contraseña</label>
	    		<input type="password" class="span3" placeholder="Escribe contraseña" name="txtContrasenaC"><br/>
	    		<label>Vuelve a escribir tu Contraseña</label>
	    		<input type="password" class="span3" placeholder="Escribe contraseña" name="txtContrasenavalida"><br/>
	    		<label class="checkbox">
	    			<input type="checkbox"> Seguir conectado
	    		</label><br/>
	   			<button type="submit" class="btn btn-success" >Crear Usuario</button>
	   		</form> 
	    </div>
	    <div class="span4">
	    	<form >
	    	</form>
	    </div>
	       	
	</div>
</div>
</body>
</html>