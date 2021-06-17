<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW Airlines | Nuevo registro de usuario</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/mainstyle.css">
</head>

<body class="back-reg">

<div class="container">
        <form action="./registro" method="post" class="form-reg">
        	<div class="border border-right-0 border-left-0 border-top-0">
        	<h4>Formulario de registro</h4>
        	</div>
            <div class="form-group mt-3">
                <label for="nombre">Nombre</label>
                <input required type="text" class="form-control" placeholder="Introduzca su nombre" name="nombre"
                    id="nombre">
            </div>
            <div class="form-group">
                <label for="apellido">Apellidos</label>
                <input type="text" class="form-control" placeholder="Introduzca sus apellidos" id="apellido
                " name="apellido">
            </div>
             <div class="form-group">
                <label for="nacimiento">Fecha de nacimiento</label>
                <input type="date"  class="form-control" id="nacimiento" name="nacimiento">
              </div> 
            <div class="form-group">
                <label for="dni">Dni</label>
                <input type="text" class="form-control" placeholder="Introduzca su número de dni" id="dni
                " name="dni">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input required type="email" class="form-control" placeholder="Introduzca su email" id="email"
                    name="email">
            </div>
            <div class="form-group">
                <label for="contrasenya">Contraseña</label>
                <input type="password" class="form-control" placeholder="Introduzca una contraseña" id="contrasenya"
                    name="contrasenya">
            </div>  
              <div class="form-group">
                <label for="contrasenya2">Repetir contraseña</label>
                <input type="password" class="form-control" placeholder="Introduzca de nuevo la contraseña" id="contrasenya2"
                    name="contrasenya2">
            </div>     
          <div class="form-check">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" value="1">Acepto la política de publicidad y las condiciones de servicio.
			  </label>
			</div>
			<div class="form-check mt-2">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" value="1">Acepto recibir información, ocasionalmente, por parte nuestra sobre vuelos que te podrían interesar.
			  </label>
			</div>
			<h5 class="text-center text-white pt-2">${error}</h5>
            <div class="text-center mt-3">
            <button type="submit" class="btn btn-primary">Registrar</button>
            </div>
            <div class="text-center mt-2">
            <a href="./login.jsp" class="text-light">¿Ya tienes cuenta?</a>
            </div>
        </form>
        </div>
        <footer class="pie">
        <div class="limitar-container">  
          </div>
          <div class="pie-copyright">
          </div>
        </footer>
        
</body>
</html>