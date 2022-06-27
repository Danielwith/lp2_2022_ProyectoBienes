<%
	if(request.getSession().getAttribute("LISTA")==null)
		response.sendRedirect("login.jsp");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Bien por Codigo de Compra</title>

	<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">´
<link rel="stylesheet" href="css/stylePages.css">
<style>
	body{
		background-image:url("https://quiasma.com.mx/wp-content/uploads/2017/03/fondo-blanco.jpg");
		background-repeat: no-repeat;
		background-attachment: fixed;
	}
	
	.bg{
		background-position:center center;
	}
</style>
<style type="text/css">
	.modal-header{
		color:#fff;
		background: black;
		display: flex;
  		justify-content: center;  		
  		
	}
	.help-block {
	  		color: red;
	}
	.form-group.has-error .form-control-label {
	  color: red;
	}
	.form-group.has-error .form-control {
	  border: 1px solid red;
	  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
	}
</style>
</head>
<jsp:include page="partialMenu.jsp"></jsp:include>
	<!-- Añadir class .home  -->
	<div class="container home">
			<c:if test="${param.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${param.MENSAJE} 
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			<c:remove var="param.MENSAJE"/>
		<h2 class="text-center mt-5">Consultar Bien por Codigo de Compra</h2>
		<form>
		   <div class="form-row mt-5">
			    <div class="col-auto">
			       
			    </div>
			    
			    
			   <div class="form-group">
				  
				    <select class="form-control" name="condicion" id="idCompra">
				      <option value=" ">[Seleccione Codigo Compra]</option>
				    </select>
				  </div>
			    
			    
			    
			    <div class="col-auto mt-2">
			      <button type="button" class="btn btn-success mb-2" id="btn-consultar">Consultar</button>
			    </div>
			    
		  </div>
		</form>
		
		<div class="mt-4">
			<table id="tableConsultar" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		               <th>CÓDIGO DEL BIEN</th>
		                <th>DESCRIPCIÓN</th>
		                <th>CANTIDAD</th>
		                <th>PROVEEDOR</th>
		                <th>FECHA LLEGADA</th>
		                 <th>CODIGO COMPRA</th>
		                <th></th>
		            </tr>
		        </thead>
		        <tbody>
				</tbody>
			</table>	
		</div>
		
		
		<!-- FIN - Modal PARA EDITAR-->		
		
		
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<script>
		//
		llenarTabla();
		
		
		
		$(document).on("click","#btn-consultar",function(){
			let cod;
			cod=$("#idCompraBuscar").val();
			$("#tableConsultar tbody").empty();
			$.get("ServletBienporCompraJSON?cod="+cod,function(response){
				$.each(response,function(index,item){
					$("#tableConsultar").append("<tr><td>"+item.codigo_bien+"</td><td>"+
							item.descrip_bien+"</td><td>"+item.cantidad_bien+"</td><td>"+
							item.nom_provee+"</td><td>"+item.fecha_llegada+"</td><td>"+
							item.codigoOrdendeCompra+"</td>"+
							"<button type='button' class='btn btn-success btn-datos' data-bs-toggle='modal'"+
							"data-bs-target='#BienModal'>Editar</button></td></tr>");
				})
			})
		})	
		
		
		
		$(document).on("click","#btn-consultar",function(){
			let cod;
			cod=$("#idCompra").val();
			$("#tableConsultar tbody").empty();
			$.get("ServletBienporCompraJSON?cod="+cod,function(response){
				$.each(response,function(index,item){
					$("#tableConsultar").append("<tr><td>"+item.codigo_bien+"</td><td>"+
							item.descrip_bien+"</td><td>"+item.cantidad_bien+"</td><td>"+
							item.nom_provee+"</td><td>"+item.fecha_llegada+"</td><td>"+
							item.codigoOrdendeCompra+"</td>"+
							"<button type='button' class='btn btn-success btn-datos' data-bs-toggle='modal'"+
							"data-bs-target='#BienModal'>Editar</button></td></tr>");
				})
			}) 	
		})	
		
		
		
		
		
		function llenarTabla(){
			$.get("ServletGuiaListaJSON",function(response){
				$.each(response,function(index,item){
					$("#idCompra").append("<option>"+item.codigoguiacompra+"</option>");
					
				})
			})
		}
		


		

		
		
		$(document).on("click",".btn-datos",function(){
				
			let cod,descrip,cant,nomprovee,fechallegada,codigocompra;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			descrip=$(this).parents("tr").find("td")[1].innerHTML;
			cant=$(this).parents("tr").find("td")[2].innerHTML;
			nomprovee=$(this).parents("tr").find("td")[3].innerHTML;
			fechallegada=$(this).parents("tr").find("td")[4].innerHTML;
			codigocompra=$(this).parents("tr").find("td")[5].innerHTML;
			
				//console.log(response);
				//asignar a los controles las claves del parámetro response
				$("#idCodigo").val(cod);
				$("#idDescripcion").val(descrip);
				$("#idCantidad").val(cant);
				$("#idNombreproveedor").val(nomprovee);
				$("#idFechallegada").val(fechallegada);
				$("#idCompra").val(codigocompra);
			
		})
		
		//
		
	
		
		
		
		
	</script>
</body>
</html>









