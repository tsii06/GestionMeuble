<%@page import="metier.Meuble"%>
<%@page import="metier.Client"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
    Vector<Client> m = (Vector<Client>) request.getAttribute("listeClient");
    Vector<Meuble> meuble = (Vector<Meuble>) request.getAttribute("listeMeuble");
    String message = (String)request.getAttribute("message");
%>

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
              <h1>Insertion Vente :</h1>
            <nav class=" navbar-default">
                <nav class=" navbar-default">
              <h2>Choisir Meuble</h2>
                <form method="GET" action="Statistique">
                    <label for="client">meuble</label><br>
                       <select class="form-control" id="matiere" name="idmeuble">
                    <option value="0">Tous</option>
                  <%
                      for(int i=0;i<meuble.size ();i++){
                  %>
                  <option value="<%=meuble.get(i).getId()%>"><%=meuble.get(i).getNom()%></option>
                  <%}%>
                </select><br>
                <input class="btn btn-primary" type="submit" value="Générer">
                </form>
        </nav>
            </nav>
                <div class="panel panel-default cover">             
                    <form method="GET" action="InsertVente">
                    <label for="client">client:</label><br>
                       <select class="form-control" id="matiere" name="idclient">
                  <%
                      for(int i=0;i<m.size ();i++){
                  %>
                  <option value="<%=m.get(i).getIdClient()%>"><%=m.get(i).getNom()%></option>
                  <%}%>
                </select><br>
                <label for="client">meuble</label><br>
                       <select class="form-control" id="matiere" name="idmeuble">
                  <%
                      for(int i=0;i<meuble.size ();i++){
                  %>
                  <option value="<%=meuble.get(i).getId()%>"><%=meuble.get(i).getNom()%></option>
                  <%}%>
                </select><br>
                    <label for="quantite">Quantité:</label><br>
                    <input class="form-control" type="number" id="quantite" name="quantite" min="0" required><br>

                    <label for="date">Date:</label><br>
                    <input class="form-control" type="date" id="date" name="date" required><br>

                    <input class="btn btn-primary" type="submit" value="Générer">
                    <p><%=message%></p>
                </form> 
                </div>
                
          </div>
        </div>
    </body>
</html>
