package com.bienes.fabrica;

import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.GuiaDAO;
import com.bienes.interfaces.LoginDAO;
import com.bienes.interfaces.OperadorDAO;
import com.bienes.interfaces.ProveedorDAO;


public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    
    public abstract BienesDAO getBienesDAO();
    public abstract ProveedorDAO getProveedorDAO();
    public abstract GuiaDAO getGuiaDAO();
    public abstract LoginDAO getLoginDAO();
    public abstract OperadorDAO getOperadorDAO();
   
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();*/
        	case SQLSERVER:
        	    //return new SqlServerDAOFactory();
        	/*case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
