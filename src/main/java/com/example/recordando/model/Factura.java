/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.model;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author luis
 */
@Data
@Component
@RequestScope
public class Factura 
{
    @Value("${factura.descripcion}")
    private String descripcion;
    
    @Autowired
    private Cliente cliente;
    
    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;
    
    //Se ejecuta despues de crear el objeto e inyectar las dependencias
    @PostConstruct
    public void inicializar()
    {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }
    
    @PreDestroy
    public void destruir()
    {
        System.out.println("===> metodo destruir".concat(descripcion));
    }
}
