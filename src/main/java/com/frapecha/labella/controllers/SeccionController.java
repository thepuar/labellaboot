/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.service.impl.SeccionService;
import com.frapecha.labella.validator.SeccionValidator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class SeccionController {
	
	@Autowired
	SeccionValidator seccionValidator;
	
	@Autowired
	SeccionService seccionService;
	
	  @RequestMapping("/useccion/info/{id}")
	    public ModelAndView gotoInfoUSeccion(@PathVariable(value = "id") Long id) {
	        ModelAndView mav = new ModelAndView("useccion/info");
	    	Seccion laseccion = seccionService.findById(id);

	        mav.addObject("seccion", laseccion);
	        return mav;
	    }
	    
	    
	    @RequestMapping(value = "/useccion/update/{id}", method = RequestMethod.POST)
	    public ModelAndView UpdateSeccion(@Valid @ModelAttribute("seccion") Seccion laseccion, @PathVariable(value = "id") Long id, BindingResult result, Model model) {
	        ModelAndView mav = new ModelAndView();
	    	Seccion secciondb = seccionService.findById(id);
	        mav.addObject("seccionInfo", secciondb);
	        seccionValidator.validate(laseccion, result);
	        if (result.hasErrors()) {
	            mav.setViewName("useccion/update");
	            mav.addObject(result.getModel());
	            return mav;
	        } else {
	            secciondb.setEmail(laseccion.getEmail());
	            seccionService.saveSeccion(secciondb);
	            mav.setViewName("redirect:/useccion/info/" + secciondb.getId());
	            return mav;
	        }
	    }


    @RequestMapping("/seccion/{id}")
    public ModelAndView gotoDetailSeccion(@PathVariable(value = "id") Long id) {
//        HSeccion hseccion = new HSeccion();
//        Seccion laseccion = hseccion.getByIdAndPedidos(id);
    	Seccion laseccion = seccionService.findById(id);
        ModelAndView mav = new ModelAndView("seccion");
        mav.addObject("seccion", laseccion);

        int[] pedidosxdia;
        pedidosxdia = new int[14];
        for (int i = 0; i < 14; i++) {
            pedidosxdia[i] = laseccion.getNumPedidosDia(i);
            System.out.println("Pedidos para hoy " + pedidosxdia[i]);
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar today = new GregorianCalendar();

        String[] nombredias;
        nombredias = new String[14];
        nombredias[0] = df.format(today.getTime());
        for (int i = 1; i < 14; i++) {
            today.add(Calendar.DAY_OF_YEAR, 1);
            nombredias[i] = df.format(today.getTime());
        }
        mav.addObject("pedidosxdia", pedidosxdia);
        mav.addObject("nombredias", nombredias);
        return mav;
    }

    @RequestMapping("/useccion/{id}")
    public ModelAndView gotoDetailUSeccion(@PathVariable(value = "id") Long id) {
//        HSeccion hseccion = new HSeccion();
//        Seccion laseccion = hseccion.getByIdAndPedidos(id);
    	Seccion laseccion = seccionService.findById(id);

        ModelAndView mav = new ModelAndView("useccion");
        mav.addObject("seccion", laseccion);

        //Pedidos por dia
        int[] pedidosxdia;
        pedidosxdia = new int[14];
        for (int i = 0; i < 14; i++) {
            pedidosxdia[i] = laseccion.getNumPedidosDia(i);
            //System.out.println("Pedidos para hoy "+pedidosxdia[i]);
        }
        //Pedidos por dia que se entregan en tienda
        int[] pedidosxdiasitienda;
        pedidosxdiasitienda = new int[14];
        for (int i = 0; i < 14; i++) {
            pedidosxdiasitienda[i] = laseccion.getNumPedidosDiaSiTienda(i);
        }

        //Pedidos por dia que no se entregan en tienda
        int[] pedidosxdianotienda;
        pedidosxdianotienda = new int[14];
        for (int i = 0; i < 14; i++) {
            pedidosxdianotienda[i] = laseccion.getNumPedidosDiaNoTienda(i);
        }

        //Palets por dia
        int[] paletsxdia;
        paletsxdia = new int[14];
        for (int i = 0; i < 14; i++) {
            paletsxdia[i] = laseccion.getNumPaletsDia(i);
        }
        //Palets por dia que se entregan en tienda
        int[] paletsxdiasitienda;
        paletsxdiasitienda = new int[14];
        for (int i = 0; i < 14; i++) {
            paletsxdiasitienda[i] = laseccion.getNumPaletsDiaATienda(i);
        }
        //Palets por dia que no se entregan en tienda
        int[] paletsxdianotienda;
        paletsxdianotienda = new int[14];
        for (int i = 0; i < 14; i++) {
            paletsxdianotienda[i] = laseccion.getNumPaletsDiaNoATienda(i);
        }
        //Unidades por dia
        int[] unidadesxdia;
        unidadesxdia = new int[14];
        for (int i = 0; i < 14; i++) {
            unidadesxdia[i] = laseccion.getUnidadesDia(i);
        }
        //Unidades por dia que se entregan en tienda
        int[] unidadesxdiasitienda;
        unidadesxdiasitienda = new int[14];
        for (int i = 0; i < 14; i++) {
            unidadesxdiasitienda[i] = laseccion.getUnidadesDiaATienda(i);
        }
        //Unidades por dia que no se entregan en tienda
        int[] unidadesxdianotienda;
        unidadesxdianotienda = new int[14];
        for (int i = 0; i < 14; i++) {
            unidadesxdianotienda[i] = laseccion.getNumPaletsDiaNoATienda(i);
        }
        //Importe por dia
        double[] importexdia;
        importexdia = new double[14];
        for (int i = 0; i < 14; i++) {
            importexdia[i] = laseccion.getImporteDia(i);
        }
        //Importe por dia que se entrega en tienda
        double[] importexdiaatienda;
        importexdiaatienda = new double[14];
        for (int i = 0; i < 14; i++) {
            importexdiaatienda[i] = laseccion.getImporteDiaATienda(i);
        }
        //Importe por dia que no se entrega en tienda
        double[] importexdianoatienda;
        importexdianoatienda = new double[14];
        for (int i = 0; i < 14; i++) {
            importexdianoatienda[i] = laseccion.getImporteDiaNoATienda(i);
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar today = new GregorianCalendar();

        String[] nombredias;
        nombredias = new String[14];
        nombredias[0] = df.format(today.getTime());
        for (int i = 1; i < 14; i++) {
            today.add(Calendar.DAY_OF_YEAR, 1);
            nombredias[i] = df.format(today.getTime());
        }
        mav.addObject("pedidosxdia", pedidosxdia);
        mav.addObject("nombredias", nombredias);
        mav.addObject("pedidosxdiasitienda", pedidosxdiasitienda);
        mav.addObject("pedidosxdianotienda", pedidosxdianotienda);

        mav.addObject("paletsxdia", paletsxdia);
        mav.addObject("paletsxdiasitienda", paletsxdiasitienda);
        mav.addObject("paletsxdianotienda", paletsxdianotienda);

        mav.addObject("unidadesxdia", unidadesxdia);
        mav.addObject("unidadesxdiasitienda", unidadesxdiasitienda);
        mav.addObject("unidadesxdianotienda", unidadesxdianotienda);

        mav.addObject("importexdia", importexdia);
        mav.addObject("importexdiasitienda", importexdiaatienda);
        mav.addObject("importexdianotienda", importexdianoatienda);

        //Datos para grafica de revisados
        int pedidosvivosrevisados = laseccion.getNumPedidosVivosRevisados();
        int pedidosvivosnorevisados = laseccion.getNumPedidosVivosNoRevisados();
        int pedidosvivos = laseccion.getNumPedidosVivos();
        double porcpedidosvivosrevisados = (pedidosvivosrevisados * 100) / pedidosvivos;
        double porcpedidosvivosnorevisados = (pedidosvivosnorevisados * 100) / pedidosvivos;
        mav.addObject("numRevisados", pedidosvivosrevisados);
        mav.addObject("numNoRevisados", pedidosvivosnorevisados);
        mav.addObject("porcRevisados", porcpedidosvivosrevisados);
        mav.addObject("porcNoRevisados", porcpedidosvivosnorevisados);

        //Datos para grafica de tipos de pedidos
        int numpedidostienda = laseccion.getNumPedidosVivosRevTienda();
        int numpedidospc = laseccion.getNumPedidosVivosRevPC();
        int numpedidosopecom = laseccion.getNumPedidosVivosRevOpecom();
        int numpedidosrm = laseccion.getNumPedidosVivosRevRM();
        double porctienda = 0;
        double porcpc = 0;
        double porcopecom = 0;
        double porcrm = 0;
        if (pedidosvivosrevisados > 0) {
            porctienda = (numpedidostienda * 100) / pedidosvivosrevisados;
            porcpc = (numpedidospc * 100) / pedidosvivosrevisados;
            porcopecom = (numpedidosopecom * 100) / pedidosvivosrevisados;
            porcrm = (numpedidosrm * 100) / pedidosvivosrevisados;
        }
        mav.addObject("porcTienda", porctienda);
        mav.addObject("numPedTienda", numpedidostienda);
        mav.addObject("porcPC", porcpc);
        mav.addObject("numPedPC", numpedidospc);
        mav.addObject("porcOpecom", porcopecom);
        mav.addObject("numPedOpecom", numpedidosopecom);
        mav.addObject("porcRM", porcrm);
        mav.addObject("numPedRM", numpedidosrm);

//        //Palets por dias
//            int[]paletsxdia;
//            paletsxdia=new int[14];
//            for(int i = 0;i<14;i++){
//                paletsxdia[i] = laseccion.getNumPaletsDia(i);
//                System.out.println("Palets para hoy "+pedidosxdia[i]);
//            }
        return mav;
    }

  
    

    @RequestMapping(value = "/useccion/update/{id}", method = RequestMethod.GET)
    public ModelAndView gotoUpdateUSeccion(@PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("useccion/update");
//        HSeccion hseccion = new HSeccion();
//        Seccion laseccion = (Seccion) hseccion.selectById(id, Seccion.class);
    	Seccion laseccion = seccionService.findById(id);

        mav.addObject("seccionInfo", laseccion);
        mav.addObject("seccion", laseccion);
        return mav;
    }

   

}
