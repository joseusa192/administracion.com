package com.administracion.administracion.Service;

import com.administracion.administracion.Modelo.Administrador;
import java.util.List;


public interface ServiceAdministrador {
    
    List<Administrador> getListaAdministrador();
    Administrador crearAdministrador(Administrador administrador);
    Administrador ActualizarAdministrador(Administrador administrador);
    Boolean EliminarAdministrador(Long idAdmin);
    
}