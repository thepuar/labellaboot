package com.frapecha.labella.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frapecha.labella.model.Etiqueta;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.service.impl.EtiquetaService;
import com.frapecha.labella.service.impl.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET})
@RequestMapping(value="/labellaboot/api/v1",produces= {"application/json","application/xml"})
@Api(value="Etiqueta",description="Metodos para etiquetas",tags= {"Etiquetas"})
public class RestEtiquetaController {
	
	@Autowired
	EtiquetaService etiquetaService;
	
	@RequestMapping(value="/etiquetas", method= RequestMethod.GET)
	@ApiOperation(value="Obtiene todas las etiquetas",notes = "Obtiene todas las etiquetas")
	public List<Etiqueta> retrieveAlletiquetas(){
		return etiquetaService.findAll();
	}

}
