<%@page import="metier.Meuble"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    String message = (String)request.getAttribute("message");
    Vector<Meuble> m = (Vector<Meuble>) request.getAttribute("liste");;
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
          
          <div class="panel panel-default cover">             
              <form action="CreateMeuble" method="get">
                  <h1>Fabriquation</h1>
                  <div class="form-group">
                                <label class="input-group-text" for="matiere">Matiere</label>
                                  <select class="form-control" id="diplome" name="idmeuble">
                                    <% for(int i=0;i<m.size();i++) { %>
                                        <option value=<%= m.get(i).getId()%>><%= m.get(i).getNom() %></option>
                                    <% } %>
                                  </select>
                     </div>
                <div class="form-group">
                  <label>Quantite</label>
                  <input type="number" name="quantite" class="form-control"  placeholder="Quantite">
                </div>
                <div class="col-12 ">
                        <button type="submit" class="btn btn-primary col-12 mt-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Enregistrer</button>
                </div>
              </form>
                                  <p><%=message%></p>
          </div>
      </div>
    </div>
</body>
</html>
