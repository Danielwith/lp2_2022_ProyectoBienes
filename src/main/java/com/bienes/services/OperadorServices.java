package com.bienes.services;

import java.util.List;

import com.bienes.entidad.Operador;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.OperadorDAO;

public class OperadorServices {

	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);			
	private OperadorDAO objOperador=fabrica.getOperadorDAO();
		
		public int registrarOpe(Operador bean) {
			return objOperador.saveOpe(bean);
		}
		public int actualizarOpe(Operador bean) {
			return objOperador.updateOpe(bean);
		}
		public int eliminarPorIdOpe(int codi) {
			return objOperador.deleteOpe(codi);
		}
		public Operador buscarPorIdOpe(int codi) {
			return objOperador.findByIdOpe(codi);
		}
		public List<Operador> listarTodos(){
			return objOperador.listAll();
	}
		
}
