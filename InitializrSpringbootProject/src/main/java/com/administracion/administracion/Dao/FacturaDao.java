package com.administracion.administracion.Dao;

import com.administracion.administracion.Modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaDao extends JpaRepository<Factura, Long> {
    
}
