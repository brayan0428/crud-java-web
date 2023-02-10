/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author braya
 */
public class ConexionDB {
    final String driver = "com.mysql.jdbc.Driver";
    final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    final String user = "root";
    final String password = "Pa$$w0rd";
    
    protected Connection conn = null;

    public ConexionDB() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null) System.out.println("Conexión establecida exitosamente");
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("No se encontró el driver: " + e.getMessage());
        }
    }
    
    public Connection connect(){
        return conn;
    }
    
    public void disconnect(){
        try{
            System.out.println("Desconectando la base de datos");
            conn.close();
        }catch(SQLException e){
            System.out.println("Error de SQL: " + e.getMessage());
        }
    }
}
