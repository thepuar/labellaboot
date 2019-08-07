/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.service.impl;

import com.frapecha.labella.DAO.ProveedorDAO;
import com.frapecha.labella.fichero.model.LPRE;
import com.frapecha.labella.model.Historico;
import com.frapecha.labella.model.LaBella;
import com.frapecha.labella.model.LineaPedido;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;
import com.frapecha.labella.model.Seccion;
import com.frapecha.labella.model.Tienda;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author thepuar
 */
@Component
public class LaBellaProvServiceImpl implements LaBellaProvService{
	@Autowired
	LaBellaService laBellaService;

	@Autowired
	TiendaService tiendaService;

	@Autowired
	ProveedorService proveedorService;

	@Autowired
	SeccionService seccionService;

	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	HistoricoService historicoService;

	private LaBella laBella;
//    private HLaBella hlabella;

	public void init() {
		laBella = new LaBella();
		if (laBellaService.countAllLaBellas() == 0) {
			System.out.println("Se ha creado a LaBella");
			laBellaService.saveLaBella(laBella);
		} else
			System.out.println("Ya existia LaBella");
	}

	public void cargarLPREFromDB() {
//        HLPRE hlpre = new HLPRE();
//        List<LPRE> listLPRE = hlpre.selectAll(LPRE.class);
//        for (LPRE ellpre : listLPRE) {
//            this.cargarLPRE(ellpre);
//        }
	}

	public void cargarLPRE2(LPRE ellpre) {
//        this.init();
//        HHistorico hhistorico = new HHistorico();
//        LaBellaModel labella = (LaBellaModel) hlabella.selectById(1, LaBellaModel.class);
//        Tienda mitienda;
//        HTienda htienda = new HTienda();
//        HPedido hpedido = new HPedido();
//        HSeccion hseccion = new HSeccion();
//        Pedido pedlocal;
//        System.out.println("ENTRO EN CARGALPRE");
//        if (labella.getTiendaByNum(ellpre.getNumero_tienda()) != null) {
//            //La tienda existe
//            System.out.println("LA TIENDA EXISTE");
//            mitienda = labella.getTiendaByNum(ellpre.getNumero_tienda());
//            //mitienda = htienda.selectByIdAndSeccionesAndPedidos(mitienda.getId());
//            hhistorico.insert(new Historico("Tienda", "Info", mitienda.getNumero().toString(), "Creación", 0));
//
//        } else {
//            //La tienda no existe
//            System.out.println("CREANDO LA TIENA");
//            Tienda latienda = this.crearTienda(ellpre.getNombreTienda(), ellpre.getNumero_tienda());
//            latienda.setFechaLPRE(ellpre.getFechafichero());
//            labella.getTiendas().add(latienda);
//            mitienda = latienda;
//            hlabella.update(labella);
//            hhistorico.insert(new Historico("Tienda", "Info", mitienda.getNumero().toString(), "Creación", 0));
//
//        }
//        //Comprobando proveedores
//        Proveedor provlocal;
//        for (Proveedor elproveedor : ellpre.getProveedores()) {
//            provlocal = labella.getProveedorByNum(elproveedor.getNumero());
//            if (provlocal != null) {
//                //El proveedor existe
//                System.out.println("El proveedor ya existe");
//                //hhistorico.insert(new Historico("Prov", "Info", elproveedor.getNumero().toString(), "El proveedor ya existe."));
//                //Comprobar pedidos
//                for (Pedido ped : elproveedor.getPedidos()) {
//                    pedlocal = hpedido.getByNumPedido(ped.getNumeropedido());
//                    if (pedlocal == null) {
//                        System.out.println("Creando pedido a proveedor existente.");
//                        //El pedido no existe, crearlo
//                        provlocal.addPedido(ped);
//                        hhistorico.insert(new Historico("Ped", "Info", ped.getNumeropedido().toString(), "Añadido.", 0));
//
//                        Seccion laseccion = mitienda.getSeccionByNum(provlocal.getNumSeccion());
//                        //laseccion.addPedido(ped);
//                        laseccion.setNombre("IluIlu");
//                        System.out.println("Id seccion: " + laseccion.getId() + " Nombre: " + laseccion.getNombre());
//                        hseccion.update(laseccion);
//                        //hlabella.update(labella);
//
//                    } else {
//                        System.out.println("El pedido ya existe");
//                        //El pedido existe
//                        // hhistorico.insert(new Historico("Ped", "Info", pedlocal.getNumeropedido().toString(), "El pedido sigue estando vivo."));
//                    }
//
//                }
//
//            } else {
//                labella.getProveedores().add(elproveedor);
//                hhistorico.insert(new Historico("Prov", "Info", elproveedor.getNumero().toString(), "Añadido", 0));
//                //El proveedor no existe
//                System.out.println("Creando proveedor y sus pedidos");
//                Proveedor nuevoproveedor = elproveedor;
//                for (Pedido elpedido : nuevoproveedor.getPedidos()) {
//
//                    Seccion laseccion = mitienda.getSeccionByNum(elproveedor.getNumSeccion());
//                    //laseccion = hseccion.getByIdAndPedidos(laseccion.getId());
//                    laseccion.addPedido(elpedido);
//                    hhistorico.insert(new Historico("Ped", "Info", elpedido.getNumeropedido().toString(), "Añadido", 0));
//
//                }
//
//            }
//        }
//        System.out.println("Empiezo a actualizar a labella");
//        hlabella.update(labella);
//        //Fin de recorrer los lpres
//
//        System.out.println("LaBella tiene:" + labella.getProveedores().size() + " proveedores.");

	}

	public void cargarLPRE(LPRE ellpre) {
		ellpre.iniciarHash();
//        HTienda htienda = new HTienda();
//        HProveedor hproveedor = new HProveedor();
//        HSeccion hseccion = new HSeccion();
//        HPedido hpedido = new HPedido();
//        Tienda latienda = htienda.selectTiendaByNum(ellpre.getNumero_tienda());
		Tienda latienda = tiendaService.findByNumero(ellpre.getNumero_tienda());
		List<Proveedor> lpreprov = ellpre.getProveedoresHash();
		int pedidocreado = 0;
		int pedidoexiste = 0;
		int pedidoeliminado = 0;
		int proveedorexiste = 0;
		int proveedorcreado = 0;
		if (latienda == null) {
			System.out.println("#Paso 0A .- La tienda no existe, la creo");
			latienda = new Tienda();
			latienda = this.crearTienda(ellpre.getNombreTienda(), ellpre.getNumero_tienda());
			latienda.setFechaLPRE(ellpre.getFechafichero());
			tiendaService.saveTienda(latienda);
//            htienda.update(latienda);
			// Comprobar si los proveedores existen.
//            latienda = htienda.selectByIdAndSeccionesAndPedidos(latienda.getId());
//            hlabella = new HLaBella();
//            this.labella = hlabella.selectByIdAndProveedoresAndPedidos();
			this.laBella = laBellaService.findById(1L);
			for (Proveedor preprov : lpreprov) {

				if (proveedorService.findByNumero(preprov.getNumero()) == null) {
					// El proveedor no existe, lo añado.
					List<Pedido> listapedidos = preprov.getPedidos();
					preprov.setPedidos(null);
					Historico historicoprov = new Historico("PROV", "Info", preprov.getNumero().toString(), "Creado",
							0);
					preprov.addHistorico(historicoprov);
					proveedorService.saveProveedor(preprov);
					laBella.addProveedor(preprov);
					for (Pedido preped : listapedidos) {
						// Asociando los pedidos a las secciones correspondientes

						latienda.getSeccionByNum(preprov.getNumSeccion()).addPedido(preped);
						Seccion seccionAux = latienda.getSeccionByNum(preprov.getNumSeccion());
						seccionAux.addPedido(preped);
						

						// hproveedor.getByNumProveedorAndPedidos(preprov.getNumero()).addPedido(preped);
						Historico historicoped = new Historico("Ped", "Info", preped.getNumeropedido().toString(),	"Creado", 0);
						preped.addHistorico(historicoped);
						pedidoService.savePedido(preped);
						preped.setProveedor(preprov);
						
					}
					proveedorService.updateProveedor(preprov);
				}
			}
			System.out.println("Empiezo a actualizar a la bella");
			laBellaService.updateLaBella(laBella);
//            // this.hlabella.update(this.labella);
			System.out.println("La Bella Actualizada");

		} else {
			System.out.println("#Paso 0B.- La tienda existe");
//
//            latienda = htienda.selectTiendaByNum(ellpre.getNumero_tienda());
			latienda = tiendaService.findByNumero(ellpre.getNumero_tienda());
//            latienda = htienda.selectByIdAndSecciones(latienda.getId());
			latienda.setFechaLPRE(ellpre.getFechafichero());
//            htienda.update(latienda);
			tiendaService.updateTienda(latienda);
			// Paso a comprobar si hay proveedores nuevos.
//            hlabella = new HLaBella();
//            this.labella = hlabella.selectByIdAndProveedoresAndPedidos();
			System.out.println("#Paso 1.- Comienzo a comprobar el LPRE contra BD");
			for (Proveedor preprov : lpreprov) {
				// Comprobando LPRE contra datos del proveedor en BD
//                if (hproveedor.getByNumProveedor(preprov.getNumero()) == null) {
				if ((proveedorService.findByNumero(preprov.getNumero()) == null)) {
					List<Pedido> listapedidos = preprov.getPedidos();
					preprov.setPedidos(null);
					proveedorcreado++;
					System.out.println("#1.1 - " + proveedorcreado + " El proveedor no existe, paso a añadirlo: "
							+ preprov.getNombre());
					Historico historicoprov = new Historico("PROV", "Info", preprov.getNumero().toString(), "Creado",
							0);
					preprov.addHistorico(historicoprov);
//                    hproveedor.insert(preprov);
					proveedorService.saveProveedor(preprov);
//
					for (Pedido preped : listapedidos) {
						// Asociando los pedidos a las secciones correspondientes
						Seccion laseccion = latienda.getSeccionByNum(preprov.getNumSeccion());
//                        laseccion = hseccion.getByIdAndPedidos(laseccion.getId());
						laseccion = seccionService.findById(laseccion.getId().longValue());
						laseccion.addPedido(preped);
						pedidocreado++;
						System.out.println("#1.1.1 - " + pedidocreado + " Pedido creado de nuevo proveedor");
//                      hproveedor.getByNumProveedorAndPedidos(preprov.getNumero()).addPedido(preped);
						Proveedor prov = proveedorService.findByNumero(preprov.getNumero());
						
						Historico historicoped = new Historico("Ped", "Info", preped.getNumeropedido().toString(),
								"Creado", 0);
						preped.addHistorico(historicoped);
						preped.setNumPalets(1);
						preped.setProveedor(null);
						preped.setSeccion(null);
						pedidoService.savePedido(preped);
						laseccion.addPedido(preped);
						prov.addPedido(preped);
						proveedorService.updateProveedor(prov);
						seccionService.saveSeccion(laseccion);
//                        hpedido.insert(preped);
						
					}
					if(preprov.getPedidos()!=null)
					for (Pedido preped : preprov.getPedidos()) {
						// Asocio los pedidos a las secciones correspondientes
						latienda.getSeccionByNum(preprov.getNumSeccion()).addPedido(preped);
					}
				} else {
					proveedorexiste++;
					System.out.println("#1.2 - " + proveedorexiste + " El proveedor existe " + preprov.getNombre());
					// El proveedor existe, paso a comprobar sus pedidos
					for (Pedido preped : preprov.getPedidos()) {
//                        Pedido temp = hpedido.getByNumPedido(preped.getNumeropedido());
						Pedido pedidoTemp = pedidoService.findByNumeropedido(preped.getNumeropedido());
						if (pedidoTemp == null) {
							// El pedido no existe, lo añado a los pedidos del proveedor y a los pedidos de
							// la seccion.
//                            hseccion.getByIdAndPedidos(preprov.getNumSeccion()).addPedido(preped);
							//pedidoService.savePedido(preped);
							Seccion seccionTemp = seccionService.findById(preprov.getNumSeccion().longValue());
							seccionTemp.addPedido(preped);
//                    		hproveedor.getByNumProveedorAndPedidos(preprov.getNumero()).addPedido(preped);
							Proveedor proveedorTemp = proveedorService.findByNumero(preprov.getNumero());
						
							
							pedidocreado++;
							System.out.println("#1.2.1 - " + pedidocreado + " He encontrado un pedido nuevo");
							Historico historicoped = new Historico("Ped", "Info", preped.getNumeropedido().toString(),
									"Creado", 0);
							preped.setNumPalets(1);
							if (preped.getProveedor().getFranco() != null
									&& preped.getProveedor().getFranco() > preped.getImportePC()) {
								preped.setLlegaAFranco(false);
							}
							historicoService.saveHistorico(historicoped);
							preped.setProveedor(null);
							preped.setSeccion(null);
							pedidoService.savePedido(preped);
							proveedorTemp.addPedido(preped);
							seccionTemp.addPedido(preped);
							
							proveedorService.saveProveedor(proveedorTemp);
							seccionService.saveSeccion(seccionTemp);
//                          hpedido.insert(preped);
							//

//
						} else {
							pedidoexiste++;
							System.out.println(
									"#1.2.2 - " + pedidoexiste + " El pedido " + preped.getNumeropedido() + " existe");
							if (pedidoTemp.getFechaentregaReal().compareTo(new Date()) < 0) {
								pedidoTemp.setRetraso(true);

//                                hpedido.update(temp);
							}
							if (pedidoTemp.isEnCurso() == false) {
								pedidoTemp.setEnCurso(true);

//                                hpedido.update(temp);
							}
							if (pedidoTemp.getImportePC() == null && preped.getImportePC() != null) {
								pedidoTemp.setImportePC(preped.getImportePC());
								if (pedidoTemp.getProveedor().getFranco() != null
										&& pedidoTemp.getProveedor().getFranco() > pedidoTemp.getImportePC()) {
									pedidoTemp.setLlegaAFranco(false);
//
								}

//                                hpedido.update(temp);
//
							}
							pedidoService.updatePedido(pedidoTemp);
						}
//
					}
				}
			}
		}
        //Comprobando Proveedor en BD contra LPRE
        System.out.println("#Paso 2.- Comienzo a comprobar la BD contra el LPRE");
        
//        pedidosEnCursoTienda = hpedido.selectAllVivosByIdTienda(latienda.getId());
        List<Pedido> pedidosEnCursoTienda = pedidoService.findBySeccionTiendaAndEnCurso(latienda, true);
        for (Pedido elpedidodb : pedidosEnCursoTienda) {
            if (ellpre.getPedidoByNumPedidoHash(elpedidodb.getNumeropedido()) == null) {
                elpedidodb.setEnCurso(false);
                pedidoeliminado++;
                System.out.println("#2.1 - " + pedidoeliminado + " El pedido " + elpedidodb.getNumeropedido() + " ya no existe");
              pedidoService.updatePedido(elpedidodb);
//                hpedido.update(elpedidodb);
//                elpedidodb = hpedido.getByNumPedidoAndHistorico(elpedidodb.getNumeropedido());
                elpedidodb = pedidoService.findByNumeropedido(elpedidodb.getNumeropedido());
                Historico historico = new Historico("Ped", "Info", elpedidodb.getNumeropedido().toString(), "No encurso", 0);
                elpedidodb.addHistorico(historico);
//                hpedido.update(elpedidodb);
                pedidoService.updatePedido(elpedidodb);
//
            }
        }
//        //this.hlabella.update(this.labella);
        	laBellaService.updateLaBella(this.laBella);
        System.out.println(
                "#Paso 3.-He terminado");
        System.out.println(
                "RESUMEN - Proveedores");
        System.out.println(proveedorcreado
                + " creados");
        System.out.println(proveedorexiste
                + " comprobados");
        System.out.println(
                "RESUMEN - Pedidos");
        System.out.println(pedidocreado
                + " creados");
        System.out.println(pedidoeliminado
                + " dejan de estar en curso");
        System.out.println(pedidoexiste
                + " comprobados");
	}

	public Tienda crearTienda(String nombre, int numero) {
		Tienda latienda = new Tienda();
		latienda.setNombre(nombre);
		latienda.setNumero(numero);
		System.out.println("Se acaba de crear la tienda " + latienda.getNombre());
		crearSeccionesTienda(latienda);
		return latienda;
	}

	public void crearSeccionesTienda(Tienda latienda) {
		latienda.addSeccion(new Seccion("Materiales de construcción", 1));
		latienda.addSeccion(new Seccion("Carpintería y madera", 2));
		latienda.addSeccion(new Seccion("Electricidad y fontanería", 3));
		latienda.addSeccion(new Seccion("Herramientas", 4));
		latienda.addSeccion(new Seccion("Moqueta", 5));
		latienda.addSeccion(new Seccion("Cerámica", 6));
		latienda.addSeccion(new Seccion("Sanitario", 7));
		latienda.addSeccion(new Seccion("Cocinas", 8));
		latienda.addSeccion(new Seccion("Jardín", 9));
		latienda.addSeccion(new Seccion("Ferretería y ordenación", 10));
		latienda.addSeccion(new Seccion("Pintura", 11));
		latienda.addSeccion(new Seccion("Decoración", 12));
		latienda.addSeccion(new Seccion("Iluminación", 13));
		latienda.addSeccion(new Seccion("Logistica", 14));
		latienda.addSeccion(new Seccion("Departamentos", 15));
		System.out.println("Se han creado las secciones.");

	}

}
