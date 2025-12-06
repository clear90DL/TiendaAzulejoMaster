package com.todocodeacademy.login.logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CLIENTES")
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado de SEQUENCE a IDENTITY para MySQL
    @Column(name = "ID")
    private int id;

    // Datos personales
    @Column(name = "primer_nombre")
    private String primerNombre;
    
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno")  // ¡ESTA ES LA COLUMNA QUE FALTA!
    private String apellidoMaterno;
    
    @Column(name = "Tipo_de_cliente")
    private String tipoDeCliente;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "correo_electronico")
    private String correoElectronico;
    
    @Column(name = "rfc")
    private String rfc;

    // Dirección desglosada
    @Column(name = "calle")
    private String calle;
    
    @Column(name = "numeroExterior")
    private String numeroExterior;
    
    @Column(name = "numeroInterior")
    private String numeroInterior;
    
    @Column(name = "colonia")
    private String colonia;
    
    @Column(name = "codigoPostal")
    private String codigoPostal;
    
    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "referencia")
    private String referencia;

    
    public Clientes() {
    }

    public Clientes(int id, String primerNombre, String segundoNombre, String apellidoPaterno, 
                    String apellidoMaterno, String tipoDeCliente, String telefono, 
                    String correoElectronico, String rfc, String calle, String numeroExterior, 
                    String numeroInterior, String colonia, String codigoPostal, 
                    String municipio, String ciudad, String referencia) {

        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDeCliente = tipoDeCliente;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.rfc = rfc;

        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.municipio = municipio;
        this.ciudad = ciudad;
        this.referencia = referencia;
    }

    // -------- GETTERS Y SETTERS --------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
