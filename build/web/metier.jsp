<%-- 
    Document   : metier
    Created on : 16 janv. 2024, 14:31:25
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
           <h1>Insertion Metier :</h1>
        <div class="panel panel-default cover">               
            <form method="GET" action="AjoutMetier">
              <label for="Asa">Métier:</label><br>
              <input class="form-control" type="text" id="name" name="asa"><br>
              <label for="karama">Salaire:</label><br>
              <input class="form-control" type="text" id="salary" name="karama"><br><br>
              <input class="btn btn-primary" type="submit" value="Générer">
            </form>
        </div>
     
    </div>
    </div>
</body>
</html>
