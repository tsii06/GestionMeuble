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
import metier.Matiere;
import metier.Meuble;
import metier.MeubleMatiere;
import metier.Style;

/**
 *
 * @author Tsiory
 */
public class AjoutMeuble extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
                Connection c=Connexion.getConnection();
                String nom = request.getParameter("nom");
                String type = request.getParameter("taille");
                Meuble  m = new Meuble(0,nom,type);
                String [] matiere = request.getParameterValues("matiere");
                String [] quantite = request.getParameterValues("quantite");
                int jj = m.insert(c);
                Meuble mm = Meuble.getAllMeubleById(c, jj);
                for(int i = 0 ;i<matiere.length;i++){
                    Matiere  mat = Matiere.getMatiere(c, Integer.parseInt(matiere[i]));
                    MeubleMatiere meublemat = new MeubleMatiere(mat,mm,Integer.parseInt(quantite[i]));
                    meublemat.insertMeubleMatiere(c);
                }
                Vector<Matiere> matie = Matiere.getAllMatiere(c);
            request.setAttribute("listeMatiere",matie);
            request.getRequestDispatcher("ajoutMeuble.jsp").forward(request, response);
            c.close();
            }catch(Exception e){
                request.setAttribute("erreur",e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }   
    }

}
