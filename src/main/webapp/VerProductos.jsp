<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<table class= "table table-striped">
		<tr>
			<th colspan="7" style="text-align:center">PRODUCTOS</th>
		</tr>
		<tr>
			<th scope ="col">ID</th>
			<th scope ="col">CODIGO</th>
			<th scope ="col">NOMBRE</th>
			<th scope ="col">CANTIDAD</th>
			<th scope ="col">PRECIO</th>
			<th scope ="col">CADUCIDAD</th>
			<th scope ="col">ID_SECCION</th>
		</tr>
		
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td scope = "row">${producto.id}</td>
				<td scope ="row">${producto.codigo}</td>
				<td scope ="row">${producto.nombre}</td>
				<td scope ="row">${producto.cantidad}</td>
				<td scope ="row">${producto.precio}</td>
				<td scope ="row">${producto.caducidad}</td>
				<td scope ="row"></td>
					
			</tr>
		</c:forEach>
	</table>
	<a href="Principal">Principal</a>
</body>
</html>