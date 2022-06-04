package com.bienes.services;

import java.util.List;

import com.bienes.entidad.*;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.LoginDAO;

public class LoginServices {
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private LoginDAO objUsuario=fabrica.getLoginDAO();
	
	public Usuario loginUsuario(String login, String clave) {
		return objUsuario.iniciarSesion(login, clave);
	}
	public List<Menu> menuDelUsuario(int codUsu) {
		return objUsuario.traerOpciones(codUsu);
	}
}
