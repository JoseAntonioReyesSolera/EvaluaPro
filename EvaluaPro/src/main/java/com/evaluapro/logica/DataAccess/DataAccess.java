/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.logica.DataAccess;

import com.evaluapro.classes.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumne
 */
public class DataAccess {
    private Connection getConnection() {
        String ddb = "simulapdb";
        String nom = "paco";
        String pws = "1234";
        Connection connection = null;
        
        String connectionString = "jdbc:sqlserver://localhost;database=" +ddb+";" 
                + "user="+nom+";password="+pws+";trustServerCertificate=true;";
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    public Usuario getUsuarioByEmail(String email){
        Connection connection = getConnection();
        
        String sql = "SELECT Id, Nom, Email, PasswordHash, IsInstructor FROM usuaris WHERE Email = ?";
        
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            
          if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("Id"));
                usuario.setNom(resultSet.getString("Nom"));
                usuario.setEmail(resultSet.getString("Email"));
                usuario.setPasswordHash(resultSet.getString("PasswordHash"));
                usuario.setIsInstructor(resultSet.getBoolean("IsInstructor"));
                
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}