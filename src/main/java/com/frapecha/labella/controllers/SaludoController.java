/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.UsuarioService;

import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@SessionAttributes("datosuser")
@Controller
public class SaludoController {
	
	@Autowired
	UsuarioService usuarioService;

//    //@RequestMapping
//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
//    public String homepage(ModelMap model) {
//        System.out.println("He entrado por String");
//        return "main";
//    }
//    @RequestMapping("/*")
//    public ModelAndView main() {
//        //session.setAttribute("valor", "Vacio");
//        System.out.println("He entrado por MAV");
//        return new ModelAndView("main", "command", new Usuario());
//
//    }

   
    
    
    
    @RequestMapping(value = "/saludo", method = RequestMethod.GET)
    public ModelAndView saludo(@ModelAttribute("modelo") Usuario elusuario, HttpSession session) {

        ModelAndView mav = new ModelAndView("saludo");
        mav.addObject("commando", new Usuario());
        session.setAttribute("valor", elusuario.getPassword());
        mav.addObject("valorsesion", (String) session.getAttribute("valor"));
        mav.addObject("datosuser", elusuario);
        return mav;
    }

    @RequestMapping(value = "/saludo1", method = RequestMethod.POST)
    public ModelAndView saludo1() {
        return new ModelAndView("saludo");
    }

    @RequestMapping(value = "/saludo2", method = RequestMethod.GET)
    public ModelAndView saludo2(@ModelAttribute("datosuser") Usuario valor) {
        ModelAndView mav = new ModelAndView("pruebasesion");
        mav.addObject("eldato", valor);

        return mav;
    }

    @RequestMapping("/home2")
    public ModelAndView home(@ModelAttribute("datosuser") Usuario elusuario) {
        ModelAndView mav = new ModelAndView("home");
        System.out.println("Usuario " + elusuario.getLdap());
        mav.addObject("usuario", elusuario);
        return mav;
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
//        HUsuarioDAO huser = new HUsuarioDAO();
        Usuario eluser = new Usuario();
        eluser.setLdap(30017301);
        eluser.setPassword("2609");
        eluser.setNombre("Francisco");
        eluser.setApellidos("Pérez");
//        huser.insert(eluser);
        usuarioService.saveUsuario(eluser);
       // huser.selectAll(Usuario.class);

        return mav;
    }
    
     @RequestMapping(value="/gotoIndex", method=RequestMethod.GET)
    public ModelAndView index(){
        System.out.println("Nuevo controller");
        return new ModelAndView("index");
    }
}
