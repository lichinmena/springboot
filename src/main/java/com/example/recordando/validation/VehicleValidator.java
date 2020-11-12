/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.recordando.model.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author luis
 */
@Component
public class VehicleValidator implements Validator
{

    @Override
    public boolean supports(Class<?> type) 
    {
        return Vehicle.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Vehicle v = (Vehicle)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serie", "NotEmpty.vehicle.serie");
        if(!v.getIdentificador().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"))
        {
            errors.rejectValue("identificador", "pattern.vehicle.identificador");
        }
    }
    
}
