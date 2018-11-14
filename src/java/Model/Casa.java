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
public class Casa {
    
    int id;
    String direccion;
    int metrosCuadrados;
    String rutPropietario;
    String nomPropietario;
    int avaluoFiscal;

    public Casa() {
    }

    public Casa(int id, String direccion, int metrosCuadrados, String rutPropietario, String nomPropietario, int avaluoFiscal) {
        this.id = id;
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.rutPropietario = rutPropietario;
        this.nomPropietario = nomPropietario;
        this.avaluoFiscal = avaluoFiscal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getRutPropietario() {
        return rutPropietario;
    }

    public void setRutPropietario(String rutPropietario) {
        this.rutPropietario = rutPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public int getAvaluoFiscal() {
        return avaluoFiscal;
    }

    public void setAvaluoFiscal(int avaluoFiscal) {
        this.avaluoFiscal = avaluoFiscal;
    }

    @Override
    public String toString() {
        return "Casa{" + "id=" + id + ", direccion=" + direccion + ", metrosCuadrados=" + metrosCuadrados + ", rutPropietario=" + rutPropietario + ", nomPropietario=" + nomPropietario + ", avaluoFiscal=" + avaluoFiscal + '}';
    }
    
    

}
