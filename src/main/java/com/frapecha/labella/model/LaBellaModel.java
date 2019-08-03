/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

//import com.mycompany.labellaprov.core.UtilesFechas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author thepuar
 */
@Entity
public class LaBellaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "id_bella")
    private List<Tienda> tiendas;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "id_bella")
    private List<Proveedor> proveedores;
    
    public LaBellaModel(){
        this.proveedores = new ArrayList<Proveedor>();
        this.tiendas = new ArrayList<Tienda>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }
    
    public Tienda getTiendaByNum(int numero){
        for(Tienda latienda : this.getTiendas()){
            if(latienda.getNumero()==numero)
                return latienda;
        }
        return null;
    }
    
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    public void addProveedor(Proveedor elprov){
        this.proveedores.add(elprov);
    }
    
    public Proveedor getProveedorByNum(int num){
        for(Proveedor prov : this.getProveedores()){
            if(prov.getNumero()==num)return prov;
        }
        return null;
    }
    
    
    
    public double getUdsPedidosPorSeccion(int num){
        double valor=0.0;
        for(Proveedor elproveedor : this.getProveedores()){
            if(elproveedor.getNumSeccion()==num){
                valor += elproveedor.getUdsEnCamino();
            }
        }
        return valor;
    }
    
    public double getValorPedidosPorSeccion(int num){
        double valor = 0.0;
        for(Proveedor elproveedor : this.getProveedores()){
            if(elproveedor.getNumSeccion()==num){
                valor += elproveedor.getValorEnCamino();
            }
        }
        return valor;
    }
    
//    public int getNumPedidosDia(int num){
//        int numpedidos = 0;
//        for(Proveedor  elproveedor : this.getProveedores()){
//            for(Pedido elpedido : elproveedor.getPedidos()){
//                if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentrega())){
//                    numpedidos++;
//                    System.out.println("El pedido coincide");
//                }
//               
//            }
//        }
//        return numpedidos;
//    }

    
}
