package com.bienes.services;

import java.util.List;

import com.bienes.entidad.Proveedor;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.ProveedorDAO;

public class ProveedorServices {

	
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);			
	private ProveedorDAO objProveedor=fabrica.getProveedorDAO();
		
		public int registrarPro(Proveedor bean) {
			return objProveedor.savePro(bean);
		}
		public int actualizarPro(Proveedor bean) {
			return objProveedor.updatePro(bean);
		}
		public int eliminarPorIdPro(int id) {
			return objProveedor.deletePro(id);
		}
		public Proveedor buscarPorIdPro(int id) {
			return objProveedor.findByIdPro(id);
		}
		public List<Proveedor> listarTodos(){
			return objProveedor.listAll();
	}
	
}
