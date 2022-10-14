package com.administracion.administracion.Controller;

import com.administracion.administracion.Modelo.Administrador;
import com.administracion.administracion.ServiceImpl.ServiceAdministradorImpl;
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
@RequestMapping(value = "/administrador")
public class AdministradorController {
    
    @Autowired
    private ServiceAdministradorImpl serviceAdministrador;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Administrador>> ListaAdministrador(){
        List<Administrador> lista = serviceAdministrador.getListaAdministrador();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Administrador> CrearAdministrador(@Valid @RequestBody Administrador 
            administrador,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Administrador crear = serviceAdministrador.crearAdministrador(administrador);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Administrador> ActualizarAdministrador(@RequestBody Administrador administrador){
        Administrador actualizar = serviceAdministrador.ActualizarAdministrador(administrador);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{idAdmin}")
    public ResponseEntity<String> EliminarAdministrador(@PathVariable("idAdmin") Long idAdmin){
        if(idAdmin != null){
            if( serviceAdministrador.EliminarAdministrador(idAdmin)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }
      
        return ResponseEntity.notFound().build();
    }
}