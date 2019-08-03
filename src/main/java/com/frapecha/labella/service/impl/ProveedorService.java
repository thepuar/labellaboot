package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Proveedor;

public interface ProveedorService {
	
	public Proveedor findById(Long id);
	
	public void saveProveedor(Proveedor Proveedor);
	
	public void deleteProveedor(Proveedor Proveedor);
	
	public List<Proveedor> findAll();
	
	public long countAllProveedors();
	
}
