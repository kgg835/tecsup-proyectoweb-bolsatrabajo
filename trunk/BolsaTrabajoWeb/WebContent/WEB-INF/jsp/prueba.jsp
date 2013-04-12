<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/BolsaTrabajoWeb/jquery/js/jquery-1.8.2.js"></script>
  <script type="text/javascript">
    function doAjax() {
    ///BolsaTrabajoWeb/
   alert("dentro de la funcion doAjax..");
   /* $.ajax({
	     url: myurl,
	     data: mydata,
	     dataType: 'json',
	     type: 'get',
	     contentType : 'application/json',
	     cache: false,
	     success: function ()
	}); */
    var usuario=$('#txtUsuario').val();
    var password=$('#txtPassword').val();
    alert(usuario+" -- "+password);
    
       $.ajax({
        url: '/BolsaTrabajoWeb/mostrarMensaje.html',
        type:'POST',
       // dataType: 'json',
      //  contentType : 'application/json',
        data: ({"USUARIO" : usuario,"PASSWORD" :password }),
        success: function(response) {
         // $('#time').html(data);
         if(response.status=="SUCCESS"){
        	 alert(response.status);
        	 alert("USUARIO--> "+response.result.usuario);
        	 alert("PASSWORD--> "+response.result.clave);
        	 
        	 alert("USUARIO--> "+response.result[0].usuario);
        	 alert("PASSWORD--> "+response.result[0].clave);
       
         }
         $("#rpta_servidor").html(response.result.usuario);

         
 
        },
        error: function(e){
        	alert('Error: ' + e);
        }
      }); 
    }
    
    function enviar(){
    	var usuario=$('#txtUsuario').val();
    	var password=$('#txtPassword').val();
    	alert(usuario+" -- "+password);
    alert("dentro de la funcion enviar() ..");
    jQuery.getJSON("/BolsaTrabajoWeb/mostrarMensaje.html",
    	{USUARIO: usuario,PASSWORD: password},
    	function (response) {
       
    		if(response.status=="SUCCESS"){
           	 alert(response.status);
           	 alert("usuario--> "+response.result.usuario);
           	 alert("clave--> "+response.result.clave);
          
            }
            $("#rpta_servidor1").html(response.result.usuario);
            $("#rpta_servidor2").html(response.result.clave);
    	});
    
    }
  </script>
</head>
<body>

	<div id="miformulario">
		<form>
			<table width="50" cellpadding="10" border="1" cellspacing="10">
				<tr>
					<td>Usuario:</td>
					<td><input maxlength="20" name="txtUsuario" id="txtUsuario" type="text">
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input maxlength="8" name="txtPassword" id="txtPassword" type="text">
					</td>
				</tr>
				<tr>
					<td><br>
						<input name="boton" type="button" value="Enviar" onclick="enviar();">
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<div id="rpta_servidor1" style="color: green;">
	</div>
	<div id="rpta_servidor2" style="color: blue;">
	</div>
</body>
</html>