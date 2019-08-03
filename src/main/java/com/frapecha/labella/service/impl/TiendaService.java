package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Tienda;

public interface TiendaService {
	
	public Tienda findById(Long id);
	
	public void saveTienda(Tienda Tienda);
	
	public void deleteTienda(Tienda Tienda);
	
	public List<Tienda> findAll();
	
	public long countAllTiendas();
	
}
