/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author thepuar
 */
@Entity
@JsonIgnoreProperties({"pedidos","historico","pedidosVivos"})
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Integer numero;
    private Integer numSeccion;
    private String nombre;
    private Double franco;
    private Double importeMedioPalet;
    private String nombreContacto;
    private String email;
    private String telefono;

    private boolean esTransito;
    private boolean estaEnReapro;
    private String diasEnReapro;
    
    @OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "id_proveedor")
    private List<Pedido> pedidos;
    
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_proveedor")
    private List<Historico> historico;


    public Proveedor() {
        this.pedidos = new ArrayList<Pedido>();
        this.historico = new ArrayList<Historico>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumSeccion() {
        return numSeccion;
    }

    public void setNumSeccion(Integer numSeccion) {
        this.numSeccion = numSeccion;
    }

    public Double getFranco() {
        return franco;
    }

    public void setFranco(Double franco) {
        this.franco = franco;
    }

    public boolean isEstaEnReapro() {
        return estaEnReapro;
    }

    public void setEstaEnReapro(boolean estaEnReapro) {
        this.estaEnReapro = estaEnReapro;
    }
    
    

    public Double getImporteMedioPalet() {
        return importeMedioPalet;
    }

    public void setImporteMedioPalet(Double importeMedioPalet) {
        this.importeMedioPalet = importeMedioPalet;
        for(Pedido elpedido : this.pedidos){
            if(elpedido.isEnCurso()){
                int numpalets = 1;
                numpalets += new Double(elpedido.getImporte()/this.importeMedioPalet).intValue();
                elpedido.setNumPalets(numpalets);
                System.out.println("El pedido "+elpedido.getNumeropedido()+" tiene: "+elpedido.getNumPalets());
            }
        }
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEsTransito() {
        return esTransito;
    }

    public void setEsTransito(boolean esTransito) {
        this.esTransito = esTransito;
    }

    public String getDiasEnReapro() {
        return diasEnReapro;
    }

    public void setDiasEnReapro(String diasEnReapro) {
        this.diasEnReapro = diasEnReapro;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
        String cadenaTransito = nombre;
        cadenaTransito = cadenaTransito.substring(nombre.length() - 2, nombre.length());
        cadenaTransito = cadenaTransito.trim();
        if (cadenaTransito.equals("TR")) {
            this.esTransito = true;
        } else {
            esTransito = false;
        }
        this.nombre = nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public List<Pedido> getPedidosVivos(){
        List<Pedido> lista = new ArrayList<>();
        for(Pedido elpedido : this.pedidos){
            if(elpedido.isEnCurso()){
                lista.add(elpedido);
            }
        }
        return lista;
    }
    
    public void addPedido(Pedido elpedido){
        this.pedidos.add(elpedido);
        elpedido.setProveedor(this);
        
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

    public Pedido getPedidoByNum(int numero) {
        for (Pedido elpedido : this.pedidos) {
            if (elpedido.getNumeropedido() == numero) {
                return elpedido;
            }
        }
        return null;
    }

    public double getUdsEnCamino() {
        double uds = 0;
        for (Pedido elpedido : this.getPedidos()) {
            if(elpedido.isEnCurso())
            uds += elpedido.getUds();
        }
        return uds;
    }

    public double getValorEnCamino() {
        double importe = 0;
        for (Pedido elpedido : this.getPedidos()) {
            if(elpedido.isEnCurso())
            importe += elpedido.getImporte();
        }
        return importe;
    }

    public int getNumPedidosSinRevisar() {
        int valor = 0;
        for (Pedido elpedido : this.pedidos) {
            if (!elpedido.isRevisado()) {
                valor++;
            }
        }
        return valor;
    }

    public int getNumPedidosEnRetraso() {
        int valor = 0;
        for (Pedido elpedido : this.pedidos) {
            if (elpedido.isRetraso()) {
                valor++;
            }
        }
        return valor;
    }
    
    public boolean IsPossibleSendEmail(){
        if(this.nombreContacto!=null && this.nombreContacto.length()>0){
            if(this.email!=null && this.email.length()>0){
                return true;
            }
        }
        return false;
    }
    
    public boolean datosOK(){
        boolean result = true;
        if(this.nombreContacto==null || this.nombreContacto.length()<2)result = false;
        if(this.email==null || this.email.length()<2)result = false;
        if(this.telefono==null || this.telefono.length()<8)result = false;
        if(this.franco== null)result = false;
        return result;
        
    }

}
