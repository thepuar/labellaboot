/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.service.impl.TiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class TiendaController {
	
	@Autowired
	TiendaService tiendaService;
    
    @RequestMapping("/tienda/{id}")
    public ModelAndView gotoDetailTienda(@PathVariable(value="id")Long id){
//        HTienda htienda = new HTienda();
//        Tienda latienda = (Tienda) htienda.selectByIdAndSecciones(id);
    	Tienda latienda = tiendaService.findById(id);
        ModelAndView mav = new ModelAndView("tienda");
        mav.addObject("tienda", latienda);
        
        return mav;
    }
    
}
