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
public class Employer {
    
    String nom;
    Metier metier;
    String dateEmbauche;
    double experitse;
    double salaire;
    String poste;

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getExperitse() {
        return experitse;
    }

    public void setExperitse(double experitse) {
        this.experitse = experitse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Employer(String nom, Metier metier, String dateEmbauche) {
        this.nom = nom;
        this.metier = metier;
        this.dateEmbauche = dateEmbauche;
    }
    
    public static Vector<Employer> getAllEmployer(Connection conex) throws Exception{
        String req= "select * from employer";
        Statement stat= conex.createStatement();
        ResultSet res= stat.executeQuery(req);
        Vector<Employer> all = new Vector<Employer>();
        Employer mbl= null;
        while (res.next()){
            Metier m = Metier.getMetier(conex, res.getInt("idmetier"));
            mbl = new Employer(res.getString("nom"),m,res.getString("dateEmbauche"));
            mbl.setExperitse(Employer.getExpertise(conex, res.getInt("idemployer")));
            mbl.setEmployer(conex, res.getInt("idemployer"));
            all.add(mbl);

        }
        return all;        
    }
    
    public static void insertEmployer(Connection con,int idM,String nomEmp,String dateE)throws Exception{
        Statement s=con.createStatement();
        s.executeUpdate("insert into employer values(default,"+idM+",'"+nomEmp+"','"+dateE+"')");        
    }
    public static Employer getEmpById(Connection con,int idEmp)throws Exception{
        String req= "select * from Employer where idEmployer="+idEmp ;
        Statement stat= con.createStatement();
        ResultSet res= stat.executeQuery(req);
        Employer s = null;
        while (res.next()){
            Metier m = Metier.getMetier(con, res.getInt("idmetier"));
            s = new Employer(res.getString("nom"),m,res.getString("dateEmbauche"));
        }
        return s;        
    }
    public static double getExpertise(Connection con,int idEmp)throws Exception{
        String req= "SELECT (EXTRACT(YEAR FROM current_date) - EXTRACT(YEAR FROM dateEmbauche)) AS duree FROM employer where idEmployer="+idEmp ;
        Statement stat= con.createStatement();
        ResultSet res= stat.executeQuery(req);
        double rep=0;
        while (res.next()){
            rep = res.getInt("duree");
        }
        return rep;        
    }
    
    public void setEmployer(Connection con,int idEmp) throws Exception{
        double ancien = this.getExpertise(con,idEmp);
        if(ancien >=2 && ancien<=5){
            this.setPoste("senior");
            double salaire = this.getMetier().getSalaire()*2;
            this.setSalaire(salaire);
        }
        if(ancien>5){
            this.setPoste("expert");
            double salaire = this.getMetier().getSalaire()*3;
            this.setSalaire(salaire);
        }
        if(ancien<2){
            this.setPoste("debutant");
            double salaire = this.getMetier().getSalaire()*1;
            this.setSalaire(salaire);
        }
        
    } 
    public double getExperience()throws Exception{
        
        return 0;
    }
    
    
    
    
    
    
    
}
