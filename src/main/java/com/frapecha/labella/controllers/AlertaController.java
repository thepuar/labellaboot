/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.ProveedorService;
import com.frapecha.labella.service.impl.SeccionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class AlertaController {
	
	@Autowired
	SeccionService seccionService;
	
	@Autowired
	ProveedorService proveedorService;
    
    @RequestMapping("/ualertas")
    public ModelAndView gotoUAlertas(@ModelAttribute("usuario")Usuario elusuario){
        ModelAndView mav = new ModelAndView("ualertas");
        
        //Pedidos sin revisar
        List<Pedido> pedidosNoRev = new ArrayList<>();
        List<Pedido> pedidosDestacados = new ArrayList<>();
        List<Pedido> pedidosEnRetraso = new ArrayList<>();
        List<Pedido> pedidosAvisar = new ArrayList<>();
        List<Pedido> pedidosAnular = new ArrayList<>();
        List<Pedido> pedidosNoLleganAFranco = new ArrayList<>();
        List<Proveedor> proveedorNoOk = new ArrayList<>();
        for(Seccion laseccion : elusuario.getSecciones()){
//                laseccion = hseccion.getByIdAndPedidos(laseccion.getId());
                laseccion = seccionService.findById(laseccion.getId());
                pedidosNoRev.addAll(laseccion.getPedidosVivosNoRevisados());
                pedidosDestacados.addAll(laseccion.getPedidosDestacados());
                pedidosEnRetraso.addAll(laseccion.getPedidosEnRetraso());
                pedidosAvisar.addAll(laseccion.getPedidosAvisarAlEntrar());
                pedidosAnular.addAll(laseccion.getPedidosPendienteAnular());
                pedidosNoLleganAFranco.addAll(laseccion.getPedidosNoLleganAFranco());
                List<Proveedor> proveedores = proveedorService.findByNumSeccion(laseccion.getNumero());
                for(Proveedor elproveedor : proveedores){
                    if(!elproveedor.datosOK()){
                        proveedorNoOk.add(elproveedor);
                    }
                }
            
                
        }
        
        mav.addObject("pedidosNoRevisados", pedidosNoRev);
        mav.addObject("pedidosDestacados",pedidosDestacados);
        mav.addObject("pedidosEnRetraso",pedidosEnRetraso);
        mav.addObject("pedidosAvisar",pedidosAvisar);
        mav.addObject("pedidosAnular",pedidosAnular);
        mav.addObject("pedidosNoLleganAFranco",pedidosNoLleganAFranco);
        mav.addObject("proveedorNoOk",proveedorNoOk);
        
        //Pedidos destacados
       
              
        return mav;
    }
    
}
