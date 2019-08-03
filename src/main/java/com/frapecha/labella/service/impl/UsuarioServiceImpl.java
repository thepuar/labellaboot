package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.UsuarioDAO;
import com.frapecha.labella.model.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDAO UsuarioDAO;
	
	@Override
	public Usuario findById(Long id) {
		
		Optional<Usuario> opUsuario =  UsuarioDAO.findById(id);
		if(opUsuario.isPresent())
			return opUsuario.get();
		else return null;
	}
	
	public List<Usuario> findAll(){
		return UsuarioDAO.findAll();
	}
	
	public void saveUsuario(Usuario Usuario) {
		UsuarioDAO.save(Usuario);
	}
	
	public void deleteUsuario(Usuario Usuario) {
		UsuarioDAO.delete(Usuario);
	}

	@Override
	public long countAllUsuarios() {
		return UsuarioDAO.count();
	}
	
	
	
	

}
