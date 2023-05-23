<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<form action="" method="get">
<h1 style= "color:red">${mensaje}</h1>
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
			<th scope ="col">NOMBRE_SECCION</th>
			<th scope ="col">ELIMINAR</th>
			<th scope ="col">MODIFICAR</th>
		</tr>
		
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td scope = "row">${producto.id}</td>
				<td scope ="row">${producto.codigo}</td>
				<td scope ="row">${producto.nombre}</td>
				<td scope ="row">${producto.cantidad}</td>
				<td scope ="row">${producto.precio}</td>
				<td scope ="row">${producto.caducidad}</td>
				<td scope ="row">${producto.seccion.nombre}</td>
				<td><a href="EliminarProducto?id=${producto.id}" class="btn btn-secondary">Eliminar</a></td>
				<td><a href="ModificarProductoForm?id=${producto.id}" class="btn btn-secondary">Modificar Producto</a></td>
					
			</tr>
		</c:forEach>
		
	</table>
	<a href="Principal" class="btn btn-primary">Dar de alta</a>
</form>	
<form action=""method="get"  class="w-50 mx-auto"></form>
	<h3>BUSCADORES</h3>
	<label>Introduce nombre:</label>
	<input type="text" name ="nombre" class= "form-control" placeholder="nombre">
</body>
</html>