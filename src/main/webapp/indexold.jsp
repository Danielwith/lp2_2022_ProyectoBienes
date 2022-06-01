<%
	if(request.getSession().getAttribute("LISTA")==null)
		response.sendRedirect("login.jsp");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
.action{
	color: black;
	background-color: yellow;
	transition: 0.7s;
}

.action:hover{ 
	color: white;
	background-color:blue;
}
body{
background: rgb(13,83,84);
		background-image:url("https://quiasma.com.mx/wp-content/uploads/2017/03/fondo-blanco.jpg");
		background-repeat: no-repeat;
		background-attachment: fixed;
}


</style>
<body>
<div class="container" style="">
	<!-- MENSAJE DE LOGEO ALERTA AL INICIAR SESION -->
	<!--  
	<h1 class="text-center mt-5">Listado de Docentes</h1>
				<c:if test="${requestScope.MENSAJE!=null}">
					<div class="alert alert-warning alert-dismissible fade show" role="alert">
					  <strong>MENSAJE : </strong> ${requestScope.MENSAJE} 
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
-->
	<!-- Nav -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Gestion de Bienes</a>
	    <a href="login.jsp" class="btn btn-primary sign-up-btn" aria-expanded="false">Cerrar Sesión</a>
	  </div>
</nav>
<div class="alert alert-primary text-center mt-2">
Seleccione la accion que desea realizar
</div>
<!--  Necesitamos un for para crear el contenido "botones" que puede realizar el usuario -->
<div class="container bg-dark">
	  <div class="row">
	    <div class="col">
	      <div class="card mb-3" style="max-width: 540px; top:10px">
	      <a style="text-decoration: none" href="#">
		  	<div class="row g-0 action">
		    	<div class="col-md-4">
		      		<img src="img/log.jpg" class="img-fluid rounded-start p-2" alt="...">
		    	</div>
		    	<div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Card title</h5>
			        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
			      </div>
		    	</div>
		  	 </div>
		  	</a>
			</div>
    	  </div>
  		</div>
</div>
</div>
</body>
</html>