/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.controllers;

import com.frapecha.labella.fichero.model.FiFranco;
import com.frapecha.labella.fichero.model.FiImportePalet;
import com.frapecha.labella.fichero.model.FiUsuario;
import com.frapecha.labella.fichero.model.LPRE;
import com.frapecha.labella.fichero.model.LineaFiFranco;
import com.frapecha.labella.fichero.model.LineaFiUsuario;
import com.frapecha.labella.fichero.model.LineaImportePalet;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.LaBellaProvService;
import com.frapecha.labella.service.impl.PedidoService;
import com.frapecha.labella.service.impl.ProveedorService;
import com.frapecha.labella.service.impl.SeccionService;
import com.frapecha.labella.service.impl.TiendaService;
import com.frapecha.labella.service.impl.UsuarioService;
import com.frapecha.labella.util.MailManager;
import com.frapecha.labella.util.UtilesFicheros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepuar
 */
@Controller
public class ConfigController {
	
	@Autowired
	LaBellaProvService laBellaProvService;
	
	@Autowired
	ProveedorService proveedorService;
	
	@Autowired
	PedidoService pedidoService;

	@Autowired
	TiendaService tiendaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SeccionService seccionService;
	
    @RequestMapping("/tconfig")
    public ModelAndView configlabella() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("labellaprovconf");
        return mav;
    }
    
    @RequestMapping("/updateLPRE")
    public ModelAndView updateLPRE(@RequestParam("num")String num){
        Integer numero = Integer.parseInt(num);
        String email = "";
        if(numero == 1)email = "mirian.cordero@leroymerlin.es";
        else email = "juan-antonio.fernandez@leroymerlin.es";
        
        
        String nombrelpre;
        LPRE ellpre = null;
        ModelAndView mav = new ModelAndView("labellaprovconf");
        MailManager mail = new MailManager();
        nombrelpre = mail.descargarLPRE(email);
        if(!nombrelpre.isEmpty()){
            UtilesFicheros utiles = new UtilesFicheros();
            ellpre = utiles.CargaLPRE(nombrelpre,0);
            laBellaProvService.cargarLPRE(ellpre);
        }
        
        return mav;
        
    }
    
    @RequestMapping("/updateLPRELocal")
    public ModelAndView updateLPRELocal(@RequestParam("num")String num){
        Integer numero = Integer.parseInt(num);
        ModelAndView mav = new ModelAndView("labellaprovconf");
        String ruta = "/Volumes/Baul/NetBeans Projects/labellaprov/src/main/webapp/resources/xlsx/";
        String fichero[] = new String[5];
        fichero[0] = "COMPRAS_LPRE_1.xlsx";
        fichero[1] = "COMPRAS_LPRE_3.xlsx";
        fichero[2] = "COMPRAS_LPRE_6.xlsx";
        fichero[3] = "COMPRAS_LPRE_8.xlsx";
        fichero[4] = "COMPRAS_LPRE_1_MOD.xlsx";
        ruta +=fichero[numero];
        System.out.println("Se ha elegido la opción "+numero);
        System.out.println("Ruta: "+ruta);
        UtilesFicheros utiles =new UtilesFicheros();
        LPRE ellpre = utiles.CargaLPRE(ruta,1);
        laBellaProvService.cargarLPRE(ellpre);
        
        
        return mav;
    }
    
    @RequestMapping("/updateFranco")
    public ModelAndView updateFrancos(){
        ModelAndView mav = new ModelAndView("labellaprovconf");
        UtilesFicheros utiles = new UtilesFicheros();
        Proveedor prov;
        FiFranco elfichero = utiles.CargaFiFranco();
        for(LineaFiFranco lalinea : elfichero.getLineas()){
//            prov = hprov.getByNumProveedor(lalinea.getNumprov());
            prov = proveedorService.findByNumero(lalinea.getNumprov());
            if(prov!=null){
                prov.setFranco(lalinea.getFranco());
//                hprov.update(prov);
                proveedorService.updateProveedor(prov);
                System.out.println("Proveedor "+prov.getNombre()+" actualizado");
            }
        }
        
        return mav;
        
    }
    
    @RequestMapping("/updateImportePalet")
    public ModelAndView updateImportePalet(){
        ModelAndView mav = new ModelAndView("labellaprovconf");
        UtilesFicheros utiles = new UtilesFicheros();
        Proveedor prov;
        FiImportePalet elfichero = utiles.CargaFiImportePalet();
        for(LineaImportePalet lalinea : elfichero.getLista()){
//            prov = hprov.getByNumProveedorAndPedidos(lalinea.getNumprov());
            prov = proveedorService.findByNumero(lalinea.getNumprov());
            if(prov!=null){
                prov.setImporteMedioPalet(lalinea.getImportemediopalet());
//                hprov.update(prov);
                proveedorService.updateProveedor(prov);
                System.out.println("Proveedor "+prov.getNombre()+" actualizado - Importe Palet "+prov.getImporteMedioPalet());
                for(Pedido elpedido: prov.getPedidos()){
//                    hpedido.update(elpedido);
                	pedidoService.updatePedido(elpedido);
                    System.out.println("He actualizado el numero de palets del pedido: "+elpedido.getNumeropedido());
                }
                
            }
        }
        return mav;
    }
    
    @RequestMapping("/updateUsuarios")
    public ModelAndView updateUsuarios(){
        ModelAndView mav = new ModelAndView("labellaprovconf");
        UtilesFicheros utiles = new UtilesFicheros();
//        HUsuarioDAO husuario = new HUsuarioDAO();
        Usuario usuario;
//        HSeccion hseccion = new HSeccion();
        Seccion laseccion;
//        HTienda htienda = new HTienda();
        Tienda latienda;
        
        FiUsuario elfichero = utiles.CargaFiUsuario();
        for(LineaFiUsuario lalinea : elfichero.getLineas()){
            usuario = new Usuario();
//            latienda = htienda.selectByNombre(lalinea.getTienda());
            latienda = tiendaService.findByNombre(lalinea.getTienda());
//            latienda = htienda.selectByIdAndSeccionesAndUsuarios(latienda.getId());
            laseccion = latienda.getSeccionByNum(lalinea.getNumseccion());
            laseccion.addUsuario(usuario);
            usuario.setNombre(lalinea.getNombre());
            usuario.setApellidos(lalinea.getApellidos());
            usuario.setPuesto(lalinea.getPuesto());
            usuario.setLdap(lalinea.getLdap());
            usuario.setEmail(lalinea.getEmail());
            //husuario.insert(usuario);
            usuarioService.saveUsuario(usuario);
            seccionService.saveSeccion(laseccion);
//            hseccion.update(laseccion);
            
        }
        return mav;
    }
    
    
    

}
