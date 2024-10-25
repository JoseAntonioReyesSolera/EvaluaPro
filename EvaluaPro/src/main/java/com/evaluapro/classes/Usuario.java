/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluapro.classes;

/**
 *
 * @author Alumne
 */
public class Usuario {
    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean IsInstructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public boolean isIsInstructor() {
        return IsInstructor;
    }
    public String getIsInstructor() {
        if (IsInstructor)
            return "Si";
        return "No";
    }

    public void setIsInstructor(boolean IsInstructor) {
        this.IsInstructor = IsInstructor;
    }
}
