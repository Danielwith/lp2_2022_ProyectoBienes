package com.bienes.fabrica;
import com.bienes.dao.*;
import com.bienes.interfaces.*;
import com.bienes.fabrica.DAOFactory;
import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.GuiaDAO;
import com.bienes.interfaces.ProveedorDAO;
import com.bienes.interfaces.OperadorDAO;

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
	
	@Override
	public ProveedorDAO getProveedorDAO() {
		return new MySqlProveedorDAO();
	}
	
	@Override
	public OperadorDAO getOperadorDAO() {
		return new MySqlOperadorDAO();
	}
	
}
