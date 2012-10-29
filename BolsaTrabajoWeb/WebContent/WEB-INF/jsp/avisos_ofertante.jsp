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
							<h2>REGISTRO DE AVISOS</h2>
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
					<form class="navbar-form well" name="f2" action="../servletaviso" method="post">
						<div class="span2" style="width:100px; height:100px;" >
							<!--Sidebar content-->
							<img src="../bootstrap/img/AVISO.jpg" class="fotoCvBox" color="green">
						</div>
						<br>
						<br>
						<br>
						<div class="span8">
							<!--Body content-->
							<div class="container">
								<label>TITULO DEL AVISO</label>
								<input type="text" class="span3" placeholder="RAZON SOCIAL" name="titulo" style="width: 626px; height: 31px"><br><br>
								<label>DESCRIPCION DEL AREA A LABORAR</label>
								<textarea name="descripcionarea" style="height: 65px; width: 622px; "></textarea>
								<label>TODA LA DESCRIPCION DEL TRABAJO</label>
								</div>
						</div>
						<textarea name="descripcion" style="height: 52px; width: 627px; "></textarea>
						
								
								
								
								
								
								
							<br>	
							Seleccione el area
<br>								
					<select name="area">
					<option>INGENIERIA</option>
					<option>CONTABILIDAD</option>
					</select>
					
									
								<p>
									
								</p>
					SELECCIONE EL PUESTO LABORAL<BR>
								
					<select name="puesto_laboral">
					<option select>---seleccione---- </option>
					<option>DESARRROLLADOR </option>
					<option>ANALISTA </option>
					
					</select>

					<div class="navbar">
									<input class="btn btn-primary" type="submit" value="Guardar datos personales">
									<button class="btn">Cancelar</button>
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