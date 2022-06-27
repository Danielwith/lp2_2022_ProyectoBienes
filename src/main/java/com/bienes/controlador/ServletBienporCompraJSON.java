package com.bienes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bienes.entidad.Bienes;
import com.bienes.services.BienesServices;
import com.google.gson.Gson;
import com.bienes.entidad.Bienes;
import com.bienes.services.BienesServices;

@WebServlet("/ServletBienporCompraJSON")
public class ServletBienporCompraJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletBienporCompraJSON() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("cod");
		List<Bienes> lista=new BienesServices().listarBienesporCodigodeComptra(Integer.parseInt(codigo));
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
















