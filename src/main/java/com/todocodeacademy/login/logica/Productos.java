package com.todocodeacademy.login.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L; // Opcional pero recomendado

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a IDENTITY para compatibilidad con MySQL
    private int idProducto;

    private String codigo;
    private String nombre;
    private String color;
    private String dimension;
    private int precioVenta;
    private int stockDisponible;
    private int precioCompra;
    private String material; // Considerar si debería ser una relación

    @ManyToOne
    @JoinColumn(name = "fk_categoria") // Configuración de clave foránea
    private Categorias unCategoria;

    // Constructor sin parámetros
    public Productos() {
    }

    // Constructor con parámetros
    public Productos(int idProducto, String codigo, String nombre, String color, String dimension, int precioVenta,
                     int stockDisponible, int precioCompra, String material, Categorias unCategoria) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.dimension = dimension;
        this.precioVenta = precioVenta;
        this.stockDisponible = stockDisponible;
        this.precioCompra = precioCompra;
        this.material = material;
        this.unCategoria = unCategoria;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }



    public Categorias getUnCategoria() {
        return unCategoria;
    }

    public void setUnCategoria(Categorias unCategoria) {
        this.unCategoria = unCategoria;
    }
}
