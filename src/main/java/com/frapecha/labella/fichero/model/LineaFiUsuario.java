/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.fichero.model;

/**
 *
 * @author thepuar
 */
public class LineaFiUsuario {
    
    private int ldap;
    private String nombre;
    private String apellidos;
    private String seccion;
    private int numseccion;
    private String puesto;
    private String tienda;
    private String email;

    public int getLdap() {
        return ldap;
    }

    public void setLdap(int ldap) {
        this.ldap = ldap;
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

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
        
        switch(seccion){
            case  "Materiales":this.numseccion=1;break;
            case "Madera": this.numseccion = 2;break;
            case "Electr-Fontan-Calor": this.numseccion = 3; break;
            case "Herramientas": this.numseccion = 4;break;
            case "Moqueta": this.numseccion = 5;break;
            case "Ceramica": this.numseccion = 6;break;
            case "Sanitario": this.numseccion = 7;break;
            case "Cocinas": this.numseccion = 8;break;
            case "Jardin": this.numseccion = 9;break;
            case "Ferreteria": this.numseccion = 10;break;
            case "Pintura": this.numseccion = 11;break;
            case "Decoracion": this.numseccion = 12;break;
            case "Iluminacion": this.numseccion = 13;break;
            case "Logistica": this.numseccion = 14;break;
                
            default: this.numseccion = 15;break;
        }
    }

    public int getNumseccion() {
        return numseccion;
    }

    public void setNumseccion(int numseccion) {
        this.numseccion = numseccion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
