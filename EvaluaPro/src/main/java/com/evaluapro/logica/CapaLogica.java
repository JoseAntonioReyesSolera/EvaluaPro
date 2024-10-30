/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.logica;

import com.evaluapro.classes.Usuario;
import com.evaluapro.logica.DataAccess.DataAccess;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Alumne
 */
public class CapaLogica {
    public boolean login(String email, String password) {
        DataAccess da = new DataAccess();
        Usuario usuario = da.getUsuarioByEmail(email);

        if (usuario == null) {
            return false;
        }

        // Compara el hash de la contraseña ingresada
        boolean isAuthenticated = BCrypt.checkpw(password, usuario.getPasswordHash());

        return isAuthenticated && usuario.isIsInstructor();
    }
}