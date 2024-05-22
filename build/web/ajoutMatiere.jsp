<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Style> s = (Vector<Style>) request.getAttribute("liste");;
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
          <h1>Insertion Matiere :</h1>
        <nav class=" navbar-default">
          <ul class="nav nav-tabs">
               <% for(int i=0;i<s.size();i++) { %>
                    <li role="presentation"><a href="#"><%= s.get(i).getNom() %></a></li>
                <% } %>
          </ul>
        </nav>
          <div class="panel panel-default cover">             
              <ul class="list-group">
                <% for(int i=0;i<s.size();i++) { %>
                    <li class="list-group-item">
                      <span class="badge">14</span>
                      Cras justo odio
                    </li>
                <% } %>
              </ul>
              <form>
                  <h1>Ajouter matiere</h1>
                <div class="form-group">
                  <label>Nom</label>
                  <input type="text" class="form-control"  placeholder="Nom">
                </div>
              </form>
          </div>
      </div>
    </div>
</body>
</html>
