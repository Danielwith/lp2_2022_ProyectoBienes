package com.bienes.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.entidad.Proveedor;
import com.bienes.services.ProveedorServices;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletProveedorJSON
 */
@WebServlet("/ServletProveedorJSON")
public class ServletProveedorJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedorJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
				String id=request.getParameter("idpro");
				
				Proveedor lista = new ProveedorServices().buscarPorIdPro(Integer.parseInt(id));
				
					Gson gson=new Gson();
						
					String json=gson.toJson(lista);
						
					response.setContentType("application/json;charset=UTF-8");
					PrintWriter salida=response.getWriter();
					salida.println(json);
						
	}

}
