/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Historico;
import com.frapecha.labella.model.LineaPedido;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.EtiquetaService;
import com.frapecha.labella.service.impl.HistoricoService;
import com.frapecha.labella.service.impl.PedidoService;
import com.frapecha.labella.service.impl.ProveedorService;
import com.frapecha.labella.service.impl.SeccionService;
import com.frapecha.labella.service.impl.TiendaService;
import com.frapecha.labella.service.impl.UsuarioService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class NavBarController {
	
	@Autowired
	TiendaService tiendaService;
	
	@Autowired
	SeccionService seccionService;
	
	@Autowired
	ProveedorService proveedorService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EtiquetaService etiquetaService;
	
	@Autowired
	HistoricoService historicoService;

    @RequestMapping("/tiendas")
    public ModelAndView gotoTiendas() {
//        HTienda htienda = new HTienda();
//        List<Tienda> listTiendas = htienda.selectAllAndSecciones();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("tiendas", listTiendas);
//        return mav;
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("tiendas", tiendaService.findAll());
    	return mav;
    }

    @RequestMapping("/secciones")
    public ModelAndView gotoSecciones() {
//        HSeccion hseccion = new HSeccion();
//        List<Seccion> listSecciones = hseccion.selectAll(Seccion.class);
//        List<Seccion> nuevalista = new ArrayList<Seccion>();
//        for (Seccion laseccion : listSecciones) {
//            Seccion sec = hseccion.getByNumero(laseccion.getNumero());
//            nuevalista.add(sec);
//            System.out.println("La seccion " + sec.getNombre() + " tiene " + sec.getPedidos().size() + " pedidos.");
//        }
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("secciones", nuevalista);
//        return mav;
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("secciones",seccionService.findAll());
    	return mav;
    	
    }

    @RequestMapping("/proveedores")
    public ModelAndView gotoProveedores() {
//        HProveedor hprov = new HProveedor();
//        List<Proveedor> listProv = hprov.selectAllAndPedidos();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("proveedores", listProv);
//        mav.setViewName("proveedores");
//        return mav;
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("proveedores",proveedorService.findAll());
    	return mav;
    	
    }

    @RequestMapping("/pedidos")
    public ModelAndView gotoPedidos() {
//        HPedido hpedido = new HPedido();
//        List<Pedido> listPedidos = hpedido.selectAll(Pedido.class);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("pedidos", listPedidos);
//        return mav;
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("pedidos",pedidoService.findAll());
    	return mav;
    }

    @RequestMapping("/usuarios")
    public ModelAndView gotoUsuarios() {
//        HUsuarioDAO husuario = new HUsuarioDAO();
//        List<Usuario> listUsuarios = husuario.selectAll(Usuario.class);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("usuarios", listUsuarios);
//        return mav;
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("usuarios",usuarioService.findAll());
    	return mav;
    }

    @RequestMapping("/etiquetas")
    public ModelAndView gotoEtiquetas() {
//        HEtiqueta hetiqueta = new HEtiqueta();
//        List<Etiqueta> listEtiq = hetiqueta.selectAll(Etiqueta.class);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("etiquetas", listEtiq);
//        return mav;
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("etiquetas",etiquetaService.findAll());
    	return mav;
    	
    }
    
//    @RequestMapping("/uetiquetas")
//    public ModelAndView gotoUEtiquetas(@ModelAttribute("usuario") Usuario elusuario){
//        HEtiqueta hetiqueta = new HEtiqueta();
//        List<Etiqueta> listEtiq = hetiqueta.selectAllByNumSeccion(elusuario.get)
//    }
    @RequestMapping("/historico")
    public ModelAndView gotoHistorico() {
//        HHistorico hhistorico = new HHistorico();
//        List<Historico> listHist = hhistorico.selectAll(Historico.class);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("historico", listHist);
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("historico",historicoService.findAll());
        return mav;

    }

    @RequestMapping("/uproveedores")
    public ModelAndView gotoUProveedores(@ModelAttribute("usuario") Usuario elusuario) {
//        HProveedor hprov = new HProveedor();
        List<Proveedor> listProv = new ArrayList<>();
//        for (Seccion laseccion : elusuario.getSecciones()) {
//            listProv.addAll(hprov.selectByNumSeccionAndPedidosVivos(laseccion.getNumero()));
//        }
        for(Seccion seccion : elusuario.getSecciones()) {
        	listProv.addAll(proveedorService.findByNumSeccion(seccion.getNumero()));
        }
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("proveedores", listProv);
        mav.setViewName("uproveedores");
        return mav;
    }

    @RequestMapping("/upedidos")
    public ModelAndView gotoUPedidos(@ModelAttribute("usuario") Usuario elusuario) {
//        HPedido hpedido = new HPedido();
        List<Pedido> listPedidos = new ArrayList<>();
        for (Seccion laseccion : elusuario.getSecciones()) {
//            listPedidos.addAll(hpedido.selectAllEnCursoByIdSeccion(laseccion.getId()));
        	listPedidos.addAll(pedidoService.findBySeccionAndEnCurso(laseccion, true));
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("pedidos", listPedidos);
        mav.setViewName("upedidos");
        return mav;

    }

    @RequestMapping("/uprincipal")
    public ModelAndView gotoIndex(@ModelAttribute("usuario") Usuario elusuario) {
        ModelAndView mav = new ModelAndView("uprincipal");
        Tienda latienda = elusuario.getSecciones().get(0).getTienda();
//        latienda = htienda.selectByIdAndSecciones(latienda.getId());
        latienda= tiendaService.findByNumero(elusuario.getSecciones().get(0).getTienda().getNumero());
        List<Seccion> lseccion = new ArrayList<>();
        Map<Integer, Seccion> mapseccion = new HashMap<Integer, Seccion>();

        int pedidosTiendaVivos = 0;
        int pedidosTiendaRevisados = 0;
        for (Seccion laseccion : latienda.getSecciones()) {
            if (laseccion.getNumero() < 14) {
                //mapseccion.put(laseccion.getNumero(), hseccion.getByIdAndPedidos(laseccion.getId()));
            	mapseccion.put(laseccion.getNumero(), seccionService.findById(laseccion.getId()));

            }
        }

        for (int i = 1; i < 14; i++) {
            lseccion.add(mapseccion.get(i));
            pedidosTiendaVivos += mapseccion.get(i).getNumPedidosVivos();
            pedidosTiendaRevisados += mapseccion.get(i).getNumPedidosVivosRevisados();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(latienda.getFechaLPRE());
        cal.add(Calendar.MONTH,-1);
        latienda.setFechaLPRE(cal.getTime());
        mav.addObject("tienda", latienda);
        mav.addObject("pedidosVivos", pedidosTiendaVivos);
        mav.addObject("pedidosRevisados", pedidosTiendaRevisados);
        mav.addObject("secciones", lseccion);
        return mav;
    }

    @RequestMapping("/spedido")
    public ModelAndView gotoPedido(@RequestParam(value = "buscar") String buscar) {
        ModelAndView mav = new ModelAndView();
//        HPedido hpedido = new HPedido();
//        HLineaPedido hlineaPedido = new HLineaPedido();
        List<Pedido> resultPedidos;//Que contienen esa referencia
        Integer numBuscar;
        try {
            numBuscar = Integer.parseInt(buscar);
//            Pedido elpedido = hpedido.getByNumPedido(numBuscar);
            Pedido elpedido = pedidoService.findByNumeropedido(numBuscar);
            if (elpedido != null) {
                mav.setViewName("redirect:/upedido/" + elpedido.getId());
                return mav;
            } else {
                mav.addObject("mensaje", "No se ha encontrado ningún pedido con ese número.");
                //comprobar si es una referencia.
//                resultPedidos =  hpedido.selectAllPedidosByReferencia(numBuscar);
                resultPedidos = pedidoService.findByLineasReferencia(numBuscar);
                if (resultPedidos.size() > 0) {
                    //Es una referencia y hay resultados
                    mav.setViewName("histReferencia");
                    mav.addObject("pedidos", resultPedidos);
                    mav.addObject("referencia",numBuscar);
                    return mav;
                }else{
                mav.addObject("mensaje", "No se ha encontrado ningún pedido con esa referencia.");
                }
            }
        } catch (NumberFormatException ex) {

        }
        mav.setViewName("error");
        

        return mav;
    }
    
    @RequestMapping("/uetiquetas")
    public ModelAndView gotoUEtiquetas(@ModelAttribute("usuario")Usuario elusuario) {
//        HEtiqueta hetiqueta = new HEtiqueta();
//        List<Etiqueta> listEtiq = hetiqueta.selectAll(Etiqueta.class);
//        List<Etiqueta> listEtiqEliminar = new ArrayList<Etiqueta>();
//        List<Integer> listNumEtiquetas = new ArrayList<Integer>();
//        listNumEtiquetas.add(100);//Etiquetas de opecom
//        for(Seccion laseccion : elusuario.getSecciones()){
//            listNumEtiquetas.add(laseccion.getNumero());//Etiquetas concretas de la seccion
//            listNumEtiquetas.add(100+laseccion.getNumero());//Etiquetas concretas y comunes, ejemplo 100 +2 -> RM de la seccion
//        }
//        for(Etiqueta laetiqueta : listEtiq){
//            boolean conservar = false;
//            for(Integer num : listNumEtiquetas){
//                if(laetiqueta.getNumSeccion()==num)conservar = true;
//            }
//            if(!conservar){
//                listEtiqEliminar.add(laetiqueta);
//            }
//        }
//        listEtiq.removeAll(listEtiqEliminar);
        ModelAndView mav = new ModelAndView();
//        mav.addObject("etiquetas", listEtiq);
        return mav;
    }

}
