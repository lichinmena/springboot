/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author luis
 */
public class EncriptarPassword 
{
    public static void main(String[] args)
    {
        
        String password = "123";
        System.out.println("password: " + password);
        System.out.println("password encriptado: " + encriptarPassword(password));
        
    }
    
    public static String encriptarPassword(String password)
    {
        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
        return enconder.encode(password);
    }
}
