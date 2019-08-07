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

import com.frapecha.labella.model.Seccion;

/**
 *
 * @author thepuar
 */
@Component
public class SeccionValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Seccion.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Seccion laseccion = (Seccion) o;
        ValidationUtils.rejectIfEmpty(errors, "email", "required.email", "Necesito un email.");
        if (!isValidEmailAddress(laseccion.getEmail())) {
            errors.rejectValue("email","email.invalid", "Direccion de correo no valida.");
        }

    }

    public boolean isValidEmailAddress(String emailAddress) {
        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)[A-Z]{2,4}$";

        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

}
