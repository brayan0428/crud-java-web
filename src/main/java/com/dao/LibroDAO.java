/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.config.ConexionDB;
import com.models.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author braya
 */
public class LibroDAO {
    ConexionDB connectionDB;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public LibroDAO() {
        this.connectionDB = new ConexionDB();
    }
    
    
    public ArrayList<Libro> getLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            this.conn = connectionDB.connect();
            String sql = "select * from libros";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setCategoria(rs.getString("categoria"));
                libros.add(libro);
            }
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }finally{
            connectionDB.disconnect();
        }
        return libros;
    }
    
    public Libro getLibro(int id){
        Libro libro = new Libro();
        try{
            this.conn = connectionDB.connect();
            String sql = "select * from libros where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                libro.setId(rs.getInt("id"));
                libro.setIsbn(rs.getString("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setCategoria(rs.getString("categoria"));
            }
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }finally{
            connectionDB.disconnect();
        }
        return libro;
    }
    
    public void createLibro(Libro libro){
         try{
            this.conn = connectionDB.connect();
            String sql = "insert into libros (isbn, titulo, categoria) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getCategoria());   
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }finally{
            connectionDB.disconnect();
        }
    }
    
     public void editLibro(Libro libro){
         try{
            this.conn = connectionDB.connect();
            String sql = "update libros set isbn=?, titulo=?, categoria=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getCategoria());   
            ps.setInt(4, libro.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }finally{
            connectionDB.disconnect();
        }
    }
     
    public void deleteLibro(int id){
        try{
            this.conn = connectionDB.connect();
            String sql = "delete from libros where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }finally{
            connectionDB.disconnect();
        }
    }
}
