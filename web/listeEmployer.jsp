<%@page import="metier.Employer"%>
<%@page import="metier.Meuble"%>
<%@page import="metier.MeubleMatiere"%>
<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Employer> mm = (Vector<Employer>) request.getAttribute("listeemployer");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Navigation avec Bootstrap</title>
  <link rel="stylesheet" href="bootstrap.min.css">
</head>
<style>
    body{
        padding: 30px;
    }
    .panel{
        padding: 30px;
        margin-top: 20px;
    }
    .cover{
        height: 80vh;
    }
</style>
<body>

    <div class="row">
      <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">
          <li role="presentation" class="active"><a href="Default">Style</a></li>
          <li role="presentation"><a href="CMeuble">Meuble</a></li>
          <li role="presentation"><a href="#">Categorie</a></li>
          <li role="presentation"><a href="matiere.jsp">Matiere</a></li>
          <li role="presentation"><a href="Getmatiere">Stock</a></li>
          <li role="presentation"><a href="metier.jsp">Metier</a></li>
          <li role="presentation"><a href="AddEmployer">Employer</a></li>
          <li role="presentation"><a href="Client.jsp">Client</a></li>
          <li role="presentation"><a href="Vente">Vente</a></li>
        </ul>
      </div>
      <div class="col-md-9">
          <h1>Liste Employer :</h1>
<div class="panel panel-default cover">             
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Metier</th>
                            <th>Anciennete</th>
                            <th>Salaire</th>
                            <th>Poste</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(int i=0;i<mm.size();i++) { %>
                            <tr>
                                <td><%= mm.get(i).getNom()%></td>
                                <td><%= mm.get(i).getMetier().getNom() %></td>  
                                <td><%= mm.get(i).getDateEmbauche()%></td> 
                                <td><%= mm.get(i).getSalaire()%></td> 
                                <td><%= mm.get(i).getPoste() %></td> 
                               
                            </tr>
                        <% } %>
                    </tbody>
                </table>
              
            </div>
      </div>
    </div>
</body>
</html>
