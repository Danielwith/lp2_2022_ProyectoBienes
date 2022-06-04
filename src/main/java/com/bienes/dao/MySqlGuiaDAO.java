package com.bienes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.Bienes;
import com.bienes.entidad.GuiayOrdendeCompra;
import com.bienes.interfaces.GuiaDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlGuiaDAO implements GuiaDAO {

	@Override
	public List<GuiayOrdendeCompra> listAll() {
		List<GuiayOrdendeCompra> lista=new ArrayList<GuiayOrdendeCompra>();
		GuiayOrdendeCompra bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from gestionbienes.`grr-ordendecompra`";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			
			//5.
			rs=pstm.executeQuery();
			//6.
			while(rs.next()) {
				//7
				bean=new GuiayOrdendeCompra();
				//8
				bean.setCodigoguiacompra(rs.getInt(1));
				bean.setNom_provee(rs.getString(2));
				bean.setFecha_compra(rs.getDate(3)); 
				bean.setDescripcionguiacompra(rs.getString(4));
				bean.setCantidadguiacompra(rs.getString(5));
				bean.setPrecioguiacompra(rs.getDouble(6));				
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

	@Override
	public int save(GuiayOrdendeCompra bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into gestionbienes.`grr-ordendecompra` values(null,?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_provee());
			pstm.setDate(2, bean.getFecha_compra());
			pstm.setString(3, bean.getDescripcionguiacompra() );
			pstm.setString(4, bean.getCantidadguiacompra());
			pstm.setDouble(5, bean.getPrecioguiacompra());
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
	public int update(GuiayOrdendeCompra bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="update gestionbienes.`grr-ordendecompra` set proveedor=?, fecha_compra=?, descripcion=?, cantidad=?, precio=? where codigo=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNom_provee());
			pstm.setDate(2, bean.getFecha_compra());
			pstm.setString(3, bean.getDescripcionguiacompra() );
			pstm.setString(4, bean.getCantidadguiacompra());
			pstm.setDouble(5, bean.getPrecioguiacompra());
			pstm.setInt(6, bean.getCodigoguiacompra());;
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
			String sql="delete from gestionbienes.`grr-ordendecompra` where codigo=?";
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
	public GuiayOrdendeCompra findById(int cod) {
		GuiayOrdendeCompra bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1.
			cn=MySqlConexion.getConectar();
			//2.
			String sql="select * from gestionbienes.`grr-ordendecompra` where codigo=? ";
			//3.
			pstm=cn.prepareStatement(sql);
			//4.parámetros
			pstm.setInt(1, cod);
			//5.
			rs=pstm.executeQuery();
			//6.validar si existe registro
			if(rs.next()) {
				//7
				bean=new GuiayOrdendeCompra();
				//8
				bean.setCodigoguiacompra(rs.getInt(1));
				bean.setNom_provee(rs.getString(2));
				bean.setFecha_compra(rs.getDate(3)); 
				bean.setDescripcionguiacompra(rs.getString(4));
				bean.setCantidadguiacompra(rs.getString(5));
				bean.setPrecioguiacompra(rs.getDouble(6));	
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

}
