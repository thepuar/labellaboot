/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.PedidoService;
import com.frapecha.labella.util.UtilesFechas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class AjaxController {
	
	@Autowired
	PedidoService pedidoService;

    @RequestMapping(value = "/REST/ajaxsearchorderbysection", produces = "application/json")
    public @ResponseBody List<Pedido> search(@RequestParam(value = "fecha") String fecha, @ModelAttribute("usuario") Usuario elusuario) {
        List<Pedido> aux = new ArrayList<>();
        List<Pedido> result = new ArrayList<>();
        
        for (Seccion laseccion : elusuario.getSecciones()) {
//            aux = hpedido.selectAllEnCursoByIdSeccion(laseccion.getId());
            aux = pedidoService.findBySeccionAndEnCurso(laseccion, true);
            for(Pedido elpedido : aux){
                if(UtilesFechas.mismoDia(elpedido.getFechaentregaReal(), UtilesFechas.StringToCalendar(fecha).getTime())){
                    result.add(elpedido);
                }
            }
        }
        
        
        
        return result;
    }
}
