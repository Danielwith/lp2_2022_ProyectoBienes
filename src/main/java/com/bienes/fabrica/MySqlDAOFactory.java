package com.bienes.fabrica;

import com.bienes.dao.*;
import com.bienes.interfaces.*;

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

}
