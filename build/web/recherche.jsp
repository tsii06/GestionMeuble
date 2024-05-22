<%@page import="metier.MeubleMatiere"%>
<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Matiere> m = (Vector<Matiere>) request.getAttribute("listeMatiere");
    Vector<MeubleMatiere> mm = (Vector<MeubleMatiere>) request.getAttribute("listeMeuble");
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
          <nav class=" navbar-default">
          <ul class="nav nav-tabs">
                <li role="presentation"><a href="CMeuble">Ajouter</a></li>
                <li role="presentation"><a href="Recherche">Rechercher</a></li>
                <li role="presentation"><a href="FiliterForm.jsp">Filtre prix</a></li>
                <li role="presentation"><a href="FilterBenefice.jsp">Filtre benefice</a></li>
                <li role="presentation"><a href="Fabrique">Fabrique</a></li>
          </ul>
        </nav>
        <nav class=" navbar-default">
          <ul class="nav nav-tabs">
               <% for(int i=0;i<m.size();i++) { %>
                    <li role="presentation"><a href="ResutlRecherche?idMatiere=<%= m.get(i).getIdMatiere()%>"><%= m.get(i).getNom() %></a></li>
                <% } %>
          </ul>
        </nav>
            <div class="panel panel-default cover">      
                 <h1>Resultat Recherche :</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nom Meuble</th>
                            <th>Taille</th>
                            <th>Matiere</th>
                            <th>Quantite</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(int i=0;i<mm.size();i++) { %>
                            <tr>
                                <td><%= mm.get(i).getMeuble().getNom()%></td>
                                <td><%= mm.get(i).getMeuble().getType() %></td>
                                <td><%= mm.get(i).getMatiere().getNom()%></td>
                                <td><%= mm.get(i).getQuantite() %></td>      
                            </tr>
                        <% } %>
                    </tbody>
                </table>
              
            </div>
      </div>
    </div>
</body>
</html>
