package com.bienes.controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.entidad.GuiayOrdendeCompra;
import com.bienes.services.GuiaServices;

/**
 * Servlet implementation class ServletGuia
 */
@WebServlet("/ServletGuia")
public class ServletGuia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GuiaServices servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuia() {
        super();
        
        servicio=new GuiaServices();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion;
		accion=request.getParameter("tipo");
		if(accion.equals("LISTAR")) {
			listarGuia(request,response);
		}
		else if(accion.equals("REGISTRAR")) {
			registarGuia(request,response);
		}
		else if(accion.equals("ELIMINAR")) {
			eliminarGuia(request,response);
		}
		
	}

	private void listarGuia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuiayOrdendeCompra> data=servicio.listarTodos();
		request.setAttribute("listarGuia", data);
		request.getRequestDispatcher("/Guia.jsp").forward(request, response);
	}

	private void registarGuia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod,nom,fecha,descri,cant,precio;
		
		cod=request.getParameter("codigo");
		nom=request.getParameter("nombre");
		fecha=request.getParameter("fecha");
		descri=request.getParameter("descripcion");
		cant=request.getParameter("cantidad");
		precio=request.getParameter("precio");
		
		GuiayOrdendeCompra bean=new GuiayOrdendeCompra();
		
		bean.setNom_provee(nom);
		bean.setFecha_compra(Date.valueOf(fecha));
		bean.setDescripcionguiacompra(descri);
		bean.setCantidadguiacompra(cant);
		bean.setPrecioguiacompra(Double.valueOf(precio));
		
		if(Integer.parseInt(cod)==0) {
			int salida;
			salida=servicio.registrar(bean);
			
			if(salida>0) {
				request.setAttribute("MENSAJE", "Guia registrado correctamente");
				listarGuia(request, response);
			}
			else {
				request.setAttribute("MENSAJE", "Error en el registro");
				listarGuia(request, response);
			}
		}
		else {
			bean.setCodigoguiacompra(Integer.parseInt(cod));
			
			int salida;
			salida=servicio.actualizar(bean);
			
			if(salida>0) {
				request.setAttribute("MENSAJE", "Guia actualizado correctamente");
				listarGuia(request, response);
			}
			else {
				request.setAttribute("MENSAJE", "Error en la actualizacion");
				listarGuia(request, response);
			}
		}
	}

	private void eliminarGuia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			listarGuia(request, response);
		}
		else {
			request.setAttribute("MENSAJE", "Error en la eliminación");
			listarGuia(request, response);
		}
		
	}

}
