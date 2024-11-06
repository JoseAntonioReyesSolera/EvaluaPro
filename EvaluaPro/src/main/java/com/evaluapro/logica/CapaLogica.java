/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.logica;

import com.evaluapro.classes.Ejercicio;
import com.evaluapro.classes.Intento;
import com.evaluapro.classes.Usuario;
import com.evaluapro.logica.DataAccess.DataAccess;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Alumne
 */
public class CapaLogica {
    DataAccess da = new DataAccess();
    public boolean login(String email, String password) {
        Usuario usuario = da.getUsuarioByEmail(email);

        if (usuario == null) {
            return false;
        }

        // Compara el hash de la contraseña ingresada
        boolean isAuthenticated = BCrypt.checkpw(password, usuario.getPasswordHash());
        return isAuthenticated && usuario.isIsInstructor();
    }
    
    public void ventanaError(java.awt.Dialog parent, String texto) {
        JOptionPane.showConfirmDialog(
                parent,
                texto,
                "",
                JOptionPane.CANCEL_OPTION);
    }
    public List<Ejercicio> ejercicios() {
        return  da.ejercicios();
    }
    
    public DefaultTableModel obtenerTablaIntentos(int ejercicioId) {
    List<Intento> intentos = da.intentos(ejercicioId); // Llama al método de la capa de datos
    DefaultTableModel tableModel = new DefaultTableModel();
    
    // Definir columnas
    tableModel.addColumn("Id");
    tableModel.addColumn("Usuario");
    tableModel.addColumn("Inicio");
    tableModel.addColumn("Fin");
    tableModel.addColumn("Archivo Video");

    // Añadir filas al modelo de tabla
    for (Intento intento : intentos) {
        tableModel.addRow(new Object[] {
            intento.getId(),
            intento.getNomUsuari(),
            intento.getTimestamp_Inici(),
            intento.getTimestamp_Fi(),
            intento.getVideofile()
        });
    }
    return tableModel;
}
}