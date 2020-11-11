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
public class ItemFactura
{
    private Producto producto;
    private Integer cantidad;

    public ItemFactura(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public Integer calcularImporte()
    {
        return cantidad * producto.getPrecio();
    }
    
}
