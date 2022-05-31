package com.bienes.controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.dao.MySqlBienesDAO;
import com.bienes.entidad.Bienes;
import com.bienes.services.BienesServices;

/**
 * Servlet implementation class ServletBienes
 */
@WebServlet("/ServletBienes")
public class ServletBienes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//declarar objeto de la clase BienesService
		private BienesServices servicio;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBienes() {
        super();
      //crear objeto
        servicio=new BienesServices();
 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener el tipo de acción que va a realizar el Servlet
				String accion;
				accion=request.getParameter("tipo");
				if(accion.equals("LISTAR")) {
					listarBienes(request,response);
				}
				else if(accion.equals("REGISTRAR")) {
					registrarBienes(request,response);
				}
				else if(accion.equals("ELIMINAR")) {
					eliminarBienes(request,response);
				}
	}

	private void eliminarBienes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leer caja con atributo name "codigoEliminar"
				String cod;
				cod=request.getParameter("codigoEliminar");
				//invocar al método delete y enviar la variable "cod"
				int salida;
				salida=servicio.eliminarPorId(Integer.parseInt(cod));
				//validar
				if(salida>0) {
					//direccionar a la página "docente.jsp" y enviar el parámetro "MENSAJE" con el valor de éxito
					//response.sendRedirect("docente.jsp?MENSAJE=Docente registrado correctamente");
					request.setAttribute("MENSAJE", "Bien eliminado correctamente");
					listarBienes(request, response);
				}
				else {
					request.setAttribute("MENSAJE", "Error en la eliminación");
					listarBienes(request, response);
				}
		
	}

	private void registrarBienes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
				String cod,descrip,cant,nomprovee,fechallegada,nomope,idprovee,codigocompra;
				//leer controles de la página docente.jsp "trabajar con el atributo name"
				cod=request.getParameter("codigo");
				descrip=request.getParameter("descripcion");
				cant=request.getParameter("cantidad");
				nomprovee=request.getParameter("nombreproveedor");
				fechallegada=request.getParameter("fechallegada");
				nomope=request.getParameter("nombreoperador");
				idprovee=request.getParameter("idproveedor");
				codigocompra=request.getParameter("codigocompra");
				//crear objeto de la clase Docente
				Bienes bean=new Bienes();
				//setear los atributos del objeto "bean" con las variables	
				bean.setDescrip_bien(descrip);
				bean.setCantidad_bien(Integer.parseInt(cant));
				bean.setNom_provee(nomprovee);
				bean.setFecha_llegada(Date.valueOf(fechallegada));
				bean.setNom_operador(nomope);
				bean.setIdproveedor(Integer.parseInt(idprovee));
				bean.setCodigoOrdendeCompra(Integer.parseInt(codigocompra));
				//validar variable "cod"
				if(Integer.parseInt(cod)==0) {
					//invocar al método save
					int salida;
					salida=servicio.registrar(bean);
					//validar
					if(salida>0) {
						//direccionar a la página "docente.jsp" y enviar el parámetro "MENSAJE" con el valor de éxito
						//response.sendRedirect("docente.jsp?MENSAJE=Docente registrado correctamente");
						request.setAttribute("MENSAJE", "Bien registrado correctamente");
						listarBienes(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en el registro del bien");
						listarBienes(request, response);
					}
				}
				else {
					//setear atributo codigo
					bean.setCodigo_bien(Integer.parseInt(cod));
					//invocar al método update
					int salida;
					salida=servicio.actualizar(bean);
					//validar
					if(salida>0) {
						request.setAttribute("MENSAJE", "Bien actualizado correctamente");
						listarBienes(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en la actualización");
						listarBienes(request, response);
					}
				}
				
			}

		

	private void listarBienes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al método listAll
				List<Bienes> data=servicio.listarTodos();
				//crear un atributo que almacene el valor del arreglo de objetos "data"
				request.setAttribute("listarBienes", data);
				//direccionar a la página docente.jsp para que reciba el atributo "listaDocentes"
				request.getRequestDispatcher("/Bienes.jsp").forward(request, response);
				
			}
			
	

}
