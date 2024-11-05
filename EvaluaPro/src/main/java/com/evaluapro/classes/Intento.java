/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase;

import java.util.Date;

/**
 *
 * @author Alumne
 */
public class Intento {
    private int id;
    private String nomUsuari;
    private Date Timestamp_Inici;
    private Date Timestamp_Fi;
    private String Videofile;

    public Intento() {
    }

    public Intento(int id, String nomUsuari, Date Timestamp_Inici, Date Timestamp_Fi, String Videofile) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.Timestamp_Inici = Timestamp_Inici;
        this.Timestamp_Fi = Timestamp_Fi;
        this.Videofile = Videofile;
    }

    public String getVideofile() {
        return Videofile;
    }

    public void setVideofile(String Videofile) {
        this.Videofile = Videofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public Date getTimestamp_Inici() {
        return Timestamp_Inici;
    }

    public void setTimestamp_Inici(Date Timestamp_Inici) {
        this.Timestamp_Inici = Timestamp_Inici;
    }

    public Date getTimestamp_Fi() {
        return Timestamp_Fi;
    }

    public void setTimestamp_Fi(Date Timestamp_Fi) {
        this.Timestamp_Fi = Timestamp_Fi;
    }

    @Override
    public String toString() {
        return "Intento{" + "id=" + id + ", nomUsuari=" + nomUsuari + ", Timestamp_Inici=" + Timestamp_Inici + ", Timestamp_Fi=" + Timestamp_Fi + ", Videofile=" + Videofile + '}';
    }
    
    
}
