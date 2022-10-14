package com.administracion.administracion.Dao;

import com.administracion.administracion.Modelo.Residente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResidenteDao extends JpaRepository<Residente, Long> {
    
}
