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
					<label><h1 style="color: blue;">BolsaTrabajoUCV</h1></label>
					<!-- <img src="../bootstrap/img/logo.jpg" width="307" height="40"></td> -->
				<td align="right" style="width: 885px; " width="688">
					<div>
						<button class="btn btn-large" onclick="location.href='cargarLogin.html'">Iniciar Sesion</button>
						<button type="submit" onclick="location.href='inicioofertante.html'" class="btn btn-large btn-primary">Publicar Aviso</button>
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
	    		<label>Contrase�a</label>
	    		<input type="password" class="span12" placeholder="Escribe contrase�a" name="txtContrasenaC"><br/>
	    		<label>Vuelve a escribir tu Contrase�a</label>
	    		<input type="password" class="span12" placeholder="Escribe contrase�a" name="txtContrasenavalida"><br/>
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
						Dise�o
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
			<form class="well form-search" style="height: 220px; ">
				<label><h3> B�squeda avanzada &nbsp;</h3></label>
				<input class="input-xlarge search-query" type="text">
				<br><br>
					
					
					
						<table style="width: 367px;">

						<tr>
							<td>CATEGORIA</td>
							<td style="width: 62px;"></td>
							<td></td>
							<td></td>
							<td>FECHA</td>
						</tr>
						<tr>
							<td><select name=area style="width: 121px;">
							<option>Cualquiera</option>
							<option>INGENIERIA</option>
							<option>CONTABILIDAD</option>
							</select></td>
							<td></td>
							<td></td>
							<td></td>
							<td><select name=dias style="width: 131px;">
							<option>Cualquiera</option>
							<option>Hace 3 dias</option>
							<option>Hace 7 dias</option>
							</select></td>
						</tr>




							<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td style="height: 41px;"></td>
							</tr>
							<tr>
							<td style="width: 257px;"></td>
							
							<td><td style="width: 270px;">QUE CONTENGA LAS PALABRAS:<br>
								<input name=palabra><button class="btn btn-large" type="submit" style="width: 78px; ">Buscar</button></td></td>
							<td></td>
							<td></td>
							</tr>
							</table>
							</form>
			
				<label><h3>Empleos destacados en Lima</h3></label>
			
  <%@page import="java.util.*, com.proyecto.modelo.Aviso" %>
<%
Collection<Aviso> avisos = (ArrayList<Aviso>)request.getAttribute("avisos");
int i = 1;
for(Aviso avi : avisos) {
%>  
			<div class="well">
<div class="avisos-list ">
	            	
	            	<div id="titulo-avisos-home">Empleos destacados en <strong>Lima</strong></div>
	            	
                    <a href="mostrar_aviso.html?idaviso=<% out.print(avi.getIdAviso()); %>" target="_blank" method=post class="aviso_box aviso_listado " title="Gerente de Estaciones Biol�gicas">
                        <img src="/BolsaTrabajoWeb/bootstrap/img/AVISO.jpg" width="111" height="70" alt="ONG Internacional"/>
                        <div class="aviso_content">
                            <h3><% out.print(avi.getTitulo()); %></h3>
<h4><% out.print(avi.getDescripcion()); %></h4>
<%Calendar c2 = new GregorianCalendar(); %>
<br>
HACE:<%out.print((c2.getTime().getDate())-(avi.getFec_publicacion().getDate()));%> DIAS                    
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

<% }  
   %>



	    </div>	
	</div>
</div>
</body>
</html>