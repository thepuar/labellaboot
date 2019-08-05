/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.service.impl.TiendaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepu
 */

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    TiendaService tiendaService; 
	
    @RequestMapping("/admin")
    public ModelAndView main(){
        
        ModelAndView mav = new ModelAndView();
        List<Tienda> ltiendas = tiendaService.findAll();
        
        mav.addObject("ltiendas", ltiendas);
        mav.setViewName("admin");
        return mav;
        
    }
}
