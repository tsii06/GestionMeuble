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
public class MeubleMatiere {
    Matiere matiere;
    Meuble meuble;
    int quantite;

    public MeubleMatiere(Matiere matiere, Meuble meuble, int quantite) {
        this.matiere = matiere;
        this.meuble = meuble;
        this.quantite = quantite;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public static Vector<MeubleMatiere> getAllMeubleByIdMat(Connection conex,int idMat)throws Exception{
        String req= "select * from vmeuble where idMatiere="+idMat ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<MeubleMatiere> all = new Vector<MeubleMatiere>();
        while (res.next()){
            Meuble m= Meuble.getAllMeubleById(conex, res.getInt("idmeuble"));
            Matiere mm = Matiere.getMatiere(conex, res.getInt("idmatiere"));
            MeubleMatiere mbl = new MeubleMatiere(mm,m,res.getInt("quantite"));
            all.add(mbl);
        }
        return all;
    }
    
    public static Vector<MeubleMatiere> getMatiereMeuble(Connection conex,int idMat)throws Exception{
        String req= "select * from vmeuble where idMeuble="+idMat ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<MeubleMatiere> all = new Vector<MeubleMatiere>();
        while (res.next()){
            Meuble m= Meuble.getAllMeubleById(conex, res.getInt("idmeuble"));
            Matiere mm = Matiere.getMatiere(conex, res.getInt("idmatiere"));
            MeubleMatiere mbl = new MeubleMatiere(mm,m,res.getInt("quantite"));
            all.add(mbl);
        }
        return all;
    }
    public void insertMeubleMatiere(Connection con)throws Exception{
          Statement s=con.createStatement();
          s.executeUpdate("insert into meublematiere values("+this.getMeuble().getId()+","+this.getMatiere().getIdMatiere()+","+this.getQuantite()+")");        
    }
    
  
}
