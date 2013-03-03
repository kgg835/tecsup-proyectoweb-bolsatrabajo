<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="miformulario">
		<form action="mostrarMensaje.html" method="post">
			<table width="50" cellpadding="10" border="1" cellspacing="10">
				<tr>
					<td>Usuario:</td>
					<td><input maxlength="20" name="txtUsuario">
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input maxlength="8" name="txtPassword">
					</td>
				</tr>
				<tr>
					<td><br>
						<input name="boton" type="submit" value="Enviar">
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>