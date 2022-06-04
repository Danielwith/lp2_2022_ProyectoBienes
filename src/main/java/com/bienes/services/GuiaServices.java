package com.bienes.services;

import java.util.List;

import com.bienes.entidad.GuiayOrdendeCompra;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.GuiaDAO;

public class GuiaServices {

	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	
	private GuiaDAO objGuia=fabrica.getGuiaDAO();
	
	public List<GuiayOrdendeCompra> listarTodos(){
		return objGuia.listAll();
	}
	
	public int registrar(GuiayOrdendeCompra bean) {
		return objGuia.save(bean);
	}
	public int actualizar(GuiayOrdendeCompra bean) {
		return objGuia.update(bean);
	}
	public int eliminarPorId(int cod) {
		return objGuia.delete(cod);
	}
	public GuiayOrdendeCompra buscarPorId(int cod) {
		return objGuia.findById(cod);
	}
	
}
