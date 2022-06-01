package com.bienes.fabrica;
import com.bienes.dao.*;
import com.bienes.interfaces.*;
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
		return new MySqlBienesDAO();
	}
	
	@Override
	public GuiaDAO getGuiaDAO() {
		return new MySqlGuiaDAO();
	}

	@Override

	public LoginDAO getLoginDAO() {
		return new MySqlLoginDAO();
	}
	
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}
}
