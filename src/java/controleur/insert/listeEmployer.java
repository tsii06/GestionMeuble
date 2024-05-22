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
import metier.Matiere;

/**
 *
 * @author Tsiory
 */
public class listeEmployer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            Vector<Employer> mm = Employer.getAllEmployer(c);
            request.setAttribute("listeemployer",mm);
            request.getRequestDispatcher("listeEmployer.jsp").forward(request, response);
              c.close(); 
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }   
    }


}
