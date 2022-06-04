package com.bienes.interfaces;

import java.util.List;
import com.bienes.entidad.Proveedor;

public interface ProveedorDAO {
	
	public int savePro(Proveedor bean);
	public int updatePro(Proveedor bean);
	public int deletePro(int id);
	public Proveedor findByIdPro(int id);
	public List<Proveedor> listAll();

}
