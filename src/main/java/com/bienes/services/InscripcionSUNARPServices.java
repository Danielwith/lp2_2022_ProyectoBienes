package com.bienes.services;

import java.util.List;

import com.bienes.entidad.InscripcionSUNARP;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.InscripcionSUNARPDAO;

public class InscripcionSUNARPServices {

	//PASO 1: definir origen de datos, invocar al m�todo getDAOFactory y enviar como par�metro un #ro.
		private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
		//PASO 2: definir dao a utilizar
		private InscripcionSUNARPDAO objSUNARP=fabrica.getInscripcionSUNARPDAO();
		
		//m�todos de servicio
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
