/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.frapecha.labella.model.Etiqueta;

/**
 *
 * @author thepuar
 */
@Component
public class EtiquetaValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Etiqueta.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Etiqueta laetiqueta = (Etiqueta)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreEtiqueta", "required.nombreEtiqueta", "Necesito una descripción de la etiqueta");
        ValidationUtils.rejectIfEmpty(errors, "numSeccion", "required.numSeccion", "Necesito un número de sección");
    }
    
}
