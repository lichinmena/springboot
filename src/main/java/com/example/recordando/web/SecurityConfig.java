/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author luis
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN","USER")
                .and()
                .withUser("user").password("{noop}123").roles("USER");
                
                
    }
    
    @Override
    protected  void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/","/personas/editar/**", "/personas/agregar/**","/personas/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/","personas/")
                .hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/",true).and().exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}
