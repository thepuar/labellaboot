package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.SeccionDAO;
import com.frapecha.labella.model.Seccion;

@Service
@Transactional
public class SeccionServiceImpl implements SeccionService{

	@Autowired
	SeccionDAO SeccionDAO;
	
	@Override
	public Seccion findById(Long id) {
		
		Optional<Seccion> opSeccion =  SeccionDAO.findById(id);
		if(opSeccion.isPresent())
			return opSeccion.get();
		else return null;
	}
	
	public List<Seccion> findAll(){
		return SeccionDAO.findAll();
	}
	
	public void saveSeccion(Seccion Seccion) {
		SeccionDAO.save(Seccion);
	}
	
	public void deleteSeccion(Seccion Seccion) {
		SeccionDAO.delete(Seccion);
	}

	@Override
	public long countAllSeccions() {
		return SeccionDAO.count();
	}
	
	
	
	

}
