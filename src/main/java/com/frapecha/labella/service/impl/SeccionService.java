package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;

public interface SeccionService {
	
	public Seccion findById(Long id);
	
	public void saveSeccion(Seccion Seccion);
	
	public void deleteSeccion(Seccion Seccion);
	
	public List<Seccion> findAll();
	
	public long countAllSeccions();
	
	public Seccion findByTiendaAndNumero(Tienda tienda, Integer numero);
	
}
