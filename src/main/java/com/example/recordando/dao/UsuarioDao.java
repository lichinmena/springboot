/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.recordando.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.recordando.model.Usuario;
/**
 *
 * @author luis
 */

public interface UsuarioDao  extends JpaRepository<Usuario, Long>
{
    Usuario findByUsername(String username);
}
