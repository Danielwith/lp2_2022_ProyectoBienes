package com.bienes.dao;

import java.util.logging.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.Menu;
import com.bienes.entidad.Usuario;
import com.bienes.interfaces.LoginDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlLoginDAO implements LoginDAO {

	@Override
	public Usuario iniciarSesion(String login, String clave) {
		Usuario bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select id_acceso,login_acceso,pass_acceso from acceso where login_acceso=? and pass_acceso=?";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setString(1, login);
			pstm.setString(2, clave);
			//5.
			rs=pstm.executeQuery();
			//6.validar si existe registro
			if(rs.next()) {
				//7
				bean=new Usuario();
				//8
				bean.setCodigo(rs.getInt(1));
				bean.setLogin(rs.getString(2));
				bean.setClave(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}		
		return bean;
	}
	
	@Override
	public List<Menu> traerOpciones(int codUsu) {

		Logger logger = Logger.getLogger(MySqlLoginDAO.class.getName());
		List<Menu> lista=new ArrayList<Menu>();
		Menu bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select a.id_acceso,m.descrip_menu,m.url_menu,m.icon_menu from acceso a join menu m on a.id_acceso=m.id_acceso where a.id_acceso=?";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setInt(1, codUsu);
			//DEPURADOR
			logger.info(String.valueOf(codUsu));
			//5.
			rs=pstm.executeQuery();
			//6.
			while(rs.next()) {
				//7
				bean=new Menu();
				//8
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setUrl(rs.getString(3));
				bean.setIcon(rs.getString(4));
				//9
				lista.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}		
		return lista;
	}
	
}
