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
import metier.Client;
import metier.Employer;
import metier.Metier;

/**
 *
 * @author Tsiory
 */
public class InsertClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            Vector<Metier> metier = Metier.getAllMetier(c);
             String nom = request.getParameter("nom");
            int prix = Integer.parseInt(request.getParameter("genre"));
            String date = request.getParameter("date");
            Client.insertClient(c,nom,date,prix);
            request.getRequestDispatcher("Client.jsp").forward(request, response);
              c.close();
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }  
    }
}
