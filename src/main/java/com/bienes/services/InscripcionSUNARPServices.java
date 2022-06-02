package com.bienes.services;

import java.util.List;

import com.bienes.entidad.InscripcionSUNARP;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.InscripcionSUNARPDAO;

public class InscripcionSUNARPServices {

	//PASO 1: definir origen de datos, invocar al método getDAOFactory y enviar como parámetro un #ro.
		private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
		//PASO 2: definir dao a utilizar
		private InscripcionSUNARPDAO objSUNARP=fabrica.getInscripcionSUNARPDAO();
		
		//métodos de servicio
		public int registrar(InscripcionSUNARP  bean) {
			return objSUNARP.save(bean);
		}
		public int actualizar(InscripcionSUNARP  bean) {
			return objSUNARP.update(bean);
		}
		public int eliminarPorId(int cod) {
			return objSUNARP.delete(cod);
		}
		public InscripcionSUNARP  buscarPorId(int cod) {
			return objSUNARP.findById(cod);
		}
		public List<InscripcionSUNARP > listarTodos(){
			return objSUNARP.listAll();
		}
		
		
}
