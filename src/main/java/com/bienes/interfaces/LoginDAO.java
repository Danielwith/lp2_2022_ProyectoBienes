package com.bienes.interfaces;
import com.bienes.entidad.Usuario;
import java.util.List;
import com.bienes.entidad.Menu;

public interface LoginDAO {
	public Usuario iniciarSesion(String login, String clave);
	public List<Menu> traerOpciones(int codUsu);
}
