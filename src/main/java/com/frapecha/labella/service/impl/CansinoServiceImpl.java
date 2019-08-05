package com.frapecha.labella.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frapecha.labella.fichero.model.LPRE;
import com.frapecha.labella.model.Tienda;
import com.frapecha.labella.util.MailManager;
import com.frapecha.labella.util.UtilesFechas;
import com.frapecha.labella.util.UtilesFicheros;

@Component
public class CansinoServiceImpl implements Runnable, CansinoService {

	@Autowired
	TiendaService tiendaService;

	@Autowired
	LaBellaProvService laBellaProvService;

	public void run() {
		System.out.println("Hola desde Cansino");
		UtilesFicheros utilesFicheros = new UtilesFicheros();
		LPRE ellpre;
		MailManager mailManager = new MailManager();
		mailManager.setDownloademail("reportes.lazenia@leroymerlin.es");
		mailManager.setDownloadpassword("R3p0rt3s");
		mailManager.setEmailreportsender("reportingcg.regiones@leroymerlin.es");
		int comprobando = 0;
		while (true) {
			System.out.println(new Date() + " - " + comprobando + " - Hilo Cansino");
			comprobando++;
			String rutaFichero = mailManager.descargarLPREMarcandoLeido(mailManager.getEmailreportsender());
			if (rutaFichero != null && rutaFichero.length() > 0) {
				System.out.println("La ruta del fichero es: " + rutaFichero);
				ellpre = utilesFicheros.CargaLPRE(rutaFichero, 0);
				System.out.println("Fecha del LPRE: " + ellpre.getFechafichero());
				Date fecha = ellpre.getFechafichero();
				Calendar cal = new GregorianCalendar();
				Tienda latienda = tiendaService.findByNumero(ellpre.getNumero_tienda());
				if (latienda != null) {
					System.out.println("Fecha de la tienda: " + latienda.getFechaLPRE());
					cal.setTime(latienda.getFechaLPRE());
					cal.add(Calendar.MONTH, -1);
					if (UtilesFechas.esDiaHoyMasN(0, cal.getTime())) {
						System.out.println("La fecha de la tienda es la de hoy.");
					} else {
						// Actualizar con LPRE
						System.out.println("Hilo - Empiezo a actualizar con LPRE");
						laBellaProvService.cargarLPRE(ellpre);
						System.out.println("Hilo - Actualizado con LPRE " + ellpre.getNumero_tienda() + " - "
								+ ellpre.getNombreTienda());

					}
				
				}else {
					// Actualizar con LPRE
					System.out.println("Hilo - Empiezo a actualizar con LPRE");
					laBellaProvService.cargarLPRE(ellpre);
					System.out.println("Hilo - Actualizado con LPRE " + ellpre.getNumero_tienda() + " - "
							+ ellpre.getNombreTienda());
				}
			} else {
				// No hay fichero encontrado
				System.out.println("No he encontrado nada");

			}

			try {
				System.out.println("Hilo - Voy a dormir");
				Thread.sleep(60000 * 30);// Dormir 30 minutos.
				System.out.println("Hilo - Despertando");
			} catch (InterruptedException e) {
				System.out.println("Hilo - Algo ha fallado.");
			}
		}

	}

}