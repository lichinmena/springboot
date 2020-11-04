/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@RestController
@Slf4j
public class ControladorInicio 
{
    @GetMapping("/")
    public String inicio()
    {
        log.info("Ejecutando inicio");
        log.debug("Mas detalle del controlador");
        return "Hola mundo con Spring";
    }
    
    
    
}
