/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private PersonaDao personaDao;
    
    @GetMapping("/page")
    public String page(Model model)
    {
        String mensaje = "Hola mundo con thymeleaf";
        Persona persona = new Persona();
        persona.setNombre("Luis");
        persona.setApellido("Mena");
        persona.setEmail("luis_mena@outlook.com");
        persona.setTelefono("9999235689");
        
        Persona persona1 = new Persona();
        persona1.setNombre("Jose");
        persona1.setApellido("Chuc");
        persona1.setEmail("jose_chuc@outlook.com");
        persona1.setTelefono("9996235623");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Armando");
        persona2.setApellido("Chuc");
        persona2.setEmail("armando_chuc@outlook.com");
        persona2.setTelefono("9998562314");
        
        //List<Persona> listAux = Arrays.asList(persona1, persona2);
        
        List<Persona> list = new ArrayList<>();
        list.add(persona1);
        list.add(persona2);
        
        List<Persona> listAux = new ArrayList<>();
        personaDao.findAll().forEach(x -> listAux.add(x));
        
        
        log.info("Ejecutando el controlador page tipo Spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("msg", msg);
        model.addAttribute("persona",persona);
        model.addAttribute("personas",list);
        model.addAttribute("listAux",listAux);
        return "index";
    }
}
