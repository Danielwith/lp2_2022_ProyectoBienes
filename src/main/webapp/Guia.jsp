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
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">?
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
<body>
	<jsp:include page="partialMenu.jsp"></jsp:include>
	<div class="container home">

		<h1 class="text-center mt-5">Listado de Guia</h1>
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE} 
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Registrar
		</button>
				
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">GUIA</h5>
		      </div>
		      <div class="modal-body">		        
		        <form id="idRegistrar" method="post" action="ServletGuia?tipo=REGISTRAR">
				  <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">C?digo</label>
				    <input type="text" class="form-control" name="codigo" id="idCodigo" readonly value="0">
				  </div>
				
				  <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Proveedor</label>
				    <input type="text" class="form-control" name="nombre" id="idNombre">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Fecha Compra</label>
				    <input type="text" class="form-control" name="fecha" id="idFecha">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Descripcion</label>
				    <input type="text" class="form-control" name="descripcion" id="idDescripcion">
				  </div>			
				  	  
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Cantidad</label>
				    <input type="text" class="form-control" name="cantidad" id="idCantidad">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Precio</label>
				    <input type="text" class="form-control" name="precio" id="idPrecio">
				  </div>	
				  		  				  				  
				  <div class="modal-footer">
				  	<button type="submit" class="btn btn-success">Grabar</button>
			        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
			      </div>				  
				</form>		       		        		        
		      </div>
		    </div>
		  </div>
		</div>
		<!-- modal para eliminar -->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">Sistema</h5>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistrar" method="post" action="ServletGuia?tipo=ELIMINAR">
				    <input type="hidden" class="form-control" name="codigoEliminar" id="codigoEliminar">
				  <h4>Seguro de eliminar?</h4>
				  <div class="modal-footer">
				  	<button type="submit" class="btn btn-primary">SI</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
			      </div>			  
				</form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="mt-4">
			<table id="example" class="table table-striped" style="width:100%">
		        <thead>
		            <tr>
		                <th>C?DIGO</th>
		                <th>PROVEEDOR</th>
		                <th>FECHA COMPRA</th>
		                <th>DESCRIPCION</th>
		                <th>CANTIDAD</th>
		                <th>PRECIO</th>
		                <th></th>
		                <th></th>
		            </tr>
		        </thead>
		        <tbody>
		        		<c:forEach items="${requestScope.listarGuia}" var="row">
				            <tr>
				                <td>${row.codigoguiacompra}</td>
				                <td>${row.nom_provee}</td>
				                <td>${row.fecha_compra}</td>
				                <td>${row.descripcionguiacompra}</td>
				                <td>${row.cantidadguiacompra}</td>
				                <td>${row.precioguiacompra}</td>
				                <td><button type="button" class="btn btn-success" 
				                			data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button></td>
				                <td><button type="button" class="btn btn-danger" 
				                			data-bs-toggle="modal" data-bs-target="#modalEliminar">Eliminar</button></td>
				            </tr>
				        </c:forEach>    
				            
		        </tbody>
		    </table>
		
		
		
		</div>




	</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>

<!-- JS para validaci?n-->
<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

<script>
	$(document).ready(function() {
	    $('#example').DataTable();
	} );
	
	//aisgnar evento click a todos los botones con nombre de clase "btn-danger"
	$(document).on("click",".btn-danger",function(){
		//variable
		let cod;
		//obtener el c?digo del docente seg?n el bot?n eliminar que se a pulsado
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		//asignar a la caja con id "codigoEliminar" el valor de la variable "cod"
		$("#codigoEliminar").val(cod);
		
	})
	//aisgnar evento click a todos los botones con nombre de clase "btn-success"
	$(document).on("click",".btn-success",function(){
		//variables
		let cod,nomprovee,fechacompra,descrip,cant,precio;
		//obtener los datos de todas las columnas seg?n el bot?n editar que se a pulsado
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		nomprovee=$(this).parents("tr").find("td")[1].innerHTML;
		fechacompra=$(this).parents("tr").find("td")[2].innerHTML;
		descrip=$(this).parents("tr").find("td")[3].innerHTML;
		cant=$(this).parents("tr").find("td")[4].innerHTML;
		precio=$(this).parents("tr").find("td")[5].innerHTML;
		
		$.get("ServletGuiaJSON?codigo="+cod,function(response){
			//console.log(response);
			//asignar a los controles las claves del par?metro response
			$("#idCodigo").val(cod);
			$("#idNombre").val(response.nom_provee);
			$("#idFecha").val(response.fecha_compra);
			$("#idDescripcion").val(response.descripcionguiacompra);
			$("#idCantidad").val(response.cantidadguiacompra);
			$("#idPrecio").val(response.precioguiacompra);
					
		})	
		
	})				
		
</script>
<script type="text/javascript">    
    $(document).ready(function(){     
        $('#idRegistrar').bootstrapValidator({
        	 fields:{
        		     nombre:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo proveedor es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z\?\?\s\?\?\?\?\?\?\?\?\?\?]{4,20}$/,
        		 				message:'Campo proveedor MIN:4 - MAX:20'
        		 			}
        		 		}
        		 	},
        		 	
        		 fecha:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo fecha es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^([0-9]{4})-([0-9]{1,2})-([0-9]{1,2})$/,
        		 				message:'Campo fecha es obligatorio yyyy-mm-dd'
        		 			}
        		 			
        		 		}
        		 	},
        		 	
        		 	descripcion:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo descripci?n es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z\?\?\s\?\?\?\?\?\?\?\?\?\?]{4,20}$/,
        		 				message:'Campo descripci?n solo letras MIN:4 - MAX:20'
        		 			}
        		 		}
        		 	},
        		 	
        		 	cantidad:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo cantidad es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^\d+$/,
        		 				message:'Campo cantidad debe ser #entero positivo'
        		 			}
        		 		}
        		 	},
        		 	
        		 	precio:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo precio es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^\d+$/,
        		 				message:'Campo precio debe ser numerico'
        		 			}
        		 		}
        		 	}
        		 	
        	 }
        });   			
    });    
</script> 
</body>
</html>








