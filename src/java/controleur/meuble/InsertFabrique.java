/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.meuble;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Create;
import metier.Fabrication;
import metier.Matiere;
import metier.Metier;
import metier.Meuble;
import metier.MeubleMatiere;
import metier.Mfabrication;
import metier.Stock;

/**
 *
 * @author Tsiory
 */
public class InsertFabrique extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
                Connection c=Connexion.getConnection();
                int meuble = Integer.parseInt(request.getParameter("idmeuble"));
                double vente = Double.parseDouble(request.getParameter("vente"));
                String [] metier = request.getParameterValues("metier");
                String [] quantite = request.getParameterValues("quantite");
                String [] heure = request.getParameterValues("heure");
            Meuble m = Meuble.getAllMeubleById(c, meuble);

            
            Vector<Meuble> mmm = Meuble.getAllMeuble(c);
            Vector<Metier> metie = Metier.getAllMetier(c);

                int jj =Fabrication.insertFabrication(c, meuble,vente);
                for(int i = 0 ;i<metier.length;i++){
                    Mfabrication.insertMFabrication(c, jj,Integer.parseInt(metier[i]), Integer.parseInt(quantite[i]), Integer.parseInt(heure[i]));
                }

            request.setAttribute("liste",mmm);
            request.setAttribute("listeMetier",metie);
            request.getRequestDispatcher("Fabrication.jsp").forward(request, response);
            c.close();

            }catch(Exception e){
                request.setAttribute("erreur",e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }   
    }

}
