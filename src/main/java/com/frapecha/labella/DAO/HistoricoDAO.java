package com.frapecha.labella.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.frapecha.labella.model.Historico;

@Repository
public interface HistoricoDAO extends JpaRepository<Historico, Long>,JpaSpecificationExecutor<Historico>{

	
	
}
