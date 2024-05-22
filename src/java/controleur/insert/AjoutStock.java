/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.insert;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Matiere;
import metier.Stock;

/**
 *
 * @author itu
 */

public class AjoutStock extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            int idMatiere = Integer.parseInt(request.getParameter("matiere"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            String date = request.getParameter("date");
            
            Stock st = new Stock(0,idMatiere,prix,quantite,date);
            st.ajoutQuantite(c);
            Vector<Matiere> mm = Matiere.getAllMatiere(c);
            request.setAttribute("listeMatiere",mm);
            request.getRequestDispatcher("stock.jsp").forward(request, response);
            c.close();
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }      
    }

}
