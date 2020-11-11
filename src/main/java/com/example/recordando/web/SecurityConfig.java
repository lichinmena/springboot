/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author luis
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    };
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception
    {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN","USER")
                .and()
                .withUser("user").password("{noop}123").roles("USER");
                
                
    }
*/
    
    @Override
    protected  void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/factura/**").permitAll()
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
