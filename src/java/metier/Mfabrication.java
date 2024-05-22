/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author VIOTECH
 */
public class Mfabrication {
    int idFabrication;
    int idMetier;
    int heure;
    int nombre;

    public Mfabrication(int idFabrication, int idMetier, int heure, int nombre) {
        this.idFabrication = idFabrication;
        this.idMetier = idMetier;
        this.heure = heure;
        this.nombre = nombre;
    }

    public int getIdFabrication() {
        return idFabrication;
    }

    public void setIdFabrication(int idFabrication) {
        this.idFabrication = idFabrication;
    }

    public int getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(int idMetier) {
        this.idMetier = idMetier;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    public static void insertMFabrication(Connection con,int idF,int idM,int h,int nb)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into metierfabrication values("+idF+","+idM+","+h+","+nb+")");   
    }
}
