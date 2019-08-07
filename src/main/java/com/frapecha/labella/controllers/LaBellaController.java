/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.service.impl.TiendaService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class LaBellaController {
	
	@Autowired
	TiendaService tiendaService;
    
    @RequestMapping("/resumen")
    public ModelAndView gotoResumen() {
        ModelAndView mav = new ModelAndView("resumen");
//        Tienda latienda = htienda.selectByIdAndSeccionesAndPedidos(htienda.selectTiendaByNum(63).getId());
        
        Tienda latienda = tiendaService.findByNumero(63);
        
        int[] listapedidos ;
        
        listapedidos = new int[13];
        for(int i = 1; i<14;i++){
            listapedidos[i-1] = latienda.getNumPedidosPorSeccion(i);
        }
        mav.addObject("numpedidos", listapedidos);
        
        double[] udspedidos;
        udspedidos = new double[13];
        for(int i = 1; i<14;i++){
            udspedidos[i-1] = latienda.getUdsPedidosPorSeccion(i);
        }
        mav.addObject("udspedidos",udspedidos);

        
        double[] valorseccion;
        valorseccion = new double[13];
        for(int i = 1; i<14; i++){
            valorseccion[i-1] = latienda.getValorPedidosPorSeccion(i);
        }
        mav.addObject("valorencurso",valorseccion);
        
        int[] pedidosxdia;
        pedidosxdia = new int[14];
        for(int i = 0; i<14; i++){
            pedidosxdia[i] = latienda.getNumPedidosDia(i);
        }
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar today = new GregorianCalendar();
        
        String[] nombredias;
        nombredias = new String[14];
        nombredias[0] = df.format(today.getTime());
        for(int i = 1; i<14; i++){
            today.add(Calendar.DAY_OF_YEAR, 1);
            nombredias[i]= df.format(today.getTime());
        }
        mav.addObject("nombredias",nombredias);
        mav.addObject("pedidosxdia",pedidosxdia);
        return mav;
    }
}
