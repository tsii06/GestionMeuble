/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author Tsiory
 */
public class Create {
    Meuble meuble;
    double quantite;

    public Create(Meuble meuble, double quantite) {
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
    

    
        public String createMeuble(Connection conex,double q) throws Exception{
        Vector<MeubleMatiere> m= MeubleMatiere.getMatiereMeuble(conex, this.getMeuble().getId());
        for(int i=0;i<m.size();i++){
            if((m.get(i).getQuantite()*this.getQuantite())>Stock.getStockByIdMatiere(conex, m.get(i).getMatiere().getIdMatiere()).getQuantite()){
                return "quantite insufisante pour"+m.get(i).getMatiere().getNom();
            }else{
                double quantite = m.get(i).getQuantite()*this.getQuantite();
                double qmatiere =Stock.getStockByIdMatiere(conex, m.get(i).getMatiere().getIdMatiere()).getQuantite()-quantite;
                Stock.updateQuantite(conex,m.get(i).getMatiere().getIdMatiere(),qmatiere);              
            }
        }
        
        
        return "yes";
    }
}
