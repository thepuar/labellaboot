package com.frapecha.labella.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frapecha.labella.model.LineaPedido;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.DAO.LineaPedidoDAO;

@Service
@Transactional
public class LineaPedidoServiceImpl implements LineaPedidoService{
	
	@Autowired
	LineaPedidoDAO LineaPedidoDAO;
	
	@Override
	public LineaPedido findById(Long id) {
		
		Optional<LineaPedido> opLineaPedido =  LineaPedidoDAO.findById(id);
		if(opLineaPedido.isPresent())
			return opLineaPedido.get();
		else return null;
	}
	
	public List<LineaPedido> findAll(){
		return LineaPedidoDAO.findAll();
	}
	
	public void saveLineaPedido(LineaPedido LineaPedido) {
		LineaPedidoDAO.save(LineaPedido);
	}
	
	public void deleteLineaPedido(LineaPedido LineaPedido) {
		LineaPedidoDAO.delete(LineaPedido);
	}

	@Override
	public long countAllLineaPedidos() {
		return LineaPedidoDAO.count();
	}
	
	
	@Override
	public LineaPedido updateLineaPedido(LineaPedido LineaPedido) {
		return LineaPedidoDAO.save(LineaPedido);
	}

	
	
	

}
