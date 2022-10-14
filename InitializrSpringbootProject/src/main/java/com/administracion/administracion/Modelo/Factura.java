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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura") //nombre de referencia en base de datos
public class Factura {
    
    //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria inventario , con generacion automatica
    @Column(name = "idFactura") //nombre de la columna en base de datos
    private Long idFactura;
    
    @Column(name = "fechaFactura")
    @NotNull(message = "El campo FECHA FACTURA no puede estar null")
    private String fechaFactura;
    
    @Column(name = "fechaPago")
    @NotNull(message = "El campo FECHA PAGO no puede estar null")
    private String fechaPago;
    
    @Column(name = "fechaFinalPago")
    @NotNull(message = "El campo FECHA FINAL PAGO no puede estar null")
    private String fechaFinalPago;
  
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idResidente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario residente; //
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idAdmin")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Administrador administrador; // 
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idApartamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Apartamento apartamento; // 
    
    public Factura() {     
    }
    
    //Metodos Getter
    public Long getIdFactura() {
        return idFactura;
    }
    public Usuario getResidente() {
        return residente;
    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public Apartamento getApartamento() {
        return apartamento;
    }
    public String getFechaFactura() {
        return fechaFactura;
    }
    public String getFechaPago(){
        return fechaPago;
    }
    public String getFechaFinalPago() {
        return fechaFinalPago;
    }
    
    //Metodos Setter
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }
    public void setResidente(Usuario residente) {
        this.residente = residente;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    } 
    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    public void setFechaFinalPago(String fechaFinalPago) {
        this.fechaFinalPago = fechaFinalPago;
    }
    
}