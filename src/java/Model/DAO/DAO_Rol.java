/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexion;
import Model.Rol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alumno
 */
public class DAO_Rol extends Conexion implements DAO<Rol> {

    public DAO_Rol() throws ClassNotFoundException, SQLException {
        super("ejercicioParaSubirNotaJavaWeb");
    }

    @Override
    public void create(Rol ob) throws SQLException {
        ejecutar("INSERT INTO rol VALUES (NULL,'" + ob.getTipo() + "' )");
    }

    @Override
    public List<Rol> read() throws SQLException {
        List<Rol> lista = new ArrayList<>();

        ResultSet rs = ejecutar("SELECT * FROM rol");

        Rol r = null;
        while (rs.next()) {
            r = new Rol();
            r.setId(rs.getInt(1));
            r.setTipo(rs.getString(2));
            lista.add(r);

        }

        close();
        return lista;
    }

    @Override
    public void update(Rol ob) throws SQLException {
        ejecutar("UPDATE rol SET tipo=" + ob.getTipo() + " WHERE id=" + ob.getId() + "  ");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE FROM rol WHERE id=" + id + " ");
    }
    
    public Rol findById(int id) throws SQLException{
        Rol r= null;
        
        ResultSet rs=ejecutar("SELECT * FROM rol WHERE id="+id+" ");
        
        if(rs.next()){
            r=new Rol();
            r.setId(rs.getInt(1));
            r.setTipo(rs.getString(2));
        }
        
        close();
        return r;
    }
    

}
