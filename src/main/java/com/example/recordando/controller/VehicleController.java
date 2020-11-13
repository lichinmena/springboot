/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.controller;

import com.example.recordando.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.recordando.model.Vehicle;
import com.example.recordando.validation.VehicleValidator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Autowired
    private VehicleValidator validator;
    
    
/*
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        //binder.setValidator(validator);
          binder.addValidators(validator);
    }
*/
    
    @GetMapping("/new")
    public String newVehicle(Model model)
    {
        Vehicle vehicle = new Vehicle();
        //vehicle.setIdentificador("123456789");
        vehicle.setIdentificador("12.456.789-K");
        vehicle.setPlaca("GAS-123");
        vehicle.setSerie("1234567812345678");
        model.addAttribute("titulo","Formulario de vehículo");
        model.addAttribute("vehicle", vehicle);
        return "vehicles/form";
    }
    
    
    @PostMapping("/save")
    public String guardar(@Valid Vehicle vehicle, BindingResult result, Model model, SessionStatus status)
    {
        validator.validate(vehicle, result);
        model.addAttribute("titulo", "Resultado del formulario vehículo");
        
        if(result.hasErrors())
        {
            return "vehicles/form";
        }
        
        model.addAttribute("vehicle", vehicle);
        status.setComplete();
        return "vehicles/show";
    }
    
    
    
    @ModelAttribute("paises")
    public List<String> paises()
    {
        return Arrays.asList("México", "España", "Chile", "Perú", "Venenzuela");
    }
    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMapa()
    {
       Map<String, String> paises = new HashMap<>();
       paises.put("ES", "España");
       paises.put("MX", "México");
       paises.put("CL", "Chile");
       paises.put("AR", "Argentina");
       paises.put("PE", "Peru");
       return paises;
    }
    
    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises()
    {
        return  Arrays.asList(new Pais(1, "ES", "España"),
                  new Pais(2, "MX", "Mexico"),
                  new Pais(3, "AR", "Argentina"),
                  new Pais(4, "CH", "Chile")
                );
    }
    
}
