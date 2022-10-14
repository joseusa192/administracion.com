package com.administracion.administracion.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "residente") //nombre de referencia en base de datos
public class Residente {
    
    //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria inventario , con generacion automatica
    @Column(name = "idResidente") //nombre de la columna en base de datos
    private Long idResidente; 
  
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUsuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario; // 
    
    public Residente() {     
    }
    
    //Metodos Getter
    public Long getIdResidente() {
        return idResidente;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    
    //Metodos Setter
    public void setIdResidente(Long idResidente) {
        this.idResidente = idResidente;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
