/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.logica.DataAccess;

import com.evaluapro.classes.Ejercicio;
import com.evaluapro.classes.Intento;
import com.evaluapro.classes.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public List<Ejercicio> ejercicios() {
    List<Ejercicio> lista = new ArrayList<>();
    
    String sql = "SELECT Id, nomExercici, Descripcio FROM Exercicis";
    
    try (Connection connection = getConnection();
         PreparedStatement selectStatement = connection.prepareStatement(sql);
         ResultSet resultSet = selectStatement.executeQuery()) {
         
        while (resultSet.next()) {
            // Create a new Ejercicio object for each row
            Ejercicio ejercicio = new Ejercicio();
            ejercicio.setId(resultSet.getInt("Id"));
            ejercicio.setNomExercici(resultSet.getString("nomExercici"));
            ejercicio.setDescripcio(resultSet.getString("Descripcio"));
            
            // Add the new Ejercicio object to the list
            lista.add(ejercicio);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return lista; // Return the list of exercises
}

    
      public List<Intento> intentos(int ejercicio) {
          List<Intento> lista = new ArrayList();
          String sql = """
                       select i.Id, u.nom as nomUsuari, Timestamp_Inici, Timestamp_Fi, Videofile 
                       from Intents i
                       join Usuaris u on u.Id = IdUsuari
                       where IdExercici = ?
                       order by Timestamp_Inici
                       """;
          
          try (Connection connection = getConnection();
                PreparedStatement selectStatement = connection.prepareStatement(sql)) {
                selectStatement.setInt(1, ejercicio);
                ResultSet resultSet = selectStatement.executeQuery();
                while (resultSet.next()) {
                    Intento intento =  new Intento();
                    intento.setId(resultSet.getInt("Id"));
                    intento.setNomUsuari(resultSet.getString("nomUsuari"));
                    intento.setTimestamp_Inici(resultSet.getTimestamp("Timestamp_Inici"));
                    intento.setTimestamp_Fi(resultSet.getTimestamp("Timestamp_Fi"));
                    intento.setVideofile(resultSet.getString("Videofile"));
                    lista.add(intento);
                }
          }
          catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
      }
}