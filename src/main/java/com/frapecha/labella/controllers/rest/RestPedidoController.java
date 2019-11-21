package com.frapecha.labella.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.service.impl.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET})
@RequestMapping(value="/labellaboot/api/v1",produces= {"application/json","application/xml"})
@Api(value="Pedido",description="Metodos para pedidos",tags= {"Pedidos"})
public class RestPedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@RequestMapping(value="/pedidos", method= RequestMethod.GET)
	@ApiOperation(value="Obtiene todos los pedidos",notes = "Obtiene todos los pedidos")
	public List<Pedido> retrieveAllpedidos(){
		return pedidoService.findAll();
	}
	
}
