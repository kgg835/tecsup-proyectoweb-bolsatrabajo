<!DOCTYPE html>
<%@page import="com.proyecto.modelo.HistorialPostulaciones"%>
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
		
		<script language="javascript">
var Url = location.href;
Url = Url.replace(/.*\?(.*?)/,"$1");
Variables = Url.split ("&");
for (i = 0; i < Variables.length; i++) {
       Separ = Variables[i].split("=");
       eval ('var '+Separ[0]+'="'+Separ[1]+'"');
}

//alert(id);
</script>
		
		
		
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
							<li class="active"><a href="#regPostulaciones">Registro Postulacion</a></li>
						</ul>
						</div>
					</div>
				</div>
			</div>
	<!--------------------------------BARRA SECUNDARIA-------------->

		<table class="table table-hover">
			<tr>

				<th style="width: 53px;">#</th>

				<th>Empresa</th>
				<th style="width: 119px;">Aviso</th>
				<th>Fecha de Publicacion</th>
				<th>Fecha de Postulacion</th>



				<th style="width: 300px;"><a class="btn dropdown-toggle"
					data-toggle="dropdown" href="#"> Estado <span class="caret">
					</span>
				</a></th>
			</tr>
			    <%@page import="java.util.*, com.proyecto.modelo.HistorialPostulaciones" %>
			<%
			Collection<Historial> arreglo = (ArrayList<HistorialPostulaciones>)request.getAttribute("historial");
			if(arreglo != null) { 
			int i = 1;
			for(HistorialPostulaciones x : arreglo) {
			%>  
			
			<tbody>
				<tr>

					<td><%out.print(x.getIdpostulacion()); %></td>

					<td><% out.print(x.getDescempresa()); %></td>
					<td><% out.print(x.getTituloAviso()); %></td>
					<td><% out.print(x.getFechapublicacion()); %></td>
					<td><% out.print(x.getFechpostulacion()); %></td>

					<td>En Espera</td>
				</tr>
				<tr>
					<td>Cell</td>

					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td></td>

					<td>Activo</td>
				</tr>
				<tr>
					<td>
					</td>

					<td></td>
					<td></td>
					<td></td>
					<td></td>

					<td>Inactivo</td>
				</tr>
				<tr>
					<td></td>

					<td></td>
					<td></td>
					<td></td>
					<td></td>

					<td></td>
				</tr>
				<tr>
					<td></td>

					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>

					<td></td>
				</tr>
			</tbody>
			<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
		</table>
		<div class="btn-group-left">
  <button class="btn">1</button>
  <button class="btn">2</button>
  
  
</div>
						
					</div>