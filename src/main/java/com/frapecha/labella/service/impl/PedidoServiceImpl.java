package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.PedidoDAO;
import com.frapecha.labella.model.Pedido;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoDAO PedidoDAO;
	
	@Override
	public Pedido findById(Long id) {
		
		Optional<Pedido> opPedido =  PedidoDAO.findById(id);
		if(opPedido.isPresent())
			return opPedido.get();
		else return null;
	}
	
	public List<Pedido> findAll(){
		return PedidoDAO.findAll();
	}
	
	public void savePedido(Pedido Pedido) {
		PedidoDAO.save(Pedido);
	}
	
	public void deletePedido(Pedido Pedido) {
		PedidoDAO.delete(Pedido);
	}

	@Override
	public long countAllPedidos() {
		return PedidoDAO.count();
	}
	
	
	
	

}
