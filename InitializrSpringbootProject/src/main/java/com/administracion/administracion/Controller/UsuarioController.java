package com.administracion.administracion.Controller;

import com.administracion.administracion.Modelo.Usuario;
import com.administracion.administracion.ServiceImpl.ServiceUsuarioImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins={"http://127.0.0.1:5500"})/*direccion ip de donde se hara el despliegue */
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private ServiceUsuarioImpl serviceUsuario;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Usuario>> ListaUsuario(){
        List<Usuario> lista = serviceUsuario.getListaUsuario();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Usuario> CrearUsuario(@Valid @RequestBody Usuario 
            usuario,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Usuario crear = serviceUsuario.crearUsuario(usuario);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Usuario> ActualizarUsuario(@RequestBody Usuario usuario){
        Usuario actualizar = serviceUsuario.ActualizarUsuario(usuario);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<String> EliminarUsuario(@PathVariable("idUsuario") Long idUsuario){
        if(idUsuario != null){
            if( serviceUsuario.EliminarUsuario(idUsuario)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }      
        return ResponseEntity.notFound().build();
    }
}