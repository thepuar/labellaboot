package com.frapecha.labella.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.service.impl.TiendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET})
@RequestMapping(value="/labellaboot/api/v1",produces= {"application/json","application/xml"})
@Api(value="Tiendas",description="Metodos para tiendas",tags= {"Tiendas"})
public class RestTiendaController {

	@Autowired
	TiendaService tiendaService;
	
	@RequestMapping(value="/tiendas", method= RequestMethod.GET)
	@ApiOperation(value="Obtiene todas las tiendas",notes = "Obtiene todas las tiendas")
	public List<Tienda> retrieveAlltiendas(){
		return tiendaService.findAll();
	}
}
