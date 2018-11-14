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
public class Administrador {

    int id;
    String rut;
    String nombre;
    String contrasenia;
    Rol rol;

    public Administrador() {
    }

    public Administrador(int id, String rut, String nombre, String contrasenia, Rol rol) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
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
        return "Administrador{" + "id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", rol=" + rol + '}';
    }
    
    

}
