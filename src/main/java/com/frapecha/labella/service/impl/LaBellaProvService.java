package com.frapecha.labella.service.impl;

import com.frapecha.labella.fichero.model.LPRE;
import com.frapecha.labella.model.Tienda;

public interface LaBellaProvService {
	
	public void init() ;

	public void cargarLPREFromDB();
	
	public void cargarLPRE2(LPRE ellpre);
	
	public void cargarLPRE(LPRE ellpre);
	
	public Tienda crearTienda(String nombre, int numero);
	
	public void crearSeccionesTienda(Tienda latienda);


}
