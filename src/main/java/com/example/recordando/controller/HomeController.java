/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author luis
 */
@Controller("/home")
public class HomeController 
{
    //Si cambia la ruta
    @GetMapping("/home")
    public String home()
    {
        return "redirect:/personas/";
    }
    
    
    @GetMapping("/google")
    public String google()
    {
        return "redirect:https://google.com.mx";
    }
    
    
    //No cambia la ruta, es para rutas propias del proyecto, ejecuta request distpacher
    @GetMapping("/home2")
    public String home2()
    {
        return "forward:/personas/";
    }
}
