<%@page import="com.proyecto.modelo.HistorialPostulaciones"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.util.*, com.proyecto.modelo.HistorialPostulaciones" %>
<%
Collection<HistorialPostulaciones> postulaciones = (ArrayList<HistorialPostulaciones>)request.getAttribute("postulaciones");
%> 

<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
 <title>Mi Bolsa de Empleo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
     <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
	
<!--------------ESTILOS-------------------------------------------------->
		<link href="/BolsaTrabajoWeb//bootstrap/css/bootstrap.css" rel="stylesheet">

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
						<a class="brand" href="index.html">Bolsa de Empleo</a>
						<div class="nav-collapse collapse">
						<ul class="nav">
							<li><a href="postulante.jsp">Mi Cv</a></li>
							<li><a href="listarAvisos.html">Buscar Avisos</a></li>
							<li class="active"><a href="postulaciones.jsp">Mis Postulaciones</a></li>
						<li><a href="buscaraviso.jsp">Herramientas</a></li>
						</ul>
						</div>
					</div>
				</div>
			</div>
	<!--------------------------------BARRA SECUNDARIA-------------->
<form action="historialPostulaciones" method="post">

		
<p style="color:purple;font-style: italic;" >Resultado total de Postulaciones Encontradas<strong> <%out.print(postulaciones.size()); %></strong></p>
	
		<table class="table table-hover">
			<tr>

				<th style="width: 53px;">#</th>

				<th>Empresa</th>
				<th style="width: 119px;">Aviso</th>
				<th>Fecha de Publicacion</th>
				<th>Fecha de Postulacion</th>



				<th> <select name="opcion">
  <option>Estado</option>
  <option style="color:green;" value="0">Activo</option>
  <option style="color:red;" value="1">Caduco</option>
</select>
 </th></tr>
			    
<% int i = 1;
for(HistorialPostulaciones hp : postulaciones) {	%>	
 
  <tr>
    <td><%=i++ %></td>
    <td><% out.print(hp.getNombreEmpresa()); %></td>
    <td><% out.print(hp.getTituloAviso()); %></td>
    <td><% out.print(hp.getFechpostulacion()); %></td>
    <td><% out.print(hp.getFechpostulacion()); %></td>
     <td><% out.print(hp.getEstado()); %></td>
  </tr>
<% } 


   %>
  
</table></form>
  
  
	
		<div class="btn-group-left">
  <button class="btn">1</button>
  <button class="btn">2</button>
  </div>
						
					</div></body></html>