package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.TiendaDAO;
import com.frapecha.labella.model.Tienda;

@Service
@Transactional
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	TiendaDAO tiendaDAO;
	
	@Override
	public Tienda findById(Long id) {
		
		Optional<Tienda> opTienda =  tiendaDAO.findById(id);
		if(opTienda.isPresent())
			return opTienda.get();
		else return null;
	}
	
	public List<Tienda> findAll(){
		return tiendaDAO.findAll();
	}
	
	public void saveTienda(Tienda Tienda) {
		tiendaDAO.save(Tienda);
	}
	
	public void deleteTienda(Tienda Tienda) {
		tiendaDAO.delete(Tienda);
	}

	@Override
	public long countAllTiendas() {
		return tiendaDAO.count();
	}

	@Override
	public Tienda findByNumero(Integer numero) {
		return tiendaDAO.findByNumero(numero);
	}

	@Override
	public Tienda updateTienda(Tienda tienda) {
		return tiendaDAO.save(tienda);
		
	}

	@Override
	public Tienda findByNombre(String nombre) {
		return tiendaDAO.findByNombre(nombre);
	}
	
	
	
	

}
