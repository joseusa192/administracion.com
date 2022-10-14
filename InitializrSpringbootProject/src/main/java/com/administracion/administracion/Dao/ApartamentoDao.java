package com.administracion.administracion.Dao;

import com.administracion.administracion.Modelo.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApartamentoDao extends JpaRepository<Apartamento, Long> {
    
}
