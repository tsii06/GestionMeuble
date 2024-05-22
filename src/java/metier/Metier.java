/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author VIOTECH
 */
public class Metier {
       int idMetier;
       String nom;
       double salaire;

    public Metier(int idMetier, String nom, double salaire) {
        this.idMetier = idMetier;
        this.nom = nom;
        this.salaire = salaire;
    }

    public int getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(int idMetier) {
        this.idMetier = idMetier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    public static void insertMetier(Connection con,String name,double vola)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into metier(nom,salaire) values('"+name+"',"+vola+")");        
    }
    
    public static Vector<Metier> getAllMetier(Connection conex)throws Exception{
        String req= "select * from metier";
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Metier> allMetier = new Vector<Metier>();
        while (res.next()){
            allMetier.add(new Metier(
              res.getInt("idMetier"),
              res.getString("nom"),
              res.getDouble("salaire")
            ));
        }
        return allMetier;
    }
    public static Metier getMetier(Connection c,int idMetier) throws Exception{
        String req= "select * from metier where idmetier="+idMetier ;
        Statement stat= c.createStatement();
        ResultSet res= stat.executeQuery(req);
        Metier m = null;
        while (res.next()){
            m = new Metier(res.getInt("idmetier"),res.getString("nom"),res.getDouble("salaire"));
        }
//        s.setQuantite(c);
        return m;
    }
}
