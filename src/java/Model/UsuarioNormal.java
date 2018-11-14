/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alumno
 */
public class UsuarioNormal {
    
    int id;
    String rut;
    String nombre;
    String contrasenia;
    Rol rol;

    public UsuarioNormal(int id, String rut, String nombre, String conrasenia, Rol rol) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.contrasenia = conrasenia;
        this.rol = rol;
    }

    public UsuarioNormal() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioNormal{" + "id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", conrasenia=" + contrasenia + ", rol=" + rol + '}';
    }
    
    
    
    
}
