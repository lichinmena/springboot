/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.service;

import com.example.recordando.dao.PersonaDao;
import com.example.recordando.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class PersonaServiceImpl implements PersonaService
{
    
    @Autowired
    private PersonaDao personaDao;

    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() 
    {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) 
    {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona)
    {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) 
    {
        return personaDao.findById(persona.getId()).orElse(null);
    }
    
}
