/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author thepuar
 */
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Integer ldap;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;
    private String puesto;
    
    
    @OneToMany(fetch=FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name="id_usuario")
    private List<Pedido> destacados;
    
    
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    List<Seccion> secciones;
    
    //@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name="id_usuario")
    List<Pedido> pedidosDestacados;
    
     @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private List<Historico> historico;
     
    @ElementCollection
    @CollectionTable(name="referenciasdestacadas", joinColumns=@JoinColumn(name="user_id"))
    private List<Integer> referenciasDestacadas;

    public Usuario(){
        secciones = new ArrayList<Seccion>();
        pedidosDestacados = new ArrayList<Pedido>();
        referenciasDestacadas = new ArrayList<Integer>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getLdap() {
        return ldap;
    }

    public void setLdap(Integer ldap) {
        this.ldap = ldap;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<Pedido> getDestacados() {
        return destacados;
    }

    public void setDestacados(List<Pedido> destacados) {
        this.destacados = destacados;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
    
    public void addSeccion(Seccion laseccion){
        this.secciones.add(laseccion);
    }

    public List<Pedido> getPedidosDestacados() {
        return pedidosDestacados;
    }

    public void setPedidosDestacados(List<Pedido> pedidosDestacados) {
        this.pedidosDestacados = pedidosDestacados;
    }
    
    public void addPedidoDestacado(Pedido elpedido){
        this.pedidosDestacados.add(elpedido);
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }
    
    public void addHistorico(Historico historico){
        this.historico.add(historico);
    }

    public List<Integer> getReferenciasDestacadas() {
        return referenciasDestacadas;
    }

    public void setReferenciasDestacadas(List<Integer> referenciasDestacadas) {
        this.referenciasDestacadas = referenciasDestacadas;
    }
    
    public void addReferenciaDestacada(Integer referencia){
        this.referenciasDestacadas.add(referencia);
    }
    
    public boolean isAdmin(){
        if(this.ldap==30000000)return true;
        else return false;
    }
    
    
    
}
