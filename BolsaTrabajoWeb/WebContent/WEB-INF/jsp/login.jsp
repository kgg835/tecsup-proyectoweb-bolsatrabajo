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

	<div class="container">
		<table width="100%">
			<tr>
				<td style="width: 246px" width="246">
					<label><h1 style="color: blue;">BolsaTrabajo.com</h1></label>
					<!-- <img src="../bootstrap/img/logo.jpg" width="307" height="40"></td> -->
				<td align="right" style="width: 885px; " width="688">
					<form>
						<button type="submit" class="btn btn-large disabled">Iniciar Sesion</button>
						<button type="submit" class="btn btn-large btn-primary disabled">Cargar mi CV</button>
					</form>
				</td>
			</tr>
		</table>
		<br><br><br><br><br>
	<!--  -->
	<div class="row"> 
		<div class="span4" >
			<form ></form>
		</div>
		<div class="span4" >
			<form class="well" action="validarUsuario.html" method="post">
	    		<label><h3>Ingresar a bolsaTrabajo.com</h3></label><br/>
	    		<!--span class="help-inline">Texto de ayuda asociado!</span><br/>-->
	    		<label>Email o Nombre de usuario</label>
	    		<input type="text" class="span3" placeholder="Escribe algo?" name="txtUsuario" id="txtUsuario"><br/>
	    		<label>Contraseña</label>
	    		<input type="password" class="span3" placeholder="Escribe contraseña" name="txtContrasena" id="txtContrasena"><br/>
	    		<label class="checkbox">
	    			<input type="checkbox"> Seguir conectado
	    		</label><br/>
	   			<button type="submit" class="btn btn-primary">Iniciar Sesion</button>
	   		</form> 
	    </div>
	    <div class="span4">
	    	<form ></form>
	    </div>	
	</div>
</div>
</body>
</html>