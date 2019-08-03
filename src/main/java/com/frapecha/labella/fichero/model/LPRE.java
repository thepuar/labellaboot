/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.fichero.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.frapecha.labella.model.LineaPedido;
import com.frapecha.labella.model.Pedido;
import com.frapecha.labella.model.Proveedor;

/**
 *
 * @author thepuar
 */
@Entity
public class LPRE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lpre")
    private List<LineaLPRE> listalineas = new ArrayList<LineaLPRE>();
    private int numero_tienda;
    private String nombreTienda;
    private Date fechafichero;
    @Transient
    private Map<Integer, Proveedor> hashProveedores;
    @Transient
    private Map<Integer, Pedido> hashPedidos;
    

    public LPRE() {
        hashProveedores = new HashMap<>();
        hashPedidos = new HashMap<>();
    }
    
    public void iniciarHash(){
        System.out.println("Iniciando tablas hash del LPRE");
        for(Proveedor elproveedor : this.getProveedores()){
            hashProveedores.put(elproveedor.getNumero(), elproveedor);
            for(Pedido elpedido : elproveedor.getPedidos()){
                hashPedidos.put(elpedido.getNumeropedido(), elpedido);
            }
        }
        System.out.println("Tablas HashCargadas - Proveedores "+hashProveedores.size()+" - Pedidos "+hashPedidos.size());
    
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public List<LineaLPRE> getListalineas() {
        return listalineas;
    }

    public void setListalineas(List<LineaLPRE> listalineas) {
        this.listalineas = listalineas;
    }

    public int getNumero_tienda() {
        return numero_tienda;
    }

    public void setNumero_tienda(int numero_tienda) {
        this.numero_tienda = numero_tienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public Date getFechafichero() {
        return fechafichero;
    }

    public void setFechafichero(Date fechafichero) {
        this.fechafichero = fechafichero;
    }

    public List<Proveedor> getProveedores() {
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        List<LineaLPRE> lineas = this.getListalineas();
        for (LineaLPRE lalinea : lineas) {
            boolean existe = false;
            for (Proveedor prov : proveedores) {
                if (prov.getNumero() == lalinea.getNum_proveedor()) {
                    existe = true;
                }
            }
            if (existe) {
                //El proveedor ya existe.
               
            } else {
               
                Proveedor nuevoprov = new Proveedor();
                nuevoprov.setNombre(lalinea.getNom_proveedor());
                nuevoprov.setNumSeccion(lalinea.getSeccion());
                nuevoprov.setNumero(lalinea.getNum_proveedor());
                proveedores.add(nuevoprov);
            }
        }
        //System.out.println("Hay: " + proveedores.size());

        for (LineaLPRE lalinea : lineas) {
            boolean existe = false;

            for (Pedido pedido : getProveedorByNum(proveedores, lalinea.getNum_proveedor()).getPedidos()) {
                if (pedido.getNumeropedido() == lalinea.getNum_pedido()) {
                    existe = true;
                }
            }
            if (existe) {
                
            } else {
                Pedido nuevopedido = new Pedido();
                Proveedor prov = getProveedorByNum(proveedores, lalinea.getNum_proveedor());
                nuevopedido.setProveedor(prov);
                nuevopedido.setNumeropedido(lalinea.getNum_pedido());
                nuevopedido.setFechaentrega(lalinea.getFecha_entrega());
                nuevopedido.setEnCurso(true);
                prov.getPedidos().add(nuevopedido);
               
            }

        }
        int count = 0;
        for (Proveedor prov : proveedores) {
            for (Pedido ped : prov.getPedidos()) {
                count++;
            }
        }
        //System.out.println("Hay: "+ count +" pedidos");
        
        //Cargar lineas de pedidos
        LineaPedido lineaped = null;
        Pedido elpedido = null;
        for (LineaLPRE lalinea : lineas) {
            elpedido = this.getPedidoByNum(proveedores, lalinea.getNum_pedido());
            lineaped = new LineaPedido();
            lineaped.setDesignacion(lalinea.getDesignacion());
            lineaped.setEncurso(lalinea.getEncurso());
            lineaped.setGama(lalinea.getGama());
            lineaped.setIrrenunciable(lalinea.isIrrenunciable());
            lineaped.setPrimerprecio(lalinea.isPrimerprecio());
            lineaped.setPvp(lalinea.getPvp());
            lineaped.setPc(lalinea.getPc());
            lineaped.setReferencia(lalinea.getReferencia());
            lineaped.setTop(lalinea.getTop());
            elpedido.addLinea(lineaped);
        }
        return proveedores;
    }
    
    public List<Proveedor> getProveedoresHash(){
        List<Proveedor> lproveedores = new ArrayList<>();
        for(Proveedor elproveedor : this.hashProveedores.values()){
            lproveedores.add(elproveedor);
        }
        return lproveedores;
    }

    public Proveedor getProveedorByNum(List<Proveedor> proveedores, int numero) {
        for (Proveedor elprov : proveedores) {
            if (elprov.getNumero() == numero) {
                return elprov;
            }
        }
        return null;
    }
    
    public Proveedor getProveedorByNumHash(int numero){
        Proveedor elproveedor = null;
        elproveedor = this.hashProveedores.get(numero);
        return elproveedor;
    }
    
    public Pedido getPedidoByNum(List<Proveedor> proveedores, int numero){
        for(Proveedor elprov: proveedores){
            for(Pedido elpedido : elprov.getPedidos()){
                if(elpedido.getNumeropedido()==numero)return elpedido;
            }
        }
        return null;
    }
    public Pedido getPedidoByNumPedido(int numero){
        Pedido elpedido = null;
        for(Pedido pedido : this.getAllPedidos()){
            if(pedido.getNumeropedido()==numero)elpedido = pedido;
        }
        return elpedido;
    }
    
    public Pedido getPedidoByNumPedidoHash(int numero){
        Pedido elpedido = null;
        elpedido = this.hashPedidos.get(numero);
        return elpedido;
    }
    
    
    public List<Pedido> getPedidos(List<Proveedor> proveedores){
        List<Pedido> listpedido = new ArrayList<Pedido>();
        for(Proveedor elproveedor : proveedores){
            for(Pedido elpedido : elproveedor.getPedidos()){
                listpedido.add(elpedido);
            }
        }
        return listpedido;
        
    }
    
    public List<Pedido> getAllPedidos(){
        List<Pedido> lpedidos = new ArrayList<>();
        for(Proveedor elproveedor : this.getProveedores()){
            lpedidos.addAll(elproveedor.getPedidos());
        }
        return lpedidos;
    }
    
    
    

}
