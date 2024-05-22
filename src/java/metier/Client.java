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
public class Client {
    int idClient;
    String nom;
    String dateNaissance;
    int genre;

    public Client(int idClient, String nom, String dateNaissance, int genre) {
        this.idClient = idClient;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public static void insertClient(Connection con,String name,String dtn,int gr)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into client(nom,dateNaissance,genre) values('"+name+"','"+dtn+"',"+gr+")");        
    }
    
    public static Vector<Client> getAllClient(Connection conex)throws Exception{
        String req= "select * from client";
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Client> all = new Vector<Client>();
        while (res.next()){
            Client m = new Client(res.getInt("idClient"),res.getString("nom"),res.getString("dateNaissance"),res.getInt("genre"));
            all.add(m);
        }
        return all;
    }
}
