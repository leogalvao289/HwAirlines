<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW Airlines | Búsqueda de vuelos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/mainstyle.css">
</head>
<body>
	<div class="container-fluid"> <!-- Barra de nav -->
	<nav class="navbar navbar-expand-md navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">HW Airlines</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<%
				String email = (String) session.getAttribute("email");
				if (email != null) {
				%>
				<a type="button" class="btn btn-dark" href="./micuenta">Mi
					cuenta</a> <a type="button" class="btn btn-dark" href="./carrito">Carrito de compra</a> <a type="button" class="btn btn-dark"
					href="./desconectar">Desconectar</a>
				<%
				} else {
				%>
				<a type="button" class="btn btn-dark" href="login.jsp">Inicio
					Sesion</a> <a type="button" class="btn btn-dark" href="registro.jsp">Registrarse</a>
				<%
				}
				;
				%>
			</div>
		</div>
	</nav>
	</div>
	<main class="container-fluid">
		<section> <!-- Búsqueda de vuelos -->
		<form class="form-inline d-flex justify-content-center bg-light py-3" action="./vuelos?accion=buscar" method="post">  
				<label for="origen">Origen:</label> 
				<select class="form-control" id="origen" name="origen">
					<c:forEach var="origen" items="${vuelos}">
	    			 <option value="${origen.getId_aeropuerto()}"><c:out value="${origen.getNombre()}"></c:out></option>
					</c:forEach>
				</select>
				<label for="destino" class="pl-3">Destino:</label> 
				<select class="form-control " id="destino" name="destino">
					<c:forEach var="destino" items="${vuelos}">
	    			 <option value="${destino.getId_aeropuerto()}"><c:out value="${destino.getNombre()}"></c:out></option>
					</c:forEach>
				</select>
				<label for="fecha " class="pl-3">Fecha:</label>
				<input type="date" id="fecha" name="fecha">
				<div class="pl-3">
				<button type="submit" class="btn btn-dark">Buscar</button>
				</div>	
		</form>
		</section>
		<div class="container">
		<c:forEach var="vuelosB" items="${vuelosBusqueda}">
					<table class="table mt-4 bg-light">
					  <tbody>
					    <tr>
					      <td>Origen: <c:out value="${vuelosB.getAeropuertoOrigen().getNombre()}"></c:out></td>
					      <td>Destino: <c:out value="${vuelosB.getAeropuertoDestino().getNombre()}"></c:out></td>
					      <td></td>
					    </tr>
					    <tr>
					      <td>Fecha: <c:out value="${vuelosB.getFecha()}"></c:out></td>
					      <td>Precio: <c:out value="${vuelosB.getPrecio()}"></c:out>€</td>
					      <td><a href="./vuelos?accion=reservar&id=${vuelosB.getId_vuelo()}" type="button" class="btn btn-dark">Reservar</a></td>
					    </tr>
					    <tr>
					      <td>Hora salida: <c:out value="${vuelosB.getHora_salida()}"></c:out>h</td>
					      <td>Hora llegada: <c:out value="${vuelosB.getHora_llegada()}"></c:out>h</td>
					      <td></td>
					    </tr>
					  </tbody>
					</table> 
		</c:forEach>
	</div>
	</main>
	<footer class="container-fluid"> <!-- Footer -->
		<div class=" jumbotron text-center text-wide mt-4 mb-0 my-4 bg-dark">
			<p class="pie">
				Información sobre nuestra <a
					class="text-decoration-none text-body text-success"
					href="politica-privacidad.html">política de privacidad</a>
			</p>
			<p class="pie">Creado por: Estefania Figueiras, Gaspar de la
				Ossa, Leo Messi, Adrià Ros</p>
			<p class="pie">Copyright ©2021 | Todos los derechos reservados</p>
		</div>
	</footer>
</body>
</html>