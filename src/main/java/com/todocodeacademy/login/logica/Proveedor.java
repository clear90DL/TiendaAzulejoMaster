package com.todocodeacademy.login.logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PROVEEDORES") // Especifica el nombre exacto de la tabla
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    // Datos generales
    @Column(name = "NOMBRE_PROVEEDOR", length = 100, nullable = false)
    private String nombreProveedor;
    
    @Column(name = "NOMBRE_CONTACTO", length = 100)
    private String nombreContacto;
    
    @Column(name = "TIPO_PROVEEDOR", length = 50)
    private String tipoProveedor;

    // Datos de contacto
    @Column(name = "TELEFONO1", length = 20)
    private String telefono1;
    
    @Column(name = "TELEFONO2", length = 20)
    private String telefono2;
    
    @Column(name = "CORREO", length = 100)
    private String correo;

    // Datos fiscales
    @Column(name = "RFC", length = 20)
    private String rfc;

    // Dirección
    @Column(name = "CALLE", length = 100)
    private String calle;
    
    @Column(name = "NUMERO_INTERIOR", length = 20)
    private String numeroInterior;
    
    @Column(name = "NUMERO_EXTERIOR", length = 20)
    private String numeroExterior;
    
    @Column(name = "COLONIA", length = 100)
    private String colonia;
    
    @Column(name = "MUNICIPIO", length = 100)
    private String municipio;
    
    @Column(name = "CIUDAD", length = 100)
    private String ciudad;
    
    @Column(name = "CODIGO_POSTAL", length = 10)
    private String codigoPostal;
    
    @Column(name = "REFERENCIA", length = 200)
    private String referencia;

    // Opcional: Administración
    @Column(name = "ESTADO", length = 20)
    private String estado = "ACTIVO"; // Valor por defecto
    
    @Column(name = "FECHA_REGISTRO")
    private String fechaRegistro;

    // Constructor vacío requerido por JPA
    public Proveedor() {
    }

    // Constructor completo (opcional si quieres usarlo)
    public Proveedor(int id, String nombreProveedor, String nombreContacto, String tipoProveedor,
                     String telefono1, String telefono2, String correo, String rfc,
                     String calle, String numeroInterior, String numeroExterior, String colonia,
                     String municipio, String ciudad, String codigoPostal, String referencia,
                     String estado, String fechaRegistro) {

        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.nombreContacto = nombreContacto;
        this.tipoProveedor = tipoProveedor;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.rfc = rfc;
        this.calle = calle;
        this.numeroInterior = numeroInterior;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
        this.municipio = municipio;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.referencia = referencia;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
