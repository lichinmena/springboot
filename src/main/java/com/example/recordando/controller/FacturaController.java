/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.recordando.model.Factura;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author luis
 */
@Controller
@RequestMapping("/factura")
@Slf4j
public class FacturaController
{
    @Autowired
    private Factura factura;
    
    @GetMapping("/ver")
    public String ver(Model model)
    {
        log.info("estas en /factura/ver/");
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Ejemplo Factura con inyección de dependencia");
        return "factura/ver";
        
    }
    
    
}
