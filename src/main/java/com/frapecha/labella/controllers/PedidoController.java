/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Etiqueta;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.EtiquetaService;
import com.frapecha.labella.service.impl.LaBellaProvServiceImpl;
import com.frapecha.labella.service.impl.PedidoService;
import com.frapecha.labella.service.impl.ProveedorService;
import com.frapecha.labella.util.MailCutre;
import com.frapecha.labella.validator.PedidoValidator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
@SessionAttributes("usuario")
public class PedidoController {
	
	@Autowired
	PedidoValidator pedidoValidator;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ProveedorService proveedorService;
	
	
	@Autowired
	EtiquetaService etiquetaService;
	
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(PedidoController.class);

    @RequestMapping("/pedido/{id}")
    public ModelAndView gotoDetailPedido(@PathVariable(value = "id") Long id) {
//        HPedido hpedido = new HPedido();
//        Pedido elpedido = (Pedido) hpedido.selectByIdAndLineas(id);
        Pedido elpedido = pedidoService.findById(id);
        ModelAndView mav = new ModelAndView("pedido");
        mav.addObject("pedido", elpedido);

        return mav;
    }
    
    @RequestMapping("pedido/adddate")
    public ModelAndView updateXDays() {
    	List<Pedido> pedidos = pedidoService.findAll();
    	Calendar cal =null;
    	int num = 1;
    	int i = 0;
    	for(Pedido pedido : pedidos) {
    		pedido.setRevisado(true);
    		 cal = Calendar.getInstance();
    		Date date = pedido.getFechaentrega();
    		int day = date.getDate();
    		cal.set(Calendar.DAY_OF_MONTH, day);
    		pedido.setFechaentrega(cal.getTime());
    		pedido.setFechaentregaReal(cal.getTime());
    		if(i==10) {
    			pedido.setRevisado(false);
    			i=0;
    		}
    		pedidoService.updatePedido(pedido);
    		
    		i++;
    		num++;
    		log.info(num+" - Pedido "+pedido.getNumeropedido());
    	}
    	ModelAndView mav = new ModelAndView("redirect:/");
    	return mav;
    	
    }

    @RequestMapping("/upedido/{id}")
    public ModelAndView gotoDetailUPedido(@PathVariable(value = "id") Long id) {
//        HPedido hpedido = new HPedido();
//        Pedido elpedido = (Pedido) hpedido.selectByIdAndLineas(id);
        Pedido elpedido = pedidoService.findById(id);
        ModelAndView mav = new ModelAndView("upedido");
        mav.addObject("pedido", elpedido);
        Proveedor proveedor = proveedorService.findByPedidos(elpedido);
        if (proveedor.IsPossibleSendEmail()) {
            MailCutre mailprov = new MailCutre(elpedido);
            mav.addObject("mailProv", mailprov);
        }

        return mav;
    }

    @RequestMapping(value = "/pedido/update/{id}", method = RequestMethod.GET)
    public ModelAndView gotoUpdatePedido(@PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("pedido/update");
//        HPedido hpedido = new HPedido();
//        Pedido pedido = (Pedido) hpedido.selectByIdAndLineas(id);
        Pedido pedido = pedidoService.findById(id);
        mav.addObject("pedido", pedido);
//        HEtiqueta hetiqueta = new HEtiqueta();

//        List<Etiqueta> listaetiqueta = hetiqueta.selectAll(Etiqueta.class);
        List<Etiqueta> listaetiqueta = etiquetaService.findAll();
        List<Etiqueta> selectOpecom = new ArrayList<>();
        selectOpecom.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == 100) {
                selectOpecom.add(laetiqueta);
            }
        }
        mav.addObject("selectOpecom", selectOpecom);

        List<Etiqueta> selectRM = new ArrayList<>();
        selectRM.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == (100 + pedido.getProveedor().getNumSeccion())) {
                selectRM.add(laetiqueta);
            }
        }
        mav.addObject("selectRM", selectRM);

        List<Etiqueta> selectSeccion = new ArrayList<>();
        //Map<Integer, String> selectSeccion = new LinkedHashMap<Integer, String>();
        selectSeccion.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == (pedido.getProveedor().getNumSeccion())) {
                selectSeccion.add(laetiqueta);
            }
        }
        mav.addObject("selectSeccion", selectSeccion);

        return mav;
    }

    @RequestMapping(value = "/upedido/update/{id}", method = RequestMethod.GET)
    public ModelAndView gotoUpdateUPedido(@PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("upedido/update");
//        HPedido hpedido = new HPedido();
//        Pedido pedido = (Pedido) hpedido.selectByIdAndLineas(id);
        Pedido pedido = pedidoService.findById(id);
        mav.addObject("pedido", pedido);
//        HEtiqueta hetiqueta = new HEtiqueta();

//        List<Etiqueta> listaetiqueta = hetiqueta.selectAll(Etiqueta.class);
        List<Etiqueta> listaetiqueta = etiquetaService.findAll();
        List<Etiqueta> selectOpecom = new ArrayList<>();
        selectOpecom.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == 100) {
                selectOpecom.add(laetiqueta);
            }
        }
        mav.addObject("selectOpecom", selectOpecom);

        List<Etiqueta> selectRM = new ArrayList<>();
        selectRM.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == (100 + pedido.getProveedor().getNumSeccion())) {
                selectRM.add(laetiqueta);
            }
        }
        mav.addObject("selectRM", selectRM);

        List<Etiqueta> selectSeccion = new ArrayList<>();
        //Map<Integer, String> selectSeccion = new LinkedHashMap<Integer, String>();
        selectSeccion.add(new Etiqueta(0, "Nada"));
        for (Etiqueta laetiqueta : listaetiqueta) {
            if (laetiqueta.getNumSeccion() == (pedido.getProveedor().getNumSeccion())) {
                selectSeccion.add(laetiqueta);
            }
        }
        mav.addObject("selectSeccion", selectSeccion);

        return mav;
    }

    @RequestMapping(value = "/pedido/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdatePedido(@Valid @ModelAttribute("pedido") Pedido pedido, @PathVariable(value = "id") Long id, BindingResult result) {
        ModelAndView mav = new ModelAndView();
//        HPedido hpedido = new HPedido();
//        Pedido pedidodb = hpedido.selectByIdAndLineas(id);
        Pedido pedidodb = pedidoService.findById(id);
        pedido = pedidoService.findById(id);
        mav.addObject("pedido", pedidodb);
        pedidoValidator.validate(pedido, result);
        if (result.hasErrors()) {
            mav.setViewName("pedido/update");
            mav.addObject(result.getModel());

        } else {
            mav.setViewName("pedido");
            pedidodb.setNumPalets(pedido.getNumPalets());
            pedidodb.setFechaentregaReal(pedido.getFechaentregaReal());
            pedidodb.setObservacion(pedido.getObservacion());
            pedidodb.setTipoPedido(pedido.getTipoPedido());
            pedidodb.setRevisado(true);
            pedidodb.setDestacado(pedido.isDestacado());
            pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
            pedidodb.setPendienteAnular(pedido.isPendienteAnular());
//            HEtiqueta hetiqueta = new HEtiqueta();
            Etiqueta laetiqueta = null;
            switch (pedidodb.getTipoPedido()) {
                case 0: //Tienda
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    if (pedido.getEtiquetaId() != null) {
//                        pedidodb.setEtiquetaTienda((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaId(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.etiquetaId));
                        pedidodb.setEtiquetaId(pedido.getEtiquetaId());
                        pedidodb.setEtiquetaOpecom(null);
                        pedidodb.setEtiquetaRM(null);
                        pedidodb.setEntregaEnTienda(true);
                    }
                    pedidodb.setNumPC(null);
                    break;
                case 1: //PC
                    pedidodb.setEntregaEnTienda(pedido.isEntregaEnTienda());
                    pedidodb.setNumPC(pedido.getNumPC());
                    pedidodb.setEtiquetaTienda(null);
                    pedidodb.setEtiquetaOpecom(null);
                    pedidodb.setEtiquetaRM(null);

                    break;
                case 2: //Opecom
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    if (pedido.getEtiquetaIdOpecom() != null) {
//                        pedidodb.setEtiquetaOpecom((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaIdOpecom(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.getEtiquetaIdOpecom()));
                        pedidodb.setEtiquetaId(pedido.getEtiquetaIdOpecom());
                        pedidodb.setEtiquetaTienda(null);
                        pedidodb.setEtiquetaRM(null);
                        pedidodb.setEntregaEnTienda(true);
                    }
                    pedidodb.setNumPC(null);
                    break;
                case 3: //RM
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    if (pedido.getEtiquetaIdRM() != null) {
//                        pedidodb.setEtiquetaRM((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaIdRM(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.getEtiquetaIdRM()));
                        pedidodb.setEtiquetaId(pedido.getEtiquetaIdRM());
                        pedidodb.setEtiquetaOpecom(null);
                        pedidodb.setEtiquetaTienda(null);
                        pedidodb.setEntregaEnTienda(true);
                    }
                    pedidodb.setNumPC(null);
                    break;
                default:
                    break;
            }
            pedidoService.updatePedido(pedidodb);
//            hpedido.update(pedidodb);
        }
        return mav;
    }

    @RequestMapping(value = "/upedido/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUPedido(@Valid @ModelAttribute("pedido") Pedido pedido, @PathVariable(value = "id") Long id, @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        ModelAndView mav = new ModelAndView();
//        HPedido hpedido = new HPedido();
//        Pedido pedidodb = hpedido.selectByIdAndLineas(id);
        Pedido pedidodb = pedidoService.findById(id);
        PedidoValidator pedidovalidator = new PedidoValidator();
        mav.addObject("pedido", pedidodb);
        pedidovalidator.validate(pedido, result);
        if (result.hasErrors()) {
            mav.setViewName("upedido/update");
            mav.addObject(result.getModel());

        } else {
            Calendar ahora = Calendar.getInstance();
            String fecha = ahora.get(Calendar.DAY_OF_MONTH) + "/" + (ahora.get(Calendar.MONTH) + 1) + "/" + ahora.get(Calendar.YEAR) + " " + ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE) + ":" + ahora.get(Calendar.SECOND);
            String logObservacion = fecha + " - " + usuario.getLdap() + " " + usuario.getNombre() + " " + usuario.getApellidos() + ":";
            String logNuevo = "";
            String resultado = "";

            if (!pedido.getNuevoComentario().isEmpty()) {
                resultado += pedidodb.getObservacion() + "\n";
                resultado += logObservacion + "\n";
                logNuevo = pedido.getNuevoComentario();
                if (logNuevo.endsWith("\n")) {
                    resultado += logNuevo;
                } else {
                    resultado += logNuevo + "\n";
                }

            } else if (pedidodb.getObservacion() == null || !pedidodb.getObservacion().isEmpty()) {
                resultado = pedidodb.getObservacion();
            }

            mav.setViewName("redirect:/upedido/" + pedidodb.getId());
            pedidodb.setNumPalets(pedido.getNumPalets());
            pedidodb.setFechaentregaReal(pedido.getFechaentregaReal());
            pedidodb.setObservacion(resultado);
            pedidodb.setTipoPedido(pedido.getTipoPedido());
            pedidodb.setRevisado(true);
            pedidodb.setPendienteAnular(pedido.isPendienteAnular());
            pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
            pedidodb.setDestacado(pedido.isDestacado());
//            HEtiqueta hetiqueta = new HEtiqueta();
            Etiqueta laetiqueta = null;
            switch (pedidodb.getTipoPedido()) {
                case 0: //Tienda
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    pedidodb.setEntregaEnTienda(true);
                    if (pedido.getEtiquetaId() != null) {
//                        pedidodb.setEtiquetaTienda((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaId(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.getEtiquetaId()));
                                                
                        pedidodb.setEtiquetaId(pedido.getEtiquetaId());
                    }
                    pedidodb.setNumPC(null);
                    break;
                case 1: //PC
                    pedidodb.setEntregaEnTienda(pedido.isEntregaEnTienda());
                    pedidodb.setNumPC(pedido.getNumPC());
                    pedidodb.setEtiquetaId(null);
                    pedidodb.setEtiquetaTienda(null);
                    pedidodb.setEtiquetaIdOpecom(null);
                    pedidodb.setEtiquetaOpecom(null);
                    pedidodb.setEtiquetaIdRM(null);
                    pedidodb.setEtiquetaRM(null);

                    break;
                case 2: //Opecom
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    pedidodb.setEntregaEnTienda(true);
                    if (pedido.getEtiquetaIdOpecom() != null) {
//                        pedidodb.setEtiquetaOpecom((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaIdOpecom(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.getEtiquetaIdOpecom()));
                        pedidodb.setEtiquetaIdOpecom(pedido.getEtiquetaIdOpecom());
                        pedidodb.setEtiquetaId(null);
                        pedidodb.setEtiquetaTienda(null);
                        pedidodb.setEtiquetaIdRM(null);
                        pedidodb.setEtiquetaRM(null);

                    }
                    pedidodb.setNumPC(null);
                    break;
                case 3: //RM
                    pedidodb.setAvisarAlLlegar(pedido.isAvisarAlLlegar());
                    pedidodb.setEntregaEnTienda(true);
                    if (pedido.getEtiquetaIdRM() != null) {
//                        pedidodb.setEtiquetaRM((Etiqueta) hetiqueta.selectById(pedido.getEtiquetaIdRM(), Etiqueta.class));
                        pedidodb.setEtiquetaTienda(etiquetaService.findById(pedido.getEtiquetaIdRM()));
                        
                        pedidodb.setEtiquetaIdRM(pedido.getEtiquetaIdRM());
                        pedidodb.setEtiquetaIdOpecom(null);
                        pedidodb.setEtiquetaOpecom(null);
                        pedidodb.setEtiquetaId(null);
                        pedidodb.setEtiquetaTienda(null);

                    }
                    pedidodb.setNumPC(null);
                    break;
                default:
                    break;
            }
//            hpedido.update(pedidodb);
            pedidoService.updatePedido(pedidodb);
        }
        return mav;
    }
}
