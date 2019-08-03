package com.frapecha.labella.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Etiqueta;

@Repository
public interface EtiquetaDAO extends JpaRepository<Etiqueta, Long>,JpaSpecificationExecutor<Etiqueta>{

	
	
}
