package com.bienes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.entidad.GuiayOrdendeCompra;
import com.bienes.services.GuiaServices;
import com.google.gson.Gson;

import com.bienes.entidad.GuiayOrdendeCompra;
import com.bienes.services.GuiaServices;

@WebServlet("/ServletGuiaListaJSON")
public class ServletGuiaListaJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletGuiaListaJSON() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuiayOrdendeCompra> lista=new GuiaServices().listarTodos();
		//PASO 2: crear objeto de la clase Gson
		Gson gson=new Gson();
		//PASO 3: generar json del arreglo "lista" en formato String
		String json=gson.toJson(lista);
		//PASO 4: mostrar el valor de la variable "json" en formato JSON verdadero
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);		
		
	}

}
