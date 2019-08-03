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
	ProveedorDAO ProveedorDAO;
	
	@Override
	public Proveedor findById(Long id) {
		
		Optional<Proveedor> opProveedor =  ProveedorDAO.findById(id);
		if(opProveedor.isPresent())
			return opProveedor.get();
		else return null;
	}
	
	public List<Proveedor> findAll(){
		return ProveedorDAO.findAll();
	}
	
	public void saveProveedor(Proveedor Proveedor) {
		ProveedorDAO.save(Proveedor);
	}
	
	public void deleteProveedor(Proveedor Proveedor) {
		ProveedorDAO.delete(Proveedor);
	}

	@Override
	public long countAllProveedors() {
		return ProveedorDAO.count();
	}
	
	
	
	

}
