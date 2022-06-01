package com.bienes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bienes.entidad.Menu;
import com.bienes.entidad.Usuario;
import com.bienes.services.LoginServices;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginServices servicio = new LoginServices();
	
    public ServletLogin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion;
		accion = request.getParameter("tipo");
		if(accion.equals("INICIAR"))
			iniciarSesion(request,response);
		else if(accion.equals("CERRAR"))
			cerrarSesion(request,response);
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar valores de las cajas
		String vLogin,vPassword;
		vLogin=request.getParameter("idusuario");
		vPassword=request.getParameter("password");
		//invocar al método loginUsuario
		Usuario bean=servicio.loginUsuario(vLogin, vPassword);
		//validar bean
		if(bean==null) {//usuario y/o clave incorrectos
			request.setAttribute("MENSAJE", "Usuario y/o clave incorrectos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {//todo ok
			//invocar al método menuDelUsuario
			List<Menu> data=servicio.menuDelUsuario(bean.getCodigo());
			//crear atributo de tipo sesión
			HttpSession session=request.getSession();
			session.setAttribute("LISTA", data);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
		
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar sesesión actual
		HttpSession session=request.getSession();
		//invalidar sesión "destruir todos los atributos de tipo session"
		session.invalidate();
		request.setAttribute("MENSAJE", "Sesión terminada");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
}
