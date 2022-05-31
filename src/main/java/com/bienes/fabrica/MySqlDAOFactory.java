package com.bienes.fabrica;

import com.bienes.dao.MySqlBienesDAO;
import com.bienes.dao.MySqlGuiaDAO;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.GuiaDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public BienesDAO getBienesDAO() {
		// TODO Auto-generated method stub
		return new MySqlBienesDAO();
	}
	
	@Override
	public GuiaDAO getGuiaDAO() {
		// TODO Auto-generated method stub
		return new MySqlGuiaDAO();
	}

}
