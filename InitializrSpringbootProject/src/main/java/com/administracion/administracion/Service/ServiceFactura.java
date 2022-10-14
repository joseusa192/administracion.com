package com.administracion.administracion.Service;

import com.administracion.administracion.Modelo.Factura;
import java.util.List;


public interface ServiceFactura {
    
    List<Factura> getListaFactura();
    Factura crearFactura(Factura factura);
    Factura ActualizarFactura(Factura factura);
    Boolean EliminarFactura(Long idFactura);
    
}
