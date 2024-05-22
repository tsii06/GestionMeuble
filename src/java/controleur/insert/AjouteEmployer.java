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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Employer;
import metier.Metier;


/**
 *
 * @author Tsiory
 */
public class AjouteEmployer extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            Vector<Metier> metier = Metier.getAllMetier(c);
            request.setAttribute("listeMetier",metier);
             String nom = request.getParameter("nom");
            int prix = Integer.parseInt(request.getParameter("idmetier"));
            String date = request.getParameter("date");
            Metier m = Metier.getMetier(c, prix);
            Employer emp = new Employer(nom,m,date);
            emp.insertEmployer(c,m.getIdMetier(),nom,date);
            request.getRequestDispatcher("employer.jsp").forward(request, response);
             c.close();  
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }           
    }
}
