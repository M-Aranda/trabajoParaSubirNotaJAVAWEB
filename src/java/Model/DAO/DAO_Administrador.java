/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Administrador;
import Model.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class DAO_Administrador extends Conexion implements DAO<Administrador> {

    public DAO_Administrador() throws ClassNotFoundException, SQLException {
        super("ejercicioParaSubirNotaJavaWeb");
    }

    @Override
    public void create(Administrador ob) throws SQLException {
        ejecutar("INSERT INTO administrador VALUES (NULL, '" + ob.getRut() + "', '" + ob.getNombre() + "', '" + ob.getContrasenia() + "', '" + ob.getRol().getId() + "' ) ");
    }

    @Override
    public List<Administrador> read() throws SQLException {

        List<Administrador> lista = new ArrayList<>();
        try {
            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM administrador");

            Administrador a = null;

            while (rs.next()) {
                a = new Administrador();
                a.setId(rs.getInt(1));
                a.setRut(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setContrasenia(rs.getString(4));
                a.setRol(dr.findById(rs.getInt(5)));

                lista.add(a);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return lista;
    }

    @Override
    public void update(Administrador ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE FROM administrador WHERE id=" + id + " ");
    }
    
    public Boolean adminCorrecto(String rut, String contrasenia) throws SQLException {
        Boolean datosCorrectos = false;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM administrador WHERE rut='" + rut + "' AND contrasenia='" + contrasenia + "'  ");

            Administrador a = null;

            while (rs.next()) {
                a = new Administrador();
                a.setId(rs.getInt(1));
                a.setRut(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setContrasenia(rs.getString(4));
                a.setRol(dr.findById(rs.getInt(5)));

            }

            if (a != null) {
                datosCorrectos = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        return datosCorrectos;

    }
    
    
    
    public Administrador findByRutContr(String rut, String contrasenia) throws SQLException {
        Administrador a = null;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM administrador WHERE rut='"+rut+"' AND contrasenia='"+contrasenia+"'  ");
            while (rs.next()) {
                a = new Administrador();
                a.setId(rs.getInt(1));
                a.setRut(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setContrasenia(rs.getString(4));
                a.setRol(dr.findById(rs.getInt(5)));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return a;
    }
    
    
        public Administrador findById(int id) throws SQLException {
        Administrador a = null;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM administrador WHERE id="+id+"");
            while (rs.next()) {
                a = new Administrador();
                a.setId(rs.getInt(1));
                a.setRut(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setContrasenia(rs.getString(4));
                a.setRol(dr.findById(rs.getInt(5)));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return a;
    }
    
    
    

}
