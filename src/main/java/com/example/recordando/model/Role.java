/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.model;

import lombok.Data;

/**
 *
 * @author luis
 */
@Data
public class Role
{
    private Integer id;
    private String  nombre;
    private String  role;

    public Role()
    {
    }
    
    public Role(Integer id, String nombre, String role) {
        this.id = id;
        this.nombre = nombre;
        this.role = role;
    }
    
    
}
