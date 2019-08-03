package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Usuario;

public interface UsuarioService {
	
	public Usuario findById(Long id);
	
	public void saveUsuario(Usuario Usuario);
	
	public void deleteUsuario(Usuario Usuario);
	
	public List<Usuario> findAll();
	
	public long countAllUsuarios();
	
}
