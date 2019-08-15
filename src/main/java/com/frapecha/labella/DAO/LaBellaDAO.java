package com.frapecha.labella.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.frapecha.labella.model.LaBella;
import com.frapecha.labella.model.Proveedor;

@org.springframework.stereotype.Repository
public interface LaBellaDAO extends JpaRepository<LaBella, Long>,JpaSpecificationExecutor<LaBella>{

	
	
}
