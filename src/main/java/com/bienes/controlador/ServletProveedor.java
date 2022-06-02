package com.bienes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bienes.dao.MySqlProveedorDAO;
import com.bienes.entidad.Proveedor;
import com.bienes.services.ProveedorServices;


/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
			private ProveedorServices servicio1;
			
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ServletProveedor(){
	        super();
	     
	        servicio1=new ProveedorServices();
	 
	        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String accion;
			accion=request.getParameter("tipo");
			if(accion.equals("LISTAR")) {
				listarProveedor(request,response);
			}
			else if(accion.equals("REGISTRAR")) {
				registrarProveedor(request,response);
			}
			else if(accion.equals("ELIMINAR")) {
				eliminarProveedor(request,response);
			}
		
	}
	
	private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String id;
				id=request.getParameter("codigoEliminar");
				
				int salida;
				salida=servicio1.eliminarPorIdPro(Integer.parseInt(id));
				//validar
				if(salida>0) {
					
					request.setAttribute("MENSAJE", "Proveedor eliminado correctamente");
					listarProveedor(request, response);
				}
				else {
					request.setAttribute("MENSAJE", "Error en la eliminación");
					listarProveedor(request, response);
				}
		
	}
	
	private void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
				String id,nomPro,distPro,telfPro,estPro;
				
				id=request.getParameter("idpro");
				nomPro=request.getParameter("nombreProveedor");
				distPro=request.getParameter("distritoProveedor");
				telfPro=request.getParameter("telefonoProveedor");
				estPro=request.getParameter("estadoProveedor");
				
				Proveedor bean=new Proveedor();
						
				bean.setNom_prove(nomPro);
				bean.setDist_prove(distPro);
				bean.setTelf_prove(telfPro);
				bean.setEstado_prove(estPro);
				
				//validar variable "id"
				if(Integer.parseInt(id)==0) {
					
					int salida;
					salida=servicio1.registrarPro(bean);
					//validar
					if(salida>0) {						
						request.setAttribute("MENSAJE", "Proveedor registrado correctamente");
						listarProveedor(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en el registro del Proveedor");
						listarProveedor(request, response);
					}
				}
				else {
					
					bean.setId_prove(Integer.parseInt(id));
					
					int salida;
					salida=servicio1.actualizarPro(bean);
					//validar
					if(salida>0) {
						request.setAttribute("MENSAJE", "Proveedor actualizado correctamente");
						listarProveedor(request, response);
					}
					else {
						request.setAttribute("MENSAJE", "Error en la actualización");
						listarProveedor(request, response);
					}
				}
				
			}
	
	private void listarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				List<Proveedor> data=servicio1.listarTodos();
				
				request.setAttribute("listarProveedor", data);				
				request.getRequestDispatcher("/proveedor.jsp").forward(request, response);
				
			}
	

}












