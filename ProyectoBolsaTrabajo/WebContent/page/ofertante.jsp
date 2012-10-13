<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Nuevo proyecto con Bootstrap 2.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<meta name="description" content="Bootstrap 2.0">
		<meta name="author" content="">
		<!—[if lt IE 9]>
		<!--script src="js/html5.js"--><!--/script-->
		<![endif]—>
		<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
 
		<style type="text/css">
			body { 
				padding-bottom: 40px;
				padding-top: 10px; 
			}
		</style>
		<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<link href="css/docs.css" rel="stylesheet">
		
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
		<script src="../bootstrap/js/jquery-1.7.2.min.js"></script>
	
	
 
	</head>
	<!-- Este es el Body -->
	<body>
 
		<!-- Este es la parte del cuepo-->
		
		<div class="container">
			<div class="navbar navbar-inner">
				<div class="navbar-inner">
					<div class="container">
						<a class="brand" href="#">Bolsa de Empleo</a>
						<ul class="nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">Bio</a></li>
							<li><a href="#contact">Contacto</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="row-fluid">
						<div class="span12">
							<h2>Registro de ofertante</h2>
						</div>
					</div>
					<div class="row-fluid">
						<div class="btn btn-info">
						<p>
							<strong>Bienvenido a Bolsa de trabajo,por favor registre su empresa</strong>
						</p>
						</div>
					</div>
					<br>
					<form class="navbar-form well" name="f2" action="Servletofertante" method="post">
						<div class="span2" style="width:100px; height:100px;" >
							<!--Sidebar content-->
							<img src="../bootstrap/img/fotoCvGenericaGrande.jpg" class="fotoCvBox" color="green">
						</div>
						<br>
						<br>
						<br>
						<div class="span8">
							<!--Body content-->
							<div class="container">
								<label>RAZON SOCIAL</label>
								<input type="text" class="span3" placeholder="RAZON SOCIAL" name="rasonsocial"><br>DESCRIPCION DE LA EMPRESA:<br>
								<textarea name="descripcion"></textarea>
								<label>RUC</label>
								<input type="text" class="span3" placeholder="RUC" name="ruc"><br>
								<label>E-mail</label>
								<input type="text" class="span3" placeholder="brayangey@gmail.com" name="correo"><br>
								<label>PASSWORD</label>
								<input type="password" class="span3" placeholder="password" name="password"><br>
								<table>
									<tr>
										<td>
											<label>Pais de residencia</label>
											<select type="combobox" >
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
											<select type="combobox" >
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
								<input type="text" class="span3" placeholder="ciudad"><br>
								<label>Direccion</label>
								<input class="span4" type="text" placeholder="direccion"><br>
								<label>telefono fijo</label>
								<input class="span3" type="text" placeholder="fijo"><br>
								<label>telefono celular</label>
								<input class="span3" type="text" placeholder="celular"><br>
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
									<select type="combobox">
										<option selected="" value="">-</option>
										<option value="PA">Pasaporte</option>
										<option value="DN">DNI</option>
									</select>
									<input type="text" placeholder="....">									
								</p>
								<p>
									
										
											<label>Fecha de nacimiento</label>
											<select type="combobox" class="span1"> 
												<option selected="" value="">-</option>
												<option value="PE">1</option>
 
											</select>	
										
										
											<select type="combobox" class="span2">
												<option selected="" value="">-</option>
												<option value="LI">Enero</option>
 
											</select>
								
 
											<select type="combobox" class="span1">
												<option selected="" value="">-</option>
												<option value="LI">1981</option>
				
											</select>
											
								
								</p>	
									</br>
									
								<div class="control-group">
									<label>Sexo</label>
									<br>
									<input type="radio" name="#" value="1" >
									<span>Masculino</span>
									<br>
									<input type="radio" name="#" value="2">
									<span>Femenino</span>
									<br>
								</div>
								</br></br>
								<p>
									<label>Estado civil</label>
									<select type="combobox" class="span2">
										<option selected="" value="">-</option>
										<option value="5">Viudo/a</option>
										<option value="290">Unión Libre</option>
										<option value="2">Casado/a</option>
										<option value="1">Soltero/a</option>
										<option value="3">Divorciado/a</option>
										<option value="4">Pareja de Hecho</option>
									</select>
								</p>
								</br>
								<div class="navbar">
									<Input class="btn btn-primary" type="submit" value="Guardar datos personales">
									<button class="btn">Cancelar</button>
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