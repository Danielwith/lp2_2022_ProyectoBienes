package com.bienes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.dao.MySqlOperadorDAO;
import com.bienes.entidad.Operador;
import com.bienes.services.OperadorServices;

/**
 * Servlet implementation class ServletOperador
 */
@WebServlet("/ServletOperador")
public class ServletOperador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		private OperadorServices servicio2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOperador() {
        super();
        
        servicio2=new OperadorServices();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion;
		accion=request.getParameter("tipo");
		if(accion.equals("LISTAR")) {
			listarOperador(request,response);
		}
		else if(accion.equals("REGISTRAR")) {
			registrarOperador(request,response);
		}
		else if(accion.equals("ELIMINAR")) {
			eliminarOperador(request,response);
		}
		
	}
	
	private void eliminarOperador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codi;
		codi=request.getParameter("codigoEliminar");
		
		int salida;
		salida=servicio2.eliminarPorIdOpe(Integer.parseInt(codi));
		//validar
		if(salida>0) {
			
			request.setAttribute("MENSAJE", "Operador eliminado correctamente");
			listarOperador(request, response);
		}
		else {
			request.setAttribute("MENSAJE", "Error en la eliminación");
			listarOperador(request, response);
		}

	}
	
	private void registrarOperador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
				String codi,nomOpe,distOpe,celOpe,estOpe;
				
				codi=request.getParameter("idope");
				nomOpe=request.getParameter("nombreOperador");
				distOpe=request.getParameter("distritoOperador");
				celOpe=request.getParameter("celularOperador");
				estOpe=request.getParameter("estadoOperador");
				
				Operador bean = new Operador();
						
				bean.setNom_ope(nomOpe);
				bean.setDist_ope(distOpe);
				bean.setCel_ope(Integer.parseInt(celOpe));
				bean.setEstado_ope(estOpe);
				
				//validar variable "id"
				if(Integer.parseInt(codi)==0) {
					
					int salida;
					salida=servicio2.registrarOpe(bean);
					//validar
					if(salida>0) {						
						request.setAttribute("MENSAJE", "Operador registrado correctamente");
						listarOperador(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en el registro del Operador");
						listarOperador(request, response);
					}
				}
				else {
					
					bean.setId_ope(Integer.parseInt(codi));
					
					int salida;
					salida=servicio2.actualizarOpe(bean);
					//validar
					if(salida>0) {
						request.setAttribute("MENSAJE", "Proveedor actualizado correctamente");
						listarOperador(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en la actualización");
						listarOperador(request, response);
					}
				}
				
			}
	
	
	private void listarOperador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Operador> data=servicio2.listarTodos();
		
		request.setAttribute("listarOperador", data);				
		request.getRequestDispatcher("/operador.jsp").forward(request, response);
		
	}

}










