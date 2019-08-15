package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import com.frapecha.labella.model.LineaPedido;

public interface LineaPedidoService {

	public LineaPedido findById(Long id);
	
	public List<LineaPedido> findAll();
	
	public void saveLineaPedido(LineaPedido LineaPedido);
	
	public void deleteLineaPedido(LineaPedido LineaPedido);

	public long countAllLineaPedidos();
	
	public LineaPedido updateLineaPedido(LineaPedido LineaPedido);

	
}
