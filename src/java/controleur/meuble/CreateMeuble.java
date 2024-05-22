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
public class CreateMeuble extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
                Connection c=Connexion.getConnection();
                int meuble = Integer.parseInt(request.getParameter("idmeuble"));
                int quant = Integer.parseInt(request.getParameter("quantite"));
                Meuble m = Meuble.getAllMeubleById(c, meuble);
                Create cc = new Create(m,quant);
                String mm = cc.createMeuble(c,quant);

                Vector<Meuble> mmm = Meuble.getAllMeuble(c);
                if(mm=="yes"){
                    Stock stock = new Stock(1,meuble,3000,quant,"2023-10-02");
                    stock.ajoutQuantiteM(c);
                }

                request.setAttribute("message",mm);
                request.setAttribute("liste",mmm);
                request.getRequestDispatcher("Create.jsp").forward(request, response);
                c.close();

            }catch(Exception e){
                request.setAttribute("erreur",e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }   
    }

}
