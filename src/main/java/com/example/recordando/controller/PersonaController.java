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
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Double saldoTotal = 0.0;
        for(Persona p : listAux)
        {
            saldoTotal += p.getSaldo();
        }
        log.info("Usuario que hizo login; " + user);
        log.info("Ejecutando el controlador persona tipo Spring mvc");
        model.addAttribute("listAux",listAux);
        model.addAttribute("saldoTotal",saldoTotal);
        model.addAttribute("totalClientes",listAux.size());
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
    
    
    
    
    /*http://localhost:8080/personas/string?texto=Hola%20Luis*/
    @GetMapping("/string")
    public String param(@RequestParam(name="texto", defaultValue = "No existe el parametro") String texto, Model model)
    {
        System.out.println("texto :: " + texto);
        model.addAttribute("resultado", "El texto enviado por la url es: " + texto);
        return "testPage";
    }
    
    
    //Elegante y moderno
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, Integer numero, Model model)
    {
        model.addAttribute("resultado", "El saludo es " + saludo +" y el numero es: " + numero);
        return "testPage";
    }
    
    
    //Arcaico, pero mas limpio
    @GetMapping("/mix-params-arc")
    public String param(HttpServletRequest request, Model model)
    {
        System.out.println("mix-params-arc");
        String saludo = request.getParameter("saludo");
        Integer numero = Integer.parseInt(request.getParameter("numero"));
        model.addAttribute("resultado", "El saludo es " + saludo +" y el numero es: " + numero);
        return "testPage";
    }
    
    
    //Otra forma de enviar parametros de la vista al controllador
    //http://localhost:8080/personas/otro/cualquier_valor
    @GetMapping("/otro/{texto}")
    public String variables(@PathVariable String texto, Model model)
    {
        model.addAttribute("titulo", "Recibir con PathVariable");
        model.addAttribute("miCadena", texto);
        return "variables/ver";
    }
    
    
    
    
    @GetMapping("/otro-mix/{texto}/{numero}")
    public String variables(@PathVariable String texto,
                            @PathVariable Integer numero,
                            Model model)
    {
        model.addAttribute("titulo", "Recibir con PathVariable");
        model.addAttribute("miCadena", texto);
        model.addAttribute("miNumero", numero);
        return "variables/ver";
    }
    
    
    
    
    
    
    
    
    
    
    //Es comun a todos lo metodos del controllador
    @ModelAttribute("cadenaGeneral")
    public String cadenaParaTodosLosMetodos()
    {
        return "Esta es la cadena general, es comun para todos los metodos del controlador";
    }
}
