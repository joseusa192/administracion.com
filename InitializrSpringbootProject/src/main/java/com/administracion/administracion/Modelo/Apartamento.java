package com.administracion.administracion.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apartamento") //nombre de referencia en base de datos
public class Apartamento {
    
    //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria inventario , con generacion automatica
    @Column(name = "idApartamento") //nombre de la columna en base de datos
    private Long idApartamento; 
    
    @Column(name = "descripcion")
    @NotNull(message = "El campo DESCRIPCION no puede estar null")
    private String descripcion;
    
    @Column(name = "numero")
    @NotNull(message = "El campo NUMERO no puede estar null")
    private String numero;
    
    @Column(name = "serv_basicos")
    @NotNull(message = "El campo SERVICIOS BASICOS no puede estar null")
    private String serv_basicos;
    
    @Column(name = "serv_secundarios")
    @NotNull(message = "El campo SERVICIOS SECUNDARIOS no puede estar null")
    private String serv_secundarios;
 
    public Apartamento() {       
    }
    
    //Metodos Getter
    public Long getIdApartamento() {
        return idApartamento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNumero() {
        return numero;
    }
    public String getServ_basicos() {
        return serv_basicos;
    }
    public String getServ_secundarios() {
        return serv_secundarios;
    }
    
    //Metodos Setter
    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setServ_basicos(String serv_basicos) {
        this.serv_basicos = serv_basicos;
    }
    public void setServ_secundarios(String serv_secundarios) {
        this.serv_secundarios = serv_secundarios;
    }
    
}
