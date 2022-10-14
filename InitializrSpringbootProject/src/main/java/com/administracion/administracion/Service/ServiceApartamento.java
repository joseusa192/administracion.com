package com.administracion.administracion.Service;

import com.administracion.administracion.Modelo.Apartamento;
import java.util.List;


public interface ServiceApartamento {
    
    List<Apartamento> getListaApartamento();
    Apartamento crearApartamento(Apartamento apartamento);
    Apartamento ActualizarApartamento(Apartamento apartamento);
    Boolean EliminarApartamento(Long idApartamento);
    
}
