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
public class Stock {
    int idStock;
    int idMatiere;
    double prixUnitaire;
    int quantite;
    String dateAchat;
    int idMeuble;

    public Stock(int idStock, int idMatiere, double prixUnitaire, int quantite, String dateAchat) {
        this.idStock = idStock;
        this.idMatiere = idMatiere;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.dateAchat = dateAchat;
    }
    
    public Stock(){
        
    }
   

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public static Stock getStockByIdMatiere(Connection conex,int idMat)throws Exception{
        String req= "select * from stock where idmatiere="+idMat ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Stock st = new Stock();
        st.setQuantite(-1);
        while (res.next()){
            st= new Stock(res.getInt("idstock"),res.getInt("idmatiere"),2,res.getInt("quantite"),res.getString("datemouvement"));
        }
        return st;
    }
    public void insertStock(Connection con)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into stock values(default,"+this.getIdMatiere()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");        
    }
    
    public void ajoutQuantite(Connection con)throws Exception{
        Statement s=con.createStatement();
        Stock st = getStockByIdMatiere(con,this.getIdMatiere());
        
        if(st.getQuantite()==-1)  {
            insertStock(con);
            s.executeUpdate("insert into mouvement values(default,"+this.getIdMatiere()+","+this.getPrixUnitaire()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");
        } else {
            s.executeUpdate("update stock set quantite = quantite+"+this.getQuantite()+" where idMatiere="+this.getIdMatiere());  
            s.executeUpdate("insert into mouvement values(default,"+this.getIdMatiere()+","+this.getPrixUnitaire()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");
        }
    }
    
    public static void updateQuantite(Connection con,int idMatiere,double quantite) throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("update stock set quantite="+quantite+" where idMatiere="+idMatiere);  
        s.executeUpdate("insert into mouvement values(default,"+idMatiere+","+0+","+quantite+",now(),0)");
    }
    
    //======================= stock Meuble
    
public static Stock getStockByIdMeuble(Connection conex, int idMat) throws Exception {
    String req = "select * from stockmeuble where idmeuble=" + idMat;
    Statement stat = conex.createStatement();
    ResultSet res = stat.executeQuery(req);
    Stock st = new Stock();
    st.setQuantite(-1);
        while (res.next()) {
            st = new Stock(res.getInt("idstockmeuble"), res.getInt("idmeuble"), 3, res.getInt("quantite"), res.getString("datemouvement"));
        }
    
    return st;
}

    
    public void insertStockM(Connection con)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into stockmeuble values(default,"+this.getIdMatiere()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");        
    }
    
    public void ajoutQuantiteM(Connection con)throws Exception{
        Statement s=con.createStatement();
        Stock st = getStockByIdMeuble(con,this.getIdMatiere());
        if(st.getQuantite()==-1)  {
            insertStockM(con);
            System.out.println(st);
            s.executeUpdate("insert into mouvementmeuble values(default,"+this.getIdMatiere()+","+this.getPrixUnitaire()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");
        } else {
            s.executeUpdate("update stockmeuble set quantite = quantite +"+this.getQuantite()+" where idmeuble="+this.getIdMatiere());  
            s.executeUpdate("insert into mouvementmeuble values(default,"+this.getIdMatiere()+","+this.getPrixUnitaire()+","+this.getQuantite()+",'"+this.getDateAchat()+"',1)");
        }
    }
    
    public static void updateQuantiteM(Connection con,int idMatiere,double quantite) throws Exception{
         Statement s=con.createStatement();
        s.executeUpdate("update stockmeuble set quantite="+quantite+" where idmeuble="+idMatiere);  
        s.executeUpdate("insert into mouvementmeuble values(default,"+idMatiere+","+0+","+quantite+",now(),0)");
    }
}
