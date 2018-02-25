/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class PersonasJDBC {
    
    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido) VALUES (?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE idpersona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE idpersona=?";
    private final String SQL_SELECT = "SELECT idpersona, nombre, apellido FROM persona ORDER BY idpersona";
    
    public int insert(String nombre, String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            System.out.println("Ejecutando Query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int update(int id, String nombre, String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query: "+SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            stmt.setInt(index++, id);
            rows = stmt.executeUpdate();
            System.out.println("Registros Actualizados: "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
    public int delete(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando Query: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Registros Eliminados: "+rows);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona p = null;
        List<Persona> lp = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idpersona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                p = new Persona();
                p.setId(idpersona);
                p.setNombre(nombre);
                p.setApellido(apellido);
                lp.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lp;
    }
}
