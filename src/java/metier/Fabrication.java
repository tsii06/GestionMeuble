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
 * @author Tsiory
 */
public class Fabrication {
    int idFabrication;
    Meuble meuble;
    double quantite;

    public Fabrication(int idFabrication, Meuble meuble) {
        this.idFabrication = idFabrication;
        this.meuble = meuble;
    }

    public Fabrication(Meuble meuble, double quantite) {
        this.meuble = meuble;
        this.quantite = quantite;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    public static int insertFabrication(Connection con,int idM,double vola)throws Exception{
        Statement s=con.createStatement();
        ResultSet res = s.executeQuery("insert into fabrication(idmeuble,prixvente) values("+idM+","+vola+") returning idfabrication");  
        
        while(res.next()){
              return res.getInt("idfabrication");
          }
          return 0;
    }
    public String createMeuble(Connection conex,double q) throws Exception{
        Vector<MeubleMatiere> m= MeubleMatiere.getMatiereMeuble(conex, this.getMeuble().getId());
        for(int i=0;i<m.size();i++){
            if((m.get(i).getQuantite()*this.getQuantite())>Stock.getStockByIdMatiere(conex, m.get(i).getMatiere().getIdMatiere()).getQuantite()){
                return "quantite insufisante pour"+m.get(i).getMatiere().getNom();
            }else{
                double quantite = m.get(i).getQuantite()*this.getQuantite();
                Stock.updateQuantite(conex,m.get(i).getMatiere().getIdMatiere(),quantite);
                Stock.updateQuantiteM(conex, this.getMeuble().getId(), q);
            }
        }
        
        return "Effectue";
    }
}
