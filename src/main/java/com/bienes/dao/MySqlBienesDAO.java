package com.bienes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.Bienes;
import com.bienes.interfaces.BienesDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlBienesDAO implements BienesDAO {

	@Override
	public int save(Bienes bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into bienes values(null,?,?,?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDescrip_bien());
			pstm.setInt(2, bean.getCantidad_bien());
			pstm.setString(3, bean.getNom_provee() );
			pstm.setDate(4, bean.getFecha_llegada());
			pstm.setString(5, bean.getNom_operador());
			pstm.setInt(6, bean.getIdproveedor());
			pstm.setInt(7, bean.getCodigoOrdendeCompra());
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
	public int update(Bienes bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="update bienes set descrip_bien=?, cantidad_bien=?, nom_provee=?, fecha_llegada=?, nom_operador=?, PROVEEDOR_id_provee=?, "
					+ "GRR-ORDENDECOMPRA_codigo=? where codigo_bien=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDescrip_bien());
			pstm.setInt(2, bean.getCantidad_bien());
			pstm.setString(3, bean.getNom_provee() );
			pstm.setDate(4, bean.getFecha_llegada());
			pstm.setString(5, bean.getNom_operador());
			pstm.setInt(6, bean.getIdproveedor());
			pstm.setInt(7, bean.getCodigoOrdendeCompra());
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
	public int delete(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="delete from bienes where codigo_bien=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setInt(1, cod);
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
	public Bienes findById(int cod) {
		Bienes bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from bienes where codigo_bien=?";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setInt(1, cod);
			//5.
			rs=pstm.executeQuery();
			//6.validar si existe registro
			if(rs.next()) {
				//7
				bean=new Bienes();
				//8
				bean.setCodigo_bien(rs.getInt(1));
				bean.setDescrip_bien(rs.getString(2));
				bean.setCantidad_bien(rs.getInt(3)); 
				bean.setNom_provee(rs.getString(4));
				bean.setFecha_llegada(rs.getDate(5));
				bean.setNom_operador(rs.getString(6));
				bean.setIdproveedor(rs.getInt(7));
				bean.setCodigoOrdendeCompra(rs.getInt(8));
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
	public List<Bienes> listAll() {
		List<Bienes> lista=new ArrayList<Bienes>();
		Bienes bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from bienes";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			
			//5.
			rs=pstm.executeQuery();
			//6.
			while(rs.next()) {
				//7
				bean=new Bienes();
				//8
				bean.setCodigo_bien(rs.getInt(1));
				bean.setDescrip_bien(rs.getString(2));
				bean.setCantidad_bien(rs.getInt(3)); 
				bean.setNom_provee(rs.getString(4));
				bean.setFecha_llegada(rs.getDate(5));
				bean.setNom_operador(rs.getString(6));
				bean.setIdproveedor(rs.getInt(7));
				bean.setCodigoOrdendeCompra(rs.getInt(8));
				
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
