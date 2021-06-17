<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
<title>Inicio</title>
</head>
<body class="body-index">
<div class="container-fluid">
	<nav class="navbar navbar-expand-md navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">HW Airlines</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAl
		tMarkup">
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

		<div class="row">
		<div class="col-md-6">
			<div class="text-center">
			<h6 class="m-h6">Vive una experiencia única</h6>
			<h1 class="m-h1">Encuentra tu vuelo al mejor precio</h1>
			<a href="./vuelos" type="button" class="btn btn-dark">Buscar vuelo</a>
			</div>	
		</div>
		<div class="my-4 pr-4 col-md-6">
			<img class="img-responsive" style="width: 100%"
				src="./img/web1.jpg" />
		</div>
	</div>

	<div class="row">
		<div class="separador col-md-12 bg-dark text-center">
			<h3 class="m-h3">Disfruta de tus vacaciones</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<article class="p-4">
				<img class="img-responsive" style="width: 100%" src="./img/bcn1.jpg" />
				<h4 class="text-center">Barcelona</h4>
				<p class="articulos text-center">Desde 36.00€</p>
				<div class="row">
					<button type="button"
						class="botonDentro col-md-12 btn btn-outline-danger">
						AÑADIR AL CARRITO</button>
				</div>
			</article>
		</div>
		<div class="col-md-4">
			<article class="p-4">
				<img class="img-responsive" style="width: 100%" src="img/gc1.jpg" />
				<h4 class="text-center">Gran Canaria</h4>
				<p class="articulos text-center">Desde 32.00€</p>
				<div class="row">
					<button type="button"
						class="botonDentro col-md-12 btn btn-outline-danger">
						AÑADIR AL CARRITO</button>
				</div>
			</article>
		</div>
		<div class="col-md-4">
			<article class="p-4">
				<img class="img-responsive" style="width: 100%" src="img/ibiza1.jpg" />
				<h4 class="text-center">Ibiza</h4>
				<p class="articulos text-center">Desde 30.00€</p>
				<div class="row">
					<button type="button"
						class="botonDentro col-md-12 btn btn-outline-danger">
						AÑADIR AL CARRITO</button>
				</div>
			</article>
		</div>
	</div>
	<div class="row">
		<div class="separador col-md-12 bg-dark text-center">
			<h3 class="m-h3">Completa tu viaje con los mejores sevicios</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<article class="p-4">
				<img class="img-responsive" style="width: 100%" src="img/pepe1.jpg" />
				<div class="row  mt-2">
					<button type="button"
						class="botonDentro col-md-12 btn btn-outline-danger">
						ALQUILA TU COCHE</button>
				</div>
			</article>
		</div>
		<div class="col-md-6">
			<article class="p-4">
				<img class="img-responsive" style="width: 100%" src="img/hotel1.jpg" />
				<div class="row  mt-2">
					<button type="button"
						class="botonDentro col-md-12 btn btn-outline-danger">
						RESERVA TU HOTEL</button>
				</div>
			</article>
		</div>
	</div>
	</div>
	<div class="container-fluid">
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
	</div>
</body>
</html>
