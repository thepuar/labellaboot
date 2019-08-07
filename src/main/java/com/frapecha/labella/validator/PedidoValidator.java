/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frapecha.labella.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.frapecha.labella.model.Pedido;

/**
 *
 * @author thepuar
 */
@Component
public class PedidoValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Pedido.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pedido elpedido = (Pedido)o;
        
    }
    
}
