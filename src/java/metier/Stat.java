/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Tsiory
 */
public class Stat {
    int femelle;
    int male;

    public Stat(int femelle, int male) {
        this.femelle = femelle;
        this.male = male;
    }
    public Stat(){
        
    }

    public int getFemelle() {
        return femelle;
    }

    public void setFemelle(int femelle) {
        this.femelle = femelle;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }
    
    public double male(){
        double total = this.getFemelle()+this.getMale();
        double male = (this.getMale()*100)/total;
        return male;
    }
    public double femelle(){
         double total = this.getFemelle()+this.getMale();
        double male = (this.getFemelle()*100)/total;
        return male;
    }
}
