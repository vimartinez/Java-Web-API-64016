<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ej01</title>
</head>
<body>
	<h3>Ingreso al Sistema</h3>
	<form action="Login" method="post">
		<label for="mail">Ingres� tu mail</label>
		<input type="email" name="mail" id="mail" placeholder="mail@gmail.com" required>
		<label for="clave">Ingres� la clave</label>
	    <input type="password" name="clave" id="clave" placeholder="Ingres� la clave!" required>
	    <button type="submit">Ingresar</button>
	</form>
	
	<% 
	String mensaje = (String) request.getAttribute("mensajeError");
	if (mensaje != null) out.print("<h3>"+ mensaje +"</h3>");
	%>
	
	
</body>
</html>