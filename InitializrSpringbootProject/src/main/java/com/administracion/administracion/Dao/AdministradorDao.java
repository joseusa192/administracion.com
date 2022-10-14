package com.administracion.administracion.Dao;

import com.administracion.administracion.Modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministradorDao extends JpaRepository<Administrador, Long> {
    
}