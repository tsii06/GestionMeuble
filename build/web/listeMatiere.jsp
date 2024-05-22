<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Style> s = (Vector<Style>) request.getAttribute("listeStyle");
    Vector<Matiere> m = (Vector<Matiere>) request.getAttribute("listeMatiere");
    Vector<Matiere> ms = (Vector<Matiere>) request.getAttribute("listeMatiereStyle");
    String id = (String)request.getAttribute("id");
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
          <h1>Choisir le Style:</h1>
        <nav class=" navbar-default">
          <ul class="nav nav-tabs">
              <form action="CMatiere">
                  <select name="style" class="form-control" style="width:300px; margin-bottom: 10px">
                        <% for(int i=0;i<s.size();i++) { %>
                              <option value="<%= s.get(i).getIdStyle()%>"><%= s.get(i).getNom() %></option>
                         <% } %>
                  </select>
                  <input type="submit"value="Valider" class="btn btn-primary">
               </form>
          </ul>
        </nav>
            <div class="panel panel-default cover">    
                <h2>Neutre</h2>
              <ul class="list-group">
                <% for(int i=0;i<ms.size();i++) { %>
                    <li class="list-group-item">
                      <span class="badge"></span>
                      <%= ms.get(i).getNom() %>
                    </li>
                <% } %>
              </ul>
              <form action="AjoutMatiere">
                  <h1>Ajouter matiere</h1>
                    <div class="form-group">
                        <label>Nom</label>
                        <select name="matiere" class="form-control">
                            <% for(int i=0;i<m.size();i++) { %>
                            <option value="<%= m.get(i).getIdMatiere()%>"><%= m.get(i).getNom() %></option>
                            <% } %>
                        </select>
                        <input type="text" name="style" value="<%=id%>" hidden>
                    </div>
                    <input type="submit"value="Valider" class="btn btn-primary">
              </form>
            </div>
      </div>
    </div>
</body>
</html>
