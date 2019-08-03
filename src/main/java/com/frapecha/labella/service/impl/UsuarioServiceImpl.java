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
	UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario findById(Long id) {
		
		Optional<Usuario> opUsuario =  usuarioDAO.findById(id);
		if(opUsuario.isPresent())
			return opUsuario.get();
		else return null;
	}
	
	public List<Usuario> findAll(){
		return usuarioDAO.findAll();
	}
	
	public void saveUsuario(Usuario Usuario) {
		usuarioDAO.save(Usuario);
	}
	
	public void deleteUsuario(Usuario Usuario) {
		usuarioDAO.delete(Usuario);
	}

	@Override
	public long countAllUsuarios() {
		return usuarioDAO.count();
	}

	@Override
	public Usuario findByLdap(Integer ldap) {
		// TODO Auto-generated method stub
		return usuarioDAO.findByLdap(ldap);
	}
	
	
	
	

}
