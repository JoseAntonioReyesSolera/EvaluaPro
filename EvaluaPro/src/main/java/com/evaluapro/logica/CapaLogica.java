/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.logica;

import com.evaluapro.logica.DataAccess.DataAccess;

/**
 *
 * @author Alumne
 */
public class CapaLogica {
    public boolean login(String email, String password) {
        DataAccess da = new DataAccess();
        da.verifyLogin(email, password);
        System.out.println(email);
        System.out.println(password);
        return true;
    }
}
