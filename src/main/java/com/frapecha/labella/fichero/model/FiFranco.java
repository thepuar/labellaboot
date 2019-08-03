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
public class FiFranco {
    
    private List<LineaFiFranco> lineas;

    public FiFranco(){
        this.lineas = new ArrayList<LineaFiFranco>();
    }
    
    public List<LineaFiFranco> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaFiFranco> lineas) {
        this.lineas = lineas;
    }
    
    public void addLinea(LineaFiFranco lalinea){
        this.lineas.add(lalinea);
    }
    
    
    
    
}
