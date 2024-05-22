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
public class Meuble {
    int id;
    String nom;
    String type;
    double prix;
    double benefice;
    int quantite;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(Connection c) throws Exception{
        Stock s = Stock.getStockByIdMeuble(c, this.getId());
        this.quantite=s.getQuantite();
        if(s.getQuantite()==-1){
            this.quantite=0;
        }
        
        System.out.println("dkd"+this.getQuantite());
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Meuble(int id, String nom,String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
      public int insert(Connection con)throws Exception{
          Statement s=con.createStatement();
          ResultSet res = s.executeQuery("insert into meuble values(default,'"+this.getNom()+"',1,1,'"+this.getType()+"') returning idmeuble");        
          while(res.next()){
              return res.getInt("idmeuble");
          }
          return 0;
      }
      public static Vector<Meuble> getAllMeuble(Connection conex)throws Exception{
        String req= "select * from meuble";
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Meuble> all = new Vector<Meuble>();
        while (res.next()){
            Meuble m = new Meuble(res.getInt("idmeuble"),res.getString("nom"),res.getString("type"));
            m.setQuantite(conex);
            all.add(m);
        }
        return all;
    }
      public static Meuble getAllMeubleById(Connection conex,int id)throws Exception{
        String req= "select * from meuble where idmeuble="+id ;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
       Meuble mbl= null;
        while (res.next()){
            mbl = new Meuble(res.getInt("idmeuble"),res.getString("nom"),res.getString("type"));
        }
        return mbl;
    }
    public static Vector<Meuble>  getAllMeubleByPrix(Connection conex,double prixMin,double prixMax)throws Exception{
        String req= "select * from vsomme where prix>="+prixMin+" and prix<="+prixMax;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Meuble> all = new Vector<Meuble>();
        Meuble mbl= null;
        while (res.next()){
            mbl = new Meuble(res.getInt("idmeuble"),res.getString("nom"),res.getString("type"));
            mbl.setPrix(res.getDouble("prix"));
            all.add(mbl);

        }
        return all;
    }
    
    public static Vector<Meuble>  getBeneficeByPrix(Connection conex,double prixMin,double prixMax)throws Exception{
        String req= "select * from vbenefice where benefice>="+prixMin+" and benefice<="+prixMax;
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Meuble> all = new Vector<Meuble>();
        Meuble mbl= null;
        while (res.next()){
            mbl = new Meuble(res.getInt("idmeuble"),res.getString("nom"),res.getString("type"));
            mbl.setBenefice(res.getDouble("benefice"));
            mbl.setPrix(res.getDouble("prixvente"));
            all.add(mbl);
        }
        return all;
    }
    
    public String venteMeuble(Connection con,int quantite) throws Exception{
        if(quantite > Stock.getStockByIdMeuble(con, this.getId()).getQuantite()){
                return "quantite insufisante pour"+this.getNom();
            }else{
                double q = Stock.getStockByIdMeuble(con, this.getId()).getQuantite()-quantite ;
                Stock.updateQuantiteM(con, this.getId(), q);
            }
        return "yes";
    }
    
    
    
}
