package com.todocodeacademy.login.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Claudio De Jesus
 */
 @Entity
public class Categorias implements Serializable{
     
   @Id
  // @GeneratedValue(strategy=GenerationType.AUTO)
   
    private int id;
    private String nombre;
    private String descripcion;
    
     @OneToMany(mappedBy="unCategoria")
    private List<Productos>listaProductos;

    public Categorias(int id, String nombre, String descripcion, List<Productos> listaProductos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaProductos = listaProductos;
    }

    public Categorias() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
}
