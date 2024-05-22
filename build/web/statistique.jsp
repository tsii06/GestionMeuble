
<%@page import="metier.Stat"%>
<%@page import="metier.Meuble"%>
<%@page import="metier.MeubleMatiere"%>
<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
<%
    Vector<Meuble> mm = (Vector<Meuble>) request.getAttribute("listeMeuble");
    Stat s =(Stat) request.getAttribute("stat");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Navigation avec Bootstrap</title>
  <link rel="stylesheet" href="bootstrap.min.css">
 <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

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
              <h2>Choisir Meuble</h2>
                <form method="GET" action="Statistique">
                    <label for="client">meuble</label><br>
                       <select class="form-control" id="matiere" name="idmeuble">
                    <option value="0">Tous</option>
                  <%
                      for(int i=0;i<mm.size ();i++){
                  %>
                  <option value="<%=mm.get(i).getId()%>"><%=mm.get(i).getNom()%></option>
                  <%}%>
                </select><br>
                <input class="btn btn-primary" type="submit" value="Générer">
                </form>
        </nav>
                  <h1>Statistique :</h1>
            <div class="panel panel-default cover">   
                <div>
                <table class="table table-bordered">
    <thead>
      <tr>
        <th>Sexe</th>
        <th>Nombre</th>
        <th>Pourcentage</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Male</td>
        <td><%=s.getMale()%></td>
        <td><%=s.male()%></td>
      </tr>
      <tr>
        <td>Femelle</td>
        <td><%=s.getFemelle()%></td>
        <td><%=s.femelle()%></td>
      </tr>
    </tbody>
  </table>
</div>
<div style="width: 80%; margin: auto;">
    <canvas id="genderPieChart"></canvas>
</div>
              
            </div>
                    
<!-- Création d'un conteneur pour le diagramme -->


<script>
    // Données pour le diagramme
    var ventesFemelle = <%=s.femelle()%>; // Remplacez 0 par l'index approprié dans votre vecteur
    var ventesMale = <%=s.male()%>; // Remplacez 0 par l'index approprié dans votre vecteur

    var data = {
        labels: ['Femelle', 'Male'],
        datasets: [{
            data: [ventesFemelle, ventesMale],
            backgroundColor: ['#FF6384', '#36A2EB']
        }]
    };

    // Options du diagramme
    var options = {
        responsive: true,
        maintainAspectRatio: false
    };

    // Obtenez le contexte du canevas
    var ctx = document.getElementById('genderPieChart').getContext('2d');

    // Créez le diagramme circulaire
    var genderPieChart = new Chart(ctx, {
        type: 'pie',
        data: data,
        options: options
    });
</script>
      </div>
    </div>
</body>
</html>
