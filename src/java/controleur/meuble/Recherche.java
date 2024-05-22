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
import metier.MeubleMatiere;
import metier.Style;

/**
 *
 * @author VIOTECH
 */
public class Recherche extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
                Connection c=Connexion.getConnection();
                Vector<Matiere> mm = Matiere.getAllMatiere(c);
                Vector<MeubleMatiere> meu = MeubleMatiere.getAllMeubleByIdMat(c, 1);
                request.setAttribute("listeMatiere",mm);
                request.setAttribute("listeMeuble",meu);
                request.getRequestDispatcher("recherche.jsp").forward(request, response);
                c.close();
            }catch(Exception e){
                request.setAttribute("erreur",e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }        
    }


}
