/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author thepuar
 */
@Entity
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int referencia;
    private String designacion;
    private double top;
    private String gama;
    private boolean irrenunciable;
    private boolean primerprecio;
    private Double pvp;
    private Double pc;
    private double encurso;

    public double getValorLinea(){
        return pvp * encurso;
    }
    
    public double getValorLineaPc(){
        return pc * encurso;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    
    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public Double getPc() {
        return pc;
    }

    public void setPc(Double pc) {
        this.pc = pc;
    }
    

    public double getEncurso() {
        return encurso;
    }

    public void setEncurso(double encurso) {
        this.encurso = encurso;
    }
    
    
    
}
