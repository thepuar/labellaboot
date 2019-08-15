/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.frapecha.labella.model.Etiqueta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author thepuar
 */
@Entity
@JsonIgnoreProperties({"lineas", "seccion", "etiquetaTienda", "etiquetaOpecom", "etiquetaRM", "historico"})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeropedido;
    private Integer numPalets;
    private Date fechaentrega;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaentregaReal;
    private Date fechaencontrado;
    private boolean enCurso;
    private boolean revisado;
    @Column(columnDefinition = "boolean default true")
    private boolean llegaAFranco;
    private Integer tipoPedido;//0 - Tienda # 1 - PC  # 2 - Opecom # 3 - RM
    private boolean esReapro;
    private boolean entregaEnTienda;
    private boolean retraso;
    private boolean avisarAlLlegar;
    private boolean pendienteAnular;
    @Column(columnDefinition = "boolean default false")
    private boolean destacado;
    @Column(columnDefinition = "TEXT")
    private String observacion;
    @Transient
    private String nuevoComentario;
    private Integer numPC;
    private Double importe;
    private Double importePC;
    private Double uds;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<LineaPedido> lineas;
    @ManyToOne(cascade = CascadeType.ALL)
    private Proveedor proveedor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Seccion seccion;
    @ManyToOne
    private Etiqueta etiquetaTienda;
    @ManyToOne
    private Etiqueta etiquetaOpecom;
    @ManyToOne
    private Etiqueta etiquetaRM;

    public Long etiquetaId;
    public Long etiquetaIdOpecom;
    public Long etiquetaIdRM;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private List<Historico> historico;

    public Pedido() {
        revisado = false;
        llegaAFranco = true;
        lineas = new ArrayList<LineaPedido>();
        historico = new ArrayList<Historico>();
        fechaencontrado = new GregorianCalendar().getTime();
        avisarAlLlegar = false;
        pendienteAnular = false;
        tipoPedido = 0;
        importe = 0.0;
        importePC = 0.0;
        uds = 0.0;
    }

    public Integer getDiasRestantes() {
        GregorianCalendar fechaactual = new GregorianCalendar();
        GregorianCalendar fechapedido = new GregorianCalendar();
        if (fechaentregaReal != null) {
            fechapedido.setTime(fechaentregaReal);
        } else {
            fechapedido.setTime(fechaentrega);
        }

        long difms = fechapedido.getTimeInMillis() - fechaactual.getTimeInMillis();
        long difd = (long) difms / (1000 * 60 * 60 * 24);
        return (int) difd + 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(Integer numeropedido) {
        String cadena = numeropedido + "";
        if (cadena.startsWith("5")) {
            entregaEnTienda = true;
            esReapro = true;
        } else {
            esReapro = false;
        }
        this.numeropedido = numeropedido;
    }

    public Integer getNumPalets() {
        return numPalets;
    }

    public void setNumPalets(Integer numPalets) {
        this.numPalets = numPalets;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
        if (getDiasRestantes() <= 0) {
            this.setRetraso(true);
        } else {
            this.setRetraso(false);
        }
        if (this.proveedor.isEsTransito()) {
            GregorianCalendar fecha = new GregorianCalendar();
            fecha.setTime(fechaentrega);
            for (int i = 0; i < 2; i++) {
                fecha.add(Calendar.DAY_OF_YEAR, 1);
                if (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    fecha.add(Calendar.DAY_OF_YEAR, 1);
                }
            }

            this.setFechaentregaReal(fecha.getTime());
        } else {
            this.setFechaentregaReal(this.getFechaentrega());
        }
    }

    public Date getFechaentregaReal() {
        return fechaentregaReal;
    }

    public void setFechaentregaReal(Date fechaentregaReal) {
        this.fechaentregaReal = fechaentregaReal;
    }

    public Date getFechaencontrado() {
        return fechaencontrado;
    }

    public void setFechaencontrado(Date fechaencontrado) {
        this.fechaencontrado = fechaencontrado;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedido> lineas) {
        this.importe = 0.0;
        this.uds = 0.0;
        for (LineaPedido lalinea : lineas) {
            this.importe += lalinea.getValorLinea();
            this.uds += lalinea.getEncurso();
            this.importePC += lalinea.getValorLineaPc();
        }
    }
    
    public LineaPedido getLineaByReferencia(Integer referencia){
        for(LineaPedido lalinea : this.lineas){
            if(lalinea.getReferencia()==referencia)return lalinea;
        }
        return null;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public boolean isEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public Integer getTipoPedido() {
        return tipoPedido;
    }

    public String getTipoPedidoDescr() {
        String result = "";
        switch (this.tipoPedido) {
            case 0:
                result = "Tienda";
                break;
            case 1:
                result = "PC";
                break;
            case 2:
                result = "Opecom";
                break;
            case 3:
                result = "RM";
                break;
            default:
                result = "Desc";
                break;
        }

        return result;
    }

    public void setTipoPedido(Integer tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public boolean isTienda() {
        boolean result = false;
        if (tipoPedido == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isEsPc() {
        boolean result = false;
        if (tipoPedido == 1) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isEsOpecom() {
        boolean result = false;
        if (tipoPedido == 2) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isEsRm() {
        boolean result = false;
        if (tipoPedido == 3) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isEsReapro() {
        return esReapro;
    }

    public void setEsReapro(boolean esReapro) {
        this.esReapro = esReapro;
    }

    public boolean isEntregaEnTienda() {
        return entregaEnTienda;
    }

    public void setEntregaEnTienda(boolean entregaEnTienda) {
        this.entregaEnTienda = entregaEnTienda;
    }

    public boolean isRetraso() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }

    public boolean isLlegaAFranco() {
        return llegaAFranco;
    }

    public void setLlegaAFranco(boolean llegaAFranco) {
        this.llegaAFranco = llegaAFranco;
    }

    public boolean isAvisarAlLlegar() {
        return avisarAlLlegar;
    }

    public void setAvisarAlLlegar(boolean avisarAlLlegar) {
        this.avisarAlLlegar = avisarAlLlegar;
    }

    public boolean isPendienteAnular() {
        return pendienteAnular;
    }

    public void setPendienteAnular(boolean pendienteAnular) {
        this.pendienteAnular = pendienteAnular;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNuevoComentario() {
        return nuevoComentario;
    }

    public void setNuevoComentario(String nuevoComentario) {
        this.nuevoComentario = nuevoComentario;
    }

    public Integer getNumPC() {
        return numPC;
    }

    public void setNumPC(Integer numPC) {
        this.numPC = numPC;
    }

    public Etiqueta getEtiquetaTienda() {
        return etiquetaTienda;
    }

    public void setEtiquetaTienda(Etiqueta etiquetaTienda) {
        this.etiquetaTienda = etiquetaTienda;
    }

    public Etiqueta getEtiquetaOpecom() {
        return etiquetaOpecom;
    }

    public void setEtiquetaOpecom(Etiqueta etiquetaOpecom) {
        this.etiquetaOpecom = etiquetaOpecom;
    }

    public Etiqueta getEtiquetaRM() {
        return etiquetaRM;
    }

    public void setEtiquetaRM(Etiqueta etiquetaRM) {
        this.etiquetaRM = etiquetaRM;
    }

    public Long getEtiquetaId() {
        return etiquetaId;
    }

    public String getEtiquetaString() {
        String laetiqueta = "";
        if (this.etiquetaOpecom != null) {
            laetiqueta = this.etiquetaOpecom.getNombreEtiqueta();
        } else if (this.etiquetaTienda != null) {
            laetiqueta = this.etiquetaTienda.getNombreEtiqueta();
        } else if (this.etiquetaRM != null) {
            laetiqueta = this.etiquetaRM.getNombreEtiqueta();
        }
        return laetiqueta;
    }

    public void setEtiquetaId(Long etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public Long getEtiquetaIdOpecom() {
        return etiquetaIdOpecom;
    }

    public void setEtiquetaIdOpecom(Long etiquetaIdOpecom) {
        this.etiquetaIdOpecom = etiquetaIdOpecom;
    }

    public Long getEtiquetaIdRM() {
        return etiquetaIdRM;
    }

    public void setEtiquetaIdRM(Long etiquetaIdRM) {
        this.etiquetaIdRM = etiquetaIdRM;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    public void addHistorico(Historico historico) {
        this.historico.add(historico);
    }

    public void addLinea(LineaPedido lalinea) {
        this.lineas.add(lalinea);
        this.uds += lalinea.getEncurso();
        this.importe += lalinea.getValorLinea();
        this.importePC += lalinea.getPc() * lalinea.getEncurso();
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getImportePC() {
        return importePC;
    }

    public void setImportePC(Double importePC) {
        this.importePC = importePC;
    }

    public Double getUds() {
        return uds;
    }

    public void setUds(Double uds) {
        this.uds = uds;
    }

}
