/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.frapecha.labella.model.Pedido;

/**
 *
 * @author thepuar
 */
public class MailCutre {
    
    private Pedido pedido;
    private String asunto;
    private String emailDestino;
    private String body;
    private String url[] =  {"\"https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=","&su=","&body=","\""};
    
    //Salto de linea en url %0D%0A
    
    public MailCutre(String eDestino,Pedido elpedido){
        this.emailDestino = eDestino;
        this.pedido = elpedido;
        url[3] = "%0D%0A%0D%0ALeroy Merlin - "+pedido.getSeccion().getTienda().getNombre()+"\"";
    }
    
    public MailCutre(Pedido elpedido){
        this.emailDestino = elpedido.getProveedor().getEmail();
        this.pedido = elpedido;
        url[3] = "%0D%0A%0D%0ALeroy Merlin - "+pedido.getSeccion().getTienda().getNombre()+"\"";
    }
    
    public String getRevisionProveedorLink(){
        String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP1- Revisión de pedido: "+pedido.getNumeropedido()+msgPC);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", podrias confirmarme que el pedido "+pedido.getNumeropedido()+" os ha llegado correctamente y será enviado en fecha.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    }
    
    public String getAnulacionPProvNuevoLink(){
        String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP2- Anulacion nuevo pedido: "+pedido.getNumeropedido()+msgPC);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", anulamos el pedido "+pedido.getNumeropedido()+" que habreis recibido recientemente.");
        result = result.concat("%0D%0ANecesito que me confirmes la anulacion en vuestro sistema.");
        result = result.concat("%0D%0ASentimos las molestias ocasionadas.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    
    }
    
    public String getAnulacionPProvTelefonoLink(){
        String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP3- Anulacion pedido: "+pedido.getNumeropedido()+msgPC);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", como hemos visto por telefono, anulamos el pedido proveedor "+pedido.getNumeropedido()+".");
        result = result.concat("%0D%0ASentimos las molestias ocasionadas.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    
    }
    
    public String getSolicitudAdelantarPedidoLink(){
        String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP4- Adelantar pedido: "+pedido.getNumeropedido()+msgPC);
        result = result.concat(url[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEntrega = sdf.format(this.pedido.getFechaentrega());
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", necesitamos el pedido "+pedido.getNumeropedido()+" lo antes posible en nuestra tienda.");
        result = result.concat("%0D%0APor favor, indicame si es posible adelantarlo antes de la fecha actual "+fechaEntrega+" y para cuando lo podriamos tener para avisar a mi recepcion.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    
    }
    
    public String getConfirmacionAdelantarPedidoLink(){
        String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino+";logistica.lazenia@leroymerlin.es");
        result = result.concat(url[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEntrega = sdf.format(this.pedido.getFechaentregaReal());
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP5- Confirmacion nueva fecha de entrega para el pedido: "+pedido.getNumeropedido() +msgPC+" "+fechaEntrega);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", como hemos hablado, podeis enviar el pedido "+pedido.getNumeropedido()+" en la fecha "+fechaEntrega+".");
        result = result.concat("%0D%0APongo en copia a mi recepcion para que no rechaze el pedido.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    
    }
    
    public String getReclamarRetrasoLink(){
    String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEntrega = sdf.format(this.pedido.getFechaentregaReal());
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP6- Reclamación entrega pedido: "+pedido.getNumeropedido() +msgPC+" "+fechaEntrega);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", todavía no hemos recibido el pedido "+pedido.getNumeropedido()+" el cual esperabamos para el "+fechaEntrega+".");
        result = result.concat("%0D%0APodriais indicarme el motivo del retraso así como la fecha en la que lo recibiremos.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    }
    
    public String getReclamarConformeEntregaLink(){
    String result = "";
        result = result.concat(url[0]);
        result = result.concat(this.emailDestino);
        result = result.concat(url[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEntrega = sdf.format(this.pedido.getFechaentregaReal());
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP7- Solicitud conforme entrega pedido: "+pedido.getNumeropedido() +msgPC+" "+fechaEntrega);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias "+this.pedido.getProveedor().getNombreContacto()+", todavía no hemos recibido el conforme de entrega del pedido "+pedido.getNumeropedido()+" el cual se entregaba sobre el: "+fechaEntrega+".");
        result = result.concat("%0D%0APodriais reenviarmelo si disponeis de el para poder valorarlo.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    }
    
    public String getFechaInstalacionLink(){
    String result = "";
        result = result.concat(url[0]);
        result = result.concat("instalaciones.lazenia@leroymerlin.es");
        result = result.concat(url[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEntrega = sdf.format(this.pedido.getFechaentregaReal());
        String msgPC = "";
        if(this.pedido.isEsPc()){
            msgPC.concat(" - PC: "+this.pedido.getNumPC());
        }
        result = result.concat("BP8- Fecha de instalacion para el pedido: "+pedido.getNumeropedido() +msgPC+" "+fechaEntrega);
        result = result.concat(url[2]);
        result = result.concat("Buenos dias compañeros, podriais indicarme para cuando esta agendada la instalacion de este pedido.");
        result = result.concat("%0D%0ANo me aparece en el LeroyApp.");
        result = result.concat("%0D%0AUn saludo y muchas gracias");
        result = result.concat(url[3]);
        return result;
    }
    
    
    
}
