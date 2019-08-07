package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Tienda;

public interface TiendaService {
	
	public Tienda findById(Long id);
	
	public void saveTienda(Tienda tienda);
	
	public Tienda updateTienda(Tienda tienda);
	
	public void deleteTienda(Tienda tienda);
	
	public List<Tienda> findAll();
	
	public long countAllTiendas();
	
	public Tienda findByNumero(Integer numero);
	
	public Tienda findByNombre(String nombre);
	
}
