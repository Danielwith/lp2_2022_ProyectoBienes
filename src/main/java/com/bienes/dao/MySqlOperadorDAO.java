package com.bienes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.Operador;
import com.bienes.entidad.Proveedor;
import com.bienes.interfaces.OperadorDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlOperadorDAO implements OperadorDAO {

	@Override
	public int saveOpe(Operador bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into operador values(null,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_ope());
			pstm.setString(2, bean.getDist_ope());
			pstm.setInt(3, bean.getCel_ope());
			pstm.setString(4, bean.getEstado_ope());
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	
	@Override
	public int updateOpe(Operador bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="update operador set nom_ope=?, dist_ope=?, cel_ope=?, estado_ope=? where id_ope=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_ope());
			pstm.setString(2, bean.getDist_ope());
			pstm.setInt(3, bean.getCel_ope());
			pstm.setString(4, bean.getEstado_ope());
			pstm.setInt(5, bean.getId_ope());
			
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	@Override
	public int deleteOpe(int codi) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="delete from operador where id_ope=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setInt(1, codi);
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	@Override
	public Operador findByIdOpe(int codi) {
		Operador bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from operador where id_ope=?";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setInt(1, codi);
			//5.
			rs=pstm.executeQuery();
			//6.validar si existe registro
			if(rs.next()) {
				//7
				bean=new Operador();
				//8
				
				bean.setId_ope(rs.getInt(1));
				bean.setNom_ope(rs.getString(2));
				bean.setDist_ope(rs.getString(3));
				bean.setCel_ope(rs.getInt(4));
				bean.setEstado_ope(rs.getString(5));
				
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
	public List<Operador> listAll() {
		List<Operador> lista=new ArrayList<Operador>();
		Operador bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from operador";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			
			//5.
			rs=pstm.executeQuery();
			//6.
			while(rs.next()) {
				//7
				bean=new Operador();
				//8
				
				bean.setId_ope(rs.getInt(1));
				bean.setNom_ope(rs.getString(2));
				bean.setDist_ope(rs.getString(3));
				bean.setCel_ope(rs.getInt(4));
				bean.setEstado_ope(rs.getString(5));
				
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
