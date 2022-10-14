package com.administracion.administracion.ServiceImpl;

import com.administracion.administracion.Dao.FacturaDao;
import com.administracion.administracion.Modelo.Factura;
import com.administracion.administracion.Service.ServiceFactura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacturaImpl implements ServiceFactura {

    @Autowired
    private FacturaDao getDao;
    
    @Override
    public List<Factura> getListaFactura() {
        return getDao.findAll();
    }
    @Override
    public Factura crearFactura(Factura factura) {
        if(factura != null){
            return getDao.save(factura);
        }
        return null;
    }
    @Override
    public Factura ActualizarFactura(Factura factura) {
        if(factura != null && factura.getIdFactura() != 0){
            Factura facturaBD = getDao.getReferenceById(factura.getIdFactura());
            if(facturaBD != null){
                facturaBD.setIdFactura(factura.getIdFactura()==0?facturaBD.getIdFactura()
                        :facturaBD.getIdFactura()+facturaBD.getIdFactura());
                return getDao.save(facturaBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarFactura(Long idFactura) {
          if(idFactura != null && idFactura != 0){
            Factura facturaBD = getDao.getReferenceById(idFactura);
            if(facturaBD != null){
                getDao.deleteById(idFactura);
                 return true;
            }
          }
           return false;
    }  
   
}
