/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.service.impl.PedidoService;
import com.frapecha.labella.service.impl.ProveedorService;
import com.frapecha.labella.validator.ProveedorValidator;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class ProveedorController {

	@Autowired
	ProveedorValidator proveedorValidator;

	@Autowired
	ProveedorService proveedorService;

	@Autowired
	PedidoService pedidoService;

	@RequestMapping("/proveedor/{id}")
	public ModelAndView gotoDetailProveedor(@PathVariable(value = "id") Long id) {
//        HProveedor hproveedor = new HProveedor();
//        Proveedor elproveedor = (Proveedor) hproveedor.selectByIdAndPedidosAndLineas(id);
		Proveedor elproveedor = proveedorService.findById(id);
		ModelAndView mav = new ModelAndView("proveedor");
		mav.addObject("proveedor", elproveedor);

		return mav;
	}

	@RequestMapping("/uproveedor/{id}")
	public ModelAndView gotoDetailUProveedor(@PathVariable(value = "id") Long id) {
//        HProveedor hproveedor = new HProveedor();
//        Proveedor elproveedor = (Proveedor) hproveedor.selectById(id, Proveedor.class);
		Proveedor elproveedor = proveedorService.findById(id);
//    	HPedido hpedido = new HPedido();
//        elproveedor.setPedidos(hpedido.selectVivosLineasHistoricoByIdProveedor(elproveedor.getId()));
		elproveedor.setPedidos(pedidoService.findByProveedorAndEnCurso(elproveedor, true));
		ModelAndView mav = new ModelAndView("uproveedor");
		mav.addObject("proveedor", elproveedor);

		return mav;
	}

	@RequestMapping(value = "/proveedor/update/{id}", method = RequestMethod.GET)
	public ModelAndView gotoUpdateProveedor(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView("proveedor/update");
//        HProveedor hprov = new HProveedor();
//        Proveedor prov = (Proveedor) hprov.selectById(id, Proveedor.class);
		Proveedor prov = proveedorService.findById(id);

		mav.addObject("proveedor", prov);
		mav.addObject("proveedorInfo", prov);
		return mav;
	}

	@RequestMapping(value = "/uproveedor/update/{id}", method = RequestMethod.GET)
	public ModelAndView gotoUpdateUProveedor(@PathVariable(value = "id") Long id) {
		ModelAndView mav = new ModelAndView("uproveedor/update");
//        HProveedor hprov = new HProveedor();
//        Proveedor prov = (Proveedor) hprov.selectById(id, Proveedor.class);
		Proveedor prov = proveedorService.findById(id);

		mav.addObject("proveedor", prov);
		mav.addObject("proveedorInfo", prov);
		return mav;
	}

	@RequestMapping(value = "/proveedor/update/{id}", method = RequestMethod.POST)
	public ModelAndView UpdateProveedor(@Valid @ModelAttribute("proveedor") Proveedor prov,
			@PathVariable(value = "id") Long id, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
//        HProveedor hprov = new HProveedor();
//        Proveedor provdb = (Proveedor) hprov.selectById(id, Proveedor.class);
		Proveedor provdb = proveedorService.findById(id);

		mav.addObject("proveedorInfo", provdb);
		proveedorValidator.validate(prov, result);
		if (result.hasErrors()) {
			mav.setViewName("proveedor/update");
			mav.addObject(result.getModel());

		} else {
			mav.setViewName("proveedor");
			provdb.setFranco(prov.getFranco());
			provdb.setNombreContacto(prov.getNombreContacto());
			provdb.setEmail(prov.getEmail());
			provdb.setTelefono(prov.getTelefono());
			proveedorService.updateProveedor(provdb);
//            hprov.update(provdb);
//            mav.addObject("proveedor", hprov.selectByIdAndPedidosAndLineasAndHistorico(provdb.getId()));
			mav.addObject("proveedor", provdb);
		}
//        prov = (Proveedor) hprov.selectByIdAndPedidosAndLineas(id);

		return mav;
	}

	@RequestMapping(value = "/uproveedor/update/{id}", method = RequestMethod.POST)
	public ModelAndView UpdateUProveedor(@Valid @ModelAttribute("proveedor") Proveedor prov,
			@PathVariable(value = "id") Long id, BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
//        HProveedor hprov = new HProveedor();
//        Proveedor provdb = (Proveedor) hprov.selectById(id, Proveedor.class);
		Proveedor provdb = proveedorService.findById(id);
		mav.addObject("proveedorInfo", provdb);
		proveedorValidator.validate(prov, result);
		if (result.hasErrors()) {
			mav.setViewName("uproveedor/update");
			mav.addObject(result.getModel());

		} else {
			mav.setViewName("uproveedor");
			if (provdb.getFranco() != prov.getFranco()) {
				// Comprobar si los pedidos en curso llegan a Franco
//				HPedido hpedido = new HPedido();
//				Proveedor esteprov = hprov.getByNumProveedorAndPedidos(provdb.getNumero());
				Proveedor esteprov = proveedorService.findByNumero(provdb.getNumero());
				List<Pedido> losPedidos = esteprov.getPedidosVivos();
				for (Pedido elpedido : losPedidos) {
					if (elpedido.getImportePC() < prov.getFranco()) {
						elpedido.setLlegaAFranco(false);
					} else {
						elpedido.setLlegaAFranco(true);
					}
//					hpedido.update(elpedido);
					pedidoService.updatePedido(elpedido);
				}

			}
			provdb.setFranco(prov.getFranco());
			provdb.setNombreContacto(prov.getNombreContacto());
			provdb.setEmail(prov.getEmail());
			provdb.setTelefono(prov.getTelefono());
//			hprov.update(provdb);
			proveedorService.updateProveedor(provdb);
//			mav.addObject("proveedor", hprov.selectByIdAndPedidosVivosAndLineasAndHistorico(provdb.getId()));
		mav.addObject("proveedor",provdb);
		}
		// prov = (Proveedor) hprov.selectByIdAndPedidosAndLineas(id);

		return mav;
	}

}
