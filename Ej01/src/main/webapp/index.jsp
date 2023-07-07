<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ej01</title>
</head>
<body>
<h1>Java Web API</h1>
<% out.print("<h2> Ej01</h2>"); %>

<%

String sesionActiva = (String) session.getAttribute("sesionActiva");
if (sesionActiva == null){
	response.sendRedirect("formulario.jsp");
}
else {
	String usuario = (String) session.getAttribute("usuario");
 	out.print("<h2>La sesión está activa</h2>");
	out.print("<h5>Los datos del usuario son:"+ usuario +"</h5>");
}

%>
<br><br>
<h3>Ejemplo Servlet Saludo</h3>
<form action="Saludo" method="get">
	<label for="saludo">Saludo Get</label>
	<input type="text" name="saludo" id="saludo">
	<button type="submit">Enviar</button>
</form>
<br><br>
<form action="Saludo" method="post">
	<label for="saludo">Saludo Post</label>
	<input type="text" name="saludo" id="saludo">
	<button type="submit">Enviar</button>
</form>

</body>
</html>