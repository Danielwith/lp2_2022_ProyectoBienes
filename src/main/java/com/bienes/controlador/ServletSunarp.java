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
import com.bienes.entidad.InscripcionSUNARP;
import com.bienes.services.BienesServices;
import com.bienes.services.InscripcionSUNARPServices;

/**
 * Servlet implementation class ServletBienes
 */
@WebServlet("/ServletSunarp")
public class ServletSunarp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//declarar objeto de la clase BienesService
		private InscripcionSUNARPServices servicio;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSunarp() {
        super();
      //crear objeto
        servicio=new InscripcionSUNARPServices();
 
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
					listarSUNARP(request,response);
				}
				else if(accion.equals("REGISTRAR")) {
					registrarSUNARP(request,response);
				}
				else if(accion.equals("ELIMINAR")) {
					eliminarSUNARP(request,response);
				}
	}

	private void eliminarSUNARP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					request.setAttribute("MENSAJE", "Inscripcion SUNARP eliminado correctamente");
					listarSUNARP(request, response);
				}
				else {
					request.setAttribute("MENSAJE", "Error en la eliminación");
					listarSUNARP(request, response);
				}
		
	}

	private void registrarSUNARP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
				String cod,descrip,cant,prec,nompro,fechalle;
				//leer controles de la página docente.jsp "trabajar con el atributo name"
				cod=request.getParameter("codigo");
				descrip=request.getParameter("descripcion");
				cant=request.getParameter("cantidad");
				prec=request.getParameter("precio");
				nompro=request.getParameter("nombreproveedor");
				fechalle=request.getParameter("fechallegada");
				//crear objeto de la clase Docente
				InscripcionSUNARP bean=new InscripcionSUNARP();
				//setear los atributos del objeto "bean" con las variables	
				bean.setDescrip_bien(descrip);
				bean.setCantidad_bien(Integer.parseInt(cant));
				bean.setPrecio_bien(Double.valueOf(prec));
				bean.setNom_provee(nompro);
				bean.setFecha_llegada(Date.valueOf(fechalle));
				//validar variable "cod"
				if(Integer.parseInt(cod)==0) {
					//invocar al método save
					int salida;
					salida=servicio.registrar(bean);
					//validar
					if(salida>0) {
						//direccionar a la página "docente.jsp" y enviar el parámetro "MENSAJE" con el valor de éxito
						//response.sendRedirect("docente.jsp?MENSAJE=Docente registrado correctamente");
						request.setAttribute("MENSAJE", "Inscripcion SUNARP registrada correctamente");
						listarSUNARP(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en el registro de la inscripcion");
						listarSUNARP(request, response);
					}
				}
				else {
					//setear atributo codigo
					bean.setCodigo_inscri(Integer.parseInt(cod));
					//invocar al método update
					int salida;
					salida=servicio.actualizar(bean);
					//validar
					if(salida>0) {
						request.setAttribute("MENSAJE", "Bien actualizado correctamente");
						listarSUNARP(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en la actualización");
						listarSUNARP(request, response);
					}
				}
				
			}

		

	private void listarSUNARP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al método listAll
				List<InscripcionSUNARP> data=servicio.listarTodos();
				//crear un atributo que almacene el valor del arreglo de objetos "data"
				request.setAttribute("listarSUNARP", data);
				//direccionar a la página docente.jsp para que reciba el atributo "listaDocentes"
				request.getRequestDispatcher("/InscripcionSUNARP.jsp").forward(request, response);
				
			}
			
	

}
