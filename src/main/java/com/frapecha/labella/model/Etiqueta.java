/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author thepuar
 */
@Entity
@Table(name="etiqueta")
public class Etiqueta implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numSeccion;
     //Si la sección es 0, significa que es una etiqueta compartida con toda la tienda, ejempl, una opecom.
    
    private String nombreEtiqueta;
    
    public Etiqueta(){;}
    
    public Etiqueta(int numseccion, String nombre){
        this.numSeccion = numseccion;
        this.nombreEtiqueta = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumSeccion() {
        return numSeccion;
    }

    public void setNumSeccion(int numSeccion) {
        this.numSeccion = numSeccion;
    }

    

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
    
    
    
    
}
