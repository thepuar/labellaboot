package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Historico;

public interface HistoricoService {
	
	public Historico findById(Long id);
	
	public void saveHistorico(Historico Historico);
	
	public void deleteHistorico(Historico Historico);
	
	public List<Historico> findAll();
	
	public long countAllHistoricos();
	
}
