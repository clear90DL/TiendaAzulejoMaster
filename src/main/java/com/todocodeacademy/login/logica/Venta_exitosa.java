package com.todocodeacademy.login.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Claudio De Jesus
 */
@Entity
public class Venta_exitosa implements Serializable{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_venta;
    private int codigo_producto;
    private String nombre_producto;
    private int precio_unitario;
    private int cantidad;
    private int descuento;
    private int total;
    private Date fecha;

    public Venta_exitosa() {
    }

    public Venta_exitosa(int id_venta, int codigo_producto, String nombre_producto, int precio_unitario, int cantidad, int descuento, int total, Date fecha) {
        this.id_venta = id_venta;
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
