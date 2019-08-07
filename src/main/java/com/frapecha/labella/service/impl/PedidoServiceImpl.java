package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.DAO.PedidoDAO;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoDAO pedidoDAO;
	
	@Override
	public Pedido findById(Long id) {
		
		Optional<Pedido> opPedido =  pedidoDAO.findById(id);
		if(opPedido.isPresent())
			return opPedido.get();
		else return null;
	}
	
	public List<Pedido> findAll(){
		return pedidoDAO.findAll();
	}
	
	public void savePedido(Pedido Pedido) {
		pedidoDAO.save(Pedido);
	}
	
	public void deletePedido(Pedido Pedido) {
		pedidoDAO.delete(Pedido);
	}

	@Override
	public long countAllPedidos() {
		return pedidoDAO.count();
	}
	
	public Pedido findByNumeropedido(Integer numero) {
		return pedidoDAO.findByNumeropedido(numero);
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		return pedidoDAO.save(pedido);
	}

	@Override
	public List<Pedido> findBySeccionTiendaAndEnCurso(Tienda tienda, boolean enCurso) {
		return pedidoDAO.findBySeccionTiendaAndEnCurso(tienda, enCurso);
	}

	@Override
	public List<Pedido> findByLineasReferencia(Integer referencia) {
		return pedidoDAO.findByLineasReferencia(referencia);
	}

	@Override
	public List<Pedido> findBySeccionAndEnCurso(Seccion seccion, boolean enCurso) {
		return pedidoDAO.findBySeccionAndEnCurso(seccion, enCurso);
	}

	@Override
	public List<Pedido> findByProveedorAndEnCurso(Proveedor proveedor, boolean enCurso) {
		return pedidoDAO.findByProveedorAndEnCurso(proveedor, enCurso);
	}
	
	
	

}
