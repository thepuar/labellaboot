package com.frapecha.labella.service.impl;

import java.util.List;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Tienda;

public interface PedidoService {
	
	public Pedido findById(Long id);
	
	public void savePedido(Pedido Pedido);
	
	public Pedido updatePedido(Pedido pedido);
	
	public void deletePedido(Pedido Pedido);
	
	public List<Pedido> findAll();
	
	public long countAllPedidos();
	
	public Pedido findByNumeropedido(Integer numero);
	
	public List<Pedido> findBySeccionTiendaAndEnCurso(Tienda tienda, boolean enCurso);
	
}
