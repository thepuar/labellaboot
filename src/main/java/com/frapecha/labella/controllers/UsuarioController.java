/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.TiendaService;
import com.frapecha.labella.service.impl.UsuarioService;
import com.frapecha.labella.validator.UsuarioValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
public class UsuarioController {
    
	@Autowired
	UsuarioValidator usuarioValidator;
	
	@Autowired
	UsuarioService usuarioService;
    
	@Autowired
	TiendaService tiendaService;
	
    @RequestMapping( value="/usuarios/update/{id}",method = RequestMethod.GET)
    public ModelAndView gotoUpdateUsuario(@PathVariable(value="id")Long id){
        ModelAndView mav = new ModelAndView("usuarios/update");
//        HUsuario husuario = new HUsuario();
//        Usuario elusuario = (Usuario)husuario.selectById(id, Usuario.class);
        Usuario elusuario = usuarioService.findById(id);
        mav.addObject("user",elusuario);
//        HTienda htienda = new HTienda();
//        Tienda tienda = htienda.selectByIdAndSecciones(elusuario.getSecciones().get(0).getTienda().getId());
        Tienda tienda = tiendaService.findById(elusuario.getSecciones().get(0).getTienda().getId());
        Map secciones = new HashMap();
        secciones.put(0,"0 - No añadir");
        for(Seccion laseccion : tienda.getSecciones()){
            secciones.put(laseccion.getId(), laseccion.getNumero()+" - "+laseccion.getNombre());
        }
        mav.addObject("seccionesTienda",secciones);
        
        return mav;
    }
    
    @RequestMapping(value="/usuarios/update/{id}", method= RequestMethod.POST)
    public ModelAndView UpdateUsuario(@Valid @ModelAttribute("user")Usuario usuario,@ModelAttribute("seccionesTienda")HashMap secciones, @PathVariable(value="id")Long id, BindingResult result){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/usuarios");
//        HUsuario husuario = new HUsuario();
//        Usuario usuariodb = (Usuario)husuario.selectById(id, Usuario.class);
        Usuario usuariodb = usuarioService.findById(id);
        usuariodb.setLdap(usuario.getLdap());
        usuariodb.setNombre(usuario.getNombre());
        usuariodb.setApellidos(usuario.getApellidos());
        usuariodb.setEmail(usuario.getEmail());
        usuariodb.setPassword(usuario.getPassword());
//        husuario.update(usuariodb);
        usuarioService.saveUsuario(usuariodb);
        
        UsuarioValidator usuarioValidator = new UsuarioValidator();
        if(result.hasErrors()){}
        
        return mav;
    }
}
