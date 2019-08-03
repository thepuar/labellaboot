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
public class FiImportePalet {
    
    List<LineaImportePalet> lista;
    
    public FiImportePalet(){
        lista = new ArrayList<LineaImportePalet>();
    }

    public List<LineaImportePalet> getLista() {
        return lista;
    }

    public void setLista(List<LineaImportePalet> lista) {
        this.lista = lista;
    }
    
    public void addLinea(LineaImportePalet linea){
        this.lista.add(linea);
    }
    
    
    
}
