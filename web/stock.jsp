<%-- 
    Document   : traitMatiere
    Created on : 9 janv. 2024, 14:52:48
    Author     : Maharina
--%>
<%@page import="metier.Matiere"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Matiere> m = (Vector<Matiere>) request.getAttribute("listeMatiere");
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
                <li role="presentation"><a href="StockMeuble">Meuble</a></li>
                <li role="presentation"><a href="StockMatiere">Matiere</a></li>
          </ul>
        </nav>
            <h1>Insertion Stock :</h1>
            <div class="panel panel-default cover">  
                
                <form method="GET" action="AjoutStock">
                <label for="matiere">Matière:</label><br>
                <select class="form-control" id="matiere" name="matiere">
                  <%
                      for(int i=0;i<m.size ();i++){
                  %>
                  <option value="<%=m.get(i).getIdMatiere()%>"><%=m.get(i).getNom()%></option>
                  <%}%>
                </select><br>

                <label for="quantite">Quantité:</label><br>
                <input class="form-control" type="number" id="quantite" name="quantite" min="0" required><br>

                <label for="prix">Prix:</label><br>
                <input class="form-control" type="number" id="prix" name="prix" min="0" required><br>

                <label for="date">Date:</label><br>
                <input class="form-control" type="date" id="date" name="date" required><br>

                <input class="btn btn-primary" type="submit" value="Générer">
            </form> 
            </div>
      </div>
    </div>
</body>
</html>
