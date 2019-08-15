package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.LaBellaDAO;
import com.frapecha.labella.model.LaBella;
import com.frapecha.labella.model.Proveedor;

@Service
public class LaBellaServiceImpl implements LaBellaService {
	@Autowired
	LaBellaDAO laBellaDAO;

	@Override
	public LaBella findById(Long id) {
		Optional<LaBella> opLaBella = laBellaDAO.findById(id);
		if (opLaBella.isPresent())
			return opLaBella.get();
		return null;

	}

	@Override
	public void saveLaBella(LaBella laBella) {
		laBellaDAO.save(laBella);

	}

	@Override
	public void deleteLaBella(LaBella laBella) {
		laBellaDAO.delete(laBella);
	}

	@Override
	public List<LaBella> findAll() {
		return laBellaDAO.findAll();
	}

	@Override
	public long countAllLaBellas() {
		return laBellaDAO.count();
	}

	@Override
	public LaBella updateLaBella(LaBella laBella) {
		return laBellaDAO.save(laBella);

	}
	

}
