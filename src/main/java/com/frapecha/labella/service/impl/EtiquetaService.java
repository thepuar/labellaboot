package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Etiqueta;

public interface EtiquetaService {
	
	public Etiqueta findById(Long id);
	
	public void saveEtiqueta(Etiqueta etiqueta);
	
	public void deleteEtiqueta(Etiqueta etiqueta);
	
	public List<Etiqueta> findAll();
	
	public long countAllEtiquetas();
	
}
