package com.bienes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bienes.entidad.InscripcionSUNARP;
import com.bienes.interfaces.BienesDAO;
import com.bienes.interfaces.InscripcionSUNARPDAO;
import com.bienes.utils.MySqlConexion;

public class MySqlInscripcionSUNARPDAO implements InscripcionSUNARPDAO {

	@Override
	public int save(InscripcionSUNARP bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConectar();
			//2
			String sql="insert into bienes values(null,?,?,?,?,?,?)";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDescrip_bien());
			pstm.setInt(2, bean.getCantidad_bien());
			pstm.setString(3, bean.getNom_provee() );
			pstm.setDouble(4, bean.getPrecio_bien());
			pstm.setString(5, bean.getNom_provee());
			pstm.setDate(6, bean.getFecha_llegada());
			
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
	public int update(InscripcionSUNARP bean) {
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
			pstm.setDouble(4, bean.getPrecio_bien());
			pstm.setString(5, bean.getNom_provee());
			pstm.setDate(6, bean.getFecha_llegada());
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
	public InscripcionSUNARP findById(int cod) {
		InscripcionSUNARP bean=null;
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
				bean=new InscripcionSUNARP();
				//8
			    bean.setCodigo_inscri(rs.getInt(1));
				bean.setDescrip_bien(rs.getString(2));
				bean.setCantidad_bien(rs.getInt(3)); 
				bean.setPrecio_bien(rs.getDouble(4));
				bean.setNom_provee(rs.getString(5));
				bean.setFecha_llegada(rs.getDate(6));
				
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
	public List<InscripcionSUNARP> listAll() {
		List<InscripcionSUNARP> lista=new ArrayList<InscripcionSUNARP>();
		InscripcionSUNARP bean=null;
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
				bean=new InscripcionSUNARP();
				//8
				  bean.setCodigo_inscri(rs.getInt(1));
					bean.setDescrip_bien(rs.getString(2));
					bean.setCantidad_bien(rs.getInt(3)); 
					bean.setPrecio_bien(rs.getDouble(4));
					bean.setNom_provee(rs.getString(5));
					bean.setFecha_llegada(rs.getDate(6));
				
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