/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author thepuar
 */
public class UtilesFechas {
    
    public static boolean mismoDia(Date fecha1, Date fecha2){
        boolean resultado = false;
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(fecha1);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(fecha2);
        
        int dia1 = cal1.get(Calendar.DAY_OF_YEAR);
        int dia2 = cal2.get(Calendar.DAY_OF_YEAR);
        int anyo1 = cal1.get(Calendar.YEAR);
        int anyo2 = cal2.get(Calendar.YEAR);
        
        if(dia1 == dia2 && anyo1 == anyo2)resultado = true;
        return resultado;
        
    }
    
    public static boolean esDiaHoyMasN(int dias, Date fecha1){
        boolean resultado = false;
        Calendar cal1 = new GregorianCalendar();
        cal1.add(Calendar.DAY_OF_YEAR, dias);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(fecha1);
        
        int dia1 = cal1.get(Calendar.DAY_OF_YEAR);
        int dia2 = cal2.get(Calendar.DAY_OF_YEAR);
        int anyo1 = cal1.get(Calendar.YEAR);
        int anyo2 = cal2.get(Calendar.YEAR);
        //System.out.println("1.- Dia "+dia1+" Anyo "+anyo1);
        //System.out.println("2.- Dia "+dia2+" Anyo "+anyo2);
        if(dia1 == dia2 && anyo1 == anyo2)resultado = true;
        return resultado;
        
    }
    
    
    
    public static Calendar StringToCalendar(String sfecha){
        Calendar fecha = new GregorianCalendar();
        
        try{
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date)formatter.parse(sfecha);
            fecha.setTime(date);
        }catch(ParseException e){;}
        
        return fecha;
    }
    
    
    
}
