<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
                <h2>Insertion Client</h2>
                  <div class="panel panel-default cover">             
                      <form method="GET" action="InsertClient">
                          
                      <label for="quantite">Nom:</label><br>
                      <input class="form-control" type="text" id="nom" name="nom" required><br>
                    
                      <label for="date">Date de Naissance:</label><br>
                      <input class="form-control" type="date" id="date" name="date" required><br>
                      
                      <label for="genre">Genre:</label><br>
                        <select class="form-control" id="genre" name="genre">
                           <option value="0">Male</option>
                           <option value="1">Femelle</option>
                        </select><br>
                        
                      <input class="btn btn-primary" type="submit" value="Générer">
                  </form> 
                  </div>
            </div>
        </div>
        
    </body>
</html>
