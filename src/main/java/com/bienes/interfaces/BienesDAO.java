package com.bienes.interfaces;

import java.util.List;

import com.bienes.entidad.Bienes;

public interface BienesDAO {
	
	public int save(Bienes bean);
	public int update(Bienes bean);
	public int delete(int cod);
	public Bienes findById(int cod);
	public List<Bienes> listAll();

}
