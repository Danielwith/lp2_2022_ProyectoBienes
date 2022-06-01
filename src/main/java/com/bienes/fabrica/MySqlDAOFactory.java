package com.bienes.fabrica;

import com.bienes.dao.MySqlBienesDAO;
import com.bienes.dao.MySqlGuiaDAO;
import com.bienes.dao.MySqlProveedorDAO;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.GuiaDAO;
import com.bienes.interfaces.ProveedorDAO;

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

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}
}
