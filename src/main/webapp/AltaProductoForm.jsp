<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Alta producto</title>
</head>
<body>

	<div class = "container shadow mt-4" >
		<h1 style="text-align:center">Alta Producto</h1>
		
		<form action="Principal" method ="post" class="w-50 mx-auto">
			<label>codigo:</label>
			<input type="text" name="codigo" class="form-control" placeholder="codigo">
			<br><br>
			<label>nombre:</label>
			<input type="text" name="nombre" class="form-control" placeholder="nombre">
			<br><br>
			<label>Cantidad:</label>
			<input type="text" name="cantidad" class="form-control" placeholder="cantidad">
			<br><br>
			<label>Precio:</label>
			<input type="text" name="precio" class="form-control" placeholder="precio">
			<br><br>
			<label>Caducidad:</label>
			<input type="date" name="caducidad" class="form-control" placeholder="caducidad">
			
			<br><br>	
		</form>
		
	<div class="form-group">
		<label for ="seccion">Elige una seccion:</label>
			<select class = "form-control" id="seccion" name="id_seccion" required">
				<option value="">--Elige una seccion</option>
				<c:forEach items="${secciones}" var="seccion">
					<option value="${seccion.id}">${seccion.nombre}</option>
				</c:forEach>
			</select>
	</div>
		<br><br>
			<input type="submit" value="Dar alta">
		<a href="VerProductos" class="btn btn-primary">Volver</a>
	</div>

</body>
</html>