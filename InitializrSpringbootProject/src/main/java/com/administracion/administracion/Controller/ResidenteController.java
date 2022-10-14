package com.administracion.administracion.Controller;

import com.administracion.administracion.Modelo.Residente;
import com.administracion.administracion.ServiceImpl.ServiceResidenteImpl;
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
@RequestMapping(value = "/residente")
public class ResidenteController {
    
    @Autowired
    private ServiceResidenteImpl serviceResidente;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Residente>> ListaResidente(){
        List<Residente> lista = serviceResidente.getListaResidente();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Residente> CrearResidente(@Valid @RequestBody Residente 
            residente,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Residente crear = serviceResidente.crearResidente(residente);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Residente> ActualizarResidente(@RequestBody Residente residente){
        Residente actualizar = serviceResidente.ActualizarResidente(residente);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{idResidente}")
    public ResponseEntity<String> EliminarResidente(@PathVariable("idResidente") Long idResidente){
        if(idResidente != null){
            if( serviceResidente.EliminarResidente(idResidente)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }
      
        return ResponseEntity.notFound().build();
    }
}
