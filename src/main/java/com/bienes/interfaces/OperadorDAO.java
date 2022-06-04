package com.bienes.interfaces;

import java.util.List;
import com.bienes.entidad.Operador;

public interface OperadorDAO {
	
	public int saveOpe(Operador bean);
	public int updateOpe(Operador bean);
	public int deleteOpe(int codi);
	public Operador findByIdOpe(int codi);
	public List<Operador> listAll();

}
