/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.fichero.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author thepuar
 */
@Entity
public class LineaLPRE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int seccion;
    private int num_proveedor;
    private String nom_proveedor;
    private int referencia;
    private String designacion;
    private double top;
    private String gama;
    private boolean irrenunciable;
    private boolean primerprecio;
    private double pvp;
    private double pc;
    private int num_pedido;
    private Date fecha_entrega;
    private String tipopedido;
    private double encurso;
    private double valorlinea;
    private String alerta;

    public LineaLPRE() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public int getNum_proveedor() {
        return num_proveedor;
    }

    public void setNum_proveedor(int num_proveedor) {
        this.num_proveedor = num_proveedor;
    }

    public String getNom_proveedor() {
        return nom_proveedor;
    }

    public void setNom_proveedor(String nom_proveedor) {
        this.nom_proveedor = nom_proveedor;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }
    
    

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public boolean isIrrenunciable() {
        return irrenunciable;
    }

    public void setIrrenunciable(boolean irrenunciable) {
        this.irrenunciable = irrenunciable;
    }

    public boolean isPrimerprecio() {
        return primerprecio;
    }

    public void setPrimerprecio(boolean primerprecio) {
        this.primerprecio = primerprecio;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }
    
    

    public int getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(int num_pedido) {
        this.num_pedido = num_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getTipopedido() {
        return tipopedido;
    }

    public void setTipopedido(String tipopedido) {
        this.tipopedido = tipopedido;
    }

    public double getEncurso() {
        return encurso;
    }

    public void setEncurso(double encurso) {
        this.encurso = encurso;
    }

    public double getValorlinea() {
        return valorlinea;
    }

    public void setValorlinea(double valorlinea) {
        this.valorlinea = valorlinea;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }
    
    
    
    
}
