/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.service;

import com.example.recordando.dao.UsuarioDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.recordando.model.Usuario;
import com.example.recordando.model.Rol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService
{
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        Usuario u = usuarioDao.findByUsername(username);
        if(u == null)
        {
            throw  new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> rolList = new ArrayList<GrantedAuthority>();
        
        for(Rol rol : u.getRoles())
        {
            rolList.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(u.getUsername(), u.getPassword(), rolList);
    }
    
}
