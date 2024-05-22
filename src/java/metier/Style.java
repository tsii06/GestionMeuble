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
public class Style {
    int idStyle;
    String nom;

    public int getIdStyle() {
        return idStyle;
    }

    public String getNom() {
        return nom;
    }

    public Style(int idStyle, String nom) {
        this.idStyle = idStyle;
        this.nom = nom;
    }
    public Style(){
        
    }
    
    public static Vector<Style> getAllStyle(Connection conex)throws Exception{
        String req= "select * from style" ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Style> allStyle = new Vector<Style>();
        while (res.next()){
            allStyle.add(new Style(
              res.getInt("idstyle"),
              res.getString("nom")
            ));
        }
        return allStyle;
    }
    
    public static Style getStyle(Connection c,int idStyle) throws Exception{
        String req= "select * from style where idStyle="+idStyle ;
        Statement stat= c.createStatement();
        ResultSet res= stat.executeQuery(req);
        Style s = new Style();
        while (res.next()){
            s = new Style(res.getInt("idstyle"),res.getString("nom"));
        }
        return s;
    }
    
}
