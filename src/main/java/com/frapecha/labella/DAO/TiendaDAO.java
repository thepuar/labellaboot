package com.frapecha.labella.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Tienda;

@Repository
public interface TiendaDAO extends JpaRepository<Tienda, Long>,JpaSpecificationExecutor<Tienda>{

	
	
}
