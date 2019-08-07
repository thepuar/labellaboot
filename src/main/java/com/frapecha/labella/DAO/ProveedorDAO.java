package com.frapecha.labella.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;

@Repository
public interface ProveedorDAO extends JpaRepository<Proveedor, Long>,JpaSpecificationExecutor<Proveedor>{

	public Proveedor findByNumero(Integer numero);
	
	
	public List<Proveedor> findByNumSeccion(Integer numSeccion);
	
	public Proveedor findByPedidos(Pedido pedido);
	
}
