package com.administracion.administracion.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario") //nombre de referencia en base de datos
public class Usuario {
    
    //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria inventario , con generacion automatica
    @Column(name = "idUsuario") //nombre de la columna en base de datos
    private Long idUsuario; 
    
    @Column(name = "documento")
    @NotNull(message = "El campo DOCUMENTO no puede estar null")
    private Long documento;
    
    @Column(name = "nombre")
    @NotNull(message = "El campo NOMBRE no puede estar null")
    private String nombre;
    
    @Column(name = "apellido")
    @NotNull(message = "El campo APELLIDO no puede estar null")
    private String apellido;
    
    @Column(name = "telefono")
    @NotNull(message = "El campo TELEFONO no puede estar null")
    private String telefono;
    
    @Column(name = "correo")
    @NotNull(message = "El campo CORREO no puede estar null")
    private String correo;
    
    @Column(name = "rol")
    @NotNull(message = "El campo ROL no puede estar null")
    private String rol;
 

    public Usuario() {       
    }
    
    //Metodos Getter
    public Long getIdUsuario() {
        return idUsuario;
    }
    public Long getDocumento() {
        return documento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public String getRol() {
        return rol;
    }
    
    //Metodos Setter
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setDocumento(Long documento) {
        this.documento = documento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
     
}