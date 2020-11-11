/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author luis
 */
@Data
@Component
@RequestScope
public class Cliente 
{
    @Value("${cliente.nombre}")
    private String nombre;
    
    @Value("${cliente.apellido}")
    private String apellido;
}
