/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer numero;
    @OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "id_seccion")
    private List<Pedido> pedidos;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name="SeccionUsuario", joinColumns={@JoinColumn(name="IdSeccion")},inverseJoinColumns={@JoinColumn(name="IdUsuario")})
    private List<Usuario> usuarios;

    @ManyToOne
    private Tienda tienda;

    public Seccion() {
        pedidos = new ArrayList<Pedido>();
        usuarios = new ArrayList<Usuario>();
    }

    public Seccion(String nombre, Integer numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.pedidos = new ArrayList<Pedido>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido(Pedido elpedido) {
        this.pedidos.add(elpedido);
        elpedido.setSeccion(this);
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

    public void addUsuario(Usuario elusuario) {
        this.usuarios.add(elusuario);
        elusuario.getSecciones().add(this);
    }

//    public int getNumPedidosDia(int num) {
//        int numpedidos = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (elpedido.isEnCurso()&&UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                numpedidos++;
//            }
//        }
//        return numpedidos;
//    }
//    public int getNumPedidosDiaSiTienda(int num) {
//        int numpedidos = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (elpedido.isEnCurso()&&elpedido.isEntregaEnTienda()&&elpedido.isRevisado()&&UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                numpedidos++;
//            }
//        }
//        return numpedidos;
//    }
//    public int getNumPedidosDiaNoTienda(int num) {
//        int numpedidos = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (elpedido.isEnCurso()&&!elpedido.isEntregaEnTienda()&&elpedido.isRevisado()&&UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                numpedidos++;
//            }
//        }
//        return numpedidos;
//    }
    
    
    
//    public int getNumPaletsDia(int num) {
//        int numpalets = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                if(elpedido.getNumPalets()!=null&&elpedido.isEnCurso())
//                numpalets += elpedido.getNumPalets();
//            }
//        }
//        return numpalets;
//    }
//    public int getNumPaletsDiaATienda(int num) {
//        int numpalets = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                if(elpedido.getNumPalets()!=null&&elpedido.isEntregaEnTienda()==true&&elpedido.isEnCurso())
//                numpalets += elpedido.getNumPalets();
//            }
//        }
//        return numpalets;
//    }
//    
//    public int getNumPaletsDiaNoATienda(int num) {
//        int numpalets = 0;
//        for (Pedido elpedido : this.pedidos) {
//            if (UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())) {
//                if(elpedido.getNumPalets()!=null&&elpedido.isEntregaEnTienda()==false&&elpedido.isEnCurso())
//                numpalets += elpedido.getNumPalets();
//            }
//        }
//        return numpalets;
//    }
//    
//    public int getUnidadesDia(int num){
//        int unidades = 0;
//        for(Pedido elpedido : this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso()){
//                unidades += elpedido.getUds().intValue();
//                }
//            }
//        }
//        return unidades;
//    }
//    public int getUnidadesDiaATienda(int num){
//        int unidades = 0;
//        for(Pedido elpedido : this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso()&&elpedido.isEntregaEnTienda()){
//                unidades += elpedido.getUds().intValue();
//                }
//            }
//        }
//        return unidades;
//    }
//    
//    public int getUnidadesDiaNoATienda(int num){
//        int unidades = 0;
//        for(Pedido elpedido : this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso()&&!elpedido.isEntregaEnTienda()){
//                unidades += elpedido.getUds().intValue();
//                }
//            }
//        }
//        return unidades;
//    }
//    
//    public double getImporteDia(int num){
//        double unidades = 0;
//        for(Pedido elpedido: this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso())
//                    unidades += elpedido.getImporte();
//            }
//        }
//        return unidades;
//    }
//    
//    public double getImporteDiaATienda(int num){
//        double unidades = 0;
//        for(Pedido elpedido: this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso()&&elpedido.isEntregaEnTienda())
//                    unidades += elpedido.getImporte();
//            }
//        }
//        return unidades;
//    }
//    
//    public double getImporteDiaNoATienda(int num){
//        double unidades = 0;
//        for(Pedido elpedido: this.pedidos){
//            if(UtilesFechas.esDiaHoyMasN(num, elpedido.getFechaentregaReal())){
//                if(elpedido.isEnCurso()&&!elpedido.isEntregaEnTienda())
//                    unidades += elpedido.getImporte();
//            }
//        }
//        return unidades;
//    }
    
    
    
    public int getNumPedidosVivos(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso())i++;
        }
        return i;
    }
    
    public int getNumPedidosVivosRevisados(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isRevisado())i++;
        }
        return i;
    }
    
    public int getNumPedidosVivosNoRevisados(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&!elpedido.isRevisado())i++;
        }
        return i;
    }
    
    public int getNumPedidosVivosRevTienda(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isTienda()&&elpedido.isRevisado())i++;
        }
        return i;
    }
    public int getNumPedidosVivosRevPC(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isEsPc()&&elpedido.isRevisado())i++;
        }
        return i;
    }
    
    public int getNumPedidosVivosRevOpecom(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isEsOpecom()&&elpedido.isRevisado())i++;
        }
        return i;
    }
    
    public int getNumPedidosVivosRevRM(){
        int i = 0;
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isEsRm()&&elpedido.isRevisado())i++;
        }
        return i;
    }
    
    public List<Pedido> getPedidosVivos(){
        List<Pedido> pedidosVivos = new ArrayList<>();
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso())
                pedidosVivos.add(elpedido);
        }
        return pedidosVivos;
    }
    
    public List<Pedido> getPedidosVivosNoRevisados(){
        List<Pedido> pedidosVivos = new ArrayList<>();
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&!elpedido.isRevisado())
                pedidosVivos.add(elpedido);
        }
        return pedidosVivos;
    }
    
    public List<Pedido> getPedidosDestacados(){
        List<Pedido> pedidosDestacados = new ArrayList<>();
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isDestacado())
                pedidosDestacados.add(elpedido);
        }
        return pedidosDestacados;
    }
    
    public List<Pedido> getPedidosEnRetraso(){
        List<Pedido> pedidosEnRetraso= new ArrayList<>();
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.getDiasRestantes()<0)
                pedidosEnRetraso.add(elpedido);
        }
        return pedidosEnRetraso;
    }
    
    public List<Pedido> getPedidosAvisarAlEntrar(){
        List<Pedido> pedidosAvisar = new ArrayList<>();
        for(Pedido elpedido : this.getPedidos()){
            if(elpedido.isEnCurso()&&elpedido.isAvisarAlLlegar()){
                pedidosAvisar.add(elpedido);
            }
        }
        return pedidosAvisar;
    }
    
    public List<Pedido> getPedidosPendienteAnular(){
        List<Pedido> pedidosAnular = new ArrayList<>();
        for(Pedido elpedido : this.getPedidosVivos()){
            if(elpedido.isPendienteAnular()){
                pedidosAnular.add(elpedido);
            }
        }
        return pedidosAnular;
    }
    
    public List<Pedido> getPedidosNoLleganAFranco(){
        List<Pedido> pedidoNoLlegaAFranco = new ArrayList<>();
        for(Pedido elpedido : this.getPedidosVivos()){
            if(!elpedido.isLlegaAFranco()){
                pedidoNoLlegaAFranco.add(elpedido);
            }
        }
        return pedidoNoLlegaAFranco;
    }
    
//    public List<Proveedor> getProveedores(){
//        List<Proveedor> proveedores = new ArrayList<>();
//        HProveedor hproveedor = new HProveedor();
//        proveedores = hproveedor.getByNumSeccion(this.numero);
//        return proveedores;
//        
//    }

}
