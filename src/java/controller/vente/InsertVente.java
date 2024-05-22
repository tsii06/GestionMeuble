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
import metier.Meuble;
import metier.Vente;
/**
 *
 * @author Tsiory
 */
public class InsertVente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection c=Connexion.getConnection();
            int idclient = Integer.parseInt(request.getParameter("idclient"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            int idmeuble = Integer.parseInt(request.getParameter("idmeuble"));
            String date = request.getParameter("date");
            Meuble l = Meuble.getAllMeubleById(c, idmeuble);
            String mes = l.venteMeuble(c,quantite);
            if(mes=="yes"){
                Vente.insertVente(c, idclient, idmeuble, date,quantite);
            }
            request.setAttribute("message",mes);
            
            Vector<Client> mm = Client.getAllClient(c);
            Vector<Meuble> meuble = Meuble.getAllMeuble(c);
            request.setAttribute("listeClient",mm);
            request.setAttribute("listeMeuble",meuble);
            request.getRequestDispatcher("Vente.jsp").forward(request, response);
            request.getRequestDispatcher("employer.jsp").forward(request, response);
            c.close();
            
               
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }   
    }

}
