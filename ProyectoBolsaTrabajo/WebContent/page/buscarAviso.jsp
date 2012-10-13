<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
     <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
	
<!--------------ESTILOS-------------------------------------------------->
		<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
		
		<style type="text/css">
			body { 
				padding-bottom: 40px;
				padding-top: 10px; 
			}
		</style>
	<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../bootstrap/css/docs.css" rel="stylesheet">
	
	 <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
    <script src="../bootstrap/js/jquery.js"></script>
		<script src="../bootstrap/js/bootstrap.js"></script>
		<script src="../bootstrap/js/bootstrap-transition.js"></script>
		<script src="../bootstrap/js/bootstrap-alert.js"></script>
		<script src="../bootstrap/js/bootstrap-modal.js"></script>
		<script src="../bootstrap/js/bootstrap-dropdown.js"></script>
		<script src="../bootstrap/js/bootstrap-scrollspy.js"></script>
		<script src="../bootstrap/js/bootstrap-tab.js"></script>
		<script src="../bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="../bootstrap/js/bootstrap-popover.js"></script>
		<script src="../bootstrap/js/bootstrap-button.js"></script>
		<script src="../bootstrap/js/bootstrap-collapse.js"></script>
		<script src="../bootstrap/js/bootstrap-carousel.js"></script>
		<script src="../bootstrap/js/bootstrap-typeahead.js"></script>
</head>
	<!----------------------------ESTE ES MI BODY:)-------------->
	
	
	<body>

	<!---------------------------- BARRA PRINCIPAL-------------->
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
							<li><a href="#inicio">Inicio</a></li>
							<li><a href="#bio">Registro Postulante</a></li>
							<li><a href="#regPostulaciones">Registro Postulacion</a></li>
							<li class="active"><a href="#Aviso">Buscar Avisos</a></li>
						</ul>
						</div>
					</div>
				</div>
			</div>
	<!--------------------------------CONTENIDO-------------->		
	   <form class="form-inline">
    <input class="input-xxlarge" id="focusedInput" type="text" placeholder="Buscar" style="width: 801px; ">
    <button type="submit" class="btn btn-primary">Buscar Empleo</button>
	<br>
								<br>
	
	
  
  <p> <label>Fecha de Publicacion</label>
 <select>
<option>Hoy</option>
<option>3 dias</option>
<option>7 dias</option>
<option>1 semana</option>
<option>2 semanas</option>
</select>
<label>Tipo de Empleo</label>
<select>
<option>Fines de Semana</option>
<option>Full Time</option>
<option>Part Time</option>
<option>Pasantia</option>
<option>Por Contrato</option>
<option>Primer Empleo</option>
<option>Por Horas</option>
<option>Teletrabajo</option>
</select>
<label>Departamento</label>
<select>
<option>Arequipa</option>
<option>Lima</option>
<option>Ica</option>
<option>Tacna</option>
<option>Moquegua</option>
<option>Lambayequen</option>
</select></p>

</form>

		<table class="table table-hover"  >

			<tr>
				<td colspan="3">Areas</td>


			</tr>
			<tr>
			<td><label><input type="checkbox" value=""> Abastecimiento y Logística</label>
					<label><input type="checkbox" value=""> Administración, Contabilidad y Finanzas</label>
					<label><input type="checkbox" value=""> Aduana y Comercio Exterior</label>
					<label><input type="checkbox" value=""> Atención al Cliente, Call Center y Telemarketing</label>
					<label><input type="checkbox" value=""> Comercial, Ventas y Negocios</label>
					<label><input type="checkbox" value=""> Comunicación, Relaciones Institucionales y Públicas</label>
					<label><input type="checkbox" value=""> Diseño</label></td>
																
				<td><label><input type="checkbox" value=""> Educación, Docencia e Investigación</label>
					<label><input type="checkbox" value=""> Gastronomía y Turismo</label>
					<label><input type="checkbox" value=""> Gerencia y Dirección General</label>
					<label><input type="checkbox" value=""> Ingeniería Civil y Construcción</label>
					<label><input type="checkbox" value=""> Ingenierías Legales</label>
					<label><input type="checkbox" value=""> Marketing y Publicidad</label>
					<label><input type="checkbox" value=""> Minería, Petróleo y Gas</label></td>
					
								
					<td><label><input type="checkbox" value=""> Oficios y Otros</label>
					<label><input type="checkbox" value=""> Producción y Manufactura</label>
					<label><input type="checkbox" value=""> Recursos Humanos y Capacitación</label>
					<label><input type="checkbox" value=""> Salud, Medicina y Farmacia</label>
					<label><input type="checkbox" value=""> Secretarias y Recepción</label>
					<label><input type="checkbox" value=""> Seguros</label>
					<label><input type="checkbox" value=""> Tecnología, Sistemas y Telecomunicaciones</label></td>
			</tr>

			<tr>
				<td colspan="3">Resusltado Avisos</td>


			</tr>
			<tr>
				<td>Logo</td>
				<td>Titulo</td>
				<td>Empresa</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>

			</tr>
		</table>
		<br>

<table></table>
	</div>			
						
					</div>
		