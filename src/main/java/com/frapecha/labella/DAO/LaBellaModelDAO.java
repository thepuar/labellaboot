package com.frapecha.labella.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.frapecha.labella.model.LaBellaModel;

@org.springframework.stereotype.Repository
public interface LaBellaModelDAO extends JpaRepository<LaBellaModel, Long>,JpaSpecificationExecutor<LaBellaModel>{

	
	
}
