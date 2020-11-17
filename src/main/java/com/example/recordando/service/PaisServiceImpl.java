/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.service;

import com.example.recordando.model.Pais;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Service
public class PaisServiceImpl implements PaisService
{
    private List<Pais> lista;
    
    public PaisServiceImpl()
    {
        this.lista =  Arrays.asList(new Pais(1, "ES", "España"),
                  new Pais(2, "MX", "Mexico"),
                  new Pais(3, "AR", "Argentina"),
                  new Pais(4, "CH", "Chile"),
                  new Pais(5, "PE", "Peru")
                );
    }
    
    @Override
    public List<Pais> listar() 
    {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) 
    {
        Pais  resultado = null;
        for(Pais pais : this.lista)
        {
            if(Objects.equals(id, pais.getId()))
            {
              resultado = pais;
              break;
            }
        }
        return resultado;
    }
    
}
