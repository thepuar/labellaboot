package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.LaBella;

public interface LaBellaService {

	public LaBella findById(Long id);

	public void saveLaBella(LaBella laBella);

	public LaBella updateLaBella(LaBella laBella);

	public void deleteLaBella(LaBella laBella);

	public List<LaBella> findAll();

	public long countAllLaBellas();

}
