package com.administracion.administracion.Controller;

import com.administracion.administracion.Modelo.Apartamento;
import com.administracion.administracion.ServiceImpl.ServiceApartamentoImpl;
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
@RequestMapping(value = "/apartamento")
public class ApartamentoController {
    
    @Autowired
    private ServiceApartamentoImpl serviceApartamento;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Apartamento>> ListaApartamento(){
        List<Apartamento> lista = serviceApartamento.getListaApartamento();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Apartamento> CrearApartamento(@Valid @RequestBody Apartamento 
            apartamento,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Apartamento crear = serviceApartamento.crearApartamento(apartamento);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Apartamento> ActualizarApartamento(@RequestBody Apartamento apartamento){
        Apartamento actualizar = serviceApartamento.ActualizarApartamento(apartamento);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{idApartamento}")
    public ResponseEntity<String> EliminarApartamento(@PathVariable("idApartamento") Long idApartamento){
        if(idApartamento != null){
            if( serviceApartamento.EliminarApartamento(idApartamento)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }      
        return ResponseEntity.notFound().build();
    }
}
