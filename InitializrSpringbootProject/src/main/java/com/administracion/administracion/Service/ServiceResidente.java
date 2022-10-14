package com.administracion.administracion.Service;

import com.administracion.administracion.Modelo.Residente;
import java.util.List;


public interface ServiceResidente {
    
    List<Residente> getListaResidente();
    Residente crearResidente(Residente residente);
    Residente ActualizarResidente(Residente residente);
    Boolean EliminarResidente(Long idResidente);
    
}
