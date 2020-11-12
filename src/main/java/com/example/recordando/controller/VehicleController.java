/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.recordando.model.Vehicle;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
/**
 *
 * @author luis
 */
@Controller
@RequestMapping("/vehicles")
@SessionAttributes("vehicle")
public class VehicleController 
{
    @GetMapping("/new")
    public String newVehicle(Model model)
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setIdentificador("123456789");
        vehicle.setPlaca("GAS-123");
        vehicle.setSerie("1234567812345678");
        model.addAttribute("titulo","Formulario de vehículo");
        model.addAttribute("vehicle", vehicle);
        return "vehicles/form";
    }
    
    
    @PostMapping("/save")
    public String guardar(@Valid Vehicle vehicle, BindingResult result, Model model, SessionStatus status)
    {
        model.addAttribute("titulo", "Resultado del formulario vehículo");
        
        if(result.hasErrors())
        {
            return "vehicles/form";
        }
        
        model.addAttribute("vehicle", vehicle);
        status.setComplete();
        return "vehicles/show";
    }
    
}
