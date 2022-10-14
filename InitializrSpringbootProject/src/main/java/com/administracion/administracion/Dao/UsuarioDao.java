package com.administracion.administracion.Dao;

import com.administracion.administracion.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
}