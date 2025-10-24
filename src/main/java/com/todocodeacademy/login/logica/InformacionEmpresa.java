package com.todocodeacademy.login.logica;

/**
 *
 * @author Usuario
 */
public class InformacionEmpresa {
    private int id_empresa;
   private String nombreEmpresa;
private String direccion;
private String email;
private String telefono;
private String webSite;
private String logoImagen;

    public InformacionEmpresa(int id_empresa,String nombreEmpresa, String direccion, String email, String telefono, String webSite, String logoImagen) {
        this.id_empresa=id_empresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.webSite = webSite;
        this.logoImagen = logoImagen;
    }

    public InformacionEmpresa() {
    }

@Override
public String toString() {
    return "Empresa{" +
            "nombre='" + nombreEmpresa + '\'' +
            ", direccion='" + direccion + '\'' +
            ", email='" + email + '\'' +
            ", telefono='" + telefono + '\'' +
            ", webSite='" + webSite + '\'' +
            ", logoImagen='" + logoImagen + '\'' +
            '}';
}

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }



    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getLogoImagen() {
        return logoImagen;
    }

    public void setLogoImagen(String logoImagen) {
        this.logoImagen = logoImagen;
    }


   
    
    
    
}
