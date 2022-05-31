package com.bienes.fabrica;

import com.bienes.dao.MySqlBienesDAO;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.BienesDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public BienesDAO getBienesDAO() {
		// TODO Auto-generated method stub
		return new MySqlBienesDAO();
	}

}
