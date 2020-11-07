/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.controller;

import com.example.recordando.model.Persona;
import com.example.recordando.service.PersonaService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author luis
 */
@Controller
@RequestMapping("/personas")
@Slf4j
public class PersonaController 
{
        @Autowired
    private PersonaService personaService;
    
    /**
     *
     * @param model
     * @param user
     * @return
     */
    @GetMapping("/")
    public String persona(Model model, @AuthenticationPrincipal User user)
    {
        List<Persona> listAux = new ArrayList<>();
        //personaService.findAll.forEach(x -> listAux.add(x));
        listAux = personaService.listarPersonas();
        log.info("Usuario que hizo login; " + user);
        log.info("Ejecutando el controlador persona tipo Spring mvc");
        model.addAttribute("listAux",listAux);
        return "persona";
    }
    
    
    @GetMapping("/agregar")
    public String agregar(Persona persona)
    {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores)
    {
        if(errores.hasErrors())
        {
            return "modificar";
        }
        
        log.info("/Guardar");
        log.info(persona.getNombre());
        log.info(persona.getApellido());
        log.info(persona.getEmail());
        log.info(persona.getTelefono());
        
        personaService.guardar(persona);
        return "redirect:/personas/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model)
    {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String elminar(Persona persona)
    {
        personaService.eliminar(persona);
        return "redirect:/personas/";
    }
}
