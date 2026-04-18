/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examengrupal2doparcial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author David Rubio
 */
public class ClsConexion {
        
    public Connection conectar(){
        Connection conn = null;
        
        
        try{
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TrackBuy;encrypt=true;trustServerCertificate=true";
            String user = "AdminUser";
            String password = "Admin123!";
            
            conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexion Exitosa");
            
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
        
        return conn;
        
    }
    
}
