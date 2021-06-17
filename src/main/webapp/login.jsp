<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class= "corpo">
<head>
<title>HW Airlines | Iniciar sesión</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/mainstyle.css">
</head>
<body class="corpo">
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3 class="text-center">Inicia sesión</h3>
					<div class="d-flex justify-content-end "></div>
				</div>
				<div class="card-body">
					<form action="./login" method="post">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Email" name = "email" id= "email">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="Contraseña	" name = "pwd" id= "pwd">
						</div>
						<h5 class="text-center text-white">${error}</h5>
						 <div class="text-center mt-3">
            			<button type="submit" class="btn btn-dark">Iniciar sesión</button>
            			<a href="./index.jsp" type="button" class="btn btn-dark ml-2">Volver</a>
            			</div>
						
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>