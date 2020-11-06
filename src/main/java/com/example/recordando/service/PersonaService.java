/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.service;

import java.util.List;
import com.example.recordando.model.Persona;
/**
 *
 * @author luis
 */
public interface PersonaService 
{
    public List<Persona> listarPersonas();
    public void guardar                (Persona persona);
    public void eliminar               (Persona persona);
    public Persona encontrarPersona    (Persona persona);
}
