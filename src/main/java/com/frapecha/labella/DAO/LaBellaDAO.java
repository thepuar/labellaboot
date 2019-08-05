package com.frapecha.labella.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.frapecha.labella.model.LaBella;

@org.springframework.stereotype.Repository
public interface LaBellaDAO extends JpaRepository<LaBella, Long>,JpaSpecificationExecutor<LaBella>{

	
	
}
