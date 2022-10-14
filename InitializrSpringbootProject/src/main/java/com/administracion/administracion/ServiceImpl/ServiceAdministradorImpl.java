package com.administracion.administracion.ServiceImpl;

import com.administracion.administracion.Dao.AdministradorDao;
import com.administracion.administracion.Modelo.Administrador;
import com.administracion.administracion.Service.ServiceAdministrador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdministradorImpl implements ServiceAdministrador {

    @Autowired
    private AdministradorDao getDao;
    
    @Override
    public List<Administrador> getListaAdministrador() {
        return getDao.findAll();
    }
    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        if(administrador != null){
            return getDao.save(administrador);
        }
        return null;
    }
    @Override
    public Administrador ActualizarAdministrador(Administrador administrador) {
        if(administrador != null && administrador.getIdAdmin() != 0){
            Administrador administradorBD = getDao.getReferenceById(administrador.getIdAdmin());
            if(administradorBD != null){
                administradorBD.setIdAdmin(administrador.getIdAdmin()==0?administradorBD.getIdAdmin()
                        :administradorBD.getIdAdmin()+administradorBD.getIdAdmin());
                return getDao.save(administradorBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarAdministrador(Long idAdmin) {
          if(idAdmin != null && idAdmin != 0){
            Administrador administradorBD = getDao.getReferenceById(idAdmin);
            if(administradorBD != null){
                getDao.deleteById(idAdmin);
                 return true;
            }
          }
           return false;
    }  
   
}