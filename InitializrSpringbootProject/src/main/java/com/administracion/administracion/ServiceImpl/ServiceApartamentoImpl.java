package com.administracion.administracion.ServiceImpl;

import com.administracion.administracion.Dao.ApartamentoDao;
import com.administracion.administracion.Modelo.Apartamento;
import com.administracion.administracion.Service.ServiceApartamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApartamentoImpl implements ServiceApartamento {

    @Autowired
    private ApartamentoDao getDao;
    
    @Override
    public List<Apartamento> getListaApartamento() {
        return getDao.findAll();
    }
    @Override
    public Apartamento crearApartamento(Apartamento apartamento) {
        if (apartamento != null) {
            return getDao.save(apartamento);
        }
        return null;
    }
    @Override
    public Apartamento ActualizarApartamento(Apartamento apartamento) {
        if(apartamento != null && apartamento.getIdApartamento() != 0){
            Apartamento apartamentoBD = getDao.getReferenceById(apartamento.getIdApartamento());
            if(apartamentoBD != null){
                apartamentoBD.setIdApartamento(apartamento.getIdApartamento()==0?apartamentoBD.getIdApartamento()
                        :apartamentoBD.getIdApartamento()+apartamentoBD.getIdApartamento());
                return getDao.save(apartamentoBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarApartamento(Long idApartamento) {
          if(idApartamento != null && idApartamento != 0){
            Apartamento apartamentoBD = getDao.getReferenceById(idApartamento);
            if(apartamentoBD != null){
                getDao.deleteById(idApartamento);
                 return true;
            }
          }
           return false;
    }  
  
}
