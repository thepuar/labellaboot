/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

/**
 *
 * @author thepuar
 */
public class MailManager {

	
    String downloademail;
    String downloadpassword;
    String downloadproperty_address;
    String imapserver_address;
    String emailreportsender;
    private String rutaWin;
    private String rutaLinux;
    private String rutaMac;
    
    public MailManager(){
        Properties propMail = new Properties();
        InputStream input = null;
        try{
            input = getClass().getResourceAsStream("/mail.properties");
            if(input!=null){
                propMail.load(input);
                this.downloademail = propMail.getProperty("cuenta_correo");
                this.downloadpassword = propMail.getProperty("pass_correo");
                this.emailreportsender=propMail.getProperty("cuenta_correo_informes");
                this.imapserver_address=propMail.getProperty("imapserver_address");
                this.downloadproperty_address=propMail.getProperty("downloadproperty_address");
            }
        }catch(IOException e){System.out.println("Error al cargar las propiedades del mail");}
        
        try{
            input = getClass().getResourceAsStream("/sistema.properties");
            if(input!=null){
                propMail.load(input);
                this.rutaWin = propMail.getProperty("ruta_win");
                this.rutaLinux = propMail.getProperty("ruta_lin");
                this.rutaMac=propMail.getProperty("ruta_mac");
            }
        }catch(IOException e){System.out.println("Error al cargar las rutas del sistema");}
       
        
        
        
    }
    
    public String descargarLPRE(String direccion) {
        //emailreportsender = direccion;
        String nombreFichero = "";
        System.out.println("Comprobando correo.");
        try {
            Properties props = new Properties();
            props.setProperty(downloadproperty_address, "true");
            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect(imapserver_address, downloademail, downloadpassword);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            for (Message message : messages) {
                Address[] direcciones = message.getFrom();
                String ladireccion = "";
                if (direcciones.length == 1) {
                    ladireccion = direcciones[0].toString();
                }
                int posicion_ini = ladireccion.indexOf("<");
                posicion_ini++;
                int posicion_fin = ladireccion.indexOf(">");
                if (posicion_ini == 0 && posicion_fin == -1) {
                    ladireccion = ladireccion;
                } else {
                    ladireccion = ladireccion.substring(posicion_ini, posicion_fin);
                }
                System.out.println("Email enviado por: " + ladireccion);
                if (ladireccion.equals(emailreportsender)) {
                    try {
                        Multipart multiPart = (Multipart) message.getContent();

                        for (int i = 0; i < multiPart.getCount(); i++) {
                            BodyPart bodyPart = multiPart.getBodyPart(i);
                            InputStream is = bodyPart.getInputStream();

                            if (bodyPart.getFileName() != null && bodyPart.getFileName().contains("LPRE") && bodyPart.getFileName().contains(".xlsx")) {

                                System.out.println("##### LPRE ENCONTRADO #####");
                                nombreFichero = UtilesFicheros.getFechaString() + "_COMPRAS_LPRE.xlsx";

                                String ruta = "";
                                UtilesFicheros uf = new UtilesFicheros();
                                ruta = uf.getRutaSistema();
                               
                                File f = new File(ruta + nombreFichero);
                                FileOutputStream fos = new FileOutputStream(f);
                                byte[] buf = new byte[4096];
                                int bytesRead = 0;
                                while ((bytesRead = is.read(buf)) != -1) {
                                    // System.out.println("VALOR IS READ "+is.read(buf));
                                    fos.write(buf, 0, bytesRead);
                                }
                                fos.close();
                                System.out.println("Fichero " + nombreFichero + " descargado.");
                                message.setFlag(Flags.Flag.SEEN, false);
//                                UtilesFicheros utiles = new UtilesFicheros();
//                                utiles.CargaLPRE(nombreFichero);
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println("ERROR: " + ex.getLocalizedMessage());
                        //  System.out.println("VALOR IS READ "+is.read(buf));
                    }
                }//FIN IF
            }

        } catch (Exception e) {
            System.out.println("ERROR MAILMANAGER: " + e.getMessage());
        }
        return nombreFichero;
    }

    
    //Comprobara todos mails y los marcara como leidos si no son un lpre
    public String descargarLPREMarcandoLeido(String direccion) {
        String ruta;
        emailreportsender = direccion;
        String nombreFichero = "";
        System.out.println("Comprobando correo.");
        try {
            Properties props = new Properties();
            props.setProperty(downloadproperty_address, "true");
            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect(imapserver_address, downloademail, downloadpassword);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            for (Message message : messages) {
                Address[] direcciones = message.getFrom();
                String ladireccion = "";
                if (direcciones.length == 1) {
                    ladireccion = direcciones[0].toString();
                }
                int posicion_ini = ladireccion.indexOf("<");
                posicion_ini++;
                int posicion_fin = ladireccion.indexOf(">");
                if (posicion_ini == 0 && posicion_fin == -1) {
                    ladireccion = ladireccion;
                } else {
                    ladireccion = ladireccion.substring(posicion_ini, posicion_fin);
                }
                System.out.println("Email enviado por: " + ladireccion);
                if (ladireccion.equals(emailreportsender)) {
                    try {
                        Multipart multiPart = (Multipart) message.getContent();

                        for (int i = 0; i < multiPart.getCount(); i++) {
                            BodyPart bodyPart = multiPart.getBodyPart(i);
                            InputStream is = bodyPart.getInputStream();

                            if (bodyPart.getFileName() != null && bodyPart.getFileName().contains("LPRE") && bodyPart.getFileName().contains(".xlsx")) {

                                System.out.println("##### LPRE ENCONTRADO #####");
                                nombreFichero = UtilesFicheros.getFechaString() + "_COMPRAS_LPRE.xlsx";
                                UtilesFicheros uf = new UtilesFicheros();
                               ruta = uf.getRutaSistema();
                                File f = new File(ruta + nombreFichero);
                                FileOutputStream fos = new FileOutputStream(f);
                                byte[] buf = new byte[4096];
                                int bytesRead = 0;
                                while ((bytesRead = is.read(buf)) != -1) {
                                    // System.out.println("VALOR IS READ "+is.read(buf));
                                    fos.write(buf, 0, bytesRead);
                                }
                                fos.close();
                                System.out.println("Fichero " + nombreFichero + " descargado.");
                                message.setFlag(Flags.Flag.SEEN, false);
//                                UtilesFicheros utiles = new UtilesFicheros();
//                                utiles.CargaLPRE(nombreFichero);
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println("ERROR: " + ex.getLocalizedMessage());
                        //  System.out.println("VALOR IS READ "+is.read(buf));
                    }
                }//FIN IF
                //Marcar mensaje como leido
                message.setFlag(Flags.Flag.SEEN,true);
            }

        } catch (Exception e) {
            System.out.println("ERROR MAILMANAGER: " + e.getMessage());
        }
        return nombreFichero;
    }

    public String getDownloademail() {
        return downloademail;
    }

    public void setDownloademail(String downloademail) {
        this.downloademail = downloademail;
    }

    public String getDownloadpassword() {
        return downloadpassword;
    }

    public void setDownloadpassword(String downloadpassword) {
        this.downloadpassword = downloadpassword;
    }

    public String getDownloadproperty_address() {
        return downloadproperty_address;
    }

    public void setDownloadproperty_address(String downloadproperty_address) {
        this.downloadproperty_address = downloadproperty_address;
    }

    public String getImapserver_address() {
        return imapserver_address;
    }

    public void setImapserver_address(String imapserver_address) {
        this.imapserver_address = imapserver_address;
    }

    public String getEmailreportsender() {
        return emailreportsender;
    }

    public void setEmailreportsender(String emailreportsender) {
        this.emailreportsender = emailreportsender;
    }

    public String getRutaWin() {
        return rutaWin;
    }

    public void setRutaWin(String rutaWin) {
        this.rutaWin = rutaWin;
    }

    public String getRutaLinux() {
        return rutaLinux;
    }

    public void setRutaLinux(String rutaLinux) {
        this.rutaLinux = rutaLinux;
    }

    public String getRutaMac() {
        return rutaMac;
    }

    public void setRutaMac(String rutaMac) {
        this.rutaMac = rutaMac;
    }
    
    

}
