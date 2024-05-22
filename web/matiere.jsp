<%-- 
    Document   : traitMatiere
    Created on : 9 janv. 2024, 14:52:48
    Author     : Maharina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <h1>Insertion Matiere : </h1>
        <div class="panel panel-default cover">
            <form action="AddMatiere" method="get">
                <label for="nom">Nom :</label><br>
                <input class="form-control"  type="text" id="nom" name="nom"><br>
                <label for="prix">Prix :</label><br>
                <input class="form-control"  type="text" id="prix" name="prix"><br>
               <input class="btn btn-primary" type="submit" value="Enregistrer">    
            </form>
        </div>
        </div>
    </body>
</html>

