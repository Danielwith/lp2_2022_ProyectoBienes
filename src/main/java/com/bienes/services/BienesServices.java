package com.bienes.services;

import java.util.List;

import com.bienes.entidad.Bienes;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.BienesDAO;

public class BienesServices {

	//PASO 1: definir origen de datos, invocar al método getDAOFactory y enviar como parámetro un #ro.
		private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
		//PASO 2: definir dao a utilizar
		private BienesDAO objBienes=fabrica.getBienesDAO();
		

		
		//métodos de servicio
		public int registrar(Bienes bean) {
			return objBienes.save(bean);
		}
		public int actualizar(Bienes bean) {
			return objBienes.update(bean);
		}
		public int eliminarPorId(int cod) {
			return objBienes.delete(cod);
		}
		public Bienes buscarPorId(int cod) {
			return objBienes.findById(cod);
		}
		public List<Bienes> listarTodos(){
			return objBienes.listAll();
		}
		public List<Bienes> listarBienesporCodigodeComptra(int cod) {
			return objBienes.listarBienesporCodigodeComptra(cod);
		}

		
}
