/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.CansinoService;
import com.frapecha.labella.service.impl.CansinoServiceImpl;
import com.frapecha.labella.service.impl.LaBellaProvService;
import com.frapecha.labella.service.impl.LaBellaProvServiceImpl;
import com.frapecha.labella.service.impl.UsuarioService;
import com.frapecha.labella.util.UtilesFicheros;
import com.frapecha.labella.validator.LoginValidator;

import javax.annotation.PostConstruct;
/**
 *
 * @author thepuar
 */
//import com.mycompany.labellaprov.DAO.impl.HUsuarioDAO;
//import com.mycompany.labellaprov.controllers.AdminController;
//import com.mycompany.labellaprov.core.Cansino;
//import com.mycompany.labellaprov.core.LaBellaProv;
//import com.mycompany.labellaprov.core.UtilesFicheros;
//import com.mycompany.labellaprov.modelos.test.LaBellaModel_old;
//import com.mycompany.labellaprov.modelos.validator.LoginValidator;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@RestController 
@RequestMapping("/")
@SessionAttributes("usuario")
public class LoginController {
	 
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	LoginValidator loginValidator;
	
	@Autowired
	LaBellaProvService laBellaProvService;
	
	@Autowired
	CansinoService cansinoService;
	
	@PostConstruct
	protected void iamAlive(){
		
	    System.out.println("Hello Im a Controller");
	}

    public static final Logger logger = org.apache.logging.log4j.LogManager.getLogger("LoggerLog");
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main() {
        
        logger.info("Hola");
        laBellaProvService.init();
        System.out.println("Controller Login");
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("usuario", new Usuario());

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        boolean estaCansino = false;
        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("Cansino")) {
                estaCansino = true;
                System.out.println("Cansino ya se estaba ejecutando");
            }

        }
        if (!estaCansino) {
            Thread hilo = new Thread(cansinoService, "Cansino");
            hilo.start();
            System.out.println("He creado a Cansino");
        }
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute("usuario") Usuario elusuario, BindingResult result) {

        ModelAndView mav = new ModelAndView();
        
        Usuario usuario = usuarioService.findByLdap(elusuario.getLdap());
//        HUsuarioDAO husuario = new HUsuarioDAO();
//        Usuario dbuser = husuario.getByLdap(elusuario.getLdap());
        
        //Comprobar si es administrador
        if (usuario == null) {
            UtilesFicheros uf = new UtilesFicheros();
            String value = uf.getPropertyByName("admin_name");
            Integer nameAdmin = Integer.parseInt(uf.getPropertyByName("admin_name"));
            String passAdmin = uf.getPropertyByName("pass_admin");
//
            if (elusuario.getLdap().intValue() == nameAdmin && elusuario.getPassword().equals(passAdmin)) {
//                //Es admin
//                AdminController adminController = new AdminController();
//                return adminController.main();
            }
        }
        loginValidator.validate(elusuario, result);
        if (result.hasErrors()) {
            //Hay errores
            mav.setViewName("login");
        } else {
            if (usuario != null) {
//
                System.out.println("Nombre db user :" + usuario.getNombre());
                mav.addObject("usuario", usuario);
                System.out.println("GoToPrincipal");
                mav.setViewName("redirect:/uprincipal");
            } else {
                Usuario testUser = new Usuario();
                testUser.setNombre("Administrador");
                testUser.setLdap(30000000);
                testUser.setApellidos("");
                testUser.setPassword("Passw0rd");
                usuarioService.saveUsuario(testUser);
                mav.setViewName("principal");
            }
        }
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(SessionStatus status) {
        ModelAndView mav = new ModelAndView("redirect:/");
        mav.addObject("usuario",null);
        status.setComplete();

        return mav;
        
        
    }
    
    
    

}
