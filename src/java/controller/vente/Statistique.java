/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.vente;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Meuble;
import metier.Vente;
import metier.Stat;


/**
 *
 * @author Tsiory
 */
public class Statistique extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            int idmeuble = Integer.parseInt(request.getParameter("idmeuble"));
            int femelle = 0;
            int male = 0;
            if(idmeuble==0){
                femelle = Vente.getCountByGenre(c, 0);
                male = Vente.getCountByGenre(c, 1);
            }else{
                femelle = Vente.getCountByMeubleGenre(c, idmeuble, 0);
                male = Vente.getCountByMeubleGenre(c, idmeuble, 1);
            }
            Stat s =new Stat();
            s.setFemelle(femelle);
            s.setMale(male);
            Vector<Meuble> meuble = Meuble.getAllMeuble(c);
            request.setAttribute("listeMeuble",meuble);
            request.setAttribute("stat",s);
            request.getRequestDispatcher("statistique.jsp").forward(request, response);
             c.close();  
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }   
    }

}
