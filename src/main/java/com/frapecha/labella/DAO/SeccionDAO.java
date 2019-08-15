package com.frapecha.labella.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;

@Repository
public interface SeccionDAO extends JpaRepository<Seccion, Long>,JpaSpecificationExecutor<Seccion>{
	
	public Seccion findByTiendaAndNumero(Tienda tienda, Integer numero);
}
