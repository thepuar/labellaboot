/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author thepuar
 */
@Entity
public class Tienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer numero;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name="id_tienda")
    private List<Seccion> secciones;
    
    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name="id_tienda")
    private List<Usuario> usuarios;
    
    private Date FechaLPRE;
    
    
    public Tienda(){
        secciones = new ArrayList<Seccion>();
        usuarios = new ArrayList<Usuario>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
    
    public void addSeccion(Seccion seccion){
        this.secciones.add(seccion);
        seccion.setTienda(this);
    }
    
    
    public Seccion getSeccionByNum(int num){
        for(Seccion laseccion : this.secciones){
            if(laseccion.getNumero()==num)return laseccion;
        }
        return null;
    }

    public Date getFechaLPRE() {
        return FechaLPRE;
    }

    public void setFechaLPRE(Date FechaLPRE) {
        this.FechaLPRE = FechaLPRE;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    
    public int getNumPedidosPorSeccion(int num){
        int valor = 0;
        for(Seccion laseccion : this.secciones){
            if(laseccion.getNumero()==num){
            valor = laseccion.getPedidos().size();
            }
        }
            return valor;
    }
    
    
    public double getValorPedidosPorSeccion(int num){
        double valor = 0.0;
        for(Seccion laseccion : this.secciones){
            if(laseccion.getNumero()==num){
                for(Pedido elpedido : laseccion.getPedidos()){
                    valor += elpedido.getImporte();
                }
            }
        }
        return valor;
    }
    
//    public int getNumPedidosDia(int num){
//        int numpedidos = 0;
//        for(Seccion laseccion : this.secciones){
//                for(Pedido elpedido : laseccion.getPedidos()){
//                    if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                        numpedidos++;
//                    }
//                }
//        }
//        return numpedidos;
//    }
    
     public double getUdsPedidosPorSeccion(int num){
        double valor=0.0;
        for(Seccion laseccion : this.secciones){
            if(laseccion.getNumero()==num){
                for(Pedido elpedido : laseccion.getPedidos()){
                    valor += elpedido.getUds();
                }
            }
        }
        return valor;
    }
     
     public List<Pedido> getAllPedidoEnCurso(){
         List<Pedido> pedidosEnCurso = new ArrayList<>();
         for(Seccion laseccion : this.secciones){
             for(Pedido elpedido : laseccion.getPedidos()){
                 if(elpedido.isEnCurso()==true)pedidosEnCurso.add(elpedido);
             }
         }
         return pedidosEnCurso;
     }
    
}
