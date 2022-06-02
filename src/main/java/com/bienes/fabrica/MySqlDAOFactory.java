package com.bienes.fabrica;

import com.bienes.dao.MySqlBienesDAO;
import com.bienes.dao.MySqlInscripcionSUNARPDAO;
import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.InscripcionSUNARPDAO;

public class MySqlDAOFactory extends DAOFactory {
	
	public BienesDAO getBienesDAO() {
		// TODO Auto-generated method stub
		return new MySqlBienesDAO();
	}

	public InscripcionSUNARPDAO getInscripcionSUNARPDAO() {
		// TODO Auto-generated method stub
		return new MySqlInscripcionSUNARPDAO();
	}
	
}
