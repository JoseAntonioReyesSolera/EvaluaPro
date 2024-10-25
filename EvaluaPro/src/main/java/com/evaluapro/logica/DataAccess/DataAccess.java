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
    
    public Usuario verifyLogin(String email, String password){
        Connection connection = getConnection();
        
        String sql = "select isInstructor from usuaris where Email = \'" + email + "\' and PasswordHash = \'" + password + "\';";
        System.out.println(sql);
        
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            
            Usuario user = new Usuario();
            user.setId(resultSet.getInt("Id"));
            user.setNom(resultSet.getString("Nom"));
            user.setEmail(resultSet.getString("Email"));
            user.setPasswordHash(resultSet.getString("PasswordHash"));
            user.setIsInstructor(resultSet.getBoolean("IsInstructor"));
            
            return user;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
