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
public class Matiere {
    int idMatiere;
    String nom;
    double quantite=0;
     
    public Matiere(){
        
    }

    public Matiere(int idMatiere, String nom) {
        this.idMatiere = idMatiere;
        this.nom = nom;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public static Vector<Matiere> getAllMatiereByIdStyle(Connection conex,int idStyle)throws Exception{
        String req= "select * from vstyle where idstyle ="+idStyle ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Matiere> allStyle = new Vector<Matiere>();
        
        while (res.next()){
            Matiere m =new Matiere();
            m.setIdMatiere(res.getInt("idmatiere"));
            m.setNom(res.getString("nommatiere"));
            allStyle.add(m);
        }
        return allStyle;
    }
    public static Vector<Matiere> getAllMatiere(Connection conex)throws Exception{
        String req= "select * from matiere";
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Matiere> allMatiere = new Vector<Matiere>();
        while (res.next()){
            Matiere m =new Matiere();
            m.setIdMatiere(res.getInt("idmatiere"));
            m.setNom(res.getString("nom"));
            m.setQuantite(conex);
            allMatiere.add(m);
        }
        return allMatiere;
    }
        
    public static void insertMatiereStyle(Connection con,int idStyle,int idMatiere)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into styleMatiere values("+idStyle+","+idMatiere+")");        
    }
        
    public static void insertMatiere(Connection con,String nomMatiere,double prixU)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into matiere(nom,prixUnitaire) values('"+nomMatiere+"',"+prixU+")");        
    }
    
    public static Matiere getMatiere(Connection c,int idStyle) throws Exception{
        String req= "select * from matiere where idmatiere="+idStyle ;
        Statement stat= c.createStatement();
        ResultSet res= stat.executeQuery(req);
        Matiere s = null;
        while (res.next()){
            s = new Matiere(res.getInt("idmatiere"),res.getString("nom"));
        }
//        s.setQuantite(c);
        return s;
    }
    
    public void setQuantite(Connection c) throws Exception{
        Stock s = Stock.getStockByIdMatiere(c, this.getIdMatiere());
        this.quantite=s.getQuantite();
        if(s.getQuantite()==-1) this.quantite=0;
        
    }
    
    public double getQuantite(){
        return quantite;
    }



}
