package com.bienes.interfaces;

import java.util.List;

import com.bienes.entidad.GuiayOrdendeCompra;

public interface GuiaDAO {

	public List<GuiayOrdendeCompra> listAll();
	public int save(GuiayOrdendeCompra bean);
	public int update(GuiayOrdendeCompra bean);
	public int delete(int cod);
	public GuiayOrdendeCompra findById(int cod);
	
}
