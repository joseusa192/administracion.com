package com.administracion.administracion.ServiceImpl;

import com.administracion.administracion.Dao.ResidenteDao;
import com.administracion.administracion.Modelo.Residente;
import com.administracion.administracion.Service.ServiceResidente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceResidenteImpl implements ServiceResidente {

    @Autowired
    private ResidenteDao getDao;
    
    @Override
    public List<Residente> getListaResidente() {
        return getDao.findAll();
    }
    @Override
    public Residente crearResidente(Residente residente) {
        if(residente != null){
            return getDao.save(residente);
        }
        return null;
    }
    @Override
    public Residente ActualizarResidente(Residente residente) {
        if(residente != null && residente.getIdResidente() != 0){
            Residente residenteBD = getDao.getReferenceById(residente.getIdResidente());
            if(residenteBD != null){
                residenteBD.setIdResidente(residente.getIdResidente()==0?residenteBD.getIdResidente()
                        :residenteBD.getIdResidente()+residenteBD.getIdResidente());
                return getDao.save(residenteBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarResidente(Long idResidente) {
          if(idResidente != null && idResidente != 0){
            Residente residenteBD = getDao.getReferenceById(idResidente);
            if(residenteBD != null){
                getDao.deleteById(idResidente);
                 return true;
            }
          }
           return false;
    }  
   
}