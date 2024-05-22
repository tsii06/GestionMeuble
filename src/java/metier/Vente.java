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
public class Vente {
    int idVente;
    Client client;
    Meuble meuble;
    String dateVente;
    int quantite;

    public Vente(int idVente, Client client, Meuble meuble, String dateVente, int quantite) {
        this.idVente = idVente;
        this.client = client;
        this.meuble = meuble;
        this.dateVente = dateVente;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }
    
    public static void insertVente(Connection con,int idCli,int idM,String dt,int qt)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into vente(idClient,idMeuble,dateVente,quantite) values("+idCli+","+idM+",'"+dt+"',"+qt+")");      
        
    }

    
    public static int getCountByMeubleGenre(Connection con,int idM,int gr)throws Exception{
        String req= "select sum(quantite) as isa from Vvente where genre="+gr+" and idMeuble="+idM;
        Statement stat= con.createStatement();
        ResultSet res= stat.executeQuery(req);
        int isa = 0;
        while (res.next()){  
            isa= res.getInt("isa");
        }
        return isa;        
    }
    
    public static int getCountByGenre(Connection con,int gr)throws Exception{
        String req= "select sum(quantite) as isa from Vvente where genre="+gr;
        Statement stat= con.createStatement();
        ResultSet res= stat.executeQuery(req);
        int isa = 0;
        while (res.next()){
            isa= res.getInt("isa");
        }
        return isa;     
    }
    
}
