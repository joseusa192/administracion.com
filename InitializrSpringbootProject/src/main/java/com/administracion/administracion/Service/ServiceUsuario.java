package com.administracion.administracion.Service;

import com.administracion.administracion.Modelo.Usuario;
import java.util.List;


public interface ServiceUsuario {
    
    List<Usuario> getListaUsuario();
    Usuario crearUsuario(Usuario usuario);
    Usuario ActualizarUsuario(Usuario usuario);
    Boolean EliminarUsuario(Long idUsuario);
    
}
