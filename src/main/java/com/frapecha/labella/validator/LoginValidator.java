/*
ç * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.validator;

import com.frapecha.labella.model.Usuario;
import com.frapecha.labella.service.impl.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author thepuar
 */
@Component
public class LoginValidator implements Validator {
	
	@Autowired
	UsuarioService usuarioService;

    @Override
    public boolean supports(Class<?> type) {
        return Usuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ldap", "required.ldap", "Debes introducir un ldap");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "required.password", "Debes introducir una contraseña");
        
        Usuario usuario = (Usuario) o;
        String password = usuario.getPassword();
        Usuario usuariodb = usuarioService.findByLdap(usuario.getLdap());
        if (usuario==null ) {
        } else if (usuario == null) {
            errors.rejectValue("ldap", "ldap.invalid", "Usuario no encontrado");
        } else {
            if (!usuario.getPassword().equals(password)) {
                errors.rejectValue("password", "password.invalid", "Error en password");
            }
        }
    }

}
