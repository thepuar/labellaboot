/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.frapecha.labella.model.Etiqueta;
import com.frapecha.labella.service.impl.EtiquetaService;
import com.frapecha.labella.validator.EtiquetaValidator;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class EtiquetaController {
	
	@Autowired
	EtiquetaValidator etiquetaValidator;
	
	@Autowired
	EtiquetaService etiquetaService;
    
    @RequestMapping("/etiquetas/add")
    public ModelAndView gotoAddEtiqueta(){
        ModelAndView mav = new ModelAndView("etiquetas/add");
        Etiqueta laetiqueta = new Etiqueta();
        mav.addObject("etiqueta", laetiqueta);
        return mav;
    }
    
    @RequestMapping(value="/etiquetas/add", method=RequestMethod.POST)
    public ModelAndView Addetiqueta(@Valid @ModelAttribute("etiqueta") Etiqueta etiqueta, BindingResult result){
        ModelAndView mav = new ModelAndView();
        etiquetaValidator.validate(etiqueta, result);
        if(result.hasErrors()){
            //Hay errores
            mav.setViewName("etiquetas/add");
            mav.addObject(result.getModel());
        }else{
//            hetiqueta.insert(etiqueta);
            etiquetaService.saveEtiqueta(etiqueta);
//            List<Etiqueta> listEtiq = hetiqueta.selectAll(Etiqueta.class);
            List<Etiqueta> listEtiq = etiquetaService.findAll();
            mav.addObject("etiquetas", listEtiq);
            mav.setViewName("etiquetas");
            
        }
        return mav;
    }
    
    @RequestMapping("/etiquetas/deleteAll")
    public ModelAndView deleteAllEtiquetas(){
        ModelAndView mav = new ModelAndView("labellaprovconf");
//            HEtiqueta hetiqueta = new HEtiqueta();
//            List<Etiqueta> listaetiquetas = hetiqueta.selectAll(Etiqueta.class);
            List<Etiqueta> listaetiquetas = etiquetaService.findAll();
            for(Etiqueta laetiqueta : listaetiquetas){
//                hetiqueta.delete(laetiqueta);
                etiquetaService.deleteEtiqueta(laetiqueta);
            }
        return mav;
    }
    
    @RequestMapping("/etiquetas/poblate")
    public ModelAndView poblateEtiquetas(){
        ModelAndView mav = new ModelAndView("labellaprovconf");
//        HEtiqueta hetiqueta = new HEtiqueta();
        List<Etiqueta> listaetiquetas = new ArrayList<Etiqueta>();
        listaetiquetas.add(new Etiqueta(100, "2017/01 Opecom Enero"));
        listaetiquetas.add(new Etiqueta(100, "2017/02 Opecom Febrero"));
        listaetiquetas.add(new Etiqueta(100, "2017/03 Opecom Marzo"));
        listaetiquetas.add(new Etiqueta(100, "2017/04 Opecom Abril"));
        listaetiquetas.add(new Etiqueta(100, "2017/05 Opecom Mayo"));
        listaetiquetas.add(new Etiqueta(100, "2017/06 Opecom Junio"));
        listaetiquetas.add(new Etiqueta(100, "2017/07 Opecom Julio"));
        listaetiquetas.add(new Etiqueta(100, "2017/08 Opecom Agosto"));
        listaetiquetas.add(new Etiqueta(100, "2017/09 Opecom Septiembre"));
        listaetiquetas.add(new Etiqueta(100, "2017/10 Opecom Octubre"));
        listaetiquetas.add(new Etiqueta(100, "2017/11 Opecom Noviembre"));
        listaetiquetas.add(new Etiqueta(100, "2017/12 Opecom Diciembre"));
        listaetiquetas.add(new Etiqueta(102, "RM Puertas"));
        listaetiquetas.add(new Etiqueta(102, "RM Puertas de entrada"));
        listaetiquetas.add(new Etiqueta(102, "RM Ventanas"));
        listaetiquetas.add(new Etiqueta(102, "RM Armarios"));
        listaetiquetas.add(new Etiqueta(107, "RM Muebles"));
        listaetiquetas.add(new Etiqueta(107, "RM Platos de ducha"));
        listaetiquetas.add(new Etiqueta(107, "RM Mamparas"));
        
        for(Etiqueta laetiqueta : listaetiquetas){
//            hetiqueta.insert(laetiqueta);
            etiquetaService.saveEtiqueta(laetiqueta);
            System.out.println("Etiqueta insertada "+laetiqueta.getNombreEtiqueta());
        }
        return mav;
    }
    
}
