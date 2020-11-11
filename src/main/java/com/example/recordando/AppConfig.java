/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.recordando.model.ItemFactura;
import com.example.recordando.model.Producto;
import java.util.Arrays;
/**
 *
 * @author luis
 */
@Configuration
public class AppConfig
{
    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems()
    {
        Producto p1 = new Producto("Camara Sony",100);
        Producto p2 = new Producto("Bicicleta Bianchi aro 26",200);
        ItemFactura linea1 = new ItemFactura(p1,2);
        ItemFactura linea2 = new ItemFactura(p2,4);
        return Arrays.asList(linea1, linea2);
        
    }
    
    
    
    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina()
    {
        Producto p1 = new Producto("Monitor LG LCD 24",250);
        Producto p2 = new Producto("Notebook Asus",500);
        Producto p3 = new Producto("Impresora HP",500);
        Producto p4 = new Producto("Escritorio de oficina",300);
        ItemFactura linea1 = new ItemFactura(p1,2);
        ItemFactura linea2 = new ItemFactura(p2,1);
        ItemFactura linea3 = new ItemFactura(p3,1);
        ItemFactura linea4 = new ItemFactura(p4,1);
        return Arrays.asList(linea1, linea2, linea3, linea4);
        
    }
}
