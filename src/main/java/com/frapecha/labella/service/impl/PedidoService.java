package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Pedido;

public interface PedidoService {
	
	public Pedido findById(Long id);
	
	public void savePedido(Pedido Pedido);
	
	public void deletePedido(Pedido Pedido);
	
	public List<Pedido> findAll();
	
	public long countAllPedidos();
	
}
