package com.bienes.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.entidad.Operador;
import com.bienes.services.OperadorServices;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletOperadorJSON
 */
@WebServlet("/ServletOperadorJSON")
public class ServletOperadorJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOperadorJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
				String codi=request.getParameter("idope");
				
				Operador lista=new OperadorServices().buscarPorIdOpe(Integer.parseInt(codi));
				
						Gson gson=new Gson();
						
						String json=gson.toJson(lista);
						
						response.setContentType("application/json;charset=UTF-8");
						PrintWriter salida=response.getWriter();
						salida.println(json);
		
		
	}

}
