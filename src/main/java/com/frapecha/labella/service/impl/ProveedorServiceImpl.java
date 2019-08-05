package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.ProveedorDAO;
import com.frapecha.labella.model.Proveedor;

@Service
@Transactional
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	ProveedorDAO proveedorDAO;
	
	@Override
	public Proveedor findById(Long id) {
		
		Optional<Proveedor> opProveedor =  proveedorDAO.findById(id);
		if(opProveedor.isPresent())
			return opProveedor.get();
		else return null;
	}
	
	public List<Proveedor> findAll(){
		return proveedorDAO.findAll();
	}
	
	public void saveProveedor(Proveedor proveedor) {
		proveedorDAO.save(proveedor);
	}
	
	public Proveedor updateProveedor(Proveedor proveedor) {
		return proveedorDAO.save(proveedor);
	}
	
	public void deleteProveedor(Proveedor proveedor) {
		proveedorDAO.delete(proveedor);
	}

	@Override
	public long countAllProveedors() {
		return proveedorDAO.count();
	}
	
	public Proveedor findByNumero(Integer numero) {
		return proveedorDAO.findByNumero(numero);
	}

	
	
	

}
