<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
	body{
		background: rgb(13,83,84);
		background: linear-gradient(132deg, rgba(13,83,84,1) 0%, rgba(36,85,167,1) 29%, rgba(20,20,163,1) 95%);
		background-repeat: no-repeat;
		background-attachment: fixed;
	}
	
	.bg{
		background-image: url(img/log.jpg);
		background-position:center center;
	}
</style>
</head>	
<body>
	<div class="container w-75 bg-primary mt-5 rounded shadow">
		<div class="row align-items-stretch">
			<div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">
			
			</div>
			<div class="col bg-white p-5 rounded-end">
				<h2 class="fw-bold text-center pt-5 mb-5">Bienvenido</h2>
				<!--  LOGIN -->
				<form action="url">
					<div class="mb-4">
						<label for="id" class="form-label">ID Usuario</label>
						<input type="text" class="form-control" name="idusuario" required="required">
					</div>
					<div class="mb-4 mb-5">
						<label for="password" class="form-label">Contraseña</label>
						<input type="password" class="form-control" name="password" required="required">
					</div>
					<div class="d-grid mb-2">
						<button type="submit" class="btn btn-outline-primary">Iniciar Sesión</button>
					</div>
				</form>
			</div>
		
		</div>
	</div>

</body>
</html>