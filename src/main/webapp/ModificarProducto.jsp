<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<form action="ModificarProductForm" method="post"  class="w-50 mx-auto">
<input type = "hidden" name= "id" value="${producto.id}" >${producto.id}
	<label>codigo:</label>
			<input type="text" name="codigo" class="form-control" value= "${producto.codigo }" placeholder="codigo">
			<br><br>
			<label>nombre:</label>
			<input type="text" name="nombre" class="form-control" placeholder="nombre"value= "${producto.nombre }" >
			<br><br>
			<label>Cantidad:</label>
			<input type="text" name="cantidad" class="form-control" placeholder="cantidad" value= "${producto.cantidad }">
			<br><br>
			<label>Precio:</label>
			<input type="text" name="precio" class="form-control" placeholder="precio" value= "${producto.precio }">
			<br><br>
			<label>Caducidad:</label>
			<input type="date" name="caducidad" class="form-control" placeholder="caducidad"value= "${producto.caducidad }">
			<br><br>
			<div class="form-group">
					seleccion:<select name ="rol">
			<option ></option>
			 <c:forEach items="${selecciones}" var="rol">
				<c:choose>
					<c:when test="${producto.seleccion.id==seleccion.id}">
						<option selected value="${seleccion.nombre}">${seleccion.nombre}</option>
					</c:when>
					<c:when test="${producto.seleccion.id!=seleccion.id}">
						<option value="${seleccion.nombre}">${seleccion.nombre}</option>
					</c:when>
					</c:choose>
				</c:forEach>
		</select>
	</div>
		<br><br>
			<input type="submit" value="Modificar">
		<a href="VerProductos" class="btn btn-primary">Volver</a>
	</div>	
		</form>
		

</form>


</body>
</html>