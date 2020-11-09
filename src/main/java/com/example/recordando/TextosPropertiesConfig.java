/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


/**
 *
 * @author luis
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:texto.properties")
})
public class TextosPropertiesConfig {
    
}
