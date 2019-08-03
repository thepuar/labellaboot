/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.fichero.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thepuar
 */
public class FiUsuario {
    
    private List<LineaFiUsuario> lineas;
    
    public FiUsuario(){
    this.lineas = new ArrayList<>();
    }

    public List<LineaFiUsuario> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaFiUsuario> lineas) {
        this.lineas = lineas;
    }
    
}
