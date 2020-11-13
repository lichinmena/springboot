/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.model;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author luis
 */
@Data
public class Vehicle
{
    //@NotEmpty
    //@Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    private String identificador;
    
    //@NotEmpty
    //@Size(min = 16, max = 16)
    private String serie;
    
    //@NotBlank
    @NotEmpty
    private String placa;
    
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Past
    //@Future
    private Date fechaNacimiento;
    
    
}
