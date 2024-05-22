/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.matiere;

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

/**
 *
 * @author VIOTECH
 */
@WebServlet(name = "Getmatiere", urlPatterns = {"/Getmatiere"})
public class Getmatiere extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            Vector<Matiere> mm = Matiere.getAllMatiere(c);
            request.setAttribute("listeMatiere",mm);
            request.getRequestDispatcher("stock.jsp").forward(request, response);
             c.close();  
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("listeMatiere.jsp").forward(request, response);
        }           
    }
}
