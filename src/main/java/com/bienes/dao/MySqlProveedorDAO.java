package com.bienes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.Proveedor;
import com.bienes.interfaces.ProveedorDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlProveedorDAO implements ProveedorDAO {

	@Override
	public int savePro(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into proveedor values(null,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_prove());
			pstm.setString(2, bean.getDist_prove());
			pstm.setString(3, bean.getTelf_prove());
			pstm.setString(4, bean.getEstado_prove());
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
	public int updatePro(Proveedor bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="update proveedor set nom_prove=?, dist_prove=?, telf_prove=?, estado_prove=? where id_prove=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_prove());
			pstm.setString(2, bean.getDist_prove());
			pstm.setString(3, bean.getTelf_prove());
			pstm.setString(4, bean.getEstado_prove());
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
	public int deletePro(int id) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="delete from proveedor where id_prove=? ";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setInt(1, id);
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
	public Proveedor findByIdPro(int id) {
		Proveedor bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from proveedor where id_prove=?";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setInt(1, id);
			//5.
			rs=pstm.executeQuery();
			//6.validar si existe registro
			if(rs.next()) {
				//7
				bean=new Proveedor();
				//8
				
				bean.setId_prove(rs.getInt(1));
				bean.setNom_prove(rs.getString(2));
				bean.setDist_prove(rs.getString(3));
				bean.setTelf_prove(rs.getString(4));
				bean.setEstado_prove(rs.getString(5));
				
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
	public List<Proveedor> listAll() {
		List<Proveedor> lista=new ArrayList<Proveedor>();
		Proveedor bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from proveedor";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			
			//5.
			rs=pstm.executeQuery();
			//6.
			while(rs.next()) {
				//7
				bean=new Proveedor();
				//8
				
				bean.setId_prove(rs.getInt(1));
				bean.setNom_prove(rs.getString(2));
				bean.setDist_prove(rs.getString(3));
				bean.setTelf_prove(rs.getString(4));
				bean.setEstado_prove(rs.getString(5));
				
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
