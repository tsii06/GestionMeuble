package controleur.insert;

import connexion.Connexion;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Metier;

/**
 *
 * @author VIOTECH
 */
public class AjoutMetier extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try{  
                Connection c=Connexion.getConnection();
                String nom = request.getParameter("asa");
                double salaire = Double.parseDouble(request.getParameter("karama"));

                Metier.insertMetier(c,nom,salaire);
                request.getRequestDispatcher("metier.jsp").forward(request, response);
                c.close();
            }catch(Exception e){
                request.setAttribute("erreur",e.getMessage());
                request.getRequestDispatcher("listeMatiere.jsp").forward(request, response);
            }     
        }
    

  

}
