/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author luis
 */
@Controller
@Slf4j
public class WithThymeleaf 
{
    @Value("${index.msg}")
    private String msg;
    
    @GetMapping("/page")
    public String page(Model model)
    {
        String mensaje = "Hola mundo con thymeleaf";
        log.info("Ejecutando el controlador page tipo Spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("msg", msg);
        return "index";
    }
}
