<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Patrick+Hand&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="styles/mainstyle.css">
<link rel="stylesheet" href="javascript.js">
<title>Mi cuenta</title>
</head>
<body class="back-reg">
	<div class="container">
		<form action="./micuenta" method="post" class="form-reg">
			<div class="border border-right-0 border-left-0 border-top-0">
				<h4>Mi cuenta</h4>
			</div>
			<div class="form-group mt-3">
				<label for="nombre">Nombre</label> <input required type="text"
					class="form-control" value="${usuario.getNombre()}" name="nombre" id="nombre">
			</div>
			<div class="form-group">
				<label for="apellido">Apellidos</label> <input type="text"
					class="form-control" value="${usuario.getApellidos()}" id="apellido
                "
					name="apellido">
			</div>
			<div class="form-group">
				<label for="nacimiento">Fecha de nacimiento</label> <input
					type="date" class="form-control" id="nacimiento" name="nacimiento"
					value="${usuario.getFecha_nacimiento()}">
			</div>
			<div class="form-group">
				<label for="dni">Dni</label> <input type="text" class="form-control"
					value="${usuario.getDni()}" id="dni
                " name="dni">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input required type="email"
					class="form-control" value="${usuario.getCorreo()}" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="contrasenya">Contraseña</label> <input type="password"
					class="form-control" value="${usuario.getContrasenya()}" id="contrasenya" name="contrasenya">
			</div>
			<div class="form-group">
				<label for="contrasenya2">Repetir contraseña</label> <input
					type="password" class="form-control" value="${usuario.getContrasenya()}" id="contrasenya2"
					name="contrasenya2">
			</div>
			<div class="text-center mt-3">
				<a href="./index.jsp" type="button" class="btn btn-dark">Volver</a>
			</div>
		</form>
	</div>
	<div class="pie-cuenta d-flex">
		<div class="pie-copyright">
			
		</div>
	</div>
</body>
</html>