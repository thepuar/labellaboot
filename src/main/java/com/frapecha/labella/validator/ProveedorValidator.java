/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.frapecha.labella.model.Proveedor;

/**
 *
 * @author thepuar
 */
@Component
public class ProveedorValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Proveedor.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Proveedor elproveedor = (Proveedor)o;
        //Persona de contacto

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombreContacto","required.nombreContacto", "Necesito una persona de contacto.");
        ValidationUtils.rejectIfEmpty(errors, "franco", "required.franco", "Necesito un franco.");
         ValidationUtils.rejectIfEmpty(errors, "telefono", "required.telefono", "Necesito un telefono de contacto.");
         if(!isValidEmailAddress(elproveedor.getEmail()))
             errors.rejectValue("email","email.invalid" ,"Direccion de correo no valida.");
    }
    
    public boolean isValidEmailAddress(String emailAddress){
        String expression="^[\\w\\-]([\\.\\w-])+[\\w]+@([\\w\\-]+\\.)[A-Z]{2,4}$";
                 
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }  
    
}
