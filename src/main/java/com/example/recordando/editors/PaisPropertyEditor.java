/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.editors;

import com.example.recordando.service.PaisService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis
 */
@Component
public class PaisPropertyEditor extends PropertyEditorSupport
{
    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException 
    {
         System.out.println("==> idString :: " + idString);
        if(idString != null && idString.length() > 0)
        {
            try 
            {
                Integer id = Integer.parseInt(idString);
                this.setValue(paisService.obtenerPorId(id));
            } 
            catch (NumberFormatException e) 
            {
                setValue(null);
            }
        }
        else
        {
            setValue(null);
        }
       
    }
    
}
