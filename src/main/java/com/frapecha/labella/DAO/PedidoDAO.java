package com.frapecha.labella.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;


@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long>,JpaSpecificationExecutor<Pedido>{


	public Pedido findByNumeropedido(Integer pedido);
	
	public List<Pedido> findBySeccionTiendaAndEnCurso(Tienda tienda,boolean enCurso);
	
	public List<Pedido> findBySeccionAndEnCurso(Seccion seccion, boolean enCurso);
	
	public List<Pedido> findByLineasReferencia(Integer referencia);
	
	public List<Pedido> findByProveedorAndEnCurso(Proveedor proveedor, boolean enCurso);
	
}
