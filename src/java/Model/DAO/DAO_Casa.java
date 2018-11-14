/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Casa;
import Model.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class DAO_Casa extends Conexion implements DAO<Casa> {

    public DAO_Casa() throws ClassNotFoundException, SQLException {
        super("ejercicioParaSubirNotaJavaWeb");
    }

    @Override
    public void create(Casa ob) throws SQLException {
        ejecutar("INSERT INTO casa VALUES (NULL, '" + ob.getDireccion() + "', " + ob.getMetrosCuadrados() + ", '" + ob.getRutPropietario()+ "','"+ob.getNomPropietario()+"', " + ob.getAvaluoFiscal() + "    )");
    }

    @Override
    public List<Casa> read() throws SQLException {
        List<Casa> lista = new ArrayList<>();
        ResultSet rs = ejecutar("SELECT * FROM casa");

        Casa c=null;
        while (rs.next()) {
            c= new Casa();
            c.setId(rs.getInt(1));
            c.setDireccion(rs.getString(2));
            c.setMetrosCuadrados(rs.getInt(3));
            c.setRutPropietario(rs.getString(4));
            c.setNomPropietario(rs.getString(5));
            c.setAvaluoFiscal(rs.getInt(6));
            
            lista.add(c);
        }

        close();
        return lista;
    }

    @Override
    public void update(Casa ob) throws SQLException {
        ejecutar("UPDATE casa SET direccion='" + ob.getDireccion() + "', metrosCuadrados=" + ob.getMetrosCuadrados() + ", rutProp='" + ob.getRutPropietario()+ "',nomPropietario='"+ob.getNomPropietario()+"', avaluoFiscal=" + ob.getAvaluoFiscal() + " WHERE id=" + ob.getId() + "   ");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE FROM casa WHERE id=" + id + " ");
    }

    public Casa findById(int id) throws SQLException{
        Casa c=null;
        
        ResultSet rs=ejecutar("SELECT * FROM casa WHERE id="+id+" ");
        
        if(rs.next()){
            c=new Casa();
            c.setId(rs.getInt(1));
            c.setDireccion(rs.getString(2));
            c.setMetrosCuadrados(rs.getInt(3));
            c.setRutPropietario(rs.getString(4));
            c.setNomPropietario(rs.getString(5));
            c.setAvaluoFiscal(rs.getInt(6));
        }
        
        close();
        return c;
    }
    
    
    
     public List<Casa> buscarPorRut(String rut) throws SQLException {
        List<Casa> lista = new ArrayList<>();
        ResultSet rs = ejecutar("SELECT * FROM casa WHERE rutProp='"+rut+"' ");

        Casa c=null;
        while (rs.next()) {
            c= new Casa();
            c.setId(rs.getInt(1));
            c.setDireccion(rs.getString(2));
            c.setMetrosCuadrados(rs.getInt(3));
            c.setRutPropietario(rs.getString(4));
            c.setNomPropietario(rs.getString(5));
            c.setAvaluoFiscal(rs.getInt(6));
            
            lista.add(c);
        }

        close();
        return lista;
    }
    
    
}
