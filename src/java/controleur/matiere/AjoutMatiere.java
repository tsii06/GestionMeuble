package controleur.matiere;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Matiere;

/**
 *
 * @author Tsiory
 */
public class AjoutMatiere extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
            Connection c=Connexion.getConnection();
            int idStyle = Integer.parseInt(request.getParameter("style"));
            int idMatiere = Integer.parseInt(request.getParameter("matiere"));
            Matiere.insertMatiereStyle(c, idStyle, idMatiere);
            response.sendRedirect("Default");
             c.close();  
        }catch(Exception e){
            request.setAttribute("erreur",e.getMessage());
            request.getRequestDispatcher("listeMatiere.jsp").forward(request, response);
        }      
    }

    
}
