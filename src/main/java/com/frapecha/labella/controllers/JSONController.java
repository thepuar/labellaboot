/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frapecha.labella.model.Etiqueta;

/**
 *
 * @author thepuar
 */
@Controller
@RequestMapping("/json")
public class JSONController {
    
    @RequestMapping(value="{name}",method=RequestMethod.GET, produces = "application/json")
        public @ResponseBody Etiqueta getEtiquetaJSON(@PathVariable String name){
                Etiqueta laetiqueta = new Etiqueta();
                laetiqueta.setNombreEtiqueta("EtiquetaJSON");
                laetiqueta.setNumSeccion(2);
                
                return laetiqueta;
    }
    
}
