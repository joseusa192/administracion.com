package com.administracion.administracion.ServiceImpl;

import com.administracion.administracion.Dao.UsuarioDao;
import com.administracion.administracion.Modelo.Usuario;
import com.administracion.administracion.Service.ServiceUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {

    @Autowired
    private UsuarioDao getDao;
    
    @Override
    public List<Usuario> getListaUsuario() {
        return getDao.findAll();
    }
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (usuario != null) {
            return getDao.save(usuario);
        }
        return null;
    }
    @Override
    public Usuario ActualizarUsuario(Usuario usuario) {
        if(usuario != null && usuario.getIdUsuario() != 0){
            Usuario usuarioBD = getDao.getReferenceById(usuario.getIdUsuario());
            if(usuarioBD != null){
                usuarioBD.setIdUsuario(usuario.getIdUsuario()==0?usuarioBD.getIdUsuario()
                        :usuarioBD.getIdUsuario()+usuarioBD.getIdUsuario());
                return getDao.save(usuarioBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarUsuario(Long idUsuario) {
          if(idUsuario != null && idUsuario != 0){
            Usuario usuarioBD = getDao.getReferenceById(idUsuario);
            if(usuarioBD != null){
                getDao.deleteById(idUsuario);
                 return true;
            }
          }
           return false;
    }  
  
}
