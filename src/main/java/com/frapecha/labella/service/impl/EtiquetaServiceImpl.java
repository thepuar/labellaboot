package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.EtiquetaDAO;
import com.frapecha.labella.model.Etiqueta;

@Service
@Transactional
public class EtiquetaServiceImpl implements EtiquetaService{

	@Autowired
	EtiquetaDAO etiquetaDAO;
	
	@Override
	public Etiqueta findById(Long id) {
		
		Optional<Etiqueta> opEtiqueta =  etiquetaDAO.findById(id);
		if(opEtiqueta.isPresent())
			return opEtiqueta.get();
		else return null;
	}
	
	public List<Etiqueta> findAll(){
		return etiquetaDAO.findAll();
	}
	
	public void saveEtiqueta(Etiqueta etiqueta) {
		etiquetaDAO.save(etiqueta);
	}
	
	public void deleteEtiqueta(Etiqueta etiqueta) {
		etiquetaDAO.delete(etiqueta);
	}

	@Override
	public long countAllEtiquetas() {
		return etiquetaDAO.count();
	}
	
	
	
	

}
