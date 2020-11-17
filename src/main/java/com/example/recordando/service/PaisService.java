/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.service;
import com.example.recordando.model.Pais;
import java.util.List;

/**
 *
 * @author luis
 */
public interface PaisService 
{
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}
