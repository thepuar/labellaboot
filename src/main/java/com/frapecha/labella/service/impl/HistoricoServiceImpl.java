package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.HistoricoDAO;
import com.frapecha.labella.model.Historico;

@Service
@Transactional
public class HistoricoServiceImpl implements HistoricoService{

	@Autowired
	HistoricoDAO HistoricoDAO;
	
	@Override
	public Historico findById(Long id) {
		
		Optional<Historico> opHistorico =  HistoricoDAO.findById(id);
		if(opHistorico.isPresent())
			return opHistorico.get();
		else return null;
	}
	
	public List<Historico> findAll(){
		return HistoricoDAO.findAll();
	}
	
	public void saveHistorico(Historico Historico) {
		HistoricoDAO.save(Historico);
	}
	
	public void deleteHistorico(Historico Historico) {
		HistoricoDAO.delete(Historico);
	}

	@Override
	public long countAllHistoricos() {
		return HistoricoDAO.count();
	}
	
	
	
	

}
