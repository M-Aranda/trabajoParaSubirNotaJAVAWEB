/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexion;
import Model.UsuarioNormal;
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
public class DAO_UsuarioNormal extends Conexion implements DAO<UsuarioNormal> {

    public DAO_UsuarioNormal() throws ClassNotFoundException, SQLException {
        super("ejercicioParaSubirNotaJavaWeb");
    }

    @Override
    public void create(UsuarioNormal ob) throws SQLException {
        if (idSeRepite(ob.getId()) == false) {
            ejecutar("INSERT INTO usuarioNormal VALUES (NULL, '" + ob.getRut() + "', '" + ob.getNombre() + "', '" + ob.getContrasenia() + "', " + ob.getRol().getId() + "  )");
        }
    }

    @Override
    public List<UsuarioNormal> read() throws SQLException {
        List<UsuarioNormal> lista = new ArrayList<>();
        try {
            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM usuarioNormal");

            UsuarioNormal u = null;

            while (rs.next()) {
                u = new UsuarioNormal();
                u.setId(rs.getInt(1));
                u.setRut(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setContrasenia(rs.getString(4));
                u.setRol(dr.findById(rs.getInt(5)));

                lista.add(u);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return lista;
    }

    @Override
    public void update(UsuarioNormal ob) throws SQLException {
        ejecutar("UPDATE usuarioNormal SET rut='" + ob.getRut() + "', '" + ob.getNombre() + "', '" + ob.getContrasenia() + "', " + ob.getRol().getId() + " WHERE id=" + ob.getId() + "   ");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE FROM usuarioNormal WHERE id=" + id + " ");
    }

    public Boolean usuarioCorrecto(String rut, String contrasenia) throws SQLException {
        Boolean datosCorrectos = false;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM usuarioNormal WHERE rut='" + rut + "' AND contrasenia='" + contrasenia + "'  ");

            UsuarioNormal u = null;

            while (rs.next()) {
                u = new UsuarioNormal();
                u.setId(rs.getInt(1));
                u.setRut(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setContrasenia(rs.getString(4));
                u.setRol(dr.findById(rs.getInt(5)));

            }

            if (u != null) {
                datosCorrectos = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return datosCorrectos;

    }

    public UsuarioNormal findByRutContr(String rut, String contrasenia) throws SQLException {
        UsuarioNormal u = null;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM usuarioNormal WHERE rut='" + rut + "' AND contrasenia='" + contrasenia + "'  ");
            while (rs.next()) {
                u = new UsuarioNormal();
                u.setId(rs.getInt(1));
                u.setRut(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setContrasenia(rs.getString(4));
                u.setRol(dr.findById(rs.getInt(5)));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return u;
    }

    public UsuarioNormal findById(int id) throws SQLException {
        UsuarioNormal u = null;
        try {

            DAO_Rol dr = new DAO_Rol();
            ResultSet rs = ejecutar("SELECT * FROM usuarioNormal WHERE id=" + id + " ");
            while (rs.next()) {
                u = new UsuarioNormal();
                u.setId(rs.getInt(1));
                u.setRut(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setContrasenia(rs.getString(4));
                u.setRol(dr.findById(rs.getInt(5)));

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_UsuarioNormal.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return u;
    }

    public Boolean idSeRepite(int id) throws SQLException {
        Boolean seRepite = false;

        UsuarioNormal u = findById(id);
        if (u != null) {
            seRepite = true;
        }

        return seRepite;
    }

}
