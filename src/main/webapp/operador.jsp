<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if(request.getSession().getAttribute("LISTA")==null)
		response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operador</title>

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
<body>
	<jsp:include page="partialMenu.jsp"></jsp:include>
	<!-- Añadir class .home  -->
	  <div class="container home">
		<h1 class="text-center mt-5">Listado de Operadores</h1>
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE} 
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Nuevo Operador
		</button>
				
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">OPERADOR</h5>
		      </div>
		      <div class="modal-body">		        
		        <form id="idRegistrar" method="post" action="ServletOperador?tipo=REGISTRAR">
		        
			 
					  <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">ID</label>
					    <input type="text" class="form-control" name="idope" id="idOperador" readonly value="0">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Nombre Operador</label>
					    <input type="text" class="form-control" name="nombreOperador" id="idNombreOperador">
					  </div>		
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Distrito</label>
					    <input type="text" class="form-control" name="distritoOperador" id="idDistritoOperador">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Celular</label>
					    <input type="text" class="form-control" name="celularOperador" id="idCelularOperador">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Estado</label>
					    <input type="text" class="form-control" name="estadoOperador" id="idEstadoOperador">
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
		        <form id="idRegistrar" method="post" action="ServletOperador?tipo=ELIMINAR">
				    <input type="hidden" class="form-control" name="codigoEliminar" id="codigoEliminar">
				  <h4>¿Desea eliminar?</h4>
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
		                <th>CÓDIGO</th>
		                <th>NOMBRE OPERADOR</th>
		                <th>DISTRITO</th>
		                <th>CELULAR</th>
		                <th>ESTADO</th>
		                <th></th>
		                <th></th>
		            </tr>
		        </thead>
		        <tbody>
		        		<c:forEach items="${requestScope.listarOperador}" var="row">
				            <tr>
				                <td>${row.id_ope}</td>
				                <td>${row.nom_ope}</td>
				                <td>${row.dist_ope}</td>
				                <td>${row.cel_ope}</td>
				                <td>${row.estado_ope}</td>
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

<!-- JS para validación-->
<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

<script>
	$(document).ready(function() {
	    $('#example').DataTable();
	    //$("#example tbody").empty();
	} );
	
	//aisgnar evento click a todos los botones con nombre de clase "btn-danger"
	$(document).on("click",".btn-danger",function(){
		//variable
		let codi;
		//obtener el código del docente según el botón eliminar que se a pulsado
		codi=$(this).parents("tr").find("td")[0].innerHTML;
		//asignar a la caja con id "codigoEliminar" el valor de la variable "cod"
		$("#codigoEliminar").val(codi);
		
	})
	//asignar evento click a todos los botones con nombre de clase "btn-success"
	$(document).on("click",".btn-success",function(){
		//variables
		let codi,nomOpe,distOpe,celOpe,estOpe;
		//obtener los datos de todas las columnas según el botón editar que se a pulsado
		codi=$(this).parents("tr").find("td")[0].innerHTML;
		nomOpe=$(this).parents("tr").find("td")[1].innerHTML;
		distOpe=$(this).parents("tr").find("td")[2].innerHTML;
		celOpe=$(this).parents("tr").find("td")[3].innerHTML;
		estOpe=$(this).parents("tr").find("td")[4].innerHTML;
		
		
		$.get("ServletOperadorJSON?idope="+codi,function(response){         // SSDFDSFSDFDSFSDFSDFSDFSDFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
			//console.log(response);
			//asignar a los controles las claves del parámetro response
			$("#idOperador").val(codi);
			$("#idNombreOperador").val(response.nom_ope);
			$("#idDistritoOperador").val(response.dist_ope);
			$("#idCelularOperador").val(response.cel_ope);
			$("#idEstadoOperador").val(response.estado_ope);
			
		})			
	})							
	
		
</script>
<script type="text/javascript">    
    $(document).ready(function(){     
        $('#idRegistrar').bootstrapValidator({      
        	 fields:{
        		  nombreOperador:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo Nombre es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z\ñ\Ñ\s\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{4,20}$/,
        		 				message:'Solo letras MIN:4 - MAX:20'
        		 			}
        		 		}
        		 	},
        		 	distritoOperador:{       		 		
        		 			validators:{
            		 			notEmpty:{
            		 				message:'Campo Distrito es obligatorio'
            		 			},
            		 			regexp:{
            		 				regexp:/^[a-zA-Z\ñ\Ñ\s\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{4,20}$/,
            		 				message:'Solo letras MIN:3 - MAX:20'
            		 			}
        		 		  }        		 		
        		 	},
        		 	estadoOperador:{
        		 		
        		 			validators:{
            		 			notEmpty:{
            		 				message:'Campo estado es obligatorio'
            		 			},
            		 			regexp:{
            		 				regexp:/^[a-zA-Z\ñ\Ñ\s\á\é\í\ó\ú\Á\É\Í\Ó\Ú]{4,20}$/,
            		 				message:'Solo letras MIN:3 - MAX:20'
            		 			}
        		 		   }
        		 	 },
        	 		 celularOperador:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo celular es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^\d+$/,
        		 				message:'Este campo debe ser numerico'
        		 			}
        		 		}
        		 	}	      		 	             	 
        		}
        });   			
    });    
</script> 
</body>
</html>