<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="VerProducto">
	<label>Introduzca las letras o palabras clave:</label>
	<input type="text" name="nombre">
	<input type ="submit" value = "BUSCAR" class= "btn btn-primary">

</form>
<form action="VerProductos">
	<input type ="submit" value = "Ver Productos" class= "btn btn-secondary">
</form>
</body>
</html>