package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.SeccionDAO;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;

@Service
@Transactional
public class SeccionServiceImpl implements SeccionService{

	@Autowired
	SeccionDAO seccionDAO;
	
	@Override
	public Seccion findById(Long id) {
		
		Optional<Seccion> opSeccion =  seccionDAO.findById(id);
		if(opSeccion.isPresent())
			return opSeccion.get();
		else return null;
	}
	
	public List<Seccion> findAll(){
		return seccionDAO.findAll();
	}
	
	public void saveSeccion(Seccion Seccion) {
		seccionDAO.save(Seccion);
	}
	
	public void deleteSeccion(Seccion Seccion) {
		seccionDAO.delete(Seccion);
	}

	@Override
	public long countAllSeccions() {
		return seccionDAO.count();
	}

	@Override
	public Seccion findByTiendaAndNumero(Tienda tienda, Integer numero) {
		return seccionDAO.findByTiendaAndNumero(tienda, numero);
	}

}
