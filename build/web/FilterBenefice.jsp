<%@page import="metier.MeubleMatiere"%>
<%@page import="metier.Matiere"%>
<%@page import="metier.Style"%>
<%@page import="java.util.Vector"%>
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
                <li role="presentation"><a href="Fabrique">Metier Meuble</a></li>
                <li role="presentation"><a href="FabriqueMeuble">Fabrique</a></li>
          </ul>
        </nav>
            <div class="panel panel-default cover">  
                <h1>Filtrer par benefice :</h1>
                <form method="GET" action="Benefice">
                        <div class="input-group mb-3  col-lg-12">
                            <label>Prix Min</label>
                            <input type="number" name="min" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                       </div>
                    <div class="input-group mb-3  col-lg-12">
                            <label>Prix Max</label>
                            <input type="number" name="max" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
                       </div>
                    <input class="btn btn-primary" type="submit" value="Valider">
                </form>
            </div>
      </div>
    </div>
</body>
</html>
