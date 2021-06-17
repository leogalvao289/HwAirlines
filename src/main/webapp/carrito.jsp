<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Carrito de la Compra</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/mainstyle.css">
<title>HW Arilines | Carrito de compra</title>
</head>
<body>
	<div class="container">
        
        	<% 
        	if(session.getAttribute("id") !=null) 
        	{ %>
        	<form action="" method="post" class="form-car text-secondary">
        	<div class="border border-right-0 border-left-0 border-top-0">
        	<h4 class="d-flex justify-content-center"> Confirmar compra</h4>
        	</div>
        	<div>
	        	<h5>Datos pasajero: </h5>
	        	<p>Nombre:<c:out value="${usuario.getNombre()}"></c:out></p>
	        	<p>Apellidos:<c:out value="${usuario.getApellidos()}"></c:out></p>
	        	<p>Fecha de nacimiento: <c:out value="${usuario.getFecha_nacimiento()}"></c:out></p>
	        	<p>DNI: <c:out value="${usuario.getDni()}"></c:out></p>
	        	<p>Correo: <c:out value="${usuario.getCorreo()}"></c:out></p>
        	</div>
        	<div>
        	<h5 class="d-flex justify-content-center">Vuelo <c:out value="${id}"></c:out></h5>
           	<p>Origen: <c:out value="${vueloReserva.getAeropuertoOrigen().getNombre()}"></c:out></p>
        	<p>Destino: <c:out value="${vueloReserva.getAeropuertoDestino().getNombre()}"></c:out></p>
        	<p>Hora salida: <c:out value="${vueloReserva.getHora_salida()}"></c:out></p>
        	<p>Hora llegada: <c:out value="${vueloReserva.getHora_llegada()}"></c:out></p>
        	<p>Fecha: <c:out value="${vueloReserva.getFecha()}"></c:out></p>
        	<p>Precio: <c:out value="${vueloReserva.getPrecio()}"> €</c:out></p>
        	</div>
        	
        	<a type="button" href="./pago" class="btn btn-info">Realizar compra</a>
        	<a href="index.jsp" type="button" class="btn btn-info">Inicio</a>
        	</form>	
        	<%}else {
        		%>
        	<h5>Todavía no se ha seleccionado ningún vuelo.</h5>
        	<a href="index.jsp" type="button" class="btn btn-info">Inicio</a>
        	<%}; %>
        
    </div>      	
</body>
</html>