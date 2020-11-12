/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author luis
 */
@Data
public class Vehicle
{
    @NotEmpty
    @Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    private String identificador;
    
    @NotEmpty
    @Size(min = 16, max = 16)
    private String serie;
    
    @NotEmpty
    private String placa;
    
    
}
