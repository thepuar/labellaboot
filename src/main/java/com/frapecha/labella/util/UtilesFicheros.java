package com.frapecha.labella.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.frapecha.labella.fichero.model.FiFranco;
import com.frapecha.labella.fichero.model.FiImportePalet;
import com.frapecha.labella.fichero.model.FiUsuario;
import com.frapecha.labella.fichero.model.LPRE;
import com.frapecha.labella.fichero.model.LineaFiFranco;
import com.frapecha.labella.fichero.model.LineaFiUsuario;
import com.frapecha.labella.fichero.model.LineaImportePalet;
import com.frapecha.labella.fichero.model.LineaLPRE;
import com.frapecha.labella.service.impl.LaBellaProvServiceImpl;
import com.frapecha.labella.util.UtilesFicheros;

public class UtilesFicheros {

	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(UtilesFicheros.class);

private Properties propSistema;

public static Date getFechaDentroReporte(String celda) {
    String fechainforme = celda;
    fechainforme = fechainforme.substring(fechainforme.length() - 8, fechainforme.length());

    GregorianCalendar fecha = new GregorianCalendar();
    String dia = fechainforme.substring(0, fechainforme.indexOf("/"));
    fechainforme = fechainforme.substring(fechainforme.indexOf("/") + 1, fechainforme.length());
    String mes = fechainforme.substring(0, fechainforme.indexOf("/"));
    fechainforme = fechainforme.substring(fechainforme.indexOf("/") + 1, fechainforme.length());
    String anyo = fechainforme.substring(0, fechainforme.length());
    Integer Idia = Integer.parseInt(dia);
    Integer Imes = Integer.parseInt(mes);
    Integer Ianyo = Integer.parseInt(anyo);
    Ianyo = Ianyo + 2000;

    fecha.set(Calendar.DAY_OF_MONTH, Idia);
    fecha.set(Calendar.MONTH, Imes);
    fecha.set(Calendar.YEAR, Ianyo);

    return fecha.getTime();
}

public static String getNombreTiendaDentroReporte(String celda) {
    int posiciondospuntos = celda.indexOf(":");
    //EL LPRE CONTIENE EL NUMERO DE LA TIENDA DESPUES DE LOS 2 PUNTOS
    int posicionprimeraletra = posiciondospuntos + 2;
    while (!Character.isLetter(celda.charAt(posicionprimeraletra))) {
        posicionprimeraletra++;
    }

    int posicionultimaletra = posicionprimeraletra + 20;
    while (celda.charAt(posicionultimaletra) == ' ') {
        posicionultimaletra--;
    }
    celda = celda.substring(posicionprimeraletra, posicionultimaletra + 1);//OBTENEMOS FINALMENTE EL NOMBRE DE LA TIENDA.
    return celda;
}

public static Integer getNumeroTiendaDentroReporte(String celda) {
    int posiciondospuntos = celda.indexOf(":");
    int posicionprimernumero = posiciondospuntos + 1;
    while (!Character.isDigit(celda.charAt(posicionprimernumero))) {
        posicionprimernumero++;
    }
    int posicionultimonumero = posicionprimernumero + 2;
    celda = celda.substring(posicionprimernumero, posicionultimonumero);
    celda.trim();
    System.out.println("El numero de la tienda es:" + celda);
    return Integer.parseInt(celda);

}

public static String getFechaString() {
    Calendar horafichero = new GregorianCalendar();
    String cadena = "";
    String hora = "";
    String minuto = "";
    String segundo = "";
    String anyo = Integer.toString(horafichero.get(Calendar.YEAR));
    String mes = Integer.toString(horafichero.get(Calendar.MONTH) + 1);
    String dia = Integer.toString(horafichero.get(Calendar.DAY_OF_MONTH));

    if (horafichero.get(Calendar.HOUR_OF_DAY) < 10) {
        hora = "0" + horafichero.get(Calendar.HOUR_OF_DAY);
    } else {
        hora = horafichero.get(Calendar.HOUR_OF_DAY) + "";
    }
    if (horafichero.get(Calendar.MINUTE) < 10) {
        minuto = "0" + horafichero.get(Calendar.MINUTE);
    } else {
        minuto = horafichero.get(Calendar.MINUTE) + "";
    }
    if (horafichero.get(Calendar.SECOND) < 10) {
        segundo = "0" + horafichero.get(Calendar.SECOND);
    } else {
        segundo = horafichero.get(Calendar.SECOND) + "";
    }
    return anyo + "" + mes + "" + dia + "" + hora + "" + minuto + "" + segundo;
}

//If opcion 0, me pasa el nombre del fichero
//If opcion 1 me pasa la ruta dle fichero
public UtilesFicheros() {
    this.propSistema = new Properties();
    InputStream input = getClass().getResourceAsStream("/sistema.properties");
    try {
        this.propSistema.load(input);
    } catch (Exception e) {
        System.out.println("ERROR construyendo UtilesFicheros - " + e.getLocalizedMessage());
    }
}

public LPRE CargaLPRE(String nombre, int opcion) {
    LPRE ellpre = new LPRE();
    String ruta = this.getRutaSistema();
    try {
        FileInputStream lpreFIS;
        if (opcion == 0) {
            lpreFIS = new FileInputStream(ruta + nombre);
        } else {
            lpreFIS = new FileInputStream(nombre);
        }
        System.out.println("Abriendo LPRE.");
        XSSFWorkbook wblpre = new XSSFWorkbook(lpreFIS);
        XSSFSheet hoja1 = wblpre.getSheetAt(1);
        int numFilas = hoja1.getLastRowNum() - 4;
        Iterator<Row> rowiterator = hoja1.iterator();
        int x = 1;
        int y = 3;
        Row row = rowiterator.next();
        row = rowiterator.next();//Estamos en la fila 2, donde esta la fila de la informacion de la fecha
        System.out.println("Intentando recuperar la fecha");
        Iterator<Cell> celliterator = row.cellIterator();
        Cell celda = celliterator.next();
        Date lafecha = UtilesFicheros.getFechaDentroReporte(celda.getStringCellValue());
        ellpre.setFechafichero(lafecha);
        String nombretienda = UtilesFicheros.getNombreTiendaDentroReporte(celda.getStringCellValue());
        ellpre.setNombreTienda(nombretienda);
        Integer numerotienda = UtilesFicheros.getNumeroTiendaDentroReporte(celda.getStringCellValue());
        ellpre.setNumero_tienda(numerotienda);
        row = rowiterator.next();
        y++;
        row = rowiterator.next();//Estamos en la  fila  del encabezadoque contiene datos.
        int num_referencias = 0;
        LineaLPRE lineaLPRE;
        while (num_referencias < numFilas) {
            //while(rowiterator.hasNext()){
            lineaLPRE = new LineaLPRE();
            row = rowiterator.next();
            y++;
            celliterator = row.cellIterator();
            x = 1;
            //Comenzamos a leer filas de la segmentacion
            int seccion, numproveedor, referencia, top, numpedido;
            boolean irrenunciable, pp;
            Double pc, pvp, enpedido, valorpedido;
            String nombreproveedor, designacion, gama, es2080, espp, segmento, tipopedido, alerta;
            java.util.Date fechaentrega;
            java.sql.Date fechaentregasql;
            Calendar calendar;
            celda = celliterator.next();
            seccion = Double.valueOf(celda.getNumericCellValue()).intValue();
            lineaLPRE.setSeccion(seccion);
            celda = celliterator.next();
            numproveedor = Double.valueOf(celda.getNumericCellValue()).intValue();
            lineaLPRE.setNum_proveedor(numproveedor);
            celda = celliterator.next();
            nombreproveedor = celda.getStringCellValue();
            lineaLPRE.setNom_proveedor(nombreproveedor);
            celda = celliterator.next();
            referencia = Double.valueOf(celda.getNumericCellValue()).intValue();
            lineaLPRE.setReferencia(referencia);
            celda = celliterator.next();
            designacion = celda.getStringCellValue();
            lineaLPRE.setDesignacion(designacion);
            celda = celliterator.next();
            gama = celda.getStringCellValue();
            lineaLPRE.setGama(gama);
            celda = celliterator.next();
            top = Double.valueOf(celda.getNumericCellValue()).intValue();
            lineaLPRE.setTop(top);
            celda = celliterator.next();
            if (celda.getCellType() == Cell.CELL_TYPE_BLANK) {
                es2080 = "";
                irrenunciable = false;
            } else {
                es2080 = celda.getStringCellValue();
                irrenunciable = true;
            }
            lineaLPRE.setIrrenunciable(irrenunciable);
            celda = celliterator.next();
            if (celda.getCellType() == Cell.CELL_TYPE_BLANK) {
                espp = "";
                pp = false;
            } else {
                espp = celda.getStringCellValue();
                pp = true;
            }
            lineaLPRE.setPrimerprecio(pp);
            celda = celliterator.next();
            try {
                pvp = celda.getNumericCellValue();
            } catch (Exception e) {
                pvp = 0.0;
            }
            lineaLPRE.setPvp(pvp);
            //Precio de compra
            celda = celliterator.next();
            try {
                pc = celda.getNumericCellValue();
            } catch (Exception e) {
                //No hay un precio de compra
                System.out.println("Ha ocurrido un error capturando el precio de compra: " + e.getLocalizedMessage());
                pc = 0.0;
            }
            lineaLPRE.setPc(pc);
            celda = celliterator.next();//SALTAMOS COLUMNA EN BLANCO
            celda = celliterator.next();
            numpedido = Double.valueOf(celda.getNumericCellValue()).intValue();
            lineaLPRE.setNum_pedido(numpedido);
            celda = celliterator.next();
            fechaentrega = celda.getDateCellValue();
            lineaLPRE.setFecha_entrega(fechaentrega);
            calendar = GregorianCalendar.getInstance();
            calendar.setTime(fechaentrega);
            //calendar.add(Calendar.MONTH, 1);
            fechaentregasql = new java.sql.Date(calendar.getTime().getTime());
            celda = celliterator.next();
            tipopedido = celda.getStringCellValue();
            lineaLPRE.setTipopedido(tipopedido);
            celda = celliterator.next();
            enpedido = celda.getNumericCellValue();
            lineaLPRE.setEncurso(enpedido);
            celda = celliterator.next();
            valorpedido = celda.getNumericCellValue();
            lineaLPRE.setValorlinea(valorpedido);
            celda = celliterator.next();//SALTAMOS COLUMNA EN BLANCO
            celda = celliterator.next();
            alerta = celda.getStringCellValue();
            lineaLPRE.setAlerta(alerta);

            num_referencias++;
            ellpre.getListalineas().add(lineaLPRE);
//            log.info(num_referencias + "/" + numFilas + " Seccion: " + seccion + " - Referencia: " + referencia + " - Designacion: " + designacion + "PC: " + pc);
        }
        System.out.println("##LPRE TERMINADA##");

    } catch (IOException e) {
        System.out.println("Error Cargando LPRE: " + e.getLocalizedMessage());
        return null;
    }
    return ellpre;
}

public FiUsuario CargaFiUsuario() {
    FiUsuario elfichero = new FiUsuario();
    String ruta = this.getRutaUsuarios();

    try {
        Double dldap;
        FileInputStream ficheroFIS = new FileInputStream(ruta);
        System.out.println("Abriendo Fichero Usuarios");
        XSSFWorkbook wbfichero = new XSSFWorkbook(ficheroFIS);
        XSSFSheet hoja = wbfichero.getSheetAt(0);
        Iterator<Row> rowiterator = hoja.iterator();
        Row row = rowiterator.next();//Estamos en la fila 2
        Iterator<Cell> celliterator = row.cellIterator();
        Cell celda;
        LineaFiUsuario lineausuario;
        while (rowiterator.hasNext()) {
            lineausuario = new LineaFiUsuario();
            row = rowiterator.next();
            celliterator = row.cellIterator();
            celda = celliterator.next();
            System.out.println("DATO: " + celda.getStringCellValue());
            lineausuario.setApellidos(celda.getStringCellValue());
            celda = celliterator.next();
            lineausuario.setNombre(celda.getStringCellValue());
            celda = celliterator.next();
            lineausuario.setSeccion(celda.getStringCellValue());
            celda = celliterator.next();
            lineausuario.setPuesto(celda.getStringCellValue());
            celda = celliterator.next();
            lineausuario.setTienda(celda.getStringCellValue());
            celda = celliterator.next();
            dldap = celda.getNumericCellValue();
            lineausuario.setLdap(dldap.intValue());
            celda = celliterator.next();
            lineausuario.setEmail(celda.getStringCellValue());
            elfichero.getLineas().add(lineausuario);
        }
    } catch (IOException e) {
        System.out.println("Error cargando FiUsuario: " + e.getLocalizedMessage());
    } catch (NoSuchElementException e) {
        System.out.println("Error leyendo fiusuarios: " + e.getLocalizedMessage());
    }
    return elfichero;
}

public FiFranco CargaFiFranco() {
    String ruta = this.getRutaFrancoProveedor();
    //Esta es la ruta de Mac
    FiFranco elfichero = new FiFranco();
    try {
        FileInputStream ficheroFIS = new FileInputStream(ruta);
        System.out.println("Abriendo Fichero Francos");
        XSSFWorkbook wbfichero = new XSSFWorkbook(ficheroFIS);
        XSSFSheet hoja = wbfichero.getSheetAt(0);
        Iterator<Row> rowiterator = hoja.iterator();
        Row row = rowiterator.next();//Estamos en la fila 2
        Iterator<Cell> celliterator = row.cellIterator();
        Cell celda;
        LineaFiFranco lineafranco;
        String cadena = "";
        int numprov;
        String nombreprov = "";
        double franco;

        while (rowiterator.hasNext()) {
            lineafranco = new LineaFiFranco();
            row = rowiterator.next();
            celliterator = row.cellIterator();
            celda = celliterator.next();
            cadena = celda.getStringCellValue();
            numprov = Integer.parseInt(cadena.substring(0, cadena.indexOf("-") - 1).trim());
            nombreprov = cadena.substring(cadena.indexOf("-") + 1, cadena.length() - 1);
            celliterator.next();
            celda = celliterator.next();
            franco = celda.getNumericCellValue();
            celda = celliterator.next();
            lineafranco.setNumprov(numprov);
            lineafranco.setNombreprov(nombreprov);
            lineafranco.setFranco(franco);
            if (celda.getStringCellValue().contains("€")) {
                elfichero.addLinea(lineafranco);
                System.out.println("FiFranco añadida " + lineafranco.getNumprov() + "-" + lineafranco.getNombreprov() + "/ " + lineafranco.getFranco() + "€");
            } else {
                System.out.println("El proveedor " + lineafranco.getNumprov() + "-" + lineafranco.getNombreprov() + " no se puede añadir.");
            }
        }
    } catch (IOException e) {
        System.out.println("ERROR EN FIFRANCO " + e.getLocalizedMessage());
    }
    return elfichero;
}

public FiImportePalet CargaFiImportePalet() {

    String ruta = this.getRutaPrecioMedioPalet();
    FiImportePalet elfichero = new FiImportePalet();
    try {
        FileInputStream ficheroFIS = new FileInputStream(ruta);
        System.out.println("Abriendo Fichero Importe Medio Palet");
        XSSFWorkbook wbfichero = new XSSFWorkbook(ficheroFIS);
        XSSFSheet hoja = wbfichero.getSheetAt(0);
        Iterator<Row> rowiterator = hoja.iterator();
        Row row = rowiterator.next();
        Iterator<Cell> celliterator = row.cellIterator();
        Cell celda;
        LineaImportePalet lineaimporte;
        while (rowiterator.hasNext()) {
            lineaimporte = new LineaImportePalet();
            row = rowiterator.next();
            celliterator = row.cellIterator();
            celda = celliterator.next();
            lineaimporte.setNumprov(new Double(celda.getNumericCellValue()).intValue());
            celda = celliterator.next();
            lineaimporte.setNomprov(celda.getStringCellValue());
            for (int i = 0; i < 10; i++) {
                celda = celliterator.next();
            }
            if (celda.getNumericCellValue() > 100) {
                lineaimporte.setImportemediopalet(celda.getNumericCellValue());
                elfichero.addLinea(lineaimporte);
                System.out.println("El importe del palet es: " + lineaimporte.getNumprov() + " - " + lineaimporte.getImportemediopalet());
            }
        }
    } catch (IOException e) {
        System.out.println("ERROR EN FIIMPORTEPALET: " + e.getLocalizedMessage());
    }
    return elfichero;
}

public String getRutaSistema() {
    String ruta = "";
    String OS = System.getProperty("os.name").toLowerCase();
    if (OS.indexOf("win") >= 0) {
        ruta = propSistema.getProperty("ruta_win");
    } else if (OS.indexOf("mac") >= 0) {
        //ruta = rutamac;
        ruta = propSistema.getProperty("ruta_mac");
    } else {
        ruta = propSistema.getProperty("ruta_lin");
    }
    return ruta;
}

public String getRutaSistemaCarga() {
    String ruta = this.getRutaSistema();
    String OS = System.getProperty("os.name").toLowerCase();
    if (OS.contains("win")) {
        return ruta.concat(propSistema.getProperty("ruta_carga_win"));
    } else if (OS.contains("mac")) {
        //ruta = rutamac;
        return ruta.concat(propSistema.getProperty("ruta_carga_mac"));
    } else {
        return ruta.concat(propSistema.getProperty("ruta_carga_lin"));
    }
}

public String getRutaPrecioMedioPalet(){
    return this.getRutaSistemaCarga().concat(propSistema.getProperty("file_palets"));
}

public String getRutaUsuarios(){
    return this.getRutaSistemaCarga().concat(propSistema.getProperty("file_usuarios"));
}

public String getRutaFrancoProveedor(){
    return this.getRutaSistemaCarga().concat(propSistema.getProperty("file_franco_proveedores"));
}

public String getPropertyByName(String name){
    return propSistema.getProperty(name);
}
}
