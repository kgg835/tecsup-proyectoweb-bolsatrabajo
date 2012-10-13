<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
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
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#bio">Bio</a></li>
							<li><a href="#contacto">Contacto</a></li>
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
					<form class="navbar-form well" name="f1" action="ServletPostulante" method="post">
						<div class="span2" style="width:100px; height:100px;" >
							<!--Sidebar content-->
							<img src="/ProyectoBolsaTrabajo/bootstrap/img/fotoCvGenericaGrande.jpg" class="fotoCvBox" color="green">
						</div>

						<div class="span8">
							<!--Body content-->
							<div class="container">
								<div id="descripcion" >	
								<div class="navbar">
									<button class="btn btn-primary" type="submit">Guardar datos personales</button>
								</div>
											<table class="table">
												<tr>
													<td><output>Anderson Roman</output></td>
												</tr>
												<tr>
													<td><output>Edad</output></td>
												</tr>
												<tr>
													<td><output>Estado civil</output></td>
												</tr>
												<tr>
													<td><output>Dni</output></td>
												</tr>
												<tr>
													<td><output>Telefono casa</output></td>
												</tr>
												<tr>
													<td><output>Movil</output></td>
												</tr>
												<tr>
													<td><output>Email</output></td>
												</tr>
											</table>
									</div>
							  <div id="datosPersonal" style="display:none;">	
								<label>Nombres(s)</label>
								<input name="txtNombre" type="text" class="span3" placeholder="nombres"><br>
								<label>Apellido(s)</label>
								<input name="txtApellido" type="text" class="span3" placeholder="apellidos"><br>
								<label>E-mail</label>
								<input name="txtEmail" type="text" class="span3" placeholder="hackromanux@gmail.com"><br>
								<table>
									<tr>
										<td>
											<label>Pais de residencia</label>
											<select name="txtPais" type="combobox" >
												<option selected="" value="">-</option>
												<option value="PE">Peru</option>
												<option value="CO">Colombia</option>
												<option value="NI">Nicaragua</option>
												<option value="BO">Bolivia</option>
												<option value="BR">Brasil</option>
											</select>	
										</td>
										<td>
											<label>Provincia o estado</label>
											<select name="txtProvincia" type="combobox" >
												<option selected="" value="">-</option>
												<option value="LI">Lima</option>
												<option value="TU">Tumbes</option>
												<option value="IA">Ica</option>
												<option value="HU">Huancayo</option>
												<option value="IQ">Iquitos</option>
											</select>
										</td>
									</tr>
								</table>
								<br>
								<br>
								<label>ciudad</label>
								<input name="txtCuidad" type="text" class="span3" placeholder="ciudad"><br>
								<label>Direccion</label>
								<input name="txtDireccion" class="span4" type="text" placeholder="direccion"><br>
								<label>telefono fijo</label>
								<input name="txtTelefonoFijo" class="span3" type="text" placeholder="fijo"><br>
								<label>telefono celular</label>
								<input name="txtTelefonoCel" class="span3" type="text" placeholder="celular"><br>
								<label>Nacionlidad</label>
								<p>
									<select type="combobox">
										<option selected="" value="">-</option>
										<option value="LI">Lima</option>
										<option value="TU">Tumbes</option>
										<option value="IA">Ica</option>
										<option value="HU">Huancayo</option>
										<option value="IQ">Iquitos</option>
									</select>
								</p>
								<p>
									<label>Tipo y numero de Documento</label>
									<select  type="combobox">
										<option selected="" value="">-</option>
										<option value="PA">Pasaporte</option>
										<option value="DN">DNI</option>
									</select>
									<input name="txtDni" type="text" placeholder="....">									
								</p>
								<p>
									
										
											<label>Fecha de nacimiento</label>
											<select name="txtDia" type="combobox" class="span1"> 
												<option selected="" value="">-</option>
												<option value="PE">1</option>

											</select>	
										
										
											<select name="txtMes" type="combobox" class="span2">
												<option selected="" value="">-</option>
												<option value="LI">Enero</option>

											</select>
								

											<select name="txtAnio" type="combobox" class="span1">
												<option selected="" value="">-</option>
												<option value="LI">1981</option>
				
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
								</br></br>
								<p>
									<label>Estado civil</label>
									<select name="txtEstadoCivil" type="combobox" class="span2">
										<option selected="" value="">-</option>
										<option value="5">Viudo/a</option>
										<option value="290">Unión Libre</option>
										<option value="2">Casado/a</option>
										<option value="1">Soltero/a</option>
										<option value="3">Divorciado/a</option>
										<option value="4">Pareja de Hecho</option>
									</select>
								</p>
								<br/>
								<div class="navbar">
									<button class="btn btn-primary" type="submit">Guardar datos personales</button>
									<button class="btn">Cancelar</button>
								</div>
							</div>							
								<script type="text/javascript">
									$(document).ready(function(){
									$('.combobox').combobox();
									});
								</script>						
							</div>
						</div>
					</form>
				</div>
			
		</div>	
		</div>
	
		
		<footer>
        <p>&copy; Company 2012</p>
      </footer>		
	</body>
</html>