package com.administracion.administracion.Controller;

import com.administracion.administracion.Modelo.Factura;
import com.administracion.administracion.ServiceImpl.ServiceFacturaImpl;
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
@RequestMapping(value = "/factura")
public class FacturaController {
    
    @Autowired
    private ServiceFacturaImpl serviceFactura;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Factura>> ListaFactura(){
        List<Factura> lista = serviceFactura.getListaFactura();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Factura> CrearFactura(@Valid @RequestBody Factura 
            factura,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Factura crear = serviceFactura.crearFactura(factura);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Factura> ActualizarFactura(@RequestBody Factura factura){
        Factura actualizar = serviceFactura.ActualizarFactura(factura);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{idFactura}")
    public ResponseEntity<String> EliminarFactura(@PathVariable("idFactura") Long idFactura){
        if(idFactura != null){
            if( serviceFactura.EliminarFactura(idFactura)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }
      
        return ResponseEntity.notFound().build();
    }
}