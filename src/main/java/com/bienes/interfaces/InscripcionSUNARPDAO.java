package com.bienes.interfaces;

import java.util.List;

import com.bienes.entidad.InscripcionSUNARP;

public interface InscripcionSUNARPDAO {
	
	public int save(InscripcionSUNARP bean);
	public int update(InscripcionSUNARP  bean);
	public int delete(int cod);
	public InscripcionSUNARP  findById(int cod);
	public List<InscripcionSUNARP> listAll();

}
